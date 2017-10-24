package com.virgiliomagalhaes.futebol.adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.virgiliomagalhaes.futebol.R;

/**
 * Created by virgiliomagalhaes on 10/23/2017.
 */

public class ImageBindingAdapter {
  @BindingAdapter({"bind:imageUrl"})
  public static void loadImage(ImageView view, String url) {
    Picasso.with(view.getContext())
        .load(url)
        .placeholder(R.drawable.football)
        .into(view);
  }
}
