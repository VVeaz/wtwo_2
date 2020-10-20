package com.company;

public class ListaPracownikow {
    Pracownik pierwszy;
    Pracownik ostatni;
    int rozmiar;

    ListaPracownikow()
    {
        pierwszy = null;
        ostatni = null;
        rozmiar = 0;
    }

    Pracownik add(String nazwa, int x, Pracownik v)
    {
        Pracownik o;
        rozmiar++;
        if(pierwszy == null)
        {
            o = new Pracownik(nazwa, x, null, null);
            pierwszy = o;
            pierwszy.popr = ostatni;
            ostatni = o;
            ostatni.nast = pierwszy;
        }
        else
        {
            o = new Pracownik(nazwa, x, v.nast, v);

            if(o.nast != null)
                v.nast.popr = o;
            else
            {
                ostatni = o;
                ostatni.nast = pierwszy;
            }

            v.nast = o;
        }

        return o;
    }

    void delete(String nazwa) //funkcja zdaje sie niepotrzebna
    {
        rozmiar --;
        Pracownik p = pierwszy;
        Pracownik popr = null;

        while (p != null && !p.imie.equals(nazwa)) {
            popr = p ;
            p = p.nast;
        }

        if (p != null)
            if (popr == null)
            {
                pierwszy = p.nast;
                pierwszy.popr = ostatni;
            }
            else
            {
                popr.nast = p.nast;

                if(p.nast == null)
                {
                    ostatni = popr;
                    ostatni.nast = pierwszy;
                }
                else
                    p.nast.popr = popr;
            }
    }
}
