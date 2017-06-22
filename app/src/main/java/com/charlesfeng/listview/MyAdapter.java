package com.charlesfeng.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by charles.feng53 on 6/21/2017.
 */

class MyAdapter extends BaseAdapter implements Filterable {

    private LayoutInflater mLayInf;
    private List<String> _texts = new ArrayList<String>();
    private MyFilter filter;

    private List<String> originaltexts=new ArrayList<String>();

    public MyAdapter(Context context, List<String> texts) {
        mLayInf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        _texts.addAll(texts);
        originaltexts.addAll(texts);
    }

    @Override
    public int getCount() {
        return _texts.size();
    }

    @Override
    public Object getItem(int i) {
        return _texts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View converterView, ViewGroup viewGroup) {
        //設定與回傳 convertView 作為顯示在這個 position 位置的 Item 的 View。

        if (converterView == null) {
            converterView = mLayInf.inflate(R.layout.name, viewGroup, false);
        }

        TextView txtView = (TextView) converterView.findViewById(R.id.name);
        txtView.setText(getItem(i).toString());
        return converterView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new MyFilter(this);
        }
        return filter;
    }

    public List<String> GetOrinalData() {
        return originaltexts;
    }

    public void clear() {
        _texts.clear();
    }

    public void addTextAll(List<String> values) {
        _texts.addAll(values);
    }
}
