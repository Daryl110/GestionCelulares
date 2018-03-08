package com.android.eam.gestioncelulares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.eam.gestioncelulares.Activities.MenuActivity;
import com.android.eam.gestioncelulares.Activities.RegistroActivity;
import com.android.eam.gestioncelulares.Entidades.ClsInventario;
import com.android.eam.gestioncelulares.Entidades.ClsMarca;
import com.android.eam.gestioncelulares.Entidades.ClsUsuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Definicion de variables
    private EditText txtNombreUsu,txtPassword;
    public static ArrayList<ClsUsuario> usuarios = new ArrayList<>();
    public static ArrayList<ClsInventario> inventarios = new ArrayList<>();
    public static ArrayList<ClsMarca> marcas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Capturacion de los EditText del ActivityMain ---> nombre de usuario y contraseña
        this.txtNombreUsu = findViewById(R.id.txtNombreUsu);
        this.txtPassword = findViewById(R.id.txtPassword);
    }

    public void solicitarRegistrarUsuario(View view){
        startActivity(new Intent(this, RegistroActivity.class));
        this.txtNombreUsu.setText("");
        this.txtPassword.setText("");
    }

    public void iniciarSesion(View view){
        String nombreUsu,pass,mensaje;

        nombreUsu = this.txtNombreUsu.getText().toString().trim();
        pass = this.txtPassword.getText().toString().trim();

        mensaje = "Debe Llenar Todos Los Campos";

        if (nombreUsu.isEmpty() || pass.isEmpty()){
            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
            return;
        }

        mensaje = "No Se Encontro Coincidencia Entre" +
                "\nEl Nombre De Usuario Y La Contraseña" +
                "\nO Es Posible Que Usted No Se Haya Registrado";

        ClsUsuario usuario = null;

        if (usuarios.isEmpty()){
            Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
            return;
        }

        for (int i = 0;i < usuarios.size();i++){
            if (nombreUsu.equals(usuarios.get(i).getNombreUsu()) && pass.equals(usuarios.get(i).getPassword())) {
                usuario = usuarios.get(i);
                break;
            }
            if (i == usuarios.size()-1){
                Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
                return;
            }
        }

        this.txtNombreUsu.setText("");
        this.txtPassword.setText("");

        Intent intent = new Intent(this, MenuActivity.class);

        intent.putExtra("usuario",usuario);

        startActivity(intent);
    }
}
