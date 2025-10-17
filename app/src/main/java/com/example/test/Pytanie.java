package com.example.test;

public class Pytanie {
    private String trescPytania;
    private int idObrazka;
    private boolean odpowiedz;
    private String podpowiedz;
    private boolean CzyDobraOdpowiedz;

    private boolean czWykorzystanaPodpowiedz;
    public Pytanie(String trescPytania, int idObrazka, boolean odpowiedz, String podpowiedz) {
        this.trescPytania = trescPytania;
        this.idObrazka = idObrazka;
        this.odpowiedz = odpowiedz;
        this.podpowiedz = podpowiedz;
        CzyDobraOdpowiedz = false;
        czWykorzystanaPodpowiedz = false;
    }

    public boolean isCzWykorzystanaPodpowiedz() {
        return czWykorzystanaPodpowiedz;
    }

    public void setCzWykorzystanaPodpowiedz(boolean czWykorzystanaPodpowiedz) {
        this.czWykorzystanaPodpowiedz = czWykorzystanaPodpowiedz;
    }

    public boolean isCzyDobraOdpowiedz() {
        return CzyDobraOdpowiedz;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public void setTrescPytania(String trescPytania) {
        this.trescPytania = trescPytania;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public void setIdObrazka(int idObrazka) {
        this.idObrazka = idObrazka;
    }

    public boolean isOdpowiedz() {
        return odpowiedz;
    }

    public void setOdpowiedz(boolean odpowiedz) {
        this.odpowiedz = odpowiedz;
    }

    public String getPodpowiedz() {
        return podpowiedz;
    }

    public void setPodpowiedz(String podpowiedz) {
        this.podpowiedz = podpowiedz;
    }

    public void setCzyDobraOdpowiedz(boolean czyDobraOdpowiedz) {
        CzyDobraOdpowiedz = czyDobraOdpowiedz;
    }
}
