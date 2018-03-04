package com.android.eam.gestioncelulares.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
