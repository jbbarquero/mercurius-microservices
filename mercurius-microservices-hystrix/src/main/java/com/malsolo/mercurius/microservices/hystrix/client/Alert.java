package com.malsolo.mercurius.microservices.hystrix.client;

import java.util.Date;

import lombok.Data;

@Data
public class Alert {

	private Long id, idType, idEvent;
	
	private Date creationDate;

	private String message;
}
