package com.virgiliomagalhaes.futebol.app.futebol;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.virgiliomagalhaes.futebol.R;
import com.virgiliomagalhaes.futebol.adapter.ClubesAdapter;
import com.virgiliomagalhaes.futebol.adapter.PartidasAdapter;
import com.virgiliomagalhaes.futebol.databinding.FragmentFutebolBinding;
import com.virgiliomagalhaes.futebol.model.Clube;
import com.virgiliomagalhaes.futebol.model.Partida;
import com.virgiliomagalhaes.futebol.model.Rodada;
import java.util.List;

public class FutebolFragment extends Fragment {

  private FragmentFutebolBinding fragmentFutebolBinding;
  private RecyclerView.Adapter<?> customAdapter;
  private Rodada rodada;
  private int viewPosition = 0;

  public FutebolFragment() { }

  public static FutebolFragment newInstance(int position) {
    FutebolFragment fragment = new FutebolFragment();
    Bundle bundle = new Bundle();
    bundle.putInt("pos", position);
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle bundle = this.getArguments();
    this.viewPosition = bundle.getInt("pos");
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    fragmentFutebolBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_futebol, container, false);
    View view = fragmentFutebolBinding.getRoot();
    setRecycleViewAdapter();
    return view;
  }

  private void setRecycleViewAdapter() {
    if (customAdapter != null) {
      fragmentFutebolBinding.recycleViewFutebol.setAdapter(customAdapter);
      fragmentFutebolBinding.recycleViewFutebol.setHasFixedSize(true);
      fragmentFutebolBinding.recycleViewFutebol.setLayoutManager(new LinearLayoutManager(getContext()));
      fragmentFutebolBinding.recycleViewFutebol.setItemAnimator(new DefaultItemAnimator());
      fragmentFutebolBinding.recycleViewFutebol.setNestedScrollingEnabled(true);
    }
  }

  public void setClubeAdapter(List<Clube> clubeList) {
    customAdapter = new ClubesAdapter(clubeList);
  }
  public void setPartidaAdapter(List<Partida> partidaList) {
    customAdapter = new PartidasAdapter(partidaList);
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    /*
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
    }*/
  }
}
