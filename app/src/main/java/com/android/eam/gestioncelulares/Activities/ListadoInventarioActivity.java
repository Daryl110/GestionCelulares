package com.android.eam.gestioncelulares.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.eam.gestioncelulares.MainActivity;
import com.android.eam.gestioncelulares.R;

import java.util.ArrayList;

public class ListadoInventarioActivity extends AppCompatActivity {

    private EditText txtImeiCel,txtDatoBusqueda;
    private ListView lstInventario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_inventario);

        this.txtImeiCel = (EditText) findViewById(R.id.txtImeiEliminar);
        this.txtDatoBusqueda = (EditText) findViewById(R.id.txtBuscar);
        this.lstInventario = (ListView) findViewById(R.id.lstInventario);

        listar();
    }

    private void listar(){
        if (MainActivity.inventarios.isEmpty()){
            Toast.makeText(this,"No Hay Inventarios Registrados!!!",Toast.LENGTH_LONG).show();
            this.finish();
            return;
        }

        ArrayList<String> inventarios = new ArrayList<>();

        for (int i = 0;i < MainActivity.inventarios.size();i++){
            inventarios.add(MainActivity.inventarios.get(i).getImeiCelular()+" - "+
                    MainActivity.inventarios.get(i).getNombreMarcaCelular()+" - "+
                    MainActivity.inventarios.get(i).getNombreCelular());
        }

        this.lstInventario.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,inventarios));
    }

    public void eliminarInventario(View view){
        String imeiCel = txtImeiCel.getText().toString().trim();

        if (imeiCel.isEmpty()){
            Toast.makeText(this,"Ingrese El IMEI Del Celular Que Desea Quitar Del Inventario e Intentelo Nuevamente",Toast.LENGTH_LONG).show();
            return;
        }

        for (int i = 0;i < MainActivity.inventarios.size();i++){
            if (imeiCel.equals(MainActivity.inventarios.get(i).getImeiCelular())){
                MainActivity.inventarios.remove(i);
                Toast.makeText(this,"Se Elimino El Celular IMEI:"+imeiCel+". Exitosamente",Toast.LENGTH_LONG).show();
                txtImeiCel.setText("");
                listar();
                return;
            }
        }

        Toast.makeText(this,"No Se Encontro El Celular IMEI:"+imeiCel+".",Toast.LENGTH_LONG).show();
    }

    public void buscarInventario(View view){
        String dato = txtDatoBusqueda.getText().toString().trim();

        if (dato.isEmpty()){
            Toast.makeText(this,"Ingrese El Dato Que Desea Buscar e Intentelo Nuevamente",Toast.LENGTH_LONG).show();
            return;
        }

        ArrayList<String> datosEncontrados = new ArrayList<>();

        for (int i = 0;i < MainActivity.inventarios.size();i++){
            if (dato.equals(MainActivity.inventarios.get(i).getImeiCelular()) ||
                    dato.equals(MainActivity.inventarios.get(i).getNombreCelular()) ||
                    dato.equals(MainActivity.inventarios.get(i).getNombreMarcaCelular())){

                datosEncontrados.add(MainActivity.inventarios.get(i).getImeiCelular()+" - "+
                        MainActivity.inventarios.get(i).getNombreMarcaCelular()+" - "+
                        MainActivity.inventarios.get(i).getNombreCelular());

                break;
            }
        }

        txtDatoBusqueda.setText("");

        if (datosEncontrados.isEmpty()){
            Toast.makeText(this,"No Se Encontro El Dato.",Toast.LENGTH_LONG).show();
            return;
        }

        this.lstInventario.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,datosEncontrados));
    }

    public void listar(View view){
        listar();
    }
}
