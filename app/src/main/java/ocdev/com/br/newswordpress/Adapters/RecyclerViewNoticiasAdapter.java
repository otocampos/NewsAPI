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
import ocdev.com.br.newswordpress.R;
import ocdev.com.br.newswordpress.ui.main.DetalhesViewModel;

//TUTORIAL 


public class RecyclerViewNoticiasAdapter extends RecyclerView.Adapter<RecyclerViewNoticiasAdapter.MyViewHolder> {
    private List<Article> data;
    DetalhesViewModel mainViewModel;
    Context context;
    private OnClickNoticia onClickNoticia;


    public interface OnClickNoticia {
        void getDetalhesNoticias(Article article);
    }


    public RecyclerViewNoticiasAdapter(OnClickNoticia onClickNoticia) {
        this.onClickNoticia = onClickNoticia;
    }


    @NonNull
    @Override
    public RecyclerViewNoticiasAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_view_item_noticias, parent, false);
        context = parent.getContext();


        // set the view's size, margins, paddings and layout parameters
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewNoticiasAdapter.MyViewHolder holder, int position) {
        final Article article = data.get(position);
        holder.bind(article);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickNoticia.getDetalhesNoticias(data.get(position));


            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
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

    public void setNoticiasData(List<Article> data) {
        this.data = data;
    }


}
