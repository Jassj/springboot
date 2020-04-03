package com.yuanjie.springboot.modules.controller;

import com.yuanjie.springboot.modules.entity.Message;
import com.yuanjie.springboot.modules.response.BaseResult;
import com.yuanjie.springboot.modules.service.MessageRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description
 * message控制器: 遵循restful web架构
 * @author yuanjie 2020/03/17 17:33
 */
@Api(value = "消息", protocols = "http")
@RestController
@RequestMapping("/")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    // 获取所有消息体
    @GetMapping(value = "message")
    @ApiOperation(value = "消息列表", notes = "完整的消息内容列表", response = List.class)
    public List<Message> list() {
        return messageRepository.findAll();
    }

    // 创建一个消息体
    @PostMapping(value = "message")
    @ApiOperation(value = "添加消息", notes = "根据参数创建消息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "id", value = "消息ID", required = true, dataType = "Long"),
        @ApiImplicitParam(paramType = "query", name = "text", value = "正文", required = true, dataType = "String"),
        @ApiImplicitParam(paramType = "query", name = "summary", value = "摘要", required = true, dataType = "String"),
    })
    public Message create(Message message) {
        return messageRepository.save(message);
    }

    // 使用put请求进行修改
    @PutMapping(value = "message")
    @ApiOperation(value = "修改消息", notes = "根据参数修改消息")
    @ApiResponses({
            @ApiResponse(code = 100, message = "请求参数有误"),
            @ApiResponse(code = 101, message = "未授权"),
            @ApiResponse(code = 103, message = "禁止访问"),
            @ApiResponse(code = 104, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误"),
    })
    public Message modify(Message message) {
        return messageRepository.update(message);
    }

    // 更新消息的text字段
    @PatchMapping(value = "/message/text")
    @ApiOperation(value = "更新消息", notes = "更新指定消息的text字段")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "消息ID", required = true, dataType = "Long"),
            @ApiImplicitParam(paramType = "query", name = "text", value = "正文", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "summary", value = "摘要", dataType = "String"),
    })
    public BaseResult<Message> patch(Message message) {
        Message messageResult = messageRepository.updateText(message);
        return BaseResult.successWithData(messageResult);
    }

    // 根据id获取消息
    @GetMapping(value = "message/{id}")
    public Message get(@PathVariable("id") Long id) {
        return messageRepository.findMessage(id);
    }

    // 根据id删除消息
    @DeleteMapping(value = "message/{id}")
    public void delete(@PathVariable("id") Long id) {
        messageRepository.deleteMessage(id);
    }
}
