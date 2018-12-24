package com.example.a13877.themovieapplication.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a13877.themovieapplication.Adapter.NewsAdapter;
import com.example.a13877.themovieapplication.Model.News;
import com.example.a13877.themovieapplication.Model.NewsList;
import com.example.a13877.themovieapplication.R;
import com.example.a13877.themovieapplication.api.ApiServiceNews;

import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment implements NewsAdapter.OnMovieItemSelectedListener {
    private ApiServiceNews apiServiceNews;
     private NewsAdapter newsAdapter;
    private News news;
    private RecyclerView recyclerViewNews;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.news_fragment, container, false);


        newsAdapter=new NewsAdapter(getContext());
        newsAdapter.setOnMovieItemSelectedListener(this);
        recyclerViewNews = view.findViewById(R.id.recyclerViewNews);
        apiServiceNews = new ApiServiceNews();
        getActivity().setTitle("News");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getNewsList();
    }

    private void getNewsList() {

        apiServiceNews.getNews(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                //gives the message from the api hit
                Log.v("hope", "" + response.message());
                //gives the api successful code from api hit -return 200
                Log.v("hope", "" + response.code());
                //gives the error message from the api hit if any- in this case return null
                Log.v("hope", "" + response.errorBody());
                //return bollean from the api hit-in tis case return true
                        Log.v("hope", "" + response.isSuccessful());
                //gives the url of the api to be hit
                Log.v("hope", "" + call.request().url());
                 news = (News) response.body();

                //gives total results from api hit
                Log.v("hope", "" + news.getTotalResults());
                   if (news!= null)
                   {
                        if (newsAdapter != null) {
                            recyclerViewNews.setLayoutManager(new LinearLayoutManager(getActivity()));
                            recyclerViewNews.setHasFixedSize(true);
                            recyclerViewNews.setAdapter(newsAdapter);
                            newsAdapter.addAll(news.getArticles());

                            Toast.makeText(getContext(), "Loaded", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "No Data!", Toast.LENGTH_LONG).show();
                    }
            }


            @Override
            public void onFailure(Call call, Throwable t) {
                if (t instanceof SocketTimeoutException) {
                    Toast.makeText(getContext(), "Request Timeout. Please try again!", Toast.LENGTH_LONG).show();
                } else {
                    Log.v("hope,", "" + t.fillInStackTrace());

                    Toast.makeText(getContext(), "Connection Error!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    @Override
    public void onItemClick(NewsList newsList)
    {

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(newsList.getUrl()));
        startActivity(browserIntent);

    }
}