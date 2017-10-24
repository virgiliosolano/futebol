package com.virgiliomagalhaes.futebol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by virgiliomagalhaes on 10/22/2017.
 */

public class Rodada {

  @SerializedName("partidas")
  @Expose
  private List<Partida> partidas;

  @SerializedName("clubes")
  @Expose
  private List<Clube> clubes;

  @SerializedName("rodada")
  @Expose
  private int rodada;

  private List<Clube> clubesDesc;

  public List<Partida> getPartidas() {
    return partidas;
  }

  public void setPartidas(List<Partida> partidas) {
    setAscPardidas(partidas);
    this.partidas = partidas;
  }

  public int getRodada() {
    return rodada;
  }

  public void setRodada(int rodada) {
    this.rodada = rodada;
  }

  public List<Clube> getClubes() {
    return clubes;
  }

  public List<Clube> getClubesDesc() {
    return clubesDesc;
  }

  public void setClubes(List<Clube> clubes) {
    setAscClubes(clubes);
    clubes = clubes.subList(0, 10);
    this.clubes = clubes;
    this.clubesDesc = new ArrayList<>(clubes);
    setDescClubes(clubesDesc);
  }

  private void setAscClubes(List<Clube> clubes) {
    Collections.sort(clubes, new Comparator<Clube>() {
      @Override public int compare(Clube clube1, Clube clube2) {
        return clube1.getPosicao() - clube2.getPosicao();
      }
    });
  }

  private void setDescClubes(List<Clube> clubes) {
    Collections.sort(clubes, new Comparator<Clube>() {
      @Override public int compare(Clube clube1, Clube clube2) {
        return clube2.getPosicao() - clube1.getPosicao();
      }
    });
  }

  public void setAscPardidas(List<Partida> partidas) {
    Collections.sort(partidas, new Comparator<Partida>() {
      public int compare(Partida partida1, Partida partida2) {
        return partida1.getDataFormatada().compareTo(partida2.getDataFormatada());
      }
    });
  }
}
