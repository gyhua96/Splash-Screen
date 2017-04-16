package cn.gongyuhua.splashscreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/**
 * The Splash screen activity.
 * This activity shows a welcome screen before start ths application
 * When the application starts, it starts this activity before
 * start the MainActivity
 */
public class SplashActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        // Delay 1000 ms to show the splash picture clearly
        // You can delete this delay code if you don't want it
        try {
            Thread.sleep(1000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        // Build a intent refers to MainActivity
        intent = new Intent(this, MainActivity.class);

        // start a new thread to delay 2000 ms and start new intent
        Thread thread=new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    // Delay 2000 ms to show the launcher screen
                    // It could be a ad picture or something
                    Thread.sleep(2000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                // Start MainActivity and finish Splash activity
                startActivity(intent);
                finish();
            }
        });
        thread.start();

    }
}
