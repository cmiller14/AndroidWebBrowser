package com.a02283751.webbroswer;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatEditText;

public class SearchBar extends LinearLayout {

    private AppCompatEditText search;

    public SearchBar(Context context) {
        super(context);
        //Search bar
        this.search = new AppCompatEditText(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.weight = 1;
        search.setLayoutParams(params);
        addView(search);
    }

    public String getText(){
        return getText(search);
    }
    private String getText(AppCompatEditText searchBar) {
        return searchBar.getText().toString();
    }

    public void setText(String text) {
        search.setText(text);
    }

}
