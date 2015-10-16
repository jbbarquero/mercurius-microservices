package com.malsolo.mercurius.microservices.zuul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.Environment;
import reactor.rx.Stream;
import reactor.rx.Streams;

@Component
public class SummaryService {

	@Autowired
	private Environment environment;

	@Autowired
	private AlertClient alertClient;

	@Autowired
	private EventClient eventClient;

	public Stream<Alert> getAlerts() {
		return Streams.<Alert> create(subscriber -> {
			this.alertClient.getAlerts().forEach(subscriber::onNext);
			subscriber.onComplete();
		}).dispatchOn(environment, Environment.cachedDispatcher())
				.log("alerts");
	}

	public Stream<Event> getEvents() {
		return Streams.<Event> create(subscriber -> {
			this.eventClient.getEvents().forEach(subscriber::onNext);
			subscriber.onComplete();
		}).dispatchOn(environment, Environment.cachedDispatcher())
				.log("alerts");
	}

	public Stream<Summary> getSummary(Stream<Alert> alerts, Stream<Event> events) {
		return Streams.zip(alerts.buffer(), events.buffer(),
				tuple -> new Summary(tuple.getT1(), tuple.getT2()));
	}
}
