package com.pug.axon.axon.services.commands;

import com.pug.axon.axon.commands.CreateJenisFasilitasCommand;
import com.pug.axon.axon.commands.UpdateJenisFasilitasCommand;
import com.pug.axon.axon.dto.JenisFasilitasDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class JenisFasilitasServiceImpl implements JenisFasilitasService {

  private final CommandGateway commandGateway;

  public JenisFasilitasServiceImpl(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @Override
  public CompletableFuture<String> createJenisFasilitas(JenisFasilitasDto jenisFasilitasDto) {
    return commandGateway.send(new CreateJenisFasilitasCommand(
      UUID.randomUUID().toString(), jenisFasilitasDto.getKode(),
      jenisFasilitasDto.getNama(), jenisFasilitasDto.getStatus()));
  }

  @Override
  public CompletableFuture<String> updateJenisFasilitas(String id, JenisFasilitasDto jenisFasilitasDto) {
    return commandGateway.send(new UpdateJenisFasilitasCommand(id, jenisFasilitasDto.getKode(), jenisFasilitasDto.getNama()
    ,jenisFasilitasDto.getStatus()));
  }


}
