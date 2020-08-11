package com.example.arthur.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtext_login ;
    EditText edtext_password ;
    Button btn_ok;
     String a;
    String b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtext_login = findViewById(R.id.edit1);
        edtext_password = findViewById(R.id.edit2);
        btn_ok = findViewById(R.id.btn_ok);



      btn_ok.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              a = edtext_login.getText().toString();
              b = edtext_password.getText().toString();
//
//            if(a.equals("a") && b.equals("a")){
//                Toast.makeText(MainActivity.this, ""+a, Toast.LENGTH_SHORT).show();




                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, ""+b, Toast.LENGTH_SHORT).show();
//            }

          }
      });

    }
}
