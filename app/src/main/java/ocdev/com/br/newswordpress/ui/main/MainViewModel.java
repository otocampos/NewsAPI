package ocdev.com.br.newswordpress.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseMethod;
import android.databinding.ObservableBoolean;
import android.databinding.adapters.ListenerUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
import ocdev.com.br.newswordpress.R;
import ocdev.com.br.newswordpress.Utils.ApiFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private static MutableLiveData<ResponseNews> NewsList;
    private ApiService api;
    public ObservableBoolean isLoading = new ObservableBoolean();

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

    public static void loadNews() {

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
                               }

                               @Override
                               public void onError(Throwable e) {
                                   Log.v("testerro", e.getMessage());
                               }
                           }
                );

    }





}



























