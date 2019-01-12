package cl.uach.inf.bachimovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    Button btnCancelar, btnIngresar;
    EditText etEmail, etUsuario, etPassword, etConPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnCancelar =findViewById(R.id.btnCan);
        btnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intCan = new Intent(Registro.this, Login.class);
                Registro.this.finish();
            }
        });

        btnIngresar = findViewById(R.id.btnReg2);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intIng = new Intent(Registro.this, DatosUsuario.class);
                Registro.this.startActivity(intIng);
            }
        });

        etEmail = findViewById(R.id.email);
        etUsuario = findViewById(R.id.user);
        etPassword = findViewById(R.id.password);
        etConPassword = findViewById(R.id.conPassword);

    }
}
