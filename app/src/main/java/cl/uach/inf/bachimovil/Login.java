package cl.uach.inf.bachimovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    Button btnIngresar, btnRegistrar, btnRecuperar;
    EditText inputEmail, inputContraseña;

    String email, contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = (EditText)findViewById(R.id.Email);
        inputContraseña= (EditText)findViewById(R.id.Contraseña);

        email = inputEmail.getText().toString();
        contraseña = inputContraseña.getText().toString();

        btnRegistrar =findViewById(R.id.botonRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intReg = new Intent(Login.this, Registro.class);
                Login.this.startActivity(intReg);
            }
        });

        btnIngresar = findViewById(R.id.botonIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intIng = new Intent(Login.this, Main.class);
                Login.this.startActivity(intIng);
            }
        });

        btnRecuperar = findViewById(R.id.recuperarContraseña);
        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intRecuperar = new Intent (Login.this, RecPassword.class);
                Login.this.startActivity(intRecuperar);
            }
        });
    }
}
