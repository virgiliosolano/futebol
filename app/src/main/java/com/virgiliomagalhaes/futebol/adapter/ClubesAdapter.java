package com.virgiliomagalhaes.futebol.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.virgiliomagalhaes.futebol.R;
import com.virgiliomagalhaes.futebol.databinding.ItemClubeBinding;
import com.virgiliomagalhaes.futebol.model.Clube;
import java.util.List;

/**
 * Created by virgiliomagalhaes on 10/23/2017.
 */

public class ClubesAdapter extends RecyclerView.Adapter<ClubesAdapter.ViewHolder> {

  private List<Clube> clubesList;

  public ClubesAdapter(List<Clube> clubesList) {
    this.clubesList = clubesList;
  }

  @Override public ClubesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clube, parent, false);
    ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override public void onBindViewHolder(ClubesAdapter.ViewHolder holder, int position) {
    final Clube clube = clubesList.get(position);
    holder.itemClubeBinding.setClube(clube);
    holder.itemClubeBinding.executePendingBindings();
    holder.itemClubeBinding.textViewPosicao.setText(String.valueOf(clube.getPosicao()));
  }

  @Override public int getItemCount() {
    return clubesList.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    private final ItemClubeBinding itemClubeBinding;

    public ViewHolder(View itemView) {
      super(itemView);
      itemClubeBinding = ItemClubeBinding.bind(itemView);
    }
  }
}
