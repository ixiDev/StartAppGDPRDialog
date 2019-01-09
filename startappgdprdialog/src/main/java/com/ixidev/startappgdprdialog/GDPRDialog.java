package com.ixidev.startappgdprdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Created by ABDELMAJID ID ALI on 09/01/2019.
 * Email : abdelmajid.idali@gmail.com
 * Github : https://github.com/ixiDev
 */
public class GDPRDialog {
    private static final String SHARED_PREFS_GDPR_SHOWN = "gdpr_dialog_was_shown";
    private GDPRCallback listener;

    public GDPRDialog(GDPRCallback listener) {
        this.listener = listener;
    }

    public void create(Activity main, final Runnable runnable) {
        if (isDialogAlredyShowed(main)) {
            listener.onInitStartAppSdk();
            runnable.run();
            return;
        }
        showGdprDialog(new Runnable() {
            @Override
            public void run() {
                listener.onInitStartAppSdk();
                runnable.run();
            }
        }, main,listener);
    }

    public static void showGdprDialog(final Runnable callback, final Activity main,
                                      final GDPRCallback mlistener) {
        final View view = main.getLayoutInflater().inflate(R.layout.dialog_gdpr, null);
        final Dialog dialog = new Dialog(main, android.R.style.Theme_Light_NoTitleBar);
        dialog.setContentView(view);
        final Button okBtn = view.findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback != null) {
                    callback.run();
                }
                main.getPreferences(Context.MODE_PRIVATE)
                        .edit()
                        .putBoolean(SHARED_PREFS_GDPR_SHOWN, true)
                        .apply();
                mlistener.onPersonalizedAdsConsentChange(true);
                dialog.dismiss();
            }
        });
        final Button cancelBtn = view.findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback != null) {
                    callback.run();
                }

                main.getPreferences(Context.MODE_PRIVATE)
                        .edit()
                        .putBoolean(SHARED_PREFS_GDPR_SHOWN, false)
                        .apply();
                mlistener.onPersonalizedAdsConsentChange(false);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private boolean isDialogAlredyShowed(Activity main) {
        return main.getPreferences(Context.MODE_PRIVATE).getBoolean(SHARED_PREFS_GDPR_SHOWN, false);
    }

}
