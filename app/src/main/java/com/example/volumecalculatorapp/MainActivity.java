package com.example.volumecalculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ShapeClickListener{

    RecyclerView recyclerView;

    List<Shape> shapeList;

    Adapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        shapeList = new ArrayList<>();

        Shape shape1 = new Shape(R.drawable.kubus,"Cube");
        Shape shape2 = new Shape(R.drawable.bola,"Sphere");
        Shape shape3 = new Shape(R.drawable.piramida,"Pyramid");

        shapeList.add(shape1);
        shapeList.add(shape2);
        shapeList.add(shape3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Adapter = new Adapter(shapeList);
        recyclerView.setAdapter(Adapter);

        Adapter.setClickListener(this);
    }

    @Override
    public void onClick(View v, int pos) {
        Intent intent;
        switch (pos) {
            case 0:
                intent = new Intent(getApplicationContext(), Kubus.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(getApplicationContext(), Bola.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(getApplicationContext(), Piramida.class);
                startActivity(intent);
                break;
        }
    }

    // Menu
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