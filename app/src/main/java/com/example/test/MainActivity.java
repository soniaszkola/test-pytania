package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button buttonTak;
    private Button buttonNie;
    private Button buttonPodpowiedz;
    private Button buttonNastepne;
    private TextView textViewPytanie;
    private int numerPytania = 0;
    private boolean odpowiedzUdzielona = false;
    private ImageView imageView;
    private String podpowiedz;
    private ArrayList<Pytanie> pytania = new ArrayList<>();

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
        textViewPytanie = findViewById(R.id.textViewPytanie);
        buttonNastepne = findViewById(R.id.buttonNastepne);
        buttonPodpowiedz = findViewById(R.id.buttonPodpowiedz);
        buttonNie = findViewById(R.id.buttonNie);
        buttonTak = findViewById(R.id.buttonTak);
        imageView = findViewById(R.id.imageView);
        pytania = Repozytorium.zwrocWszystkiePytania();

        buttonTak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sprawdzOdpowiedz(true);
            }
        });


        buttonNie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sprawdzOdpowiedz(false);
            }
        });

        buttonPodpowiedz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(MainActivity.this, PodpowiedzActivity.class);
                // intencja(aktywna wiemy co i za pomoca jakiej aktywnosci) jawna, sa tez niejawne
                //pokazPodpowiedz();
                intencja.putExtra("KTORE PYTANIE", numerPytania);
                startActivity(intencja);
            }
        });

        buttonNastepne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numerPytania < pytania.size() - 1) {
                    numerPytania++;
                    odpowiedzUdzielona = false;
                    wyswietlPytanie();
                } else {
                    textViewPytanie.setText("Koniec testu! Otrzymano: "+obliczIlePunktowZaTest()+" punktów!");
                    buttonTak.setEnabled(false);
                    buttonNie.setEnabled(false);
                    buttonPodpowiedz.setEnabled(false);
                    buttonNastepne.setEnabled(false);
                    imageView.setVisibility(View.INVISIBLE);//grafika znika
                }
            }
        });

        wyswietlPytanie();
    }

    private void wyswietlPytanie() {
        if(numerPytania < pytania.size()) {
            Pytanie pytanie = pytania.get(numerPytania);
            imageView.setImageResource(pytania.get(numerPytania).getIdObrazka());
            textViewPytanie.setText(pytania.get(numerPytania).getTrescPytania());
        }
    }
    private void  sprawdzOdpowiedz(boolean udzielonaOdpowiedz){
        if(odpowiedzUdzielona){
            pytania.get(numerPytania).setCzyDobraOdpowiedz(true);
            Toast.makeText(this, "juz dales odp", Toast.LENGTH_SHORT).show();
            return;
        }
        Pytanie pytanie = pytania.get(numerPytania);

        if(udzielonaOdpowiedz == pytanie.isOdpowiedz()){
            Toast.makeText(this, "dobrze", Toast.LENGTH_SHORT).show();
            pytanie.setCzyDobraOdpowiedz(true);
        }
        else{
            Toast.makeText(this, "zle", Toast.LENGTH_SHORT).show();
        }
        udzielonaOdpowiedz = true;
    }

    private int obliczIlePunktowZaTest(){
        int sumaPunktow = 0;
        for(Pytanie pytanie:pytania){
            if(pytanie.isCzyDobraOdpowiedz()){
                if(pytanie.isCzWykorzystanaPodpowiedz()) {
                    sumaPunktow = sumaPunktow + 1;
                }
                else{
                    sumaPunktow = sumaPunktow + 10;
                }
            }
        }
        return sumaPunktow;
    }
    private void  pokazPodpowiedz(){
        if(numerPytania < pytania.size()){
            Pytanie pytanie = pytania.get(numerPytania);
            Toast.makeText(this, pytanie.getPodpowiedz(), Toast.LENGTH_SHORT).show();
            }
        }
    }

