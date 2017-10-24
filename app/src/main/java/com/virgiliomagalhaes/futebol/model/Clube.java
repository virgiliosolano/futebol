package com.virgiliomagalhaes.futebol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by virgiliomagalhaes on 10/22/2017.
 */

public class Clube {

  @SerializedName("id") @Expose private int id;
  @SerializedName("nome") @Expose private String nome;
  @SerializedName("abreviacao") @Expose private String abreviacao;
  @SerializedName("posicao") @Expose private Integer posicao;
  @SerializedName("escudos") @Expose private Escudo escudo;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getAbreviacao() {
    return abreviacao;
  }

  public void setAbreviacao(String abreviacao) {
    this.abreviacao = abreviacao;
  }

  public Integer getPosicao() {
    return posicao;
  }

  public void setPosicao(Integer posicao) {
    this.posicao = posicao;
  }

  public Escudo getEscudo() {
    return escudo;
  }

  public void setEscudos(Escudo escudo) {
    this.escudo = escudo;
  }
}