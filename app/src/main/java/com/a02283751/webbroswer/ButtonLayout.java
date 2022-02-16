package com.a02283751.webbroswer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;

public class ButtonLayout extends LinearLayout {

    private AppCompatButton go;
    private AppCompatButton back;
    private AppCompatButton forward;



    public ButtonLayout(Context context, WebView webView, List history, SearchBar search) {
        super(context);

        // go button
        this.go = new AppCompatButton(context);
        go.setText("Go");
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = search.getText();
                history.add(url);
                webView.loadUrl(url);

            }
        });

        // back button
        this.back= new AppCompatButton(context);
        back.setText("Back");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = history.goBack();
                webView.loadUrl(url);
                search.setText(url);
            }
        });

        //forward button
        this.forward = new AppCompatButton(context);
        forward.setText("Forward");
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = history.goForward();
                webView.loadUrl(url);
                search.setText(url);
            }
        });

        //make buttons layout look good
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.weight = 1;

        this.go.setLayoutParams(params);
        this.back.setLayoutParams(params);
        this.forward.setLayoutParams(params);

        addView(back);
        addView(go);
        addView(forward);


    }
}
