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
    ArrayList<String> sss;


    String[] nombres =new String[]{
            "The walking Dead", "Game of Thrones", "Narcos", "Breaking Bad"
    };
    String[] subtitulos=new String[]{
            "e","f","g","h",
    };




    UiController uiController;
    TextView tvTitle1;
    TextView tvTitle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiController = new UiController();
        setContentView(R.layout.activity_pick);

        miLista = (ListView)findViewById(R.id.lista);

        miLista.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        tvTitle1 = (TextView) findViewById(R.id.txt);
        tvTitle2 = (TextView) findViewById(R.id.txt2);

        tvTitle1.setTypeface(uiController.GetCustomTypeface(this));
        tvTitle2.setTypeface(uiController.GetCustomTypeface(this));

        //sss=new ArrayList<String>();

        ArrayAdapter<String> data=new ArrayAdapter<String>(this,R.layout.row2,R.id.titulo, nombres);



        miLista.setAdapter(data);
       // mlista2.setAdapter(dataS);


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


