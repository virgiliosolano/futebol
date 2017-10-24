package com.virgiliomagalhaes.futebol.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.virgiliomagalhaes.futebol.R;
import com.virgiliomagalhaes.futebol.databinding.ItemClubeBinding;
import com.virgiliomagalhaes.futebol.databinding.ItemPartidaBinding;
import com.virgiliomagalhaes.futebol.model.Clube;
import com.virgiliomagalhaes.futebol.model.Partida;
import java.util.List;

/**
 * Created by virgiliomagalhaes on 10/23/2017.
 */

public class PartidasAdapter extends RecyclerView.Adapter<PartidasAdapter.ViewHolder> {

  private List<Partida> partidaList;

  public PartidasAdapter(List<Partida> partidaList) {
    this.partidaList = partidaList;
  }

  @Override public PartidasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_partida, parent, false);
    ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override public void onBindViewHolder(PartidasAdapter.ViewHolder holder, int position) {
    final Partida partida = partidaList.get(position);
    holder.itemPartidaBinding.setPartida(partida);
    holder.itemPartidaBinding.executePendingBindings();
  }

  @Override public int getItemCount() {
    return partidaList.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    private final ItemPartidaBinding itemPartidaBinding;

    public ViewHolder(View itemView) {
      super(itemView);
      itemPartidaBinding = ItemPartidaBinding.bind(itemView);
    }
  }
}
