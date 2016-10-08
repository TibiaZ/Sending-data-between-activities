package com.example.javiersanz.ud3act8pasodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Recogemos los datos del intent que nos ha llamado
        intentoLlamante = getIntent();
        bundle = intentoLlamante.getExtras();

        // Inflamos los widgets
        textView = (TextView) findViewById(R.id.textViewIntroducir);
        editText = (EditText) findViewById(R.id.editTextSecondActivity);
        btnAceptar = (Button) findViewById(R.id.buttonAceptar);

        // Hacemos uso de onClick
        btnAceptar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(editText.getText().toString() != null){
            if(bundle.getInt(MainActivity.KEY_TIPO_DATO) == MainActivity.VALOR_NOMBRE){}
            else if(bundle.getInt(MainActivity.KEY_TIPO_DATO) == MainActivity.VALOR_EDAD){}
            else if(bundle.get(MainActivity.KEY_TIPO_DATO) == MainActivity.VALOR_TELEFONO){}
        }
    }
}
