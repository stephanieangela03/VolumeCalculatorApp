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

public class Kubus extends AppCompatActivity {
    EditText sisiKubus;
    TextView judul,result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kubus);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sisiKubus = findViewById(R.id.kubusEditText);
        judul = findViewById(R.id.kubusText);
        result = findViewById(R.id.kubusResult);
        btn = findViewById(R.id.kubusBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sisi = sisiKubus.getText().toString();

                int s = Integer.parseInt(sisi);

                // V=sisi^3
                double volume = s*s*s;
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