package com.malsolo.mercurius.microservices.ribbon;

import java.util.Date;

import lombok.Data;

@Data
public class Event {

	private Long id, idType;

	private String code, data;
	
	private Date creationDate, requestDate, processDate;
	
	private Integer status;
}
