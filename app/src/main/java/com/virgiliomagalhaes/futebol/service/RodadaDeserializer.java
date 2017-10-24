package com.virgiliomagalhaes.futebol.service;

import android.icu.text.MessagePattern;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.virgiliomagalhaes.futebol.model.Clube;
import com.virgiliomagalhaes.futebol.model.Escudo;
import com.virgiliomagalhaes.futebol.model.Partida;
import com.virgiliomagalhaes.futebol.model.Rodada;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by virgiliomagalhaes on 10/22/2017.
 */

public class RodadaDeserializer implements JsonDeserializer<Rodada> {

  private static final String ID = "id";
  private static final String RODADA = "rodada";
  private static final String PARTIDAS = "partidas";
  private static final String CLUBES = "clubes";
  private static final String ESCUDOS = "escudos";
  private static final String NOME = "nome";
  private static final String ABREVIACAO = "abreviacao";
  private static final String POSICAO = "posicao";
  private static final String ESCUDO_PEQUENO = "30x30";
  private static final String ESCUDO_MEDIO = "45x45";
  private static final String ESCUDO_GRANDE = "60x60";

  @Override
  public Rodada deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    JsonObject responseJsonObject = json.getAsJsonObject();

    int numeroRodada = Integer.parseInt(responseJsonObject.get(RODADA).toString());
    JsonArray jsonArrayPartidas = responseJsonObject.get(PARTIDAS).getAsJsonArray();
    Type listPartida = new TypeToken<List<Partida>>(){}.getType();
    List<Partida> partidas = new Gson().fromJson(jsonArrayPartidas, listPartida);
    List<Clube> clubes = new ArrayList<>();
    List<Partida> partidasAtualizadas = new ArrayList<>();

    JSONObject jsonObjectClubes = null;
    JSONObject jsonObjectEscudos = null;

    Rodada rodada = new Rodada();

    try {
      jsonObjectClubes = new JSONObject(responseJsonObject.get(CLUBES).toString());
      Iterator<String> keys = jsonObjectClubes.keys();

      while (keys.hasNext()) {

        String key = keys.next();

        if (jsonObjectClubes.get(key) instanceof JSONObject) {

          JSONObject jsonObjectClube = jsonObjectClubes.getJSONObject(key);
          jsonObjectEscudos = new JSONObject(jsonObjectClube.getString(ESCUDOS).toString());

          Clube clube = new Clube();
          clube.setId(Integer.parseInt(jsonObjectClube.getString(ID)));
          clube.setNome(jsonObjectClube.getString(NOME));
          clube.setAbreviacao(jsonObjectClube.getString(ABREVIACAO));
          clube.setPosicao(Integer.parseInt(jsonObjectClube.getString(POSICAO)));

          Escudo escudo = new Escudo();
          escudo.setGrande(jsonObjectEscudos.get(ESCUDO_GRANDE).toString());
          escudo.setMedio(jsonObjectEscudos.get(ESCUDO_MEDIO).toString());
          escudo.setPequeno(jsonObjectEscudos.get(ESCUDO_PEQUENO).toString());

          clube.setEscudos(escudo);
          clubes.add(clube);
          atualizarInfoPartidas(clube, partidas);
        }
      }
    } catch (JSONException e) {
      Log.e("JSONException", e.getMessage());
    }

    rodada.setClubes(clubes);
    rodada.setPartidas(partidas);
    rodada.setRodada(numeroRodada);

    return rodada;
  }

  private void atualizarInfoPartidas(Clube clube, List<Partida> partidas) {

    for (Partida partida : partidas) {

      if (clube.getId() == partida.getClubeCasaId()) {
        partida.setClubeCasa(clube);
      }

      if (clube.getId() == partida.getClubeVisitanteId()) {
        partida.setClubeVisitante(clube);
      }

      SimpleDateFormat formatoDataServico = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      Date data = null;

      try {
        data = formatoDataServico.parse(partida.getPartidaData());
        partida.setDataFormatada(data);
      } catch (ParseException e) {
        Log.e("ParseException", e.getMessage());
      }
    }
  }
}
