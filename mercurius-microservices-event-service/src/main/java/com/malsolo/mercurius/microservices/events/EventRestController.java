package com.malsolo.mercurius.microservices.events;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/events")
public class EventRestController {

	@Autowired
	private EventRepository eventRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Event> getAllEvents() {
		return this.eventRepository.findAll();
	}

	@RequestMapping(value = "/{eventId}", method = RequestMethod.GET)
	public Event getEvent(@PathVariable Long eventId) {
		return this.eventRepository.findOne(eventId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Event createEvent(@RequestBody Event event) {
		return this.eventRepository.save(new Event(null, event.getIdType(),
				event.getCode(), event.getData(), event.getCreationDate(),
				new Date(), null, 0));
	}

	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(System.out, new Event(1L, 1L, "code", "data",
				new Date(), new Date(), null, 0));
	}

}