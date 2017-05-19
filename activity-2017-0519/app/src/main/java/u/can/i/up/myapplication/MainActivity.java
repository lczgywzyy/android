package u.can.i.up.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Activity mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
//                Intent intent = new Intent();
//                ComponentName com = new ComponentName("com.eg.android.AlipayGphone", "com.eg.android.AlipayGphone.com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
//                intent.setComponent(com);
////                String s = "This is a Test.";
////                intent.putExtra("id", s);
//                startActivity(intent);
                if (Build.VERSION.SDK_INT >= 23) {
                    int checkCallPhonePermission = ContextCompat.checkSelfPermission(mContext, Manifest.permission.SEND_SMS);
                    if(checkCallPhonePermission != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(mContext,new String[]{Manifest.permission.SEND_SMS},111);
                        return;
                    }else{
                        //上面已经写好的拨号方法
                    }
                } else {
                    //上面已经写好的拨号方法
                }
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("myjni-lib");
    }
}
