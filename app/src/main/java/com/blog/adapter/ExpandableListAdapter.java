package com.blog.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blog.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Hp on 10/10/2015.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Activity context;
    private Map<String, List<String>> laptopCollections;
    private List<String> laptops;
    private Map<Integer, List<Integer>> categoryIdList;

    public ExpandableListAdapter(Activity context, List<String> laptops,
                                 Map<String, List<String>> laptopCollections, Map<Integer, List<Integer>> categoryIdList) {
        this.context = context;
        this.laptopCollections = laptopCollections;
        this.laptops = laptops;
        this.categoryIdList = categoryIdList;
    }

    public Object getChild(int groupPosition, int childPosition) {
            return laptopCollections.get(laptops.get(groupPosition)).get(childPosition);
    }

    public int getCategoryId(int groupPosition, int childPosition){
        return categoryIdList.get(groupPosition).get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        if(laptopCollections.get(laptops.get(groupPosition)) != null) {
            final String laptop = (String) getChild(groupPosition, childPosition);
            LayoutInflater inflater = context.getLayoutInflater();
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.sub_menu_item, null);
            }
            TextView item = (TextView) convertView.findViewById(R.id.laptop);
            item.setText(laptop);
        }


        return convertView;
    }

    public int getChildrenCount(int groupPosition) {
        if(laptopCollections.get(laptops.get(groupPosition)) != null) {
            return laptopCollections.get(laptops.get(groupPosition)).size();
        } else {
            return 0;
        }
    }

    public Object getGroup(int groupPosition) {
        return laptops.get(groupPosition);
    }

    public int getGroupCount() {
        return laptops.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String laptopName = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.menu_group_item,
                    null);
        }

        TextView item = (TextView) convertView.findViewById(R.id.laptop);
        ImageView indicator = (ImageView) convertView.findViewById(R.id.menu_indicator);


        if ( getChildrenCount( groupPosition ) == 0 ) {
            indicator.setVisibility( View.INVISIBLE );
        } else {
            indicator.setVisibility( View.VISIBLE );
            indicator.setImageResource( isExpanded ? R.drawable.ic_chevron_up : R.drawable.ic_chevron_down );
        }

        item.setTypeface(null, Typeface.BOLD);
        item.setText(laptopName);


        return convertView;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}