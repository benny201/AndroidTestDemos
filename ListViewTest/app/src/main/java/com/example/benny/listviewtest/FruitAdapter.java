package com.example.benny.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by benny on 16/11/8.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceid;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context,textViewResourceId,objects);
        resourceid = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        ViewHolder viewHolder;
        View view;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceid,null);
            viewHolder = new ViewHolder();
            viewHolder.imageV = (ImageView) view.findViewById(R.id.image);
            viewHolder.textV = (TextView) view.findViewById(R.id.text);
            view.setTag(viewHolder);
        } else  {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        //View view = LayoutInflater.from(getContext()).inflate(resourceid,null);
        viewHolder.imageV.setImageResource(fruit.getImageId());
        viewHolder.textV.setText(fruit.getName());
        return view;
    }
    class ViewHolder {
        ImageView imageV;
        TextView textV;
    }
}
