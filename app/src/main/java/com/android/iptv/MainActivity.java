package com.android.iptv;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String packageName="com.zte.browser";
        String activity=packageName+".BrowserActivity";
        Bundle localBundle = new Bundle();
        localBundle.putString("com.android.bw.load", "IPTV_BW");
        Intent localIntent = new Intent();
        localIntent.addCategory("android.intent.category.LAUNCHER");
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        localBundle.putString("com.android.bw.loadtype", "BACKGROUND");
        localIntent.putExtras(localBundle);
        localIntent.setClassName(packageName, activity);
        if(getPackageManager().resolveActivity(localIntent, 0) == null)  //判断activity是否存在
        {
            Log.e(packageName, activity+"不存在" );
        }

        else {
            Log.e(packageName, activity + "存在");
            try {
                startActivity(localIntent);
            } catch (Exception e) {
                Log.e("BrowserActivity", "启动失败");
            }
        }
    }
}
