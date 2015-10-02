package com.malsolo.mercurius.microservices.alerts;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private Long idType;

	@NotNull
	private Long idEvent;

	@NotNull
	private Date creationDate;
	
	@Size(max = 250)
	private String message;
}
