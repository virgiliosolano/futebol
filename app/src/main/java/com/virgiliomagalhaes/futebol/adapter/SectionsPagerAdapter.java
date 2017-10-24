package com.virgiliomagalhaes.futebol.adapter;

/**
 * Created by virgiliomagalhaes on 10/24/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.virgiliomagalhaes.futebol.app.futebol.FutebolFragment;
import com.virgiliomagalhaes.futebol.model.Rodada;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

  private static final String CLUBES = "CLUBES";
  private static final String PARTIDAS = "PARTIDAS";
  private Rodada rodada;

  public SectionsPagerAdapter(FragmentManager fm, Rodada rodada) {
    super(fm);
    this.rodada = rodada;
  }

  @Override
  public Fragment getItem(int position) {
    FutebolFragment futebolFragment = FutebolFragment.newInstance(position);

    if (position == 0) {
      futebolFragment.setClubeAdapter(rodada.getClubes());
    } else {
      futebolFragment.setPartidaAdapter(rodada.getPartidas());
    }

    return futebolFragment;
  }

  @Override
  public int getCount() {
    return 2;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return (position == 0) ? CLUBES : PARTIDAS;
  }
}