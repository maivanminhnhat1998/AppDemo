package com.example.appdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText txtUser,txtPassword;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        addControl();
    }
    private void AnhXa(){
            btnLogin=(Button) findViewById(R.id.btnLogin);
            txtUser=(EditText) findViewById(R.id.txtUser);
            txtPassword=(EditText) findViewById(R.id.txtPassword);
    }
    private void addControl(){
            btnLogin.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String txtTK = txtUser.getText().toString();
                    String txtMK = txtPassword.getText().toString();
                   if(txtTK.equals("admin")&& txtMK.equals("admin")) {
                       Toast.makeText(MainActivity.this,"Đăng nhạp thành công",Toast.LENGTH_LONG).show();
                       Intent intent = new Intent(MainActivity.this,Two.class);
                       startActivity(intent);
                   }
                   else{
                       Toast.makeText(MainActivity.this,"Đăng nhập thất bại!!",Toast.LENGTH_LONG).show();
                   }
                }
            });
    }

}
