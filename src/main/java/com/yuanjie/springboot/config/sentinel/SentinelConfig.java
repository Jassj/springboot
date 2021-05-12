package com.yuanjie.springboot.config.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.CircuitBreaker;
import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.EventObserverRegistry;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.util.TimeUtil;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * sentinel 限流配置类
 *
 * @author jie2.yuan
 * @version 1.0.0
 * @since 2021/05/11
 */
@Configuration
public class SentinelConfig {

    /**
     * 初始化加载限流配置: 可接统一配置 | 关系型数据库
     */
    @PostConstruct
    private void init() {
        initFlowRules();
        initDegradeRules();
    }

    /**
     * 流量控制规则
     */
    private void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("test");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    /**
     * 熔断降级规则
     */
    private void initDegradeRules() {
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        rule.setResource("test");
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_RATIO);
        rule.setCount(0.5);
        rule.setTimeWindow(5);
        rule.setMinRequestAmount(10);
        rule.setStatIntervalMs(60000);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
        addObserver();
    }

    /**
     * 熔断降级添加监听器
     */
    public void addObserver() {
        EventObserverRegistry.getInstance().addStateChangeObserver("logging",
                (prevState, newState, rule, snapshotValue) -> {
                    if (newState == CircuitBreaker.State.OPEN) {
                        // 变换至 OPEN state 时会携带触发时的值
                        System.err.println(String.format("资源%s: %s -> OPEN at %d, snapshotValue=%.2f", rule.getResource(), prevState.name(),
                                TimeUtil.currentTimeMillis(), snapshotValue));
                    } else {
                        System.err.println(String.format("资源%s: %s -> %s at %d", rule.getResource(), prevState.name(), newState.name(),
                                TimeUtil.currentTimeMillis()));
                    }
                });
    }

}