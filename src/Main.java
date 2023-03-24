
class Searches{

    int interpolation_search(int[] a,int szukana_wartosc) // zalozenie - rozklad liniowy oraz tylko jedna liczba sie powtarza
    {                                                       //
        int p = -1 ;
        int czy_ostatnie = 0;
        int srodek = 0;
        int poczatek = 0;
        int koniec = a.length - 1;
        int rozklad = 0;


        if ( a.length > 4 )
        {
            if ( a[0] != a[1] ) // szukamy roznicy pomiedzy elementami tablicy / rozkladu poszczegolnych elementow
            {
                rozklad = a[1] - a[0] ;
            } else if ( a[(a.length/2)] != a[(a.length/2) + 1] )
            {
                rozklad = a[(a.length/2)] - a[(a.length/2) + 1] ;
            } else if ( a[(a.length-1)] != a[(a.length-2)] )
            {
                rozklad = a[(a.length-2)] - a[(a.length-1)] ;
            } else
            {
                rozklad = -1 ;
            }


        }

        while ( (a[poczatek] <= szukana_wartosc) && ( szukana_wartosc <= a[koniec] ) && (p == -1 ) && ( czy_ostatnie==0 ) )
        {
            System.out.println("operacja interpolation");

            srodek =  poczatek + ( ((szukana_wartosc-a[poczatek])*(koniec-poczatek) )/(a[koniec] - a[poczatek]) ) ;

            if ( szukana_wartosc != a[srodek] )
            {
                if ( szukana_wartosc < a[srodek] )
                {
                    koniec = srodek - 1 ;
                } else if ( szukana_wartosc > a[srodek] )
                {
                    poczatek = srodek + 1;
                }
            } else
            {
                if ( srodek + 1 <= a.length -1 )
                {
                    if ( a[srodek+1] == szukana_wartosc )
                    {

                        if ( rozklad != -1 )
                        {

                            return (koniec - ( ( a[koniec] - a[srodek] )/rozklad ) ) ;

                        }

                    } else if ( a[srodek+1] != szukana_wartosc )
                    {
                        p = srodek ;
                        czy_ostatnie = 1;
                    }
                } else if ( srodek == a.length -1 )
                {
                    p = srodek ;
                }

            }

        }

        return p;
    }


    int bin_search(int[] a , int szukana_wartosc)
    {

        int srodek=0;
        int lewo = 0;
        int prawo = a.length - 1 ;

        while ( lewo <= prawo )
        {

            srodek = (lewo+prawo) / 2 ;

            if ( a[srodek] == szukana_wartosc )
            {
                return srodek;
            } else if ( a[srodek] > szukana_wartosc )
            {
                prawo = srodek - 1 ;
            } else if ( a[srodek] < szukana_wartosc )
            {
                lewo = srodek + 1 ;
            }


        }

        return -1 ;

    }

}


public class Main {
    public static void main(String[] args) {


    int[] tab_1 = {1,3,5,7,9,11,13,15,17,19,21,23 } ;
//    int[] tab_2 = { 10 , 20 , 30 , 40 , 50 , 60 , 70 , 80 , 90 } ;
//    int[] tab_3 = { 1,3,5,7,21,23,25,27 } ;
//    int[] tab_4 = { 1,4,9,16,25,36,49,64,81  } ;
    int[] tab_5 = { 1,3,5,7,9,11,13,15,15,15,15,15,17,19,21,23,25  } ;

    Searches search_klasa = new Searches();

    System.out.println( search_klasa.interpolation_search(tab_5 ,15 )) ;
    //System.out.println(search_klasa.bin_search(tab_1,21));



        System.out.println("Hello world!");
    }
}