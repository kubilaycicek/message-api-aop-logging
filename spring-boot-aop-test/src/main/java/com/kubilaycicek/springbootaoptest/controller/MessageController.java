package com.kubilaycicek.springbootaoptest.controller;

import com.kubilaycicek.springbootaoptest.annotation.LogExecutionTime;
import com.kubilaycicek.springbootaoptest.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getMessage() {
		return ResponseEntity.ok(messageService.getMessage());
	}

	@PostMapping(value = "/checkMessage",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> checkMessage(@RequestBody(required = false) String message) {
		return ResponseEntity.ok(messageService.checkMessage(message));
	}

	@LogExecutionTime
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/sayhello")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok(messageService.sayHello());
	}
}
