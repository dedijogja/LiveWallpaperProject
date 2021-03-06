package com.edanlab.live;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PresetWallpaper extends FragmentActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);

        setContentView(R.layout.activity_main);

        Button btnPreview = (Button) findViewById(R.id.btn_main_activty_preview_id);
        Button btnCancel = (Button) findViewById(R.id.btn_main_activty_cancel_id);



        btnPreview.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_main_activty_preview_id) {
            Intent intent = new Intent(
                    WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
            if (Build.VERSION.SDK_INT > 15) {

                String pkg = MesinGifWallpaper.class.getPackage().getName();
                String cls = MesinGifWallpaper.class.getCanonicalName();
                intent.putExtra(
                        WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                        new ComponentName(pkg, cls));
            } else {
                intent.setAction(WallpaperManager.ACTION_LIVE_WALLPAPER_CHOOSER);
            }
            startActivityForResult(intent, 0);
        } else if (v.getId() == R.id.btn_main_activty_cancel_id) {
            this.finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 0)
            //this.finish();
        super.onActivityResult(requestCode, resultCode, data);

    }

}
