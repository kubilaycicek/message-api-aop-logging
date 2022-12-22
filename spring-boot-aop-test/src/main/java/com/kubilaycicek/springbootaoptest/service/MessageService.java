package com.kubilaycicek.springbootaoptest.service;

public interface MessageService {
    String getMessage();
    String checkMessage(String message);
    String sayHello();
    String withoutAspectGetMessage(String message);
}
