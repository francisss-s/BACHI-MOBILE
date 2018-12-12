package cl.uach.inf.bachimovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddEventActivity extends AppCompatActivity {
    TextView textView;
    Button okButton, cancelButton;

    private String name;
    private String eventDate;
    private String location;
    private String description;
    private String eventTime;
    private String tags;
    private CancelDialog salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        name = ((EditText)findViewById(R.id.editTitle)).getText().toString();
        description = ((EditText)findViewById(R.id.editDescription)).getText().toString();
        eventDate = ((EditText)findViewById(R.id.editDate)).getText().toString();
        eventTime = ((EditText)findViewById(R.id.editTime)).getText().toString();
        location = ((EditText)findViewById(R.id.editLocation)).getText().toString();

    }
    public void onClick(View v) {
        if (v.getId() == R.id.okButton) {
            //
        }
        else if (v.getId() == R.id.cancelButton) {
            salir = new CancelDialog();
            salir.show(getSupportFragmentManager(), "cancelar");
        }

    }
}



