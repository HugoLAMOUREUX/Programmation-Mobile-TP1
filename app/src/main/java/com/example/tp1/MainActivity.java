package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int nbTentativesR;
    private int nbMystere;
    private int nbTried;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startGame();
        tv=findViewById(R.id.nbCoup);
        tv.setText("Nombre de coups restants: "+nbTentativesR);


    }

    protected void startGame(){
        nbMystere= (int) Math.floor((Math.random()*10000));
        nbTentativesR=10;
        tv=findViewById(R.id.okBtn);
        tv.setClickable(true);
        tv=findViewById(R.id.result);
        tv.setText("");
        tv=findViewById(R.id.histoNb);
        tv.setText("");
    }

    public void inputOnClick(View view){
        tv=findViewById(R.id.nbInput);
        nbTried=Integer.parseInt(tv.getText().toString());
        tv.setText("");
        nbTentativesR--;
        if (nbTried == nbMystere) {
            tv=findViewById(R.id.okBtn);
            tv.setClickable(false);
            tv=findViewById(R.id.result);
            tv.setText(nbMystere+"est le bon nombre mystère");
            tv.setTextColor(Color.GREEN);
        } else{
            tv=findViewById(R.id.nbCoup);
            tv.setText("Nombre de coups restants: "+nbTentativesR);
            tv=findViewById(R.id.histoNb);
            if(nbTried>nbMystere){
                tv.setText(tv.getText().toString()+nbTried+" est trop grand\n");
            }else{
                tv.setText(tv.getText().toString()+nbTried+" est trop petit\n");
            }
            if(nbTentativesR==0){
                tv=findViewById(R.id.okBtn);
                tv.setClickable(false);
                tv=findViewById(R.id.result);
                tv.setText("Perdu ! Le nombre mystère était : "+nbMystere);
                tv.setTextColor(Color.RED);
            }
        }


    }

    public void restartOnClick(View view){
        startGame();
    }

    public void quitOnClick(View view){
        System.exit(1);
    }
}