package com.intern.mailchimpsample;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author intern
 */
public class HttpClientManager {

    HttpClient http = new DefaultHttpClient();

    public String Connection(String url) {
        HttpGet get = new HttpGet(url);
        HttpResponse response = http.execute(get);
        if (response != HttpStatus.SC_OK) {
            System.err.println("Method failed: " + get.getStatusLine());
        }
        return response;
    }

    public void close() {
        http.getConnectionManager().shutdown();
    }

}
