package com.example.benny.dialogactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by benny on 16/11/10.
 */
public class MessageAdapter extends ArrayAdapter<Message> {
    private int rourceId;
    MessageAdapter(Context context, int textViewResourceId, List<Message> objects) {
        super(context,textViewResourceId,objects);
        rourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message msg = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(rourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.leftlay = (LinearLayout) view.findViewById(R.id.leftlayout);
            viewHolder.rightlay = (LinearLayout) view.findViewById(R.id.rigtlayout);
            viewHolder.leftmsg = (TextView) view.findViewById(R.id.leftmsg);
            viewHolder.rigtmsg = (TextView) view.findViewById(R.id.rigthmsg);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        //发消息
        if(msg.getType() == Message.Send_flag) {
            viewHolder.leftmsg.setVisibility(View.GONE);
            viewHolder.rigtmsg.setVisibility(View.VISIBLE);
            viewHolder.rigtmsg.setText(msg.getContent());
        }
        //收消息
        if(msg.getType() == Message.receive_flag) {
            viewHolder.leftmsg.setVisibility(View.VISIBLE);
            viewHolder.rigtmsg.setVisibility(View.GONE);
            viewHolder.leftmsg.setText(msg.getContent());
        }
        return view;
    }
}

class ViewHolder{
    TextView leftmsg;
    TextView rigtmsg;
    LinearLayout leftlay;
    LinearLayout rightlay;
}
