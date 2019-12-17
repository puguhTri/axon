package com.pug.axon.axon.controller;


import com.pug.axon.axon.entities.JenisFasilitasEntity;
import com.pug.axon.axon.services.queries.JenisFasilitasQueryService;
import io.swagger.annotations.Api;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@RestController
@RequestMapping(value = "jenis-fasilitas")
@Api(value = "Jenis Fasilitas Query", description = "Jenis Fasilitas Related Endpoints", tags = "Jenis Fasilitas Query")

public class JenisFasilitasQueryController {

  private final JenisFasilitasQueryService jenisFasilitasQueryService;

  public JenisFasilitasQueryController(JenisFasilitasQueryService jenisFasilitasQueryService) {
    this.jenisFasilitasQueryService = jenisFasilitasQueryService;
  }

  @GetMapping("/listJenisFasilitas")
  public List<JenisFasilitasEntity> listJenisFasilitas() {
    return jenisFasilitasQueryService.listJenisFasilitas();
  }

  @GetMapping("/listJenisFasilitasAsync")
  public Future<List<JenisFasilitasEntity>> listJenisFasilitasAsyn() {
    return jenisFasilitasQueryService.sss() ;
  }


  @GetMapping("/findJenisFasilitas")
  public CompletableFuture<List<JenisFasilitasEntity>> findAllJenisFasilitas() {
    return jenisFasilitasQueryService.findAllJenisFasilitas();
  }


}
