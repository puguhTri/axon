package com.pug.axon.axon.config;

import com.pug.axon.axon.aggregates.JenisFasilitasAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

  @Bean
  EventSourcingRepository<JenisFasilitasAggregate> jenisFasilitasAggregateEventSourcingRepository(EventStore eventStore){
    EventSourcingRepository<JenisFasilitasAggregate> repository = EventSourcingRepository.builder(JenisFasilitasAggregate.class).eventStore(eventStore).build();
    return repository;
  }
}
