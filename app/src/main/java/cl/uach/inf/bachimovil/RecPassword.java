package cl.uach.inf.bachimovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RecPassword extends AppCompatActivity {

    Button btnEnviar;
    EditText inputEmail;

    String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_password);

        inputEmail = findViewById(R.id.confirmarCorreo);
        Email = inputEmail.getText().toString();

        btnEnviar = findViewById(R.id.enviarCorreo);
    }
}
