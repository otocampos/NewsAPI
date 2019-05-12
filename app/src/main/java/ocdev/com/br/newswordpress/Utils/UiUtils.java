package ocdev.com.br.newswordpress.Utils;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.adapters.ListenerUtil;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ocdev.com.br.newswordpress.Constantes.Constantes;
import ocdev.com.br.newswordpress.Data.Model.Article;
import ocdev.com.br.newswordpress.MainActivity;
import ocdev.com.br.newswordpress.R;
import ocdev.com.br.newswordpress.ui.main.MainViewModel;

public class UiUtils {
    @BindingAdapter("android:src")
    public static void LoadImageUrl(ImageView view, String url) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.communication);
        requestOptions.error(android.R.drawable.stat_notify_error);
        requestOptions.fallback(R.drawable.communication);

        Glide.with(view.getContext()).
                load(url).
                apply(requestOptions).
                into(view);
    }

    @BindingAdapter("convertdatatimeUTC")
    public static void ConvertDateUTC(TextView txtView, String datePublished) {

        try {
            SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

            Date dt = sd1.parse(datePublished);
            SimpleDateFormat sd2 = new SimpleDateFormat("dd-MM-yyyy");
            String newDate = sd2.format(dt);
            txtView.setText(newDate);

        } catch (ParseException e) {
            e.printStackTrace();
            txtView.setText("Erro");
        }
    }


    @BindingAdapter("TextNoInternet")
    public static void AvisarUsuarioSemInternet(TextView txtView, String Aviso) {

        if (NetWorkUtils.isConnected(txtView.getContext())) {
            txtView.setVisibility(View.GONE);
        } else {
            txtView.setVisibility(View.VISIBLE);
            txtView.setText(Aviso);
        }
    }

    public static String ControlarLoadCategoria(int id) {
        String categoria = null;
        if (id == R.id.categoria_general) {
            categoria = Constantes.CATEGORY_NAME_GENERAL;
        } else if (id == R.id.categoria_business) {
            categoria = Constantes.CATEGORY_NAME_BUSINESS;
        } else if (id == R.id.categoria_entertainment) {
            categoria = Constantes.CATEGORY_NAME_ENTERTAINMENT;
        } else if (id == R.id.categoria_health) {
            categoria = Constantes.CATEGORY_NAME_HEALTH;
        } else if (id == R.id.categoria_science) {
            categoria = Constantes.CATEGORY_NAME_SCIENCE;
        } else if (id == R.id.categoria_sports) {
            categoria = Constantes.CATEGORY_NAME_SPORTS;
        } else if (id == R.id.categoria_technology) {
            categoria = Constantes.CATEGORY_NAME_TECNOLOGY;
        }

        return categoria;
    }

    @BindingAdapter("clickrecyclerview")
    public static void OnclickRecyclerview(TextView view, int estado) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("teste", String.valueOf(estado));
            }
        });

    }


}


