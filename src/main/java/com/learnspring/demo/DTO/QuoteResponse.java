package com.learnspring.demo.DTO;

public class QuoteResponse {
    private String type;
    private Value value;

    public QuoteResponse() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
