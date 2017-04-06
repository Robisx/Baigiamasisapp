package com.example.user1.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by User1 on 2017-04-05.
 */

public class Transport {
    public static String transport(String url) {
        String r = "";
        HttpURLConnection http = null;
        InputStream is = null;
        BufferedReader reader;
        try {
            URL urlas = new URL(url);
            http = (HttpURLConnection) urlas.openConnection();
            http.setRequestMethod("GET");
            is = http.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while ((line = reader.readLine()) !=null){
                r += line;
            }
            reader.close();
            http.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return r;
    }
    public static String authenticate (String data_user, String data_pass, String url){
        String r = "";
        HttpURLConnection http = null;
        try {
            URL urlas = new URL(url);
            http = (HttpURLConnection) urlas.openConnection();
            http.setRequestMethod("GET");
            if (data_user !=null && data_pass !=null){
                http.addRequestProperty("request_user", data_user);
                http.addRequestProperty("request_pass", data_pass);
            }
            int responseCode = http.getResponseCode();
            if (responseCode == 200){
                r = "teisingas";
            }else{
                r = "neteisingas";
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return r;
    }
}