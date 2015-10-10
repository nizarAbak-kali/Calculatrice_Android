//Fait par Oliver et Nizar

package com.example.nizar.calculatrice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Double.*;


public class MainActivity extends Activity implements View.OnClickListener{

    /* Variable Global*/
    double gauche;
    boolean update, operator_cliqued;
    String operator_utilisee;
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
        operator_utilisee = "";
        operator_cliqued = false;

        ecran = (EditText) findViewById(R.id.editText);

        buttons = new Button[20];
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
        buttons[18] = (Button) findViewById(R.id.button_C);
        buttons[19] = (Button) findViewById(R.id.button_virgule);

        for(int j=0;j<=19;j++){
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

    // methode qui est executé quand on clique sur un chiffre
    //
    void chiffre_Click(String string){
        if(update)
            update = false;

        else
            string = ecran.getText() + string;

        ecran.setText(string);

    }


    //Voici la méthode qui fait le calcul qui a été demandé par l'utilisateur
    private void calcul() {
        if (operator_utilisee.equals("+")) {
            gauche += valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(gauche));
        }

        if (operator_utilisee.equals("-")) {
            gauche = gauche - valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(gauche));
        }

        if (operator_utilisee.equals("*")) {
            gauche = gauche * valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(gauche));
        }

        if (operator_utilisee.equals("/")) {
            try {
                gauche = gauche / valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(gauche));
            } catch (ArithmeticException e) {
                ecran.setText("0");
            }
        }
        if (operator_utilisee.equals("%")) {
            gauche = gauche * ((valueOf(ecran.getText().toString()).doubleValue()) / 100);
            ecran.setText(String.valueOf(gauche));
        }

        if (operator_utilisee.equals("sqrt")) {
            gauche = Math.sqrt(gauche);
            ecran.setText(String.valueOf(gauche));
        }
        if (operator_utilisee.equals("square")) {
            gauche = gauche * gauche;
            ecran.setText(String.valueOf(gauche));
        }


    }


    void pourcentage() {
        // si l'operateur a ete deja cliqué on le calcul
        if (operator_cliqued) {
            calcul();
            ecran.setText(String.valueOf(gauche));
        } else {
            // sinon on recupere la valeur de ce qui est sur l'ecran et on set vrai le fait qu'on
            // a clique sur le plus
            gauche = valueOf(ecran.getText().toString()).doubleValue();
            operator_cliqued = true;
        }
        operator_utilisee = "%";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsque l'on clique sur le bouton -
    void soustration() {
        // si l'operateur a ete deja cliqué on le calcul
        if (operator_cliqued) {
            calcul();
            ecran.setText(String.valueOf(gauche));
        } else {
            // sinon on recupere la valeur de ce qui est sur l'ecran et on set vrai le fait qu'on
            // a clique sur le plus
            gauche = valueOf(ecran.getText().toString()).doubleValue();
            operator_cliqued = true;
        }
        operator_utilisee = "-";
        update = true;
    }


    void mult() {
        // si l'operateur a ete deja cliqué on le calcul
        if (operator_cliqued) {
            calcul();
            ecran.setText(String.valueOf(gauche));
        } else {
            // sinon on recupere la valeur de ce qui est sur l'ecran et on set vrai le fait qu'on
            // a clique sur le plus
            gauche = valueOf(ecran.getText().toString()).doubleValue();
            operator_cliqued = true;
        }
        operator_utilisee = "*";
        update = true;
    }

    void div() {
        // si l'operateur a ete deja cliqué on le calcul
        if (operator_cliqued) {
            calcul();
            ecran.setText(String.valueOf(gauche));
        } else {
            // sinon on recupere la valeur de ce qui est sur l'ecran et on set vrai le fait qu'on
            // a clique sur le plus
            gauche = valueOf(ecran.getText().toString()).doubleValue();
            operator_cliqued = true;
        }
        operator_utilisee = "/";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsque l'on clique sur le bouton +
    void add() {
        // si l'operateur a ete cliqué on le calcul
        if (operator_cliqued) {
            calcul();
            ecran.setText(String.valueOf(gauche));
        } else {
            // sinon on recupere la valeur de ce qui est sur l'ecran et on set vrai le fait qu'on
            // a clique sur le plus
            gauche = valueOf(ecran.getText().toString()).doubleValue();
            operator_cliqued = true;
        }
        operator_utilisee = "+";
        update = true;
    }

    void square() {
        // si l'operateur a ete deja cliqué on le calcul
        if (operator_cliqued) {
            calcul();
            ecran.setText(String.valueOf(gauche));
        } else {
            // sinon on recupere la valeur de ce qui est sur l'ecran et on set vrai le fait qu'on
            // a clique sur le plus
            gauche = valueOf(ecran.getText().toString()).doubleValue();
            operator_cliqued = true;
        }
        operator_utilisee = "square";
        update = true;
    }

    void sqrt() {
        // si l'operateur a ete deja cliqué on le calcul
        if (operator_cliqued) {
            calcul();
            ecran.setText(String.valueOf(gauche));
        } else {
            // sinon on recupere la valeur de ce qui est sur l'ecran et on set vrai le fait qu'on
            // a clique sur le plus
            gauche = valueOf(ecran.getText().toString()).doubleValue();
            operator_cliqued = true;
        }
        operator_utilisee = "sqrt";
        update = true;
    }
    void equal(){
        calcul();
        update = true;
        operator_cliqued = false;
    }

    void reset() {
        operator_cliqued = false;
        update = true;
        gauche = 0;
        operator_utilisee = "";
        ecran.setText(" ");
       Toast toast= Toast.makeText(MainActivity.this,"historique effacer",Toast.LENGTH_LONG);
       toast.show();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button_C:
                reset();
                break;

            case R.id.button_add:
                add();
                break;

            case R.id.button_div:
                div();
                break;

            case R.id.button_equal:
                equal();
                break;

            case R.id.button_mult:
                mult();
                break;

            case R.id.button_soustraction:
                soustration();
                break;

            case R.id.button_sqrt:
                sqrt();
                break;

            case R.id.button_pourcent:
                pourcentage();
                break;

            case R.id.button_square:
                square();
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
            case R.id.button_trois:
                chiffre_Click("3");
                break;
            case R.id.button_quatre:
                chiffre_Click("4");
                break;
            case R.id.button_cinq:
                chiffre_Click("5");
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
            case R.id.button_virgule:
                chiffre_Click(".");
        }
    }
}
