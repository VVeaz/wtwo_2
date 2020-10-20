package com.company;

public class ListaOddzialow {
    Oddzial pierwszy;
    Oddzial ostatni;

    ListaOddzialow()
    {
        pierwszy = null;
        ostatni = null;
    }

    Oddzial add(String nazwa, int x, Oddzial v)
    {
        Oddzial o;
        if(pierwszy == null)
        {
            o = new Oddzial(nazwa, x, null, null);
            pierwszy = o;
            pierwszy.popr = ostatni;
            ostatni = o;
            ostatni.nast = pierwszy;
        }
        else
        {
            o = new Oddzial(nazwa, x, v.nast, v);

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

    void delete(String nazwa)
    {
        Oddzial p = pierwszy;
        Oddzial popr = null;

        while (p != null && !p.nazwa.equals(nazwa)) {
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

    Oddzial szukaj(String nazwa)
    {
        Oddzial p = pierwszy;

        if(p.nazwa.equals(nazwa))
            return p;
        else
            p = p.nast;

        while(p != null && !p.nazwa.equals(nazwa) || p != pierwszy)
            p = p.nast;

        return p;
    }
}
