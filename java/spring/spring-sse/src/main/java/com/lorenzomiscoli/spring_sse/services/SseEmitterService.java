package com.lorenzomiscoli.spring_sse.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

@Service
public class SseEmitterService {

    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public SseEmitter add(SseEmitter emitter) {
        this.emitters.add(emitter);
        emitter.onCompletion(() -> {
            this.emitters.remove(emitter);
        });
        emitter.onTimeout(() -> {
            emitter.complete();
            this.emitters.remove(emitter);
        });
        return emitter;
    }

    public void send(SseEventBuilder obj) {
        List<SseEmitter> failedEmitters = new ArrayList<>();
        this.emitters.forEach(emitter -> {
            try {
                emitter.send(obj);
            } catch (IOException e) {
                emitter.completeWithError(e);
                failedEmitters.add(emitter);
            }
        });
        this.emitters.removeAll(failedEmitters);
    }

}
