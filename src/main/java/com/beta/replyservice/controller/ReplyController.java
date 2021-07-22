package com.beta.replyservice.controller;

import com.beta.replyservice.model.ReplyData;
import com.beta.replyservice.model.ReplyMessage;
import com.beta.replyservice.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.regex.Pattern;

@RestController
public class ReplyController {

	private static final String VALIDATE_MSG_REGEX = "^\\d{2}-[a-z0-9]*";

	@Autowired
	private ReplyService replyService;

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return new ReplyMessage(message);
	}

	@GetMapping("/v2/reply/{message}")
	public ReplyData reply(@PathVariable String message ){

		if (!Pattern.matches(VALIDATE_MSG_REGEX,message))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect request message");

		return  replyService.replyData(message);
	}
}