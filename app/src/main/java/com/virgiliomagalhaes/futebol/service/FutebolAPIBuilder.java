package com.virgiliomagalhaes.futebol.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.virgiliomagalhaes.futebol.BuildConfig;
import com.virgiliomagalhaes.futebol.model.Rodada;
import java.util.Stack;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by virgiliomagalhaes on 10/22/2017.
 */

public final class FutebolAPIBuilder {

  private static FutebolService futebolService;

  public static FutebolService getFutebolService() {

    if (futebolService == null) {
      Gson gsonRodada =
          new GsonBuilder().registerTypeAdapter(Rodada.class, new RodadaDeserializer()).create();

      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(BuildConfig.ENDPOINT_URL)
          .addConverterFactory(GsonConverterFactory.create(gsonRodada))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .build();

      futebolService = retrofit.create(FutebolService.class);
    }

    return futebolService;
  }
}
