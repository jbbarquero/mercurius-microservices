package com.malsolo.mercurius.microservices.hystrix.client;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Background {

	private Collection<Alert> bookmarks;

	private Collection<Event> contacts;

}
