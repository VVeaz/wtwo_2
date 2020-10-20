package com.company;

public class Pracownik {
    String imie;
    int id;
    Pracownik nast;
    Pracownik popr;
    Oddzial oddzial;
    Pracownik(String imie, int id, Pracownik nast, Pracownik popr){
        this.id = id;
        this.imie = imie;
        this.nast = nast;
        this.popr = popr;
    }
}
