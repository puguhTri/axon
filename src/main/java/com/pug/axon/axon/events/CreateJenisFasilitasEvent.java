package com.pug.axon.axon.events;

public class CreateJenisFasilitasEvent extends BaseEvent<String> {

  public final String kode;

  public final String nama;

  public final String status;

  public CreateJenisFasilitasEvent(String id, String kode, String nama, String status) {
    super(id);
    this.kode = kode;
    this.nama = nama;
    this.status = status;
  }
}
