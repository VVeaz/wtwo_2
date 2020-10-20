package com.company;

public class Oddzial {
    String nazwa;
    int wielkoscZmiany;
    Oddzial nast;
    Oddzial popr;
    ListaPracownikow listaPracownikow;
    Oddzial(String nazwa, int wielkoscZmiany, Oddzial nast, Oddzial popr){
        this.nazwa=nazwa;
        this.wielkoscZmiany = wielkoscZmiany;
        this.nast=nast;
        this.popr=popr;
        listaPracownikow = new ListaPracownikow();
    }
}
