package com.lorenzomiscoli.spring_sse.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.lorenzomiscoli.spring_sse.services.SseEmitterService;

@RestController
public class SseController {
	
    private final SseEmitterService sseEmitterService;
    
    public SseController(SseEmitterService sseEmitterService) {
        this.sseEmitterService = sseEmitterService;
    }
    
    @GetMapping(path = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    SseEmitter createConnection() {
        SseEmitter emitter = sseEmitterService.add(new SseEmitter(-1L));
        return emitter;
    }
    
}
