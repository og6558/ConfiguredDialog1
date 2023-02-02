package com.example.configureddialog1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    AlertDialog.Builder adb1, adb2, adb3;
    ConstraintLayout LO;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LO = findViewById(R.id.LO);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);


        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        String st = item.getTitle().toString();
        if(st.equals("Cradits")){
            Intent dorel2 = new Intent(this,SecondActivity.class);
            startActivity(dorel2);
        }
        return true;
    }
    final  String [] colors = {"Red", "Green", "Blue"};
    int  [] color = new int [3];
    public void button1(View view) {
        color = new int[]{0, 0, 0};
        adb1 = new AlertDialog.Builder(this);

        adb1.setTitle("Base colors - one choice");
        adb1.setCancelable(false);
        adb1.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                color[i] = 255;
                LO.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));

            }
        });

        adb1.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });

        AlertDialog ad1 = adb1.create();
        ad1.show();

    }

    public void button2(View view) {
        color = new int[]{0, 0, 0};
        adb2 = new AlertDialog.Builder(this);

        adb2.setTitle("Base colors - multi choice");
        adb2.setCancelable(false);
        adb2.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b) color[i]=255;
                else if(color[i]==255) color[i]=0;


            }
        });
        adb2.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });

        adb2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                LO.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });



        AlertDialog ad2 = adb2.create();
        ad2.show();

    }

    public void button3(View view) {
        LO.setBackgroundColor(Color.WHITE);
    }

    public void button4(View view) {
        adb3 = new AlertDialog.Builder(this);
        adb3.setCancelable(false);
        adb3.setTitle("text to toast");
        final EditText eT = new EditText(this);
        eT.setHint("Type text here");
        adb3.setView(eT);
        adb3.setPositiveButton("Copy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = eT.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        adb3.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog ad3 = adb3.create();
        ad3.show();

    }


}