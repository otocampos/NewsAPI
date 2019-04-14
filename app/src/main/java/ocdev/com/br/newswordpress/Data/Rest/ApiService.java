package ocdev.com.br.newswordpress.Data.Rest;

import io.reactivex.Single;
import ocdev.com.br.newswordpress.Constantes.Constantes;
import ocdev.com.br.newswordpress.Data.Model.ResponseNews;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET(Constantes.TOP_HEADLINES)
    Single<Response<ResponseNews>> getNewsByCountry(@Query(Constantes.COUNTRY) String country, @Query(Constantes.CONSTANTE_KEY_API) String keyapi);
}
