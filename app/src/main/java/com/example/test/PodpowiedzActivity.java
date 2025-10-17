package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class PodpowiedzActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    ArrayList<Pytanie> pytania;
    private Button buttonPowrot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_podpowiedz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView2);
        pytania = Repozytorium.zwrocWszystkiePytania();
        buttonPowrot = findViewById(R.id.buttonPowrot);
        Intent intent = getIntent();
        int ktore = intent.getIntExtra("KTORE PYTANIE", 0);
        textView.setText("Podpowiedz do pytania nr "+(ktore+1)+"\n"+pytania.get(ktore).getPodpowiedz());
        imageView.setImageResource(pytania.get(ktore).getIdObrazka());
        pytania.get(ktore).setCzWykorzystanaPodpowiedz(true);
    }
}