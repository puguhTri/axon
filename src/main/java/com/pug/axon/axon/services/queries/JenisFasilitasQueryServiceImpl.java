package com.pug.axon.axon.services.queries;

import com.pug.axon.axon.dto.query.JenisFasilitasQuery;
import com.pug.axon.axon.entities.JenisFasilitasEntity;
import com.pug.axon.axon.entities.repositories.JenisFasilitasRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class JenisFasilitasQueryServiceImpl implements JenisFasilitasQueryService {

  private final EventStore eventStore;

  private final JenisFasilitasRepository jenisFasilitasRepository;

  private final QueryGateway queryGateway;

  public JenisFasilitasQueryServiceImpl(EventStore eventStore, JenisFasilitasRepository jenisFasilitasRepository, QueryGateway queryGateway) {
    this.eventStore = eventStore;
    this.jenisFasilitasRepository = jenisFasilitasRepository;
    this.queryGateway = queryGateway;
  }

  @Override
  public List<Object> listEventsForJenisFasilitas(String kode) {
    return eventStore.readEvents(kode).asStream().map(s -> s.getPayload()).collect(Collectors.toList());
  }

  @Override
  public List<JenisFasilitasEntity> listJenisFasilitas() {
    return null;
  }

  /*@Async
  @Override
  public Future<List<JenisFasilitasEntity>> listJenisFasilitas() throws InterruptedException  {
    System.out.println(" MULAI ::: " + new Date());
    CompletableFuture<List<JenisFasilitasEntity>> results = (CompletableFuture<List<JenisFasilitasEntity>>) jenisFasilitasRepository.findAll();
    Thread.sleep(1000 * 10);
    System.out.println(" END ::: " + new Date());
    return new AsyncResult<List<JenisFasilitasEntity>>((List<JenisFasilitasEntity>) results);
    //(List<JenisFasilitasEntity>) jenisFasilitasRepository.findAll();
  }*/

  @Async
  @Override
  public Future<List<JenisFasilitasEntity>> sss(){
    System.out.println("Execute method asynchronously - "
      + Thread.currentThread().getName());
    try {
      List<JenisFasilitasEntity> r = (List<JenisFasilitasEntity>) jenisFasilitasRepository.findAll();
      Thread.sleep(5000);
      System.out.println("done");
      return new AsyncResult<List<JenisFasilitasEntity>>(r);
    } catch (InterruptedException e) {
      //
    }

    return null;
  }


  @Override
  public CompletableFuture<List<JenisFasilitasEntity>> findAllJenisFasilitas() {
    return queryGateway.query(new JenisFasilitasQuery(), ResponseTypes.multipleInstancesOf(JenisFasilitasEntity.class));
  }


}
