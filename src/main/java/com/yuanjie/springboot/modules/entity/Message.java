package com.yuanjie.springboot.modules.entity;

/**
 * description
 * 消息实例类
 * @author yuanjie 2020/03/17 17:34
 */
public class Message {
    private Long id;
    private String text;
    private String summary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
