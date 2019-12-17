package com.pug.axon.axon.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class JenisFasilitasEntity {

  @Id
  private String id;

  private String kode;

  private String nama;

  private String status;



}
