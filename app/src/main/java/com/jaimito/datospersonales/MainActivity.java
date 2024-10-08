package com.jaimito.datospersonales;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {

    EditText[] editTexts = new EditText[4];
    ImageButton ivUpArrow, ivDownArrow;
    SwitchCompat switchInfoLog;
    int currentFoco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTexts[0] = findViewById(R.id.etNombre);
        editTexts[1] = findViewById(R.id.etApellidos);
        editTexts[2] = findViewById(R.id.etEmail);
        editTexts[3] = findViewById(R.id.etTelefono);
        ivUpArrow = findViewById(R.id.ivUpArrow);
        ivDownArrow = findViewById(R.id.ivDownArrow);
        switchInfoLog = findViewById(R.id.switchInfoLog);

        editTexts[0].requestFocus();
        currentFoco = 0;

        ivUpArrow.setOnClickListener(v -> { cambiarFoco(-1); });
        ivDownArrow.setOnClickListener(v -> { cambiarFoco(1); });
    }

    private void cambiarFoco(int direccion) {
        editTexts[currentFoco].clearFocus();
        currentFoco = (currentFoco + direccion + editTexts.length) % editTexts.length;
        editTexts[currentFoco].requestFocus();

        if (switchInfoLog.isChecked()) {
            Log.i("currentFoco", "El foco es: " + currentFoco + ": " + editTexts[currentFoco].getText().toString());
        }

    }

}