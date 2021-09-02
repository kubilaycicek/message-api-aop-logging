package com.kubilaycicek.springbootaoptest.service;

import com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MessageServiceImplTest {

    @Mock
    private MessageService messageService;

    private final static String HELLO = "Helloooo";

    @Test
    void getMessage() {
        Mockito.when(messageService.getMessage()).thenReturn(HELLO);

        String result = messageService.getMessage();

        Assertions.assertEquals(HELLO, result);
    }

    @Test
    void checkMessageThenReturnIllegalArgumentException() {
        final String message = null;

        Mockito.when(messageService.checkMessage(message)).thenThrow(new IllegalArgumentException());

        Assertions.assertThrows(IllegalArgumentException.class, () -> messageService.checkMessage(message));
    }

    @Test
    void checkMessageThenReturnMessage() {
        final String message = "kubilay";

        Mockito.when(messageService.checkMessage(message)).thenReturn(message);

        String result = messageService.checkMessage(message);

        Assertions.assertEquals(message, result);

    }
}