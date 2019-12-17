package com.pug.axon.axon.entities.handler;

import com.pug.axon.axon.aggregates.JenisFasilitasAggregate;
import com.pug.axon.axon.dto.query.JenisFasilitasQuery;
import com.pug.axon.axon.entities.JenisFasilitasEntity;
import com.pug.axon.axon.entities.repositories.JenisFasilitasRepository;
import com.pug.axon.axon.events.BaseEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JenisFasilitasQueryEm {

  @Autowired
  private JenisFasilitasRepository jenisFasilitasRepository;

  @Autowired
  @Qualifier("jenisFasilitasAggregateEventSourcingRepository")
  private EventSourcingRepository<JenisFasilitasAggregate> jenisFasilitasAggregateEventSourcingRepository;

  @EventSourcingHandler
  void on(BaseEvent baseEvent){
  persistJenisFasilitas(buildQueryAccount(getJenisFasilitasFromEvent(baseEvent)));
  }

  private JenisFasilitasAggregate getJenisFasilitasFromEvent(BaseEvent baseEvent){
    return jenisFasilitasAggregateEventSourcingRepository.load(baseEvent.id.toString()).getWrappedAggregate().getAggregateRoot();
  }

  private JenisFasilitasEntity findExistingOrCreateQueryJenisFasilitas(String id){
    return jenisFasilitasRepository.findById(id).isPresent() ? jenisFasilitasRepository.findById(id).get() : new JenisFasilitasEntity();
  }

  private JenisFasilitasEntity buildQueryAccount(JenisFasilitasAggregate jenisFasilitasAggregate){
    JenisFasilitasEntity jenisFasilitasEntity = findExistingOrCreateQueryJenisFasilitas(jenisFasilitasAggregate.getId());

    jenisFasilitasEntity.setId(jenisFasilitasAggregate.getId());
    jenisFasilitasEntity.setKode(jenisFasilitasAggregate.getKode());
    jenisFasilitasEntity.setNama(jenisFasilitasAggregate.getNama());
    jenisFasilitasEntity.setStatus(jenisFasilitasAggregate.getStatus());

    return jenisFasilitasEntity;
  }

  private void persistJenisFasilitas(JenisFasilitasEntity jenisFasilitasEntity){
    jenisFasilitasRepository.save(jenisFasilitasEntity);
  }

  @QueryHandler
  public List<JenisFasilitasEntity> findAllJenisFasilitas(JenisFasilitasQuery jenisFasilitasQuery){
    return (List<JenisFasilitasEntity>) jenisFasilitasRepository.findAll();
  }

}
