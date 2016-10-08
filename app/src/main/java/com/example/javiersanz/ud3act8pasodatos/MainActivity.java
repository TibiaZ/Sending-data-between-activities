package com.example.javiersanz.ud3act8pasodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    private Bundle bundle;
    private Intent intento;

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
        btnPedirEdad.setOnClickListener(this);
        btnPedirTelefono.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // Instanciamos el Bundle
        bundle = new Bundle();

        // Comprobamos que el campo de texto no esté vaciío.
        if(introducirID.getText().toString() != null){
            // Si no está vacío, asignamos funciones a los botones
            if(v.getId() == R.id.buttonNombre){
                bundle.putInt(KEY_TIPO_DATO, VALOR_NOMBRE);
                bundle.putInt(KEY_ID, Integer.valueOf(introducirID.getText().toString()));
            }
            else if(v.getId() == R.id.buttonEdad){
                bundle.putInt(KEY_TIPO_DATO, VALOR_EDAD);
                bundle.putInt(KEY_ID, Integer.valueOf(introducirID.getText().toString()));
            }
            else if(v.getId() == R.id.buttonTelefono){
                bundle.putInt(KEY_TIPO_DATO, VALOR_TELEFONO);
                bundle.putInt(KEY_ID, Integer.valueOf(introducirID.getText().toString()));
            }
            // Preparamos el intent para pasar a la segunda actividad
            intento = new Intent(this, SecondActivity.class);
            intento.putExtras(bundle);
            startActivityForResult(intento, 1234);
        }
        else
            Toast.makeText(getApplicationContext(),"No has introducido ningún texto",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
