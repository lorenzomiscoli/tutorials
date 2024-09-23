package com.lorenzomiscoli.spring_sse.utils;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

@Component
public class SseConsumer {

	@PostConstruct
	public void connect() {
		var uri = "http://localhost:8080/sse";
		var type = new ParameterizedTypeReference<ServerSentEvent<String>>(){};
		Flux<ServerSentEvent<String>> eventStream = WebClient.create()
				.get()
				.uri(uri)
				.accept(MediaType.TEXT_EVENT_STREAM)
				.retrieve()
				.bodyToFlux(type)
				.retryWhen(Retry.backoff(3, Duration.of(10, ChronoUnit.SECONDS)));
		eventStream.subscribe(content -> {
			System.out.println("Event Content: "+content);
		}, error -> {
			System.out.println("Event Error: "+error);
		});
	}

}
