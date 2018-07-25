package com.jm.jonathanmoreno.androidfavoritequotes.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jm.jonathanmoreno.androidfavoritequotes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {


    @BindView(R.id.authordetail)
    TextView authorDetail;
    @BindView(R.id.quotedetail)
    TextView quoteDetail;
    @BindView(R.id.biodetail)
    TextView bioDetail;

    @BindView(R.id.authorimageview)
    ImageView authorImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        String author  = getIntent().getExtras().getString("favoritequote_author");
        String quote = getIntent().getExtras().getString("favoritequote_quote");
        String biography = getIntent().getExtras().getString("favoritequote_bio") ;
        String img = getIntent().getExtras().getString("favoritequote_img");


        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);


        authorDetail.setText(author);
        quoteDetail.setText(quote);
        bioDetail.setText(biography);

        collapsingToolbarLayout.setTitle(author);

        RequestOptions requestOptions = new RequestOptions().centerCrop();


        Glide.with(this).load(img).apply(requestOptions).into(authorImageView);





    }
}
