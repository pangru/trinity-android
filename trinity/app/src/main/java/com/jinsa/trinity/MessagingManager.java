package com.jinsa.trinity;

import android.content.Context;

/**
 * Created by selina on 16. 8. 5..
 */
public class MessagingManager {
    private static MessagingManager mInstance;
    private final Context context;
    private Listener listener;

    public MessagingManager(Context context) {
        this.context = context;
    }

    public static MessagingManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MessagingManager(context);
        }

        return mInstance;
    }

    public void registerListener(Listener listener) {
        this.listener = listener;
    }

    public void receiveMessage(final String message) {
        if (listener != null) {
            listener.onMessageReceived(message);
        }
    }

    public interface Listener {
        String onMessageReceived(String message);
    }
}
