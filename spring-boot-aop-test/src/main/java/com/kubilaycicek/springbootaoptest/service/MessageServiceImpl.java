package com.kubilaycicek.springbootaoptest.service;

import com.kubilaycicek.springbootaoptest.annotation.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public String checkMessage(String message) {

        if (message == null) {
            throw new IllegalArgumentException("Message is null");
        }

        return message;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }

    @Override
    public String withoutAspectGetMessage(String message) {
        try {
            // Çalışma Süresini Hesaplama Başlangıcı
            // Loglama
            if (message == null) {
                throw new IllegalArgumentException("Message is null");
            }
        } catch (Exception exception) {
            // Hatayı Logla
        } finally {
            // Çalışma süresini hesabını bitir.
        }
        return message;
    }

    @Override
    public String getMessage() {
        return "Mesajımı almıştır o";
    }


}