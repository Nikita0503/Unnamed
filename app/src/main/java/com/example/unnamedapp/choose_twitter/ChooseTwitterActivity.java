package com.example.unnamedapp.choose_twitter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.unnamedapp.BaseContract;
import com.example.unnamedapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseTwitterActivity extends AppCompatActivity implements BaseContract.BaseView {

    @BindView(R.id.webView)
    WebView webViewTwitter;

    @OnClick(R.id.buttonRemember)
    void onClickRemember(){
        Toast.makeText(getApplicationContext(), webViewTwitter.getOriginalUrl(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_twitter);
        initViews();
        webViewTwitter.loadUrl("https://www.twitter.com/");
        webViewTwitter.getSettings().setJavaScriptEnabled(true);
        webViewTwitter.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webViewTwitter.canGoBack()) {
            this.webViewTwitter.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void initViews() {
        ButterKnife.bind(this);
    }
}
