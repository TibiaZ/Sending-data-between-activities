package com.example.javiersanz.ud3act8pasodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// http://ivanalbizu.eu/uso-de-startactivityforresult/
public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    // Constantes
    public final static String KEY_NOMBRE = "nombre";
    public final static String KEY_EDAD = "edad";
    public final static String KEY_TELEFONO = "telefono";

    // Variables
    private TextView textView;
    private EditText editText;
    private Button btnAceptar;
    private Intent intentoLlamante;
    private Bundle bundle;
    private int idRecibida;
    private int tipoDato;
    private Intent intento;
    private String datoReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Inflamos los widgets
        textView = (TextView) findViewById(R.id.textViewIntroducir);
        editText = (EditText) findViewById(R.id.editTextSecondActivity);
        btnAceptar = (Button) findViewById(R.id.buttonAceptar);

        // Recogemos los datos del intent que nos ha llamado
        intentoLlamante = getIntent();
        bundle = intentoLlamante.getExtras();
        idRecibida = bundle.getInt(MainActivity.KEY_ID);
        tipoDato = bundle.getInt(MainActivity.KEY_TIPO_DATO);

        // Establecemos el textView en función de lo que quiera pedir el usuario
        if(tipoDato == MainActivity.VALOR_NOMBRE)
            textView.setText(getResources().getString(R.string.str_introducir_nombre) + " " + String.valueOf(idRecibida));
        else if(tipoDato == MainActivity.VALOR_EDAD)
            textView.setText(getResources().getString(R.string.str_introducir_edad) + " " + String.valueOf(idRecibida));
        else if(tipoDato == MainActivity.VALOR_TELEFONO)
            textView.setText(getResources().getString(R.string.str_introducir_telefono) + " " + String.valueOf(idRecibida));


        // Hacemos uso de onClick
        btnAceptar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intento = new Intent();
        datoReturn = editText.getText().toString();
        if(!editText.getText().toString().isEmpty()){
            if(!datoReturn.toString().isEmpty()) {
                if (tipoDato == MainActivity.VALOR_NOMBRE) intento.putExtra(KEY_NOMBRE, datoReturn);
                else if (tipoDato == MainActivity.VALOR_EDAD) intento.putExtra(KEY_EDAD, datoReturn);
                else if (tipoDato == MainActivity.VALOR_TELEFONO) intento.putExtra(KEY_TELEFONO, datoReturn);
            }
            setResult(RESULT_OK, intento);
            finish();
        }
        else
            Toast.makeText(getApplicationContext(), "No has escrito nada", Toast.LENGTH_SHORT);
    }
}
