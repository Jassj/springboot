package com.yuanjie.springboot.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * description: 自定义过滤器
 * @author yuanjie 2020/03/13 16:01
 */
// @WebFilter web请求过滤器注解，但是无法配置过滤器顺序
public class MyFilter implements Filter {

    public void init(FilterConfig filterConfig) {
        String projectName = filterConfig.getInitParameter("PROJECT_NAME");
        System.out.println(projectName + ": this is MyFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("you are filtered by me, ha-ha :" + req.getRequestURI());
        filterChain.doFilter(request, response); // 请求放行，进行下一个过滤器；若要拦截请求，可以注释此行代码
    }

    @Override
    public void destroy() {
        System.out.println("i'm going die");
    }

}
