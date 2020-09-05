package www.abhi.lockit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtpActivity extends AppCompatActivity {
    Button btnG,btnR;
    TextView textView;
    SharedPreferences sharedPreferences;
    Boolean fTime;
    private static final String FILE_NAME ="MyPrefs" ;
    private static final String IMEI_NUMBER = "IMEI" ;
    private static final String PASSWORD = "password" ;
    private static final String PERIOD = "validityTime" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        btnG = findViewById(R.id.gButton);
        textView = findViewById(R.id.numberOTP);
        btnR = findViewById(R.id.reset);

        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Retrive data
             sharedPreferences = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
             String imei = sharedPreferences.getString(IMEI_NUMBER,null);
             int period = Integer.parseInt(sharedPreferences.getString(PERIOD,null));
             String password = sharedPreferences.getString(PASSWORD,null);

                //Generating mainKey

                int passInt=PasswordAscii.passwordToInt(password);
                int imeiInt=ImeiRot13.imeiToInt(imei);
                int dateTimeInt=DateTime.DateTimeToInt(period);
                int generatedKey=Math.abs(passInt+imeiInt+dateTimeInt)%100;

                String otp = Integer.toString(generatedKey);
                textView.setText(otp);

                //System.out.println(generatedKey);   /// show on  created entry



            }
        });
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OtpActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}