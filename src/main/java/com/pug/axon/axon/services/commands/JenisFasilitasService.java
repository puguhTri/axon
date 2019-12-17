package com.pug.axon.axon.services.commands;

import com.pug.axon.axon.dto.JenisFasilitasDto;

import java.util.concurrent.CompletableFuture;

public interface JenisFasilitasService {

  public CompletableFuture<String> createJenisFasilitas(JenisFasilitasDto jenisFasilitasDto);
  public CompletableFuture<String> updateJenisFasilitas(String kode,JenisFasilitasDto jenisFasilitasDto);

}
