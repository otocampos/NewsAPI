package ocdev.com.br.newswordpress.ui.main;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import ocdev.com.br.newswordpress.Data.Model.Article;
import ocdev.com.br.newswordpress.DetalhesActivity;

public class DetalhesViewModel extends ViewModel {

    public final MutableLiveData<Article> detalhesNoticia = new MutableLiveData();


    public void setNoticia(Article article) {
        detalhesNoticia.setValue(article);
    }

    public MutableLiveData<Article> getDetalheNoticia() {

        return detalhesNoticia;
    }


}
