package com.izi.whatview;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class PickActivity extends AppCompatActivity {

    private ListView miLista;
    private ListView mlista2;
   Integer[]image=new Integer[]{
           R.drawable.twd,
           R.drawable.got,
           R.drawable.narcos,
           R.drawable.breaking,
           R.drawable.izombie,
           R.drawable.rick,
           R.drawable.sherlock,
           R.drawable.monk,
           R.drawable.gaki,
   };



    String[] nombres =new String[]{
            "The walking Dead", "Game of Thrones", "Narcos", "Breaking Bad","izombie","Rick&Morty","Sherlock","Monk","Gaki no Tsukai"
    };
    String[] subtitulos=new String[]{
            "e","f","g","h",
    };




    UiController uiController;
    TextView tvTitle1;
    TextView tvTitle2;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiController = new UiController();
        setContentView(R.layout.activity_pick);

        miLista = (ListView)findViewById(R.id.lista);

        miLista.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        tvTitle1 = (TextView) findViewById(R.id.txt);
        tvTitle2 = (TextView) findViewById(R.id.txt2);
        img =(ImageView)findViewById(R.id.rowImg);

        tvTitle1.setTypeface(uiController.GetCustomTypeface(this));
        tvTitle2.setTypeface(uiController.GetCustomTypeface(this));


        ArrayAdapter<String> data=new ArrayAdapter<String>(this,R.layout.row2,R.id.titulo, nombres);



        miLista.setAdapter(data);




    }

    public void deleteSelected(View view) {

        SparseBooleanArray seleccionados = miLista.getCheckedItemPositions();

        if(seleccionados==null || seleccionados.size()==0){

            Toast.makeText(this,"No hay elementos seleccionados",Toast.LENGTH_SHORT).show();

        }else{

            StringBuilder resultado=new StringBuilder();
            resultado.append("Se agregaran los siguientes elementos:\n");


            final int size=seleccionados.size();
            for (int i=0; i<size; i++) {

                if (seleccionados.valueAt(i)) {

                    resultado.append("El elemento "+seleccionados.keyAt(i)+" se ha agregado\n");

                }
            }
            Intent i = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(i);
            Toast.makeText(this,resultado.toString(),Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        uiController.HideUiBars(getWindow());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        uiController.HideUiBars(getWindow());
    }


}


