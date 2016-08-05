package com.jinsa.trinity;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by selina on 16. 8. 5..
 */
public class HttpProxy {
    private static final String SERVER_URL = "http://www.isilkbag.com";

    private static HttpsURLConnection getConnection(String path, String method) throws IOException {
        URL url = new URL(SERVER_URL + path);
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.setRequestMethod(method);
        urlConnection.setRequestProperty("Content-Type", "application/json");
        return urlConnection;
    }

    private static void request(HttpsURLConnection urlConnection, JSONObject body) throws IOException, JSONException {
        writeRequestBody(urlConnection, body);
        int responseCode = urlConnection.getResponseCode();
        Log.d("HttpProxy", "request: url=" + urlConnection.getURL().toString() + ", responseCode=" + responseCode);
    }

    private static void writeRequestBody(HttpsURLConnection urlConnection, JSONObject body) throws IOException, JSONException {
        Log.d("HttpProxy", "writeRequestBody: body=" + body.toString());
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
        out.write(body.toString().getBytes());
        out.flush();
        out.close();
    }

    public static void register(String deviceId, String pushId) throws IOException, JSONException {
        JSONObject content = new JSONObject();
        content.put("user_id", deviceId);
        content.put("push_id", pushId);
        Log.d("HttpProxy", "register: " + content.toString());
        HttpsURLConnection urlConnection = getConnection("/devices/", "POST");
        request(urlConnection, content);
    }
}
