package com.blog.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.blog.R;
import com.blog.adapter.ExpandableListAdapter;
import com.blog.adapter.LoadAdapter;
import com.blog.model.Wp;
import com.blog.singleton.RestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class LoadActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /** Expandable List **/
    private ArrayList<String> groupList;
    private ArrayList<String> childList;
    private HashMap<Integer, List<Integer>> categoryIdList;
    private HashMap<String, List<String>> laptopCollection;
    private ExpandableListView expListView;
    private int lastExpandedPosition = -1;
    private int firstExpandedPosition = 0;

    ImageView closeButton;
    private RecyclerView view;
    private ArrayList<Wp> data = new ArrayList<Wp>();
    private SwipeRefreshLayout swipeContainer;
    LinearLayoutManager linearLayoutManager;
     LoadAdapter loadAdapter;
    private ArrayList<String> imagesData = new ArrayList<String>();
    String sourceUrl;

    int totalItemCount;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);


        view = (RecyclerView) findViewById(R.id.product_recycler);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(linearLayoutManager);

        view.setHasFixedSize(true);
        view.setLayoutManager(new LinearLayoutManager(this));




        RestClient.getInstance().getPosts(new Callback<List<Wp>>() {
            @Override
            public void success(List<Wp> info, Response response) {
                data = new ArrayList<Wp>(info);

                loadAdapter = new LoadAdapter(LoadActivity.this, data, view);
                view.setAdapter(loadAdapter);
                progressBar.setVisibility(View.GONE);

                // Lazy loading
                // add scroll listener
                loadAdapter.setOnLoadMoreListener(new LoadAdapter.OnLoadMoreListener() {

                    @Override
                    public void onLoadMore(int page, int totalCount) {

                        totalItemCount = totalCount;

                        // fetch data here
                        int perPage = 10;
                        RestClient.getInstance().getPostPaginate(page, perPage, new Callback<List<Wp>>() {
                            @Override
                            public void success(List<Wp> info, Response response) {
                                data = new ArrayList<Wp>(info);
                                //remove progress item
                                //data.remove(data.size() - 1);
                                //loadAdapter.notifyItemRemoved(data.size());


                                loadAdapter.setLoaded();
                                loadAdapter.addAll(data, totalItemCount, data.size());
                                //loadAdapter.notifyDataSetChanged();
                                //System.out.println("Requested more info" + data.get(0).getTitle().getRendered());

                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(LoadActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                Log.d("RetrofitError: ", error.getLocalizedMessage());
                            }
                        });

                    }
                });

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(LoadActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("RetrofitError: ", error.getLocalizedMessage());
            }
        });





















        initExpandableList();
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
        RestClient.getInstance().getPosts(new Callback<List<Wp>>() {
            @Override
            public void success(List<Wp> info, Response response) {
                data = new ArrayList<Wp>(info);


                view.setLayoutManager(new LinearLayoutManager(view.getContext()));
                view.setAdapter(new LoadAdapter(LoadActivity.this, data, view));
                // Now we call setRefreshing(false) to signal refresh has finished
                swipeContainer.setRefreshing(false);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(LoadActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("RetrofitError: ", error.getLocalizedMessage());
            }
        });
    }






    private void initExpandableList(){

        createGroupList();
        createCollection();
        expListView = (ExpandableListView) findViewById(R.id.menu_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, laptopCollection, categoryIdList);
        expListView.setAdapter(expListAdapter);
        expListView.setFocusable(false);
        //expListView.expandGroup(0);
        if(groupList.size()!=0){
            //expListView.expandGroup(0);
        }

        //setGroupIndicatorToRight();
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                final String selected = (String) expListAdapter.getChild(
                        groupPosition, childPosition);
                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG)
                        .show();
                return true;
            }
        });

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                if (firstExpandedPosition == 0) {
                    lastExpandedPosition = firstExpandedPosition;
                    firstExpandedPosition = 99; //any random number apart from zero
                }

                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroup(lastExpandedPosition);
                }

                lastExpandedPosition = groupPosition;
            }
        });
    }

    /** Expandable List View **/
    private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("Women Apparels");
        groupList.add("Men Apparels");
        groupList.add("Kids Apparels");
        groupList.add("Footwear");
        groupList.add("Accessories");
        groupList.add("Beauty");
    }


    private void createCollection() {
        // preparing laptops collection(child)

        String[] ikeja = {"Apparel1", "Apparel1", "Apparel1", "Apparel1"};
        String[] festac = {"Apparel1", "Apparel1", "Apparel1", "Apparel1"};
        String[] galleria = {"Apparel1", "Apparel1", "Apparel1", "Apparel1"};
        String[] ph = {"Apparel1", "Apparel1", "Apparel1", "Apparel1"};
        String[] secabuja = {"Apparel1", "Apparel1", "Apparel1", "Apparel1"};
        String[] accra = {"Apparel1", "Apparel1", "Apparel1", "Apparel1"};



        laptopCollection = new LinkedHashMap<String, List<String>>();

        for (String laptop : groupList) {
            if (laptop.equals("Women Apparels")) {
                loadChild(ikeja);
            }
            else if (laptop.equals("Men Apparels"))
                loadChild(festac);
            else if (laptop.equals("Kids Apparels"))
                loadChild(galleria);
            else if (laptop.equals("Footwear"))
                loadChild(ph);
            else if (laptop.equals("Accessories"))
                loadChild(secabuja);
            else if (laptop.equals("Beauty"))
                loadChild(accra);

            laptopCollection.put(laptop, childList);
        }
    }

    private void loadChild(String[] laptopModels) {
        childList = new ArrayList<String>();
        for (String model : laptopModels)
            childList.add(model);
    }

    private void setGroupIndicatorToRight() {
        /* Get the screen width */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;

        expListView.setIndicatorBounds(width - getDipsFromPixel(35), width
                - getDipsFromPixel(5));
    }

    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

    public StringBuilder append(String[] split){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
            if (i != split.length - 1) {
                sb.append("\n\n");
            }
        }
        return sb;
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void myFancyMethod(View v) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
