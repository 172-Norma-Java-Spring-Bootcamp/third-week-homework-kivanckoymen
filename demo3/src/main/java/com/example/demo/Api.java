package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Api {
    public void setApiKey(String apiKey) {
        this.apiKey = "a80bcf722e562cc65a111b673960275c";
    }

    public String apiKey;

    public String getApiKey() {
        return "a80bcf722e562cc65a111b673960275c";
    }
}

