package com.example.arthur.test;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Templates;

public class Main3Activity extends AppCompatActivity {


    int backPosition;
    ListView listView;
    Spinner katnamterq,xmichq;
    List<String> Kat = new ArrayList<>();
    DBhelper dbHelper;
    String tesak;
    List<String> Xmichq = new ArrayList<>();
    EditText ed_txt_qanak;
    Button btn_add,btn_mutq;
    List<String> cucak;
    List<String> qanak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        cucak= new ArrayList<>();
        qanak= new ArrayList<>();

        katnamterq = findViewById(R.id.spin_katnamterq);
        xmichq = findViewById(R.id.spin_xichq);
        listView = findViewById(R.id.lst_view);
         ed_txt_qanak = findViewById(R.id.edtxt_qanak);
        btn_add = findViewById(R.id.btn_add);
        btn_mutq = findViewById(R.id.btn_mutq);
        dbHelper = new DBhelper(this);

        Kat.add("Կաթնամթերք");
        Kat.add("Մածուն");
        Kat.add("Թթվասեր");
        Kat.add("Կաթ");

        Xmichq.add("Xmichq");
        Xmichq.add("Oxi");
        Xmichq.add("Gini");
        Xmichq.add("Garejur");

        spinner_katnamterq();
        spinner1();


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              if(ed_txt_qanak.getText().toString().equals("")&& tesak.equals("Կաթնամթերք")){


                  Toast.makeText(Main3Activity.this, "Լրացրեք քանակ դաշտը և ընտրեք տեսակը", Toast.LENGTH_SHORT).show();
              }
               else if(!tesak.equals("Կաթնամթերք") && ed_txt_qanak.getText().toString().equals("") ) {
                  Toast.makeText(Main3Activity.this, "Լրացրեք քանակ դաշտը", Toast.LENGTH_SHORT).show();

                }


              else if(tesak.equals("Կաթնամթերք") &&!ed_txt_qanak.getText().toString().equals("") ){

                  Toast.makeText(Main3Activity.this, "Ընտրեք տեսակը", Toast.LENGTH_SHORT).show();


              }



                if(!ed_txt_qanak.getText().toString().equals("") && tesak != "Կաթնամթերք") {



                    cucak.add(katnamterq.getSelectedItem().toString());
                    qanak.add(ed_txt_qanak.getText().toString());

                    ed_txt_qanak.setText("");
                    yourAdapter adapter = new yourAdapter(Main3Activity.this, cucak,qanak);

                    listView.setAdapter(adapter);

                }


            }
        });


        btn_mutq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                SQLiteDatabase database = dbHelper.getWritableDatabase();
//                ContentValues contentValues = new ContentValues();

               //recreate();



                startActivity(getIntent());
                finish();
            }
        });

       switch (getIntent().getStringExtra("xanut") ){

           case "sas":

               Toast.makeText(this, "SAS SUPERMRKET", Toast.LENGTH_SHORT).show();
              break;
           case "city":

               Toast.makeText(this, "YEREVAN CITY SUPERMRKET", Toast.LENGTH_SHORT).show();
             break;
           case "evrika":

               Toast.makeText(this, "EVRIKA SUPERMRKET", Toast.LENGTH_SHORT).show();
               break;
       }







    }


    public void spinner_katnamterq() {

        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Kat );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       // Spinner spinner = (Spinner) findViewById(R.id.spinnerBeck);
        katnamterq.setAdapter(adapter);
        // заголовок
        katnamterq.setPrompt("");
        // выделяем элемент
        katnamterq.setSelection(0);
        // устанавливаем обработчик нажатия
        katnamterq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionBeck, long id) {
             //  qanak =  katnamterq.getSelectedItem().toString();
                tesak = katnamterq.getSelectedItem().toString();
                backPosition = positionBeck;
                // показываем позиция нажатого элемента
               // Toast.makeText(getBaseContext(), "Position = " + backPosition, Toast.LENGTH_SHORT).show();
               // Toast.makeText(getBaseContext(), "Value = " + qanak, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


    }


    public void spinner1() {

        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Xmichq );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Spinner spinner = (Spinner) findViewById(R.id.spinnerBeck);
        xmichq.setAdapter(adapter);
        // заголовок
        xmichq.setPrompt("");
        // выделяем элемент
        xmichq.setSelection(0);
        // устанавливаем обработчик нажатия
        xmichq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionBeck, long id) {
                backPosition = positionBeck;
                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "Position = " + backPosition, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


    }

    @Override
    public void recreate()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            super.recreate();
        }
        else
        {
            startActivity(getIntent());
            finish();
        }
    }
}
