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

public class Piramida extends AppCompatActivity {

    EditText panjangAlasPiramida, lebarAlasPiramida, tinggiPiramida;
    TextView judul,result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_piramida);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        panjangAlasPiramida = findViewById(R.id.piramidaEditText);
        lebarAlasPiramida = findViewById(R.id.piramidaEditText2);
        tinggiPiramida = findViewById(R.id.piramidaEditText3);
        judul = findViewById(R.id.piramidaText);
        result = findViewById(R.id.piramidaResult);
        btn = findViewById(R.id.piramidaBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baseLength = panjangAlasPiramida.getText().toString();
                String baseWidth = lebarAlasPiramida.getText().toString();
                String height = tinggiPiramida.getText().toString();

                int l = Integer.parseInt(baseLength);
                int w = Integer.parseInt(baseWidth);
                int h = Integer.parseInt(height);

                // V= l*w*h/3
                double volume = (l * w * h) * (double) 1/3;
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