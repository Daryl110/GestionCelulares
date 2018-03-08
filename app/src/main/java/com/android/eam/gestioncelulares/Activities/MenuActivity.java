package com.android.eam.gestioncelulares.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.eam.gestioncelulares.Entidades.ClsUsuario;
import com.android.eam.gestioncelulares.R;

public class MenuActivity extends AppCompatActivity {

    private ClsUsuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.usuario = (ClsUsuario) (getIntent().getExtras()).get("usuario");

        ((TextView)findViewById(R.id.lblnNombreUsu)).setText(this.usuario.getNombreUsu());
    }

    public void solicitarCrearMarca(View view){
        startActivity(new Intent(this,MarcaActivity.class));
    }

    public void solicitarCrearInventario(View view){
        startActivity(new Intent(this,CrearInventarioActivity.class));
    }

    public void solicitarListarInventario(View view){
        startActivity(new Intent(this,ListadoInventarioActivity.class));
    }
}
