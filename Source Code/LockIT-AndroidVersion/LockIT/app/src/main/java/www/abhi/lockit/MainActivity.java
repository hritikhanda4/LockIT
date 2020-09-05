package www.abhi.lockit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   SharedPreferences sharedPreferences;
    Boolean fTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     SharedPreferences settings=getSharedPreferences("prefs",0);

      sharedPreferences=getSharedPreferences("MyPrefs",MODE_PRIVATE);
        fTime = sharedPreferences.getBoolean("fTime",true);

        if (fTime){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                    startActivity(intent);
                    finish();
                }
            },5000);
        }
       else{
            Intent intent = new Intent(MainActivity.this,OtpActivity.class);
            startActivity(intent);
            finish();
        }



    }
}