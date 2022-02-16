package com.a02283751.webbroswer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        //make a list for the history to be stored in
        final List history = new List();

        //add a layout for the buttons
        LinearLayout buttonLayout = new LinearLayout(this);

        //add search bar to the main layout
        final SearchBar search = new SearchBar(this);
        mainLayout.addView(search);


        // web page
        final WebView webView = new WebView(this);
        webView.loadUrl("https://usu.edu");
        history.add("https://usu.edu");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        //make the button layout with its buttons and functionality
        ButtonLayout buttons = new ButtonLayout(this, webView, history, search);




        //set the main layout
        mainLayout.addView(buttons);
        mainLayout.addView(webView);
        setContentView(mainLayout);
    }
}