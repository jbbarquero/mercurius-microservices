package com.malsolo.mercurius.microservices.zuul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import reactor.rx.Stream;

@RestController
public class SummaryRestController {

	@Autowired
	private SummaryService summaryService;

	@RequestMapping("/summary")
	public DeferredResult<Summary> summary() {
		DeferredResult<Summary> summarydeferredResult = new DeferredResult<>();
		
		Stream<Alert> alertStream = this.summaryService.getAlerts();
		Stream<Event> eventStream = this.summaryService.getEvents();
		
		this.summaryService.getSummary(alertStream, eventStream).consume(summarydeferredResult::setResult);
		
		return summarydeferredResult;
	}
}
