package com.kubilaycicek.springbootaoptest.service;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public String getMessage() {
        return "Helloooo";
    }
}
