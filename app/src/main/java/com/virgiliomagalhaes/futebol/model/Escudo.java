package com.virgiliomagalhaes.futebol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by virgiliomagalhaes on 10/22/2017.
 */

public class Escudo {

  @SerializedName("60x60") @Expose private String grande;

  @SerializedName("45x45") @Expose private String medio;

  @SerializedName("30x30") @Expose private String pequeno;

  public String getGrande() {
    return grande;
  }

  public void setGrande(String grande) {
    this.grande = grande;
  }

  public String getMedio() {
    return medio;
  }

  public void setMedio(String medio) {
    this.medio = medio;
  }

  public String getPequeno() {
    return pequeno;
  }

  public void setPequeno(String pequeno) {
    this.pequeno = pequeno;
  }
}
