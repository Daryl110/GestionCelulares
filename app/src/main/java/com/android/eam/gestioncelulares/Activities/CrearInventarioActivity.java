package com.android.eam.gestioncelulares.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.android.eam.gestioncelulares.Entidades.ClsInventario;
import com.android.eam.gestioncelulares.Entidades.ClsMarca;
import com.android.eam.gestioncelulares.MainActivity;
import com.android.eam.gestioncelulares.R;

import java.util.ArrayList;

public class CrearInventarioActivity extends AppCompatActivity {

    private EditText txtImeiCel,txtNombrCel;
    private Spinner cbMarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_inventario);

        this.txtImeiCel = (EditText) findViewById(R.id.txtImeiRegistro);
        this.txtNombrCel = (EditText) findViewById(R.id.txtNombreCelRegistro);
        this.cbMarca = (Spinner) findViewById(R.id.cbMarca);

        cargarMarcas();
    }

    private void cargarMarcas(){
        if(MainActivity.marcas.isEmpty()){
            Toast.makeText(this,"No Hay Marcas Registradas!!!",Toast.LENGTH_LONG).show();
            this.finish();
            return;
        }

        ArrayList<String> nombresMarcas = new ArrayList<>();

        nombresMarcas.add("-- Seleccione marca --");

        for (int i = 0;i < MainActivity.marcas.size();i++){
            nombresMarcas.add(MainActivity.marcas.get(i).getNombre());
        }

        this.cbMarca.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_item,nombresMarcas));
    }

    public void crearInventario(View view){
        String imeiCel,marcaCel,nombreCel;

        imeiCel = this.txtImeiCel.getText().toString().trim();
        marcaCel = this.cbMarca.getSelectedItem().toString().trim();
        nombreCel = this.txtNombrCel.getText().toString().trim();

        if (imeiCel.isEmpty() || marcaCel.equals("-- Seleccione marca --") || nombreCel.isEmpty()){
            Toast.makeText(this,"Debe Llenar Todos Los Datos y Seleccione Marca Valida",Toast.LENGTH_LONG).show();
            return;
        }

        for (int i = 0;i < MainActivity.inventarios.size();i++){
            if (imeiCel.equalsIgnoreCase(MainActivity.inventarios.get(i).getImeiCelular())){
                Toast.makeText(this,"El imei del celular ya existe",Toast.LENGTH_LONG).show();
                return;
            }
        }

        ClsInventario inventario = new ClsInventario(imeiCel,marcaCel,nombreCel);

        MainActivity.inventarios.add(inventario);

        Toast.makeText(this,"Inventario: "+nombreCel+". Creado Con Exito",Toast.LENGTH_SHORT).show();

        this.finish();
    }
}
