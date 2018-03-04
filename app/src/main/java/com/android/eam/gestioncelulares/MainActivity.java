package com.android.eam.gestioncelulares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.eam.gestioncelulares.Activities.RegistroActivity;
import com.android.eam.gestioncelulares.Entidades.ClsInventario;
import com.android.eam.gestioncelulares.Entidades.ClsMarca;
import com.android.eam.gestioncelulares.Entidades.ClsUsuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Definicion de variables
    private EditText txtNombreUsu,txtPassword;
    private ArrayList<ClsUsuario> usuarios;
    private ArrayList<ClsInventario> inventarios;
    private ArrayList<ClsMarca> marcas;
    private boolean ejecucion = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Capturacion de los EditText del ActivityMain ---> nombre de usuario y contraseña
        this.txtNombreUsu = findViewById(R.id.txtNombreUsu);
        this.txtPassword = findViewById(R.id.txtPassword);

        //iniciacion de estructuras de datos
        this.usuarios = new ArrayList<>();
        this.marcas = new ArrayList<>();
        this.inventarios = new ArrayList<>();
    }

    public void solicitarRegistrarUsuario(View view){
        Intent intent = new Intent(this, RegistroActivity.class);//instanciacion e iniciacion del intent en registro de usuarios
        intent.putExtra("usuarios",this.usuarios);
        startActivity(intent);//llamada a el activity RegistroActivity
        Toast.makeText(this,"asddadadaddasdada",Toast.LENGTH_SHORT).show();
    }

    public void mostrarUsuarios(View view){
        for (int i = 0;i < usuarios.size();i++){
            Toast.makeText(this,"Usuario Creado: "+usuarios.get(i).getNombreCompleto(),Toast.LENGTH_SHORT).show();
        }
    }
}
