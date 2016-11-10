package com.blog.activity;

import android.content.Intent;
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
    TextView productTitle;
    TextView toolbarTitle;
    TextView productInfo;
    ImageView productImage;
    WebView myWebView;
    int screenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Set a Toolbar to replace the ActionBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            position = extras.getInt("position");
            mValues = (ArrayList<Wp>) getIntent().getSerializableExtra("mValues");
            imageUrlList = (ArrayList<String>) getIntent().getSerializableExtra("imageUrlList");
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

        imageUrlList.get(position);

        Glide.with(DetailActivity.this)
                .load(mValues.get(position).getEmbedded().getWpFeaturedmedia().get(0)
                        .getMediaDetails().getSizes().getFull().getSourceUrl())
                .placeholder(R.drawable.big_placeholder)
                .into(productImage);

        String title = mValues.get(position).getTitle().getRendered().replace("-", " ");
        title = title.substring(0, 1).toUpperCase() + title.substring(1);
        String toolbTitle = title.substring(0, 20)+"...";

        productTitle.setText(title);
        toolbarTitle.setText(toolbTitle);

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
        productInfo.setText(formattedDate);
        String posterName = mValues.get(position).getEmbedded().getAuthor().get(0).getName();
        productInfo.setText(productInfo.getText() + " - By " + posterName);







        myWebView.setWebChromeClient(new WebChromeClient());

        //myWebView.loadUrl("http://www.selectastyle.com/2016/04/chic-bold-latest-maju-collection-stars-models-tarmar-awobutu-jessica-chibueze/");
        String data = "To give more hype to her upcoming movie “<strong>The Scorned Help</strong>”, fast rising Nollywood actress <strong>Nsikan Isaac</strong> released some eye-catchy fashion photos, shot by <strong>Tobbinator</strong>.\n\n" +
                "<strong>Nsikan Isaac</strong> looks gorgeous in all the outfit she wore, and all we can say is that the<strong> GIAMA Awards</strong>nominee actress has her stylist to thank.\n\n" +
                "\n\n" +
                "See pictures below to know why we love Nsikan Isaac and her stylist <strong>MoAshy Styling</strong>\n\n" +
                "\n\n" +
                "<img class='alignnone' src='http://i2.wp.com/www.selectastyle.com/wp-content/uploads/2016/04/Nsikan-Isaac-1-selectastyle-8.jpg?w=600' alt='' width='600' height='900' />\n\n" +
                "\n\n" +
                "<img class='alignnone' src='http://i2.wp.com/www.selectastyle.com/wp-content/uploads/2016/04/Nsikan-Isaac-1-selectastyle-7.jpg?w=600' alt='' width='600' height='899' />\n\n" +
                "\n\n" +
                "<strong>Credit</strong>:\n\n" +
                "<strong>Photo credit</strong> @tobbinator\n\n" +
                "<strong>Makeup</strong> @dmannysglow\n\n" +
                "<strong>Fashion Stylist</strong> @moashystyling\n\n" +
                "<strong>Hair Stylist</strong> @bernardsmiles";

        screenWidth = getWindowManager()
                .getDefaultDisplay().getWidth();

        int myAPI = Build.VERSION.SDK_INT;

        System.out.println("hello1 " + myAPI);

        String fontSize = "15";
        if (myAPI > 20) {
            fontSize = "60";
        }


        String s="<head><meta name='viewport' content='target-densityDpi=device-dpi'/></head>";
        String style = "" +
                "<style> " +
                "img { height:auto !important; width:100% !important; } " +
                "iframe { height:" + String.valueOf(screenWidth) + "px !important; width:100% !important; }" +
                "html { padding:0; margin:0; font-size:"+ fontSize +"px; } " +
                "</style>";


        String content = mValues.get(position).getContent().getRendered();

        myWebView.loadDataWithBaseURL("", s + style + content, "text/html", "UTF-8", "");

        sharingButton = (ImageView) findViewById(R.id.share);
        sharingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                shareIt();
            }
        });
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
