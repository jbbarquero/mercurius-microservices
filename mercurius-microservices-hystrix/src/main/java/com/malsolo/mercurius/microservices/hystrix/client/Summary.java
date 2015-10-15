package com.malsolo.mercurius.microservices.hystrix.client;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Summary {

	private Collection<Alert> alerts;

	private Collection<Event> events;

}
