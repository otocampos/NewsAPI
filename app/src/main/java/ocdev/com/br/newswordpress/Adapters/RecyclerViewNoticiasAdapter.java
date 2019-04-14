package ocdev.com.br.newswordpress.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ocdev.com.br.newswordpress.Data.Model.Article;
import ocdev.com.br.newswordpress.Data.Model.ResponseNews;
import okhttp3.Response;

//TUTORIAL 

// TODO: 14/04/2019 CONTINUAR TUTORIAL DE DATABIND https://www.androidhive.info/android-databinding-in-recyclerview-profile-screen/ 


public class RecyclerViewNoticiasAdapter extends RecyclerView.Adapter<RecyclerViewNoticiasAdapter.ActivityAdapterViewHolder> {

    private Context context;
    private List<Article> mResultNoticiasData;
    @NonNull
    @Override
    public RecyclerViewNoticiasAdapter.ActivityAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewNoticiasAdapter.ActivityAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }




    public class ActivityAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public ActivityAdapterViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
