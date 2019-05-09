package ocdev.com.br.newswordpress.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;

import java.util.List;

import ocdev.com.br.newswordpress.Data.Model.Article;
import ocdev.com.br.newswordpress.Data.Model.ResponseNews;
import ocdev.com.br.newswordpress.R;
import okhttp3.Response;

//TUTORIAL 

// TODO: 14/04/2019 CONTINUAR TUTORIAL DE DATABIND https://www.androidhive.info/android-databinding-in-recyclerview-profile-screen/ 


public class RecyclerViewNoticiasAdapter extends RecyclerView.Adapter<RecyclerViewNoticiasAdapter.MyViewHolder> {
    private List<Article> data;

    public RecyclerViewNoticiasAdapter(List<Article> myDataset) {
        data = myDataset;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private final ViewDataBinding binding;

        public MyViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object obj) {
            binding.setVariable(BR.news, obj);
            binding.executePendingBindings();
        }
    }


    @NonNull
    @Override
    public RecyclerViewNoticiasAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_view_item_noticias, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewNoticiasAdapter.MyViewHolder holder, int position) {
        final Article article = data.get(position);
        holder.bind(article);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
