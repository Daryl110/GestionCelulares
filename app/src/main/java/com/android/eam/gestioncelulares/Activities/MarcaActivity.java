package com.android.eam.gestioncelulares.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.eam.gestioncelulares.Entidades.ClsMarca;
import com.android.eam.gestioncelulares.MainActivity;
import com.android.eam.gestioncelulares.R;

public class MarcaActivity extends AppCompatActivity {

    private EditText txtNombreMarca,txtDescripcionMarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marca);

        this.txtNombreMarca = (EditText) findViewById(R.id.txtNombreMarca);
        this.txtDescripcionMarca = (EditText) findViewById(R.id.txtDescripcionMarca);
    }

    public void crearMarca(View view){
        String nombre,descripcion;

        nombre = txtNombreMarca.getText().toString().trim();
        descripcion = txtDescripcionMarca.getText().toString().trim();

        if (nombre.isEmpty() || descripcion.isEmpty()){
            Toast.makeText(this,"Debe Llenar Todos Los Campos",Toast.LENGTH_SHORT).show();
            return;
        }

        ClsMarca marca = new ClsMarca(nombre,descripcion);

        for (int i = 0; i < MainActivity.marcas.size(); i++){
            if (marca.getNombre().equals(MainActivity.marcas.get(i).getNombre())){
                Toast.makeText(this,"El Nombre De Marca Ya Existe",Toast.LENGTH_SHORT).show();
                return;
            }
        }

        MainActivity.marcas.add(marca);

        Toast.makeText(this,"Marca: "+nombre+". Creada Con Exito",Toast.LENGTH_SHORT).show();

        this.finish();
    }
}
