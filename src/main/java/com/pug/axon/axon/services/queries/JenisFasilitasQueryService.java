package com.pug.axon.axon.services.queries;

import com.pug.axon.axon.entities.JenisFasilitasEntity;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface JenisFasilitasQueryService {

  public List<Object> listEventsForJenisFasilitas(String kode);

  public List<JenisFasilitasEntity> listJenisFasilitas();

  @Async
  Future<List<JenisFasilitasEntity>> sss();

  public CompletableFuture<List<JenisFasilitasEntity>> findAllJenisFasilitas();

}
