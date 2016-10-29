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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;

                /*
              //agregar en itemclicklistener
                try{
                    for (int ctr=0;ctr<=Series.length;ctr++){
                        if(position==ctr){
                            lSeries.getChildAt(ctr).setBackgroundColor(Color.CYAN);
                        }else{
                            lSeries.getChildAt(ctr).setBackgroundColor(Color.WHITE);
                        }
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }


*/

public class PickActivity extends AppCompatActivity {




    String[] Series =new String[]{
            "The walking Dead", "Game of Thrones", "Narcos", "Breaking Bad"
    };

    public  boolean status,status2,status3,status4;;
    public  List<String> selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick);


        status=true;
        status2=true;
        status3=true;
        status4=true;


        //agregando la lista al listview

        final ListView lSeries=(ListView)findViewById(R.id.lista);

        ListAdapter listAdapter=new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1, Series



        )
                ;







    lSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public  String color;
        @Override

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Object position1 = lSeries.getItemAtPosition(position);

            if(!status && position1=="The walking Dead" ){
                status=true;

                parent.getChildAt(position).setBackgroundColor(Color.TRANSPARENT);
                color="transparente";

                Toast.makeText(getApplicationContext(), "" + color, Toast.LENGTH_SHORT).show();


            }
             else if (status && position1=="The walking Dead"){
                status=false;

                parent.getChildAt(position).setBackgroundColor(Color.LTGRAY);
                color="gris";


                Toast.makeText(getApplicationContext(), "" + color, Toast.LENGTH_SHORT).show();
            }

            if(!status2 && position1=="Game of Thrones" ){
                status2=true;

                parent.getChildAt(position).setBackgroundColor(Color.TRANSPARENT);
                color="transparente";

                Toast.makeText(getApplicationContext(), "" + color, Toast.LENGTH_SHORT).show();


            }
            else if (status2 && position1=="Game of Thrones"){
                status2=false;

                parent.getChildAt(position).setBackgroundColor(Color.LTGRAY);
                color="gris";


                Toast.makeText(getApplicationContext(), "" + color, Toast.LENGTH_SHORT).show();
            }
            if(!status3 && position1=="Narcos" ){
                status3=true;

                parent.getChildAt(position).setBackgroundColor(Color.TRANSPARENT);
                color="transparente";

                Toast.makeText(getApplicationContext(), "" + color, Toast.LENGTH_SHORT).show();


            }
            else if (status3 && position1=="Narcos"){

                status3=false;

                parent.getChildAt(position).setBackgroundColor(Color.LTGRAY);
                color="gris";


                Toast.makeText(getApplicationContext(), "" + color, Toast.LENGTH_SHORT).show();
            }
            if(!status4 && position1=="Breaking Bad" ){
                status4=true;

                parent.getChildAt(position).setBackgroundColor(Color.TRANSPARENT);
                color="transparente";

                Toast.makeText(getApplicationContext(), "" + color, Toast.LENGTH_SHORT).show();


            }
            else if (status4 && position1=="Breaking Bad"){
                status4=false;

                parent.getChildAt(position).setBackgroundColor(Color.LTGRAY);
                color="gris";


                Toast.makeText(getApplicationContext(), "" + color, Toast.LENGTH_SHORT).show();
            }


            //   lSeries.getChildAt(position).setBackgroundColor(Color.TRANSPARENT);

            // for (int i=0;i<lSeries.getAdapter().getCount();i++) {





            //status = false;


           // parent.getChildAt(position).setBackgroundColor(Color.BLUE);
            // lSeries.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
            // status=true;


            //}




        }
    });









        lSeries.setAdapter(listAdapter);




    }


}

