package www.abhi.lockit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity  {
    Button signUp;
    TextInputLayout iemi , password,period;
    SharedPreferences sharedPreferences;
    Boolean fTime;
    private static final String FILE_NAME ="MyPrefs" ;
    private static final String IMEI_NUMBER = "IMEI" ;
    private static final String PASSWORD = "password" ;
    private static final String PERIOD = "validityTime" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        iemi = findViewById(R.id.editTextIEMI);
        password = findViewById(R.id.editTextPassword);
        signUp = findViewById(R.id.lockIt);
        period = findViewById(R.id.spinner);

        sharedPreferences=getSharedPreferences(FILE_NAME,MODE_PRIVATE);

    }

    private boolean validationIEMI(){
        String Imei = iemi.getEditText().getText().toString().trim();
        if (Imei.isEmpty()){
            iemi.setError("Please Enter IMEI Number");
            return  false;
        }else if (Imei.length()!=15&&Imei.length()!=16){
            iemi.setError("Invalid IMEI");
            return  false;
        }
     else {
            iemi.setError(null);
            return true;
        }

    }
    private boolean validationPassword(){
        String as = password.getEditText().getText().toString().trim();
        if (as.isEmpty()){
            password.setError("Please Enter Password");
            return  false;
        }else if(as.length()<6){
            password.setError("Password must be at least 6 Character");
            return  false;
        }
        else {
            password.setError(null);
            return true;
        }
    }

    private boolean validationPeriod(){
        String sa = period.getEditText().getText().toString().trim();
        if (sa.isEmpty()){
            period.setError("Please Enter Validity Period");
            return  false;
        }else if(Integer.parseInt(sa)!=2&&Integer.parseInt(sa)!=5&&Integer.parseInt(sa)!=10&&Integer.parseInt(sa)!=15&&Integer.parseInt(sa)!=30){
            period.setError("Invalid Period");
            return  false;
        }
        else {
            period.setError(null);
            return true;
        }



    }


    public void Save(View view) {


        if (!validationIEMI() | !validationPassword() | !validationPeriod() ) {
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(IMEI_NUMBER, iemi.getEditText().getText().toString());
        editor.putString(PERIOD, period.getEditText().getText().toString());
        editor.putString(PASSWORD,password.getEditText().getText().toString());
        editor.apply();

        Toast.makeText(this,"Data Locked",Toast.LENGTH_SHORT).show();
        fTime = sharedPreferences.getBoolean("fTime",true);
        editor.putBoolean("fTime",false);
        Intent intent = new Intent(getApplicationContext(),OtpActivity.class);
        startActivity(intent);
        finish();
        editor.apply();
    }
}