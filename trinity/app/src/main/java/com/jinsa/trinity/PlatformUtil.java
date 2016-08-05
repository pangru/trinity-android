package com.jinsa.trinity;

import android.content.Context;
import android.os.Build;

/**
 * Created by selina on 16. 8. 5..
 */
public class PlatformUtil {
    public static String getDeviceId(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append((Build.MODEL + "-" + Build.SERIAL).toUpperCase().replace(" ", "-"));
        sb.append("-");
        sb.append(context.getPackageName().hashCode());
        String deviceId = sb.toString();
        return deviceId;
    }

}
