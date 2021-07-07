package com.tez.sikayetportali;
import android.app.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;

public class MyListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    Context contextThis;
    private final String[] maintitle;
    private final String[] subtitle;
    private final String[] imgPath;

    public MyListAdapter(Activity context, String[] maintitle,String[] subtitle, String[] imgPath) {
        super(context, R.layout.mylist, maintitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;
        this.imgPath=imgPath;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);

        titleText.setText(maintitle[position]);
        subtitleText.setText(subtitle[position]);

        try {
            Picasso.with(context).load(imgPath[position])
                    .error(R.mipmap.ic_launcher_round) //if error
                    .into(imageView,new com.squareup.picasso.Callback(){

                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {

                        }
                    });
        }catch (Exception e) {
            e.printStackTrace();
        }


        return rowView;

    };



}
