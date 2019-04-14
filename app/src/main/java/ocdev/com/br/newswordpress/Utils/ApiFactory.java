package ocdev.com.br.newswordpress.Utils;

import ocdev.com.br.newswordpress.Data.Rest.ApiService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static ocdev.com.br.newswordpress.Constantes.Constantes.BASE_URL;

public class ApiFactory {

    public static ApiService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }
}
