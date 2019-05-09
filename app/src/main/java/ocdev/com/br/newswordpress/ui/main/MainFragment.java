package ocdev.com.br.newswordpress.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import javax.security.auth.callback.Callback;

import ocdev.com.br.newswordpress.Adapters.RecyclerViewNoticiasAdapter;
import ocdev.com.br.newswordpress.Data.Model.ResponseNews;
import ocdev.com.br.newswordpress.R;

public class MainFragment extends Fragment  {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainViewModel mViewModel;
    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View viewroot = inflater.inflate(R.layout.main_fragment, container, false);



        recyclerView = (RecyclerView) viewroot.findViewById(R.id.recyclerview_noticias);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        return viewroot;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);


         mViewModel.getNews().observe(this, new Observer<ResponseNews>() {
            @Override
            public void onChanged(@Nullable ResponseNews responseNews) {
                // define an adapter
                mAdapter = new RecyclerViewNoticiasAdapter(responseNews.getArticles());
                recyclerView.setAdapter(mAdapter);



            }
        });
        // TODO: Use the ViewModel





    }

}
