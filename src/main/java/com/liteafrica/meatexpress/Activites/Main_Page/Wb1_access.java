package com.liteafrica.meatexpress.Activites.Main_Page;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.liteafrica.meatexpress.Activites.Canteen.Canteen_Mainactivity;
import com.liteafrica.meatexpress.Login.ServiceOffer;
import com.liteafrica.meatexpress.PrefManager;
import com.liteafrica.meatexpress.R;

import java.util.HashMap;


public class Wb1_access extends AppCompatActivity implements View.OnClickListener {

    private WebView webView;
    private Toolbar toolbar;
    private String postUrl;
    private ProgressBar progressBar;
    private TextView orders;
    private ImageView _i4;
    private PrefManager pref;
    private String _PhoneNo;
    private int _from;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        postUrl = i.getStringExtra("url");
        _from = i.getIntExtra("from", 0);
        if (postUrl == null) {
            postUrl = "http://139.59.38.160/eTez/privacy/";
        }

        setContentView(R.layout.webb_access);

        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);
        webView.setWebViewClient(new CustomWebViewClient());
        WebSettings webSetting = webView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);
        webView.loadUrl(postUrl);


        orders = findViewById(R.id.orders);
        pref = new PrefManager(getApplicationContext());
        HashMap<String, String> user = pref.getUserDetails();
        _PhoneNo = user.get(PrefManager.KEY_MOBILE);
        if (pref.get_food_items() != 0) {
            orders.setText(String.valueOf(pref.get_food_items()));

        }

        TextView _address = findViewById(R.id.address);
        if (pref.getDropAt() != null) {
            _address.setText(pref.getDropAt());
        }
        _i4 = findViewById(R.id._i4);
        _i4.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_white, menu);
        return true;

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        } else {
            finish();
            return true;
        }

        // return super.onKeyDown(keyCode, event);
    }


    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(Wb1_access.this, Canteen_Mainactivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id._i4: {
                if (_PhoneNo != null) {
                    if (pref.get_food_money() != 0) {
                        pref.set_cID1(1);
                        Intent o = new Intent(Wb1_access.this, GooglemapApp.class);
                        startActivity(o);
                        overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                        finish();

                    } else {
                        if (!Wb1_access.this.isFinishing()) {
                            new AlertDialog.Builder(Wb1_access.this, R.style.AlertDialogTheme)
                                    .setTitle("Your cart is empty")
                                    .setMessage("Please add items to your cart.")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                            Intent o = new Intent(Wb1_access.this, Canteen_Mainactivity.class);
                                            startActivity(o);
                                            finish();
                                            overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                                        }
                                    })
                                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    })
                                    .show();
                        }
                    }
                } else {
                    if (!Wb1_access.this.isFinishing()) {
                        new AlertDialog.Builder(Wb1_access.this, R.style.AlertDialogTheme)
                                .setTitle("Please login.")
                                .setMessage("You need to login to complete your order.")
                                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                        Intent o = new Intent(Wb1_access.this, ServiceOffer.class);

                                        startActivity(o);
                                        finish();
                                        overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                })
                                .show();
                    }
                }


            }
            break;
        }
    }

    private class CustomWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            // TODO Auto-generated method stub
            Toast.makeText(Wb1_access.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            //super.onReceivedError(view, errorCode, description, failingUrl);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }

}
