package com.virgiliomagalhaes.futebol.app;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.virgiliomagalhaes.futebol.R;
import com.virgiliomagalhaes.futebol.adapter.SectionsPagerAdapter;
import com.virgiliomagalhaes.futebol.model.Rodada;
import com.virgiliomagalhaes.futebol.service.FutebolAPIBuilder;
import com.virgiliomagalhaes.futebol.service.FutebolService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

  private static FutebolService futebolService;
  private SectionsPagerAdapter mSectionsPagerAdapter;
  private Rodada rodada;
  private CompositeDisposable disposables = new CompositeDisposable();
  private ViewPager mViewPager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getRodadas();

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

  private void setViewPager() {
    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), getRodada());
    mViewPager = (ViewPager) findViewById(R.id.container);
    mViewPager.setAdapter(mSectionsPagerAdapter);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(mViewPager);
  }

  private void setRodada(Rodada rodada) {
    this.rodada = rodada;
  }

  private Rodada getRodada() {
    return this.rodada;
  }

  private void getRodadas() {
    futebolService = FutebolAPIBuilder.getFutebolService();
    Observable<Rodada> rodadaObservable = futebolService.getPartidas();
    disposables.add(rodadaObservable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableObserver<Rodada>() {
          @Override public void onNext(Rodada rodada) {
            setRodada(rodada);
          }

          @Override public void onError(Throwable e) {
          }

          @Override public void onComplete() {
            setViewPager();
          }
        }));
  }

  @Override public void onDestroy() {
    disposables.clear();
    super.onDestroy();
  }
}
