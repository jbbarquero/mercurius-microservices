package com.malsolo.mercurius.microservices.events;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	public List<Event> findByIdType(Long idType);

}
