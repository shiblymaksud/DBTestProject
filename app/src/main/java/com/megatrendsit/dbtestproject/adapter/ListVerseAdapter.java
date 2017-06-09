package com.megatrendsit.dbtestproject.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.megatrendsit.dbtestproject.R;
import com.megatrendsit.dbtestproject.model.Verses;

import java.util.List;

/**
 * Created by Maksud on 6/9/2017.
 */

public class ListVerseAdapter extends BaseAdapter {
    private Context context;
    private List<Verses> mVerseList;

    public ListVerseAdapter(Context context, List<Verses> mVerseList) {
        this.context = context;
        this.mVerseList = mVerseList;
    }

    @Override
    public int getCount() {
        return mVerseList.size();
    }

    @Override
    public Object getItem(int position) {
        return mVerseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.verses_listview, null);
        TextView tvVerse = (TextView)v.findViewById(R.id.tv_verse_number);
        TextView tvEnglish = (TextView)v.findViewById(R.id.tv_verse_english);
        TextView tvBengali = (TextView)v.findViewById(R.id.tv_verse_bengali);
        TextView tvArabic = (TextView)v.findViewById(R.id.tv_verse_arabic);

        tvVerse.setText(mVerseList.get(position).getVerse());
        tvEnglish.setText(mVerseList.get(position).getEnglish());
        tvBengali.setText(mVerseList.get(position).getBengali());
        tvArabic.setText(mVerseList.get(position).getArabic());

        return v;
    }
}
