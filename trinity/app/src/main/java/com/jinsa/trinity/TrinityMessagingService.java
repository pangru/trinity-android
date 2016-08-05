package com.jinsa.trinity;

import android.app.Service;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class TrinityMessagingService extends FirebaseMessagingService {
    private final static String TAG = TrinityMessagingService.class.getSimpleName();

    public TrinityMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (remoteMessage.getData().size() == 0) {
            Log.e(TAG, "Message data payload is empty");
            return;
        }

        Log.d(TAG, "onMessageReceived: remoteMessage=" + remoteMessage.getData());
        JSONObject payload = new JSONObject(remoteMessage.getData());
    }
}
