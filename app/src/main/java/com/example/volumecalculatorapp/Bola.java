package com.example.volumecalculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bola extends AppCompatActivity {

    EditText radiusBola;
    TextView judul,result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bola);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radiusBola = findViewById(R.id.bolaEditText);
        judul = findViewById(R.id.bolaText);
        result = findViewById(R.id.bolaResult);
        btn = findViewById(R.id.bolaBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = radiusBola.getText().toString();
                int r = Integer.parseInt(radius);

                // V = (4/3) * pi * r^3
                double volume = 4 * (Math.PI *r*r*r)/3;
                result.setText("Volume = "+volume+" m^3");
            }
        });

    }

    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int itemId = item.getItemId();

        if(itemId == R.id.action_home){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}