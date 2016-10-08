package com.example.javiersanz.ud3act8pasodatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Declaramos las constantes
    public final static String KEY_ID = "id";
    public final static String KEY_TIPO_DATO = "tipo_dato";
    public final static int VALOR_NOMBRE = 0;
    public final static int VALOR_EDAD = 1;
    public final static int VALOR_TELEFONO = 2;

    // Declaramos nuestros widgets
    private EditText introducirID;
    private Button btnPedirNombre;
    private Button btnPedirEdad;
    private Button btnPedirTelefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflamos nuestros widgets
        introducirID = (EditText) findViewById(R.id.editTextIntroducirID);
        btnPedirNombre = (Button) findViewById(R.id.buttonNombre);
        btnPedirEdad = (Button) findViewById(R.id.buttonEdad);
        btnPedirTelefono = (Button) findViewById(R.id.buttonTelefono);

        // Hacemos uso del onClick
        btnPedirNombre.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
