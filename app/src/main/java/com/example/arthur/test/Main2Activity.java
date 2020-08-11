package com.example.arthur.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView sas,city,evrika;
   Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       sas = findViewById(R.id.sas);
       city =findViewById(R.id.city);
       evrika = findViewById(R.id.evrika);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recreate();

            }
        });



        sas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("xanut", "sas");
                startActivity(intent);


                                   }
                               }
        );

       city.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
               intent.putExtra("xanut", "city");
               startActivity(intent);

           }
       });


        evrika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("xanut", "evrika");
                startActivity(intent);
            }
        });


    }
}
