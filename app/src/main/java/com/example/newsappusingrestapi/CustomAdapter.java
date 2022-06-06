package com.example.newsappusingrestapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsappusingrestapi.Listeners.SelectListener;
import com.example.newsappusingrestapi.Models.NewsHeadline;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<com.example.newsappusingrestapi.CustomViewHolder> {
    private Context context;
    private List<NewsHeadline> headlineList;
    private SelectListener listener;

    public CustomAdapter(Context context, List<NewsHeadline> headlineList, SelectListener listener) {
        this.context = context;
        this.headlineList = headlineList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public com.example.newsappusingrestapi.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new com.example.newsappusingrestapi.CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headlines_list_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.newsappusingrestapi.CustomViewHolder holder, int position) {
        holder.text_title.setText(headlineList.get(position).getTitle());
        if (headlineList.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlineList.get(position).getUrlToImage()).into(holder.img_headline);
        }
        holder.text_author.setText(headlineList.get(position).getSource().getName());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnNewsClicked(headlineList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlineList.size();
    }
}
