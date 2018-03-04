package com.android.eam.gestioncelulares.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.eam.gestioncelulares.Entidades.ClsUsuario;
import com.android.eam.gestioncelulares.MainActivity;
import com.android.eam.gestioncelulares.R;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {

    //Creacion de variables
    private EditText txtNombreCompleto,txtNombreUsu,txtContrasena1,txtContrasena2;
    private boolean ejecucion = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Capturar Los EditText del activity registro
        this.txtNombreCompleto = findViewById(R.id.txtNombreCompleto);
        this.txtNombreUsu = findViewById(R.id.txtNombreUsu);
        this.txtContrasena1 = findViewById(R.id.txtContrasena1);
        this.txtContrasena2 = findViewById(R.id.txtContrasena2);
    }

    public void registrarUsuario(View view){

        String nombreCompleto,nombreUsu,pass1,pass2;

        nombreCompleto = this.txtNombreCompleto.getText().toString().trim();
        nombreUsu = this.txtNombreUsu.getText().toString().trim();
        pass1 = this.txtContrasena1.getText().toString().trim();
        pass2 = this.txtContrasena2.getText().toString().trim();

        if (nombreCompleto.isEmpty() || nombreUsu.isEmpty() || pass1.isEmpty() || pass2.isEmpty()){
            Toast.makeText(this,"Debe Llenar Todos Los Campos",Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pass1.equals(pass2)){
            Toast.makeText(this,"Las Contraseñas No Coinciden",Toast.LENGTH_SHORT).show();
            this.txtContrasena1.setHighlightColor(Color.RED);
            this.txtContrasena1.setHighlightColor(Color.RED);
            return;
        }

        ClsUsuario usuario = new ClsUsuario(nombreCompleto,nombreUsu,pass1);

        for (int i = 0;i < MainActivity.usuarios.size();i++){
            if (usuario.getNombreUsu().equals(MainActivity.usuarios.get(i).getNombreUsu())){
                Toast.makeText(this,"El Nombre De Usuario Ya Existe",Toast.LENGTH_SHORT).show();
                return;
            }
        }

        MainActivity.usuarios.add(usuario);

        Toast.makeText(this,"Usuario: "+nombreCompleto+". Creado Con Exito",Toast.LENGTH_SHORT).show();

        this.finish();
    }
}
