package com.tez.sikayetportali.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class Utils {
    public static String getDataFromServicesTypeGet(String url) throws IOException {
        String result;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpGet httpGet = new HttpGet(url);

            HttpResponse response = httpClient.execute(httpGet, localContext);
            String json = EntityUtils.toString(response.getEntity());
            result = json;
        } catch (IOException e){
            e.printStackTrace();
            result = e.toString();
        }
        return result;
    }
}
