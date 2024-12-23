package com.game.motionelf.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.system.ErrnoException;
import android.system.Os;
import android.widget.Toast;
import com.game.motionelf.R;

import java.io.*;

public class ActivityStart extends Activity {

    private static final String TAG = "MotionElf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        makeMotionelf();
        super.onCreate(savedInstanceState);
        finish();
    }

    private void makeMotionelf() {
        d("making motionelf");
        File files = new File(getExternalFilesDir(null).getParentFile(), "server");
        if (!files.exists())
        {
            if (!files.mkdirs())
            {
                d("Can't make motionelf");
                Toast.makeText(getApplicationContext(), "激活器创建脚本出错", 0).show();
                return;
            }
        }
        File output = new File(files, "motionelf_server");
        try (
                OutputStream os = new FileOutputStream(output);
                InputStream is = getResources().openRawResource(R.raw.activate)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.flush();
            Os.chmod(output.getPath(), 0644);
        } catch (IOException | ErrnoException e) {
            d("Can't make motionelf", e);
            Toast.makeText(getApplicationContext(), "激活器创建脚本出错", 0).show();
        }
        Toast.makeText(getApplicationContext(), "激活器创建脚本成功", 0).show();
    }

    private void d(String s) {
        android.util.Log.d(TAG, s);
    }

    private void d(String s, Throwable t) {
        android.util.Log.d(TAG, s, t);
    }

}