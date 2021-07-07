package com.tez.sikayetportali;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tez.sikayetportali.model.Users;
import com.tez.sikayetportali.util.Utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class giris extends AppCompatActivity {
    Context context;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.giris);
            Button StartButton = (Button) findViewById(R.id.hesap_var_button);
        }
    public void goToActivity2 (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
       }
    public void goToActivity3 (View view){
        Intent intent = new Intent (this, login.class);
        startActivity(intent);
    }
    public void goToActivity1 (View view) throws IOException {
        Intent intent = new Intent (this, new_account.class);
        startActivity(intent);
    }
    public void goToActivity4 (View view){
        Intent intent = new Intent (this, new_complaint_form.class);
        startActivity(intent);
    }

    /*private class MyTask extends AsyncTask<Void, Void, Void> {
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
            Intent intent = new Intent (context, login.class);
            intent.putExtra("responseJsonString", result);
            startActivity(intent);
            super.onPostExecute(aVoid);
        }
    }*/

    }
