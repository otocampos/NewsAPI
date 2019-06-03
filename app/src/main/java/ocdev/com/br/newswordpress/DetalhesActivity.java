package ocdev.com.br.newswordpress;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ocdev.com.br.newswordpress.Data.Model.Article;
import ocdev.com.br.newswordpress.databinding.ActivityDetalhesBinding;
import ocdev.com.br.newswordpress.ui.main.DetalhesViewModel;

public class DetalhesActivity extends AppCompatActivity {
    private DetalhesViewModel mViewModel;
    String str;
    ActivityDetalhesBinding contentDetalhesBinding;
    Article article;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mViewModel = ViewModelProviders.of(this).get(DetalhesViewModel.class);
        if (savedInstanceState == null) {
            article = getIntent().getParcelableExtra("noticia");
            mViewModel.setNoticia(article);
        }
        contentDetalhesBinding = DataBindingUtil.setContentView(this, R.layout.activity_detalhes);


        mViewModel.getDetalheNoticia().observe(this, new Observer<Article>() {
            @Override
            public void onChanged(@Nullable Article article) {
                contentDetalhesBinding.setNews(article);
                contentDetalhesBinding.contentNoticias.webviewNoticia.getSettings().setJavaScriptEnabled(true);
                contentDetalhesBinding.contentNoticias.webviewNoticia.loadUrl(article.getUrl());
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

}
