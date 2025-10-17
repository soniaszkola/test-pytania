package com.example.test;

import java.util.ArrayList;

public class Repozytorium {
    private static ArrayList<Pytanie> pytania;
    public static ArrayList<Pytanie> zwrocInoRaz(){
        if(pytania == null){
            zwrocWszystkiePytania();
        }
        return pytania;
    };
    private static ArrayList<Pytanie> zwrocWszystkiePytania(){
        ArrayList<Pytanie> pytania = new ArrayList<>();
        pytania.add(new Pytanie(
                "Czy na obrazie widać zachód słońca?",
                R.drawable.morze,
                true,
                "To jest przejście nieba przez różne odcienie"));

        pytania.add(new Pytanie(
                "Czy na obrazku widać jakieś zwierzeta?",
                R.drawable.morze1,
                false,
                "Na obrazku widać tylko różne kolory"));

        pytania.add(new Pytanie(
                "Czy na obrazku są latarnie morskie?",
                R.drawable.morze2,
                false,
                "Na obrazku widać fale morrza"));

        pytania.add(new Pytanie(
                "Czy na plaży widać jakieś kamienie?",
                R.drawable.morze3,
                false,
                "Plaża jest raczej piaszczysta"));
        return pytania;
    }
}
