package com.pug.axon.axon.aggregates;

import com.pug.axon.axon.commands.CreateJenisFasilitasCommand;
import com.pug.axon.axon.commands.UpdateJenisFasilitasCommand;
import com.pug.axon.axon.events.CreateJenisFasilitasEvent;
import com.pug.axon.axon.events.UpdateJenisFasilitasEvent;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Getter
@Setter
@Aggregate
public class JenisFasilitasAggregate {

  @AggregateIdentifier
  private String id;

  private String kode;

  private String nama;

  private String status;

  public JenisFasilitasAggregate() {
  }


  @CommandHandler
  public JenisFasilitasAggregate(CreateJenisFasilitasCommand createJenisFasilitasCommand) {
    AggregateLifecycle.apply(new CreateJenisFasilitasEvent(createJenisFasilitasCommand.id, createJenisFasilitasCommand.kode
      , createJenisFasilitasCommand.nama, createJenisFasilitasCommand.status));
  }

  @EventSourcingHandler
  protected void on(CreateJenisFasilitasEvent createJenisFasilitasEvent) {
    this.id = createJenisFasilitasEvent.id;
    this.kode = createJenisFasilitasEvent.kode;
    this.nama = createJenisFasilitasEvent.nama;
    this.status = createJenisFasilitasEvent.status;
  }

  @CommandHandler
  protected void on(UpdateJenisFasilitasCommand updateJenisFasilitasCommand) {
    AggregateLifecycle.apply(new UpdateJenisFasilitasEvent(updateJenisFasilitasCommand.id, updateJenisFasilitasCommand.kode
      , updateJenisFasilitasCommand.nama, updateJenisFasilitasCommand.status));
  }

  @EventSourcingHandler
  protected void on(UpdateJenisFasilitasEvent updateJenisFasilitasEvent){
    this.status = updateJenisFasilitasEvent.status;
  }
}
