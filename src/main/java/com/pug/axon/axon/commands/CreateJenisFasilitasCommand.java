package com.pug.axon.axon.commands;

public class CreateJenisFasilitasCommand extends BaseCommand<String> {

  public final String kode;

  public final String nama;

  public final String status;

  public CreateJenisFasilitasCommand(String id, String kode, String nama, String status) {
    super(id);
    this.kode = kode;
    this.nama = nama;
    this.status = status;
  }
}
