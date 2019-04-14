package ocdev.com.br.newswordpress.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ocdev.com.br.newswordpress.Constantes.Constantes;
import ocdev.com.br.newswordpress.Data.Model.ResponseNews;
import ocdev.com.br.newswordpress.Data.Rest.ApiService;
import ocdev.com.br.newswordpress.Utils.ApiFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<ResponseNews> NewsList;
    private ApiService api;

    //we will call this method to get the data
    public LiveData<ResponseNews> getNews() {
        //if the list is null
        if (NewsList == null) {
            NewsList = new MutableLiveData<>();


            //we will load it asynchronously from server in this method
            loadNews();
        }
        return NewsList;
    }


    public void loadNews() {

        Single<Response<ResponseNews>> testObservable = ApiFactory.create().getNewsByCountry(Constantes.COUNTRY_NEWS, Constantes.KeyNewsApi);
        testObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<ResponseNews>>() {


                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onSuccess(Response<ResponseNews> value) {
                                   NewsList.setValue(value.body());
                                   //Log.v("testeload", value.body().getArticles().get(0).getTitle());
                                   for (int i = 0; i < value.body().getArticles().size(); i++) {
                                       Log.v("testeload", value.body().getArticles().get(i).getTitle());
                                   }
                               }

                               @Override
                               public void onError(Throwable e) {
                                   Log.v("testerro", e.getMessage());
                               }
                           }
                );

    }
}






