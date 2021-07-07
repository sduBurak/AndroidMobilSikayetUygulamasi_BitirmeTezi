package com.tez.sikayetportali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaRecorder;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.Toast;
import android.widget.ImageView;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.tez.sikayetportali.util.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity  {
  Context context;
  Button btn;
  ListView list;

    String[] maintitle;
    String[] subtitle;
    String[] imgPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = this;
        new loadAdapterTask().execute();


    }

    private class loadAdapterTask extends AsyncTask<Void, Void, Void> {
        String result;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                result = Utils.getDataFromServicesTypeGet("http://192.168.1.41:8080/SikayetServis/complaintAPI/Complaint");
            } catch (IOException e){
                e.printStackTrace();
                result = e.toString();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            Log.println(Log.DEBUG,result,result);
            try {
                JSONObject reader = new JSONObject(result);
                String status = reader.getString("status");
                if(status.equals("Success")){
                    //JSONObject data  = reader.getJSONObject("data");
                    JSONArray complaintArray = reader.getJSONArray("data");
                    maintitle = new String[complaintArray.length()];
                    subtitle = new String[complaintArray.length()];
                    imgPath = new String[complaintArray.length()];

                    // looping through All Contacts
                    for (int i = 0; i < complaintArray.length(); i++) {

                        JSONObject c = complaintArray.getJSONObject(i);
                        String id = c.getString("id");
                        String title = c.getString("title");
                        String context = c.getString("context");
                        String create_date = c.getString("create_date");
                        maintitle[i] = title;
                        subtitle[i] = context;

                        JSONArray attachmentArray = c.getJSONArray("attachmentList");
                        for (int j = 0; j < attachmentArray.length(); j++) {
                            JSONObject a = attachmentArray.getJSONObject(j);
                            String attachment_id = a.getString("id");
                            String attachment_type = a.getString("type");
                            String attachment_path = a.getString("path");
                            imgPath[i] = attachment_path;
                        }

                    }

                }

                MyListAdapter adapter=new MyListAdapter((Activity) context, maintitle, subtitle,imgPath);
                list=(ListView)findViewById(R.id.list);
                list.setAdapter((ListAdapter) adapter);


                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        // TODO Auto-generated method stub
                        if(position == 0) {
                            //code specific to first list item
                            Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                        }

                        else if(position == 1) {
                            //code specific to 2nd list item
                            Toast.makeText(getApplicationContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                        }

                        else if(position == 2) {

                            Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                        }
                        else if(position == 3) {

                            Toast.makeText(getApplicationContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                        }
                        else if(position == 4) {

                            Toast.makeText(getApplicationContext(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            } catch (JSONException e) {
                e.printStackTrace();
            }
            super.onPostExecute(aVoid);
        }
    }

    public void goToActivity2(View view) {
    }

    public void goToActivity3(View view) {
    }

    public void goToActivity1(View view) {
    }
}