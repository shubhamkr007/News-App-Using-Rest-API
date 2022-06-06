package com.example.newsappusingrestapi.Listeners;


import com.example.newsappusingrestapi.Models.NewsHeadline;

import java.util.List;

public interface OnFetchDataListener<T> {
    void onFetchData(List<NewsHeadline> data, String message);
    void onError(String message);

}
