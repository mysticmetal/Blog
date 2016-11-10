package com.blog.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blog.R;
import com.blog.model.Wp;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Hp on 27/09/2015.
 */

public class ListingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private ArrayList<Wp> mValues;
    Context mContext;

    // The minimum amount of items to have below your current scroll position before loading more.
    private int visibleThreshold = 2;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private OnLoadMoreListener onLoadMoreListener;
    private int page = 1;

    BlogViewHolder blogViewHolder;


//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public String mBoundString;
//
//        public final View mView;
//        public final ImageView mImageView;
//        public final TextView mProductTitle, mProductDesc;
//
//        public ViewHolder(View view) {
//            super(view);
//            mView = view;
//            mImageView = (ImageView) view.findViewById(R.id.product_image);
//            mProductTitle = (TextView) view.findViewById(R.id.product_title);
//            mProductDesc = (TextView) view.findViewById(R.id.product_desc);
//
//        }
//
//        @Override
//        public String toString() {
//            return super.toString() + " '" + mProductTitle.getText();
//        }
//    }

    public String getValueAt(int position) {
        //return String.valueOf(mValues.get(position).getId());
        return String.valueOf(mValues.get(position).getId());
    }

    @Override
    public int getItemViewType(int position) {
        return mValues.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    public ListingAdapter(Context context, ArrayList<Wp> wpValues, RecyclerView recyclerView) {

        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mContext = context;
        mBackground = mTypedValue.resourceId;
        mValues = wpValues;

        //for the lazy loading
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {

            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        // End has been reached
                        // Do something
                        if (onLoadMoreListener != null) {
                            page++;
                            onLoadMoreListener.onLoadMore(page, totalItemCount);
                            System.out.println("Inside the loadmore");
                        }
                        loading = true;
                    }
                }
            });
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder vh;
        if (viewType == VIEW_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.display_list, parent, false);

            vh = new BlogViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.progressbar_item, parent, false);

            vh = new ProgressViewHolder(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        if (holder instanceof BlogViewHolder) {

            holder.setIsRecyclable(false);
            /* Set your values */

            final Wp newValues = (Wp) mValues.get(position);


            String title = newValues.getTitle().getRendered().replace("-", " ");
            title = title.substring(0, 1).toUpperCase() + title.substring(1);
            title = title.substring(0, 30) + "...";

            ((BlogViewHolder) holder).mProductTitle.setText(title);
            String description = newValues.getContent().getRendered().substring(0, 80);
            String desc = android.text.Html.fromHtml(description).toString() + "...";
            ((BlogViewHolder) holder).mProductDesc.setText(desc);



//            holder.mView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, DetailActivity.class);
//                    intent.putExtra("position", position);
//                    intent.putExtra("mValues", mValues);
//                    context.startActivity(intent);
//                }
//            });
//
//
//            int Id = mValues.get(position).getFeaturedMedia().intValue();
//            RestClient.getInstance().getThumbnail(Id, new Callback<Media>() {
//                @Override
//                public void success(Media info, Response response) {
//                    Media getMedia = info;
//
//                    Glide.with(holder.mImageView.getContext())
//                            .load(info.getMediaDetails().getSizes().getThumbnail().getSourceUrl())
//                            .placeholder(R.drawable.placeholder_small)
//                            //.override(210, 120)
//                            //.fitCenter()
//                            .into(holder.mImageView);
//
//                }
//
//                @Override
//                public void failure(RetrofitError error) {
//                    if (error != null) {
//                        Toast.makeText(mContext, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                        Log.d("RetrofitError2: ", error.getLocalizedMessage());
//                    }
//                }
//            });

        } else if(holder instanceof ProgressViewHolder){
                ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
        }





    }



    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setLoaded() {
        loading = false;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore(int page, int totalItemCount);
    }

    public void addAll(List<Wp> data, int startPosition, int itemCount){
        mValues.addAll(data);
        //notifyDataSetChanged();
        notifyItemRangeInserted(startPosition, itemCount);
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public ProgressViewHolder(View v) {
            super(v);
            progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        }
    }




    public static class BlogViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mProductTitle, mProductDesc;

        public BlogViewHolder(View v) {
            super(v);

            mImageView = (ImageView) v.findViewById(R.id.product_image);
            mProductTitle = (TextView) v.findViewById(R.id.product_title);
            mProductDesc = (TextView) v.findViewById(R.id.product_desc);


        }
    }

}

