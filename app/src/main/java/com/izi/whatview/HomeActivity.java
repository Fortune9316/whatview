package com.izi.whatview;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    ViewPager viewPager;
    ImageButton buton1;
    ImageButton buton2;
    ImageButton buton3;
    ImageButton buton4;
    ImageButton buton5;
    ImageButton buton6;
    ImageButton buton7;
    ImageButton buton8;
    ImageButton buton9;
    ImageButton buton10;
    ImageButton buton11;
    ImageButton buton12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabPrincipal);

        tabLayout.addTab(tabLayout.newTab().setText("Perfil"));
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Favoritos"));

        FragmentAdapterClass fragmentAdapterClass=new FragmentAdapterClass(getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager=(ViewPager)findViewById(R.id.visorPagina);
        viewPager.setAdapter(fragmentAdapterClass);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                page.setRotationY(position*-30);
            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public void goAlert(View v){


        LayoutInflater inflater = getLayoutInflater();

        View dialoglayout = inflater.inflate(R.layout.info, null);


       // final EditText etMensaje = (EditText) dialoglayout.findViewById(R.id.et_EmailMensaje);
        final TextView mensaje=(TextView)dialoglayout.findViewById(R.id.textView3);
        final TextView Titulo=(TextView)dialoglayout.findViewById(R.id.textView2);
        final ImageButton button1=(ImageButton)dialoglayout.findViewById(R.id.btn1);
        final ImageButton button2=(ImageButton)dialoglayout.findViewById(R.id.btn2);
        final ImageButton button3=(ImageButton)dialoglayout.findViewById(R.id.btn3);
        final ImageButton button4=(ImageButton)dialoglayout.findViewById(R.id.btn4);
        final ImageButton button5=(ImageButton)dialoglayout.findViewById(R.id.btn5);
        final ImageButton button6=(ImageButton)dialoglayout.findViewById(R.id.btn6);
        final ImageButton button7=(ImageButton)dialoglayout.findViewById(R.id.buton1);
        final ImageButton button8=(ImageButton)dialoglayout.findViewById(R.id.buton2);
        final ImageButton button9=(ImageButton)dialoglayout.findViewById(R.id.buton3);
        final ImageButton button10=(ImageButton)dialoglayout.findViewById(R.id.buton4);
        final ImageButton button11=(ImageButton)dialoglayout.findViewById(R.id.buton5);
        final ImageButton button12=(ImageButton)dialoglayout.findViewById(R.id.buton6);
        final ImageView Serie=(ImageView)dialoglayout.findViewById(R.id.imgSerie);

        switch (v.getId())
        {
            case  R.id.btn1:
                mensaje.setText(R.string.breaking);
                Serie.setBackground(getResources().getDrawable(R.drawable.breaking));
                break;
            case  R.id.btn2:
                mensaje.setText(R.string.tsukai);
                Serie.setBackground(getResources().getDrawable(R.drawable.gaki));
                break;
            case  R.id.btn3:
                mensaje.setText(R.string.game);
                Serie.setBackground(getResources().getDrawable(R.drawable.got));
                break;
            case  R.id.btn4:
                mensaje.setText(R.string.i);
                Serie.setBackground(getResources().getDrawable(R.drawable.izombie));
                break;
            case  R.id.btn5:
                mensaje.setText(R.string.narc);
                Serie.setBackground(getResources().getDrawable(R.drawable.narcos));
                break;
            case  R.id.btn6:
                mensaje.setText(R.string.walking);
                Serie.setBackground(getResources().getDrawable(R.drawable.twd));
                break;
            case  R.id.buton1:
                mensaje.setText(R.string.sher);
                Serie.setBackground(getResources().getDrawable(R.drawable.sherlock));
                break;
            case  R.id.buton2:
                mensaje.setText(R.string.umaru);
                Serie.setBackground(getResources().getDrawable(R.drawable.pp));
                break;
            case  R.id.buton3:
                mensaje.setText(R.string.morty);
                Serie.setBackground(getResources().getDrawable(R.drawable.rick));
                break;
            case  R.id.buton4:
                mensaje.setText(R.string.breaking);
                Serie.setBackground(getResources().getDrawable(R.drawable.breaking));
                break;

            case  R.id.buton5:
                mensaje.setText(R.string.breaking);
                Serie.setBackground(getResources().getDrawable(R.drawable.breaking));
                break;
            case  R.id.buton6:
                mensaje.setText(R.string.breaking);
                Serie.setBackground(getResources().getDrawable(R.drawable.breaking));
                break;
        }



        Button btnEnviarMail = (Button) dialoglayout.findViewById(R.id.btnGo);
        btnEnviarMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               // String message = etMensaje.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[] { "honovad@gmail.com"});

               // email.putExtra(Intent.EXTRA_TEXT, " mensaje " + message);

                // need this to prompts email client only
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Seleciona un cliente de correo"));

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setView(dialoglayout);
        builder.show();
    }

    @Override
    public void onBackPressed() {

        if(viewPager.getCurrentItem()==0){
            super.onBackPressed();
        }else{
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
        }
    }
}

