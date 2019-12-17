package com.pug.axon.axon.controller;


import com.pug.axon.axon.dto.JenisFasilitasDto;
import com.pug.axon.axon.services.commands.JenisFasilitasService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "jenis-fasilitas")
@Api(value = "Jenis Fasilitas Commands", description = "Jenis Fasilitas Related Endpoints", tags = "Jenis Fasilitas Commands")
public class JenisFasilitasCommadController {


  @Autowired
  private JenisFasilitasService jenisFasilitasService;


  @PostMapping(value = "/add")
  public CompletableFuture<String> createJenisFasilitas(@RequestBody JenisFasilitasDto jenisFasilitasDto){
    return jenisFasilitasService.createJenisFasilitas(jenisFasilitasDto);
  }

  @PutMapping(value = "/update/{id}")
  public CompletableFuture<String> updateJenisFasilitas(@PathVariable(value = "id") String kode,@RequestBody JenisFasilitasDto jenisFasilitasDto){
    return jenisFasilitasService.updateJenisFasilitas(kode, jenisFasilitasDto);
  }


}
