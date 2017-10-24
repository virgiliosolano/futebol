package com.virgiliomagalhaes.futebol.service;

import com.virgiliomagalhaes.futebol.model.Rodada;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by virgiliomagalhaes on 10/22/2017.
 */

public interface FutebolService {

  @GET("partidas")
  Observable<Rodada> getPartidas();
}
