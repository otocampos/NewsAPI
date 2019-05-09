package ocdev.com.br.newswordpress.Utils;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.adapters.ListenerUtil;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
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


}


