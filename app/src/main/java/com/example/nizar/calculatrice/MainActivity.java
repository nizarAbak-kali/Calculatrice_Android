package com.example.nizar.calculatrice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{


    private  int  gauche ,droite,compteur;
    boolean update ,gauche_fill, droite_fill ;
    Button[]buttons   ;
    EditText ecran;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    void init(){
        update = false;
        gauche_fill = false;
        droite_fill = false;
        ecran = (EditText) findViewById(R.id.editText);
        buttons[0] = (Button) findViewById(R.id.button_pourcent);
        buttons[1] = (Button) findViewById(R.id.button_sqrt);
        buttons[2] = (Button) findViewById(R.id.button_square);
        buttons[3] = (Button) findViewById(R.id.button_mult);
        buttons[4] = (Button) findViewById(R.id.button_div);
        buttons[5] = (Button) findViewById(R.id.button_soustraction);
        buttons[6] = (Button) findViewById(R.id.button_add);

        buttons[7] = (Button) findViewById(R.id.button_zeros);
        buttons[8] = (Button) findViewById(R.id.button_un);
        buttons[9] = (Button) findViewById(R.id.button_deux);
        buttons[10] = (Button) findViewById(R.id.button_trois);
        buttons[11] = (Button) findViewById(R.id.button_quatre);
        buttons[12] = (Button) findViewById(R.id.button_cinq);
        buttons[13] = (Button) findViewById(R.id.button_six);
        buttons[14] = (Button) findViewById(R.id.button_sept);
        buttons[15] = (Button) findViewById(R.id.button_huit);
        buttons[16] = (Button) findViewById(R.id.button_neuf);
        buttons[17] = (Button) findViewById(R.id.button_equal);

        for(int j=0;j<18;j++){
            buttons[j].setOnClickListener(this);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    void chiffre_Click(String string){
        if(update)
            update = false;
        else{
            if(ecran.getText().equals("0"))
                string = ecran.getText() + string;
        }
        ecran.setText(string);

    }


    void pourcentage(int a , int b) {

        gauche = a ;
        droite = b ;
        compteur = a * (b/100);
    }
    void soustration(int i , int j){
        gauche = i ;
        droite = j ;
        compteur = i - j ;
    }
    void mult(int i , int j){
        gauche = i ;
        droite = j ;
        compteur = i * j ;
    }
    void div(int i , int j){
        gauche = i ;
        droite = j ;
        if (droite == 0)
            compteur = 0;
        else
        compteur = i / j ;
    }
    void add(int i , int j){
        gauche = i ;
        droite = j ;
        compteur = i + j ;
    }
    void square(int i ){
        gauche = i ;

        compteur = i*i;
    }

    void sqrt(int i ){
        gauche = i ;
        if(i < 0)
            compteur = 0 ;
        else
        compteur = (int) Math.sqrt(i);
    }
    void equal(){
        ecran.setText(compteur);
    }
    void calcul(){}


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_add:
                add(gauche,droite);
                break;
            case R.id.button_div:
                div(gauche, droite);
                break;
            case R.id.button_equal:
                    equal();
                break;
            case R.id.button_soustraction:
                soustration(gauche, droite);
                break;
            case R.id.button_sqrt:
                sqrt(gauche);
                break;
            case R.id.button_pourcent:
                pourcentage(gauche, droite);
                break;
            case R.id.button_square:
                square(gauche);
                break;
            case R.id.button_zeros:
                chiffre_Click("0");
                break;
            case R.id.button_un:
                chiffre_Click("1");
                break;
            case R.id.button_deux:
                chiffre_Click("2");
                break;
            case R.id.button_quatre:
                chiffre_Click("4");
                break;
            case R.id.button_cinq:
                chiffre_Click("5");
                square(gauche);
                break;
            case R.id.button_six:
                chiffre_Click("6");
                break;
            case R.id.button_sept:
                chiffre_Click("7");
                break;
            case R.id.button_huit:
                chiffre_Click("8");
                break;
            case R.id.button_neuf:
                chiffre_Click("9");
                break;
        }
    }
}
