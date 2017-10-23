package com.example.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ResponseController {
	public ResponseEntity<String> handleRequest(RequestEntity<String> requestEntity){
		System.out.println("request body:" + requestEntity.getBody());
		HttpHeaders header= requestEntity.getHeaders();
		System.out.println("request headers:"+header);
		HttpMethod method=requestEntity.getMethod();
		System.out.println("request method:"+method);
		System.out.println(requestEntity.getUrl());
		ResponseEntity<String> responseEntity = new ResponseEntity<>("my response body",HttpStatus.OK);
		return responseEntity;
	}

}
