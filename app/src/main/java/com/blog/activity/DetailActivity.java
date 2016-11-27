package com.blog.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blog.R;
import com.blog.model.Wp;
import com.bumptech.glide.Glide;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class DetailActivity extends AppCompatActivity {

    private ImageView sharingButton;
    private ArrayList<Wp> mValues;
    private ArrayList<String> imageUrlList =  new ArrayList<String>();
    private int position;
    private String authorName = "";
    private TextView productTitle;
    private TextView toolbarTitle;
    private TextView productInfo;
    private ImageView productImage;
    private WebView myWebView;
    private int screenWidth;
    private Typeface typeFace;
    private ImageView callImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        // Set a Toolbar to replace the ActionBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        typeFace= Typeface.createFromAsset(getAssets(),"fonts/OpenSans-Light.ttf");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            position = extras.getInt("position");
            mValues = (ArrayList<Wp>) getIntent().getSerializableExtra("mValues");
        }

        myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
//        webSettings.setBuiltInZoomControls(true);
        webSettings.setDefaultFontSize(20);


        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setBuiltInZoomControls(true); // allow pinch to zooom
        myWebView.getSettings().setDisplayZoomControls(false); // disable the default zoom controls on the page

        productTitle = (TextView) findViewById(R.id.product_title);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        productInfo = (TextView) findViewById(R.id.product_info);
        productImage = (ImageView) findViewById(R.id.product_image);
        productTitle.setTypeface(typeFace);
        productInfo.setTypeface(typeFace);

        Glide.with(DetailActivity.this)
                .load(mValues.get(position).getEmbedded().getWpFeaturedmedia().get(0)
                        .getMediaDetails().getSizes().getFull().getSourceUrl())
                .placeholder(R.drawable.big_placeholder)
                .into(productImage);



        String title = mValues.get(position).getTitle().getRendered().replace("-", " ");
        title = title.toLowerCase();
        title = title.substring(0, 1).toUpperCase() + title.substring(1);
        String toolbTitle = title.substring(0, 20)+"...";

        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        DateFormat targetFormat = new SimpleDateFormat("d MMM yyyy hh:mm aaa");
        String dateGmt = mValues.get(position).getDateGmt().replace("T", " ");
        Date date;
        String formattedDate = "";
        try {
            date = originalFormat.parse(dateGmt);
            formattedDate = targetFormat.format(date);
        }
        catch (Exception e){
            e.toString();
        }

        try {
            productTitle.setText(title);
            toolbarTitle.setText(toolbTitle);
            productInfo.setText(formattedDate);
            String posterName = mValues.get(position).getEmbedded().getAuthor().get(0).getName();
            productInfo.setText(productInfo.getText() + " - By " + posterName);

            myWebView.setWebChromeClient(new WebChromeClient());

            screenWidth = getWindowManager()
                    .getDefaultDisplay().getWidth();
            int myAPI = Build.VERSION.SDK_INT;

            String fontSize = "15";
            if (myAPI > 20) {
                fontSize = "55";
            }

            String s = "<head><meta name='viewport' content='target-densityDpi=device-dpi'/></head>";
            String style = "" +
                    "<style> " +
                    "img { height:auto !important; width:100% !important; } " +
                    "iframe { height:" + String.valueOf(screenWidth) + "px !important; width:100% !important; }" +
                    "html { padding:0; margin:0; font-size:" + fontSize + "px; } " +
                    "</style>";
            //@font-face { font-family: OpenSans-Light; src: url("file:///android_asset/fonts/OpenSans-Regular.ttf}

            String content = mValues.get(position).getContent().getRendered();

            myWebView.loadDataWithBaseURL("", s + style + content, "text/html", "UTF-8", "");

            sharingButton = (ImageView) findViewById(R.id.share);
            sharingButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    shareIt();
                }
            });
        } catch (Exception e){
            e.toString();
            Toast.makeText(DetailActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
        }

        callImage = (ImageView) findViewById(R.id.call_image);
        callImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });

    }

    public void call(){
        try {
            String ussd = "+2347063553818";
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ussd)));
        } catch (SecurityException e){
            e.toString();
        }
    }

    private void shareIt() {
        //sharing implementation here
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Here is the share content body";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                onBackPressed();
                return true;
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }





}
