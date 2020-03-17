package com.yuanjie.springboot.modules.controller;

import com.yuanjie.springboot.modules.entity.Message;
import com.yuanjie.springboot.modules.service.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description
 * message控制器：遵循restful web架构
 * @author yuanjie 2020/03/17 17:33
 */
@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    // 获取所有消息体
    @GetMapping(value = "/message")
    public List<Message> list() {
        return messageRepository.findAll();
    }

    // 创建一个消息体
    @PostMapping(value = "/message")
    public Message create(Message message) {
        return messageRepository.save(message);
    }

    // 使用put请求进行修改
    @PutMapping(value = "/message")
    public Message modify(Message message) {
        return messageRepository.update(message);
    }

    // 更新消息的text字段
    @PatchMapping(value = "/message/text")
    public Message patch(Message message) {
        return messageRepository.updateText(message);
    }

    // 根据id获取消息
    @GetMapping(value = "/message/{id}")
    public Message get(@PathVariable("id") Long id) {
        return messageRepository.findMessage(id);
    }

    // 根据id删除消息
    @DeleteMapping(value = "/message/{id}")
    public void delete(@PathVariable("id") Long id) {
        messageRepository.deleteMessage(id);
    }
}
