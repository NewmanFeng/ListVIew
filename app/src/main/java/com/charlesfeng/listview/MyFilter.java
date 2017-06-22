package com.charlesfeng.listview;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by charles.feng53 on 6/22/2017.
 */
class MyFilter extends Filter {
    private MyAdapter myAdapter;

    public MyFilter(MyAdapter myAdapter) {
        this.myAdapter = myAdapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        constraint = constraint.toString();
        FilterResults result = new FilterResults();

        if (constraint != null && constraint.toString().length() > 0) {
            List<String> filterList = new ArrayList<>();
            for (int i = 0; i < myAdapter.GetOrinalData().size(); i++) {
                if (myAdapter.GetOrinalData().get(i).contains(constraint)) {
                    filterList.add(myAdapter.GetOrinalData().get(i));
                }
            }
            result.count = filterList.size();
            result.values = filterList;
        } else {
            synchronized (this) {

                result.values = myAdapter.GetOrinalData();
                result.count = myAdapter.GetOrinalData().size();
            }
        }
        return result;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        myAdapter.clear();
        myAdapter.addTextAll((List<String>) filterResults.values);
        myAdapter.notifyDataSetChanged();
    }
}
