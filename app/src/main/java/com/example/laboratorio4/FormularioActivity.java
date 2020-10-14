package com.example.laboratorio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class FormularioActivity extends AppCompatActivity {

    private Button BGuardar;
    private EditText ETCui;
    private EditText ETNombre;
    private EditText ETApellido;
    private ArrayList<Estudiante> ListaEstudiantes=new ArrayList<Estudiante>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Bundle bundle = getIntent().getExtras();
        ETCui = (EditText) findViewById(R.id.CUI);
        ETNombre = (EditText) findViewById(R.id.Nombre);
        ETApellido = (EditText) findViewById(R.id.Apellido);
        BGuardar=(Button) findViewById(R.id.Guardar);
        BGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*AQUI CREA A QUE ACTIVITY TE REDIRECCIONARA PARA EL MAPA*/
                try {
                    if(ETCui.getText().toString().trim()!="" && ETNombre.getText().toString().trim()!="" &&  ETApellido.getText().toString().trim()!="" ) {
                        Estudiante est = new Estudiante(ETCui.getText().toString().trim(), ETNombre.getText().toString().trim(), ETApellido.getText().toString().trim());
                        //ListaEstudiantes.add(est);
                        //Intent intent = new Intent(FormularioActivity.this, MainActivity.class);
                        //Bundle bundle = new Bundle();
                        //bundle.putParcelableArrayList("Estudiantes", ListaEstudiantes);
                        //intent.putExtras(bundle);
                        //startActivity(intent);
                        Intent intent = new Intent(FormularioActivity.this,MainActivity.class);
                        intent.putExtra("result",est);
                        setResult(MainActivity.RESULT_OK,intent);
                        finish();
                    }else{
                        Toast.makeText(FormularioActivity.this,"Llene el Formulario.", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(FormularioActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}