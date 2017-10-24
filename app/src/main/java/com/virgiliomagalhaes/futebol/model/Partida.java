package com.virgiliomagalhaes.futebol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Created by virgiliomagalhaes on 10/22/2017.
 */

public class Partida {

  @SerializedName("partida_id") private Integer partidaId;
  @SerializedName("clube_casa_id") private Integer clubeCasaId;
  @SerializedName("clube_visitante_id") private Integer clubeVisitanteId;
  @SerializedName("partida_data") private String partidaData;
  @SerializedName("placar_oficial_mandante") private String placarOficialMandante;
  @SerializedName("placar_oficial_visitante") private String placarOficialVisitante;
  @SerializedName("local") private String local;
  private Clube clubeCasa;
  private Clube clubeVisitante;
  private Date dataFormatada;

  public Integer getPartidaId() {
    return partidaId;
  }

  public void setPartidaId(Integer partidaId) {
    this.partidaId = partidaId;
  }

  public Integer getClubeCasaId() {
    return clubeCasaId;
  }

  public void setClubeCasaId(Integer clubeCasaId) {
    this.clubeCasaId = clubeCasaId;
  }

  public Integer getClubeVisitanteId() {
    return clubeVisitanteId;
  }

  public void setClubeVisitanteId(Integer clubeVisitanteId) {
    this.clubeVisitanteId = clubeVisitanteId;
  }

  public String getPartidaData() {
    return partidaData;
  }

  public void setPartidaData(String partidaData) {
    this.partidaData = partidaData;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public String getPlacarOficialMandante() {
    return placarOficialMandante;
  }

  public void setPlacarOficialMandante(String placarOficialMandante) {
    this.placarOficialMandante = placarOficialMandante;
  }

  public String getPlacarOficialVisitante() {
    return placarOficialVisitante;
  }

  public void setPlacarOficialVisitante(String placarOficialVisitante) {
    this.placarOficialVisitante = placarOficialVisitante;
  }

  public Clube getClubeCasa() {
    return clubeCasa;
  }

  public void setClubeCasa(Clube clubeCasa) {
    this.clubeCasa = clubeCasa;
  }

  public Clube getClubeVisitante() {
    return clubeVisitante;
  }

  public void setClubeVisitante(Clube clubeVisitante) {
    this.clubeVisitante = clubeVisitante;
  }

  public Date getDataFormatada() {
    return dataFormatada;
  }

  public void setDataFormatada(Date dataFormatada) {
    this.dataFormatada = dataFormatada;
  }
}
