package com.example.laboratorio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView TListadoEstudiantes;
    private Button BCrear;
    private int LAUNCH_SECOND_ACTIVITY = 1;
    private ArrayList<Estudiante> ListaEstudiantes=new ArrayList<Estudiante>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        //try {
        //    ListaEstudiantes = bundle.getParcelableArrayList("Estudiantes");
        //}catch (Exception e){
        //    ListaEstudiantes=new ArrayList<Estudiante>();
        //}
        TListadoEstudiantes=(ListView)findViewById(R.id.ListadoEstudiantes);
        BCrear=(Button) findViewById(R.id.Crear);
        BCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*AQUI CREA A QUE ACTIVITY TE REDIRECCIONARA PARA EL MAPA*/
                try {
                    //Intent intent = new Intent(MainActivity.this, FormularioActivity.class);
                    //Bundle bundle = new Bundle();
                    //bundle.putParcelableArrayList("ListaEstudiantes",ListaEstudiantes);
                    //intent.putExtras(bundle);
                    //startActivity(intent);
                    Intent i = new Intent(MainActivity.this, FormularioActivity.class);
                    startActivityForResult(i, LAUNCH_SECOND_ACTIVITY);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        LlenarLsita();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if(resultCode == MainActivity.RESULT_OK){
                Estudiante result=data.getExtras().getParcelable("result");
                ListaEstudiantes.add(result);
                LlenarLsita();
            }
            if (resultCode == MainActivity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult
    public void LlenarLsita(){
        ArrayList<String> STRListaEstudiantes=new ArrayList<String>();
        for(Estudiante data: ListaEstudiantes){
            try {
                STRListaEstudiantes.add("CUI: "+data.getCUI()+"\nNombre: "+data.getNombres()+"\nApellidos: "+data.getApellidos());
            }catch (Exception e){continue;
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, STRListaEstudiantes);
        TListadoEstudiantes.setAdapter(adapter);
    }
}