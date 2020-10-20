package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Pracownik []arr = new Pracownik[n];
        ListaOddzialow szpital = new ListaOddzialow();
        int id_dodawanego = 0;
        for(int i=0; i<n; i++){
            System.out.println("udany obrot");
            String p1 = scanner.next();
            if(!p1.equals("s")){
                String p2 = scanner.next();
                switch (p1){
                    case "a": {
                        String name = scanner.next();
                        if (p2.equals("w")) {
                            int wielkoscZmiany = scanner.nextInt();
                            szpital.add(name, wielkoscZmiany, szpital.ostatni);
                        } else {
                            String nazwaOddz = scanner.next();
                            Oddzial oddzial = szpital.szukaj(nazwaOddz);

                            arr[id_dodawanego] = oddzial.listaPracownikow.add(
                                    name, id_dodawanego, oddzial.listaPracownikow.ostatni);
                            arr[id_dodawanego].oddzial = oddzial;

                        }
                    };
                    case "d":{
                        if(p2.equals("w")){
                            String nazwaOddz = scanner.next();
                            szpital.delete(nazwaOddz);
                        }else{
                            int id = scanner.nextInt();
                            Pracownik p = arr[id];
                            p.oddzial.listaPracownikow.rozmiar--; //to dziala w ogole?
                            //zabezpieczyc pred nullami
                            Pracownik tmp = p.popr;
                            p.popr.nast = p.nast;
                            p.nast.popr = tmp;
                            arr[id]=null;
                        }
                    };
                    case "m":{
                        int id = scanner.nextInt();
                        String nazwaOddz = scanner.next();
                        Pracownik p = arr[id];
                        p.oddzial.listaPracownikow.rozmiar--;//to dziala?
                        //zabezpieczyc pred nullami
                        Pracownik tmp = p.popr;
                        p.popr.nast = p.nast;
                        p.nast.popr = tmp;
                        Oddzial oddzial = szpital.szukaj(nazwaOddz);
                        arr[id] = oddzial.listaPracownikow.add(p.imie, id, oddzial.listaPracownikow.ostatni);
                        oddzial.listaPracownikow.rozmiar++; //to dziala?

                    };
                    case "e":{
                        if(p2.equals("w")){
                            String s_nazwa = scanner.next();
                            String n_nazwa = scanner.next();
                            int wielk = scanner.nextInt();
                            Oddzial oddzial = szpital.szukaj(s_nazwa);
                            //to dziala w ogole?
                            oddzial.nazwa = n_nazwa;
                            oddzial.wielkoscZmiany = wielk;

                        }else{
                            int id = scanner.nextInt();
                            arr[id].imie = scanner.next();
                        }
                    }


                }

            }else{
                int iloscZmian = scanner.nextInt();
                //przejsc po wszystkich oddzialach i z kazdego wypisac kto jest po
                //podanej ilosci zmian na zmianie jesli jest za malo wypisac niedobor
                Oddzial obecny = szpital.pierwszy;
                while (obecny.nast!=szpital.pierwszy){
                    System.out.println(obecny.nazwa);
                    if(obecny.wielkoscZmiany>obecny.listaPracownikow.rozmiar){
                        System.out.println("(niedobor pracownikow)");
                    }

                    for(int j=0; j<(iloscZmian*obecny.wielkoscZmiany); j++){
                        obecny.listaPracownikow.ostatni=obecny.listaPracownikow.pierwszy;
                        obecny.listaPracownikow.pierwszy=obecny.listaPracownikow.pierwszy.nast;

                    }
                    Pracownik tmp = obecny.listaPracownikow.pierwszy;
                    for(int j=0; j<obecny.wielkoscZmiany; j++){

                        System.out.println(tmp.imie);
                        tmp = tmp.nast;
                    }

                    obecny = obecny.nast;
                }
            }
        }
	// write your code here
    }
}
