package com.ixidev.startappgdprdialog;

/**
 * Created by ABDELMAJID ID ALI on 09/01/2019.
 * Email : abdelmajid.idali@gmail.com
 * Github : https://github.com/ixiDev
 */
public interface GDPRCallback  {
    void onInitStartAppSdk();

    void onPersonalizedAdsConsentChange(boolean isGranted);
}
