package com.blog.activity;

/**
 * Created by tosin on 8/5/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.blog.R;
import com.blog.adapter.ListingAdapter;
import com.blog.model.Categories;
import com.blog.model.Wp;
import com.blog.singleton.RestClient;
import com.blog.widget.MaterialProgressBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class CategoryActivity extends AppCompatActivity {

    /** Expandable List **/
    private ArrayList<String> groupList;
    private ArrayList<String> childList;
    private HashMap<String, List<String>> laptopCollection;
    private ExpandableListView expListView;
    private int lastExpandedPosition = -1;
    private int firstExpandedPosition = 0;

    ImageView closeButton;
    private RecyclerView view;
    private ArrayList<Wp> data = new ArrayList<Wp>();
    private ArrayList<Categories> categories = new ArrayList<Categories>();
    private SwipeRefreshLayout swipeContainer;
    LinearLayoutManager linearLayoutManager;
    ListingAdapter listingAdapter;
    private ArrayList<String> imagesData = new ArrayList<String>();
    ArrayList<String> imageUrlList =  new ArrayList<String>();

    int totalItemCount;
    private MaterialProgressBar progressBar;
    private LinearLayout lostConnect;
    private LinearLayout noResult;

    private int categoryId;
    private String categoryTitle;
    private ImageView callImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            categoryId = extras.getInt("categoryId");
            categoryTitle = extras.getString("categoryTitle");
            System.out.println("hello1 " + categoryId);
        }

        // Set a Toolbar to replace the ActionBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(categoryTitle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        progressBar = (MaterialProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        callImage = (ImageView) findViewById(R.id.call_image);
        callImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });

        lostConnect = (LinearLayout) findViewById(R.id.no_connection);
        noResult = (LinearLayout) findViewById(R.id.no_result);

        view = (RecyclerView) findViewById(R.id.product_recycler);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(linearLayoutManager);

        view.setHasFixedSize(true);
        view.setLayoutManager(new LinearLayoutManager(this));

        RestClient.getInstance().getPostByCategory(categoryId, new Callback<List<Wp>>() {
            @Override
            public void success(List<Wp> info, Response response) {
                data = new ArrayList<Wp>(info);

                if(data.size() > 0) {
                    listingAdapter = new ListingAdapter(CategoryActivity.this, data, view, imageUrlList);
                    view.setAdapter(listingAdapter);
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.GONE);
                    noResult.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void failure(RetrofitError error) {
                progressBar.setVisibility(View.GONE);
                view.setVisibility(View.GONE);
                //lostConnect.setVisibility(View.VISIBLE);
                    //Toast.makeText(CategoryActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    //Log.d("RetrofitError: ", error.getLocalizedMessage());
            }
        });


        pullToRefresh();
    }


    public void pullToRefresh(){
        // Pull to refresh
        // Lookup the swipe container view
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                fetchTimelineAsync(0);
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    public void fetchTimelineAsync(int page) {
        // Send the network request to fetch the updated data
        Toast.makeText(CategoryActivity.this, "Refreshing...", Toast.LENGTH_SHORT).show();


        RestClient.getInstance().getPostByCategory(categoryId, new Callback<List<Wp>>() {
            @Override
            public void success(List<Wp> info, Response response) {
                data = new ArrayList<Wp>(info);

                if(data.size() > 0) {
                    listingAdapter = new ListingAdapter(CategoryActivity.this, data, view, imageUrlList);
                    listingAdapter.notifyDataSetChanged();
                    view.setAdapter(listingAdapter);
                    progressBar.setVisibility(View.GONE);
                    // Now we call setRefreshing(false) to signal refresh has finished
                    swipeContainer.setRefreshing(false);
                } else {
                    progressBar.setVisibility(View.GONE);
                    noResult.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                progressBar.setVisibility(View.GONE);
                //lostConnect.setVisibility(View.VISIBLE);
                //Toast.makeText(HomeActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                //Log.d("RetrofitError: ", error.getLocalizedMessage());
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





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void myFancyMethod2(View v) {
        Context context = v.getContext();
        Intent intent = new Intent(context, DetailActivity.class);
        context.startActivity(intent);
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


}
