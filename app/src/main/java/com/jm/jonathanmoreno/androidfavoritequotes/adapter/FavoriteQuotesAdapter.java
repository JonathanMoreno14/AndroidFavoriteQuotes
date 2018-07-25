package com.jm.jonathanmoreno.androidfavoritequotes.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.jm.jonathanmoreno.androidfavoritequotes.R;
import com.jm.jonathanmoreno.androidfavoritequotes.activities.DetailActivity;
import com.jm.jonathanmoreno.androidfavoritequotes.model.FavoriteQuotes;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteQuotesAdapter extends RecyclerView.Adapter<FavoriteQuotesAdapter.FavoriteQuotesViewHolder> {


    private int lastPosition = -1;
    private RequestOptions requestOptions;
    private Context context;
    private List<FavoriteQuotes> quoteData;

    public FavoriteQuotesAdapter(Context context, List<FavoriteQuotes> list){
        this.context = context;
        this.quoteData = list;

    }
    @Override
    public FavoriteQuotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        final View view;
//        LayoutInflater layoutInflater = LayoutInflater.from(context);
//        view = layoutInflater.inflate(R.layout.favoritequote_row_item ,parent, false);
//
//        return new FavoriteQuotesViewHolder(view);

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.favoritequote_row_item ,parent, false);
        final FavoriteQuotesViewHolder viewHolder = new FavoriteQuotesViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, DetailActivity.class);

                i.putExtra("favoritequote_author",quoteData.get(viewHolder.getAdapterPosition()).getAuthor());
                i.putExtra("favoritequote_bio",quoteData.get(viewHolder.getAdapterPosition()).getBio());
                i.putExtra("favoritequote_img",quoteData.get(viewHolder.getAdapterPosition()).getImg());
                i.putExtra("favoritequote_quote",quoteData.get(viewHolder.getAdapterPosition()).getQuote());



                context.startActivity(i);

            }
        });

        return viewHolder;


    }


    @Override
    public  void onBindViewHolder(FavoriteQuotesViewHolder holder, final int position){
        FavoriteQuotes favoriteQuotes = quoteData.get(position);
        holder.quoteTextView.setText(favoriteQuotes.getQuote());
        holder.authorTextView.setText(favoriteQuotes.getAuthor());
      // Glide.with(context).load(favoriteQuotes.getImg()).apply(requestOptions).into(holder.authorImage);



        Glide.with(context)
                .load(favoriteQuotes.getImg())
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher_round)
                        .centerCrop()
                        .dontAnimate()
                        .dontTransform())
                .into(holder.authorImage);


        setAnimation(holder.itemView,  position);


    }

    @Override
    public int getItemCount(){
        return quoteData.size();
    }


    public static class FavoriteQuotesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.quotetextview)
        TextView quoteTextView;
        @BindView(R.id.authortextview)
        TextView authorTextView;

        @BindView(R.id.authorimage)
        ImageView authorImage;

        RelativeLayout view_container;


        public FavoriteQuotesViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            view_container = itemView.findViewById(R.id.container);
        }

    }


    private void setAnimation(View viewToAnimate, int position)
    {

        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }


}
