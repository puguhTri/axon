package com.pug.axon.axon.commands;

public class UpdateJenisFasilitasCommand extends BaseCommand<String> {

  public final String kode;

  public final String nama;

  public final String status;

  public UpdateJenisFasilitasCommand(String id, String kode, String nama, String status) {
    super(id);
    this.kode = kode;
    this.nama = nama;
    this.status = status;
  }
}
