package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {



     // @param <T>

    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen




    public DobbeltLenketListe() {
        // Konstruktøren til den tomme listen
        hode = hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        this.hode = null;
        this.hale = null;
        if (a == null) {
            throw new NullPointerException("Tabbelen a er null!");
        }
        if (a.length > 0) {
            int i = 0;
            for (; i < a.length; i++) {
                if (a[i] != null) {
                    hode = new Node<>(a[i], null, null);
                    antall++;
                    break;
                }
            }
            hale = hode;
            if (hode != null) {
                i++;
                for (; i < a.length; i++) {
                    if (a[i] != null) {
                        hale.neste = new Node<>(a[i], hale, null);
                        hale = hale.neste;
                        antall++;
                    }
                }
            }
        }
    }


//oppgave 3 a:
    private Node<T> finnNode(int indeks) {

        indeksKontroll(indeks, false);

        Node<T> current;

        if (indeks < antall / 2) { //Søker fra hode
            current = hode;
            for (int i = 0; i < indeks; i++) {
                current = current.neste;
            }
            return current;

        } else { //Søker fra hale
            current = hale;
            for (int i = antall - 1; i > indeks; i--) {
                current = current.forrige;
            }
            return current;
        }
    }


    //hjelpe tabell fra kompendiet
    public void indeksKontroll(int indeks, boolean leggInn)
    {
        if (indeks < 0 ? true : (leggInn ? indeks > antall() : indeks >= antall()))
            throw new IndexOutOfBoundsException(melding(indeks));
    }

    //hjele tabell
    private static void fratilKontroll(int antall, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > antall)              // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + antall + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }





//oppgave 3b:
    public Liste<T> subliste(int fra, int til) {
        fratilKontroll(antall, fra, til);

        Liste<T> liste = new DobbeltLenketListe<>();
        int lengde = til - fra;

        if (lengde < 1) {
            return liste;
        }

        Node<T> current = finnNode(fra);

        while (lengde > 0) {
            liste.leggInn(current.verdi);
            current = current.neste;
            lengde--;
        }

        return liste;
    }

    @Override
    public int antall(){
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public boolean leggInn(T verdi) {
        verdi= Objects.requireNonNull(verdi, "Null-verdier er ikke tillatt!");

        Node<T> nyNode = new Node<>(verdi);
        if(hode == null && hale == null && antall == 0){ // Tilfelle der listen på forhånd er tom
            hode = nyNode;
            hale = hode;
            endringer++;
            antall++;
            return true;
        }
        else { // Tilfelle der det ikke er en tom liste
            nyNode.forrige= hale;
            hale.neste = nyNode;
            hale = nyNode;
            endringer++;
            antall++;
            return true;

        }
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi,"Verdien kan ikke være null!");
        if(indeks>antall) {
            throw new IndexOutOfBoundsException("Indeks er større enn antall noder");
        }
        else if(indeks<0){
            throw new IndexOutOfBoundsException("Indeksen kan være negativ");
        }
        if (antall == 0 && indeks == 0) hode = hale = new Node<T>(verdi, null, null);
            // Legges først
        else if (indeks == 0) {
            hode = new Node<T>(verdi, null, hode);
            hode.neste.forrige = hode;
            //legges sist
        } else if (indeks == antall) { // Legges sist
            hale = new Node<T>(verdi, hale, null);
            hale.forrige.neste = hale;
        } else { // Legges i midten
            Node<T> node = hode;

            for (int i = 0; i < indeks; i++) node = node.neste;
            node = new Node<T>(verdi, node.forrige, node);
            node.neste.forrige = node.forrige.neste = node;
        }

        antall++;
        endringer++;
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
        //  throw new NotImplementedException();
    }


    @Override
    public T hent(int indeks) {

        Node<T> current = finnNode(indeks);

        return current.verdi;
    }




    @Override
    public int indeksTil(T verdi) {
        Node<T> node = hode;

        boolean funnet = false;
        int indeks = 0;

        while (node != null) {
            if (node.verdi.equals(verdi)) {
                funnet = true;
                break;
            }
            node = node.neste;
            indeks++;
        }

        return funnet ? indeks : -1;
    }
    @Override
    public T oppdater(int indeks, T nyverdi) {

        Objects.requireNonNull(nyverdi);

        Node<T> current = finnNode(indeks);

        T gammelVerdi = current.verdi;
        endringer++;

        current.verdi = nyverdi;

        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {

        Node<T> current = hode;
        StringBuilder s = new StringBuilder();
        s.append("[");

        if (tom()) {
            s.append("]");
            return s.toString();
        } else {
            s.append(current.verdi);
            current = current.neste;
            while (current != null) {
                s.append(", ");
                s.append(current.verdi);
                current = current.neste;
            }
        }
        s.append("]");

        return s.toString();
    }


    public String omvendtString() {

        Node<T> current = hale;
        StringBuilder s = new StringBuilder();
        s.append("[");

        if (tom()) {
            s.append("]");
            return s.toString();
        } else {
            s.append(current.verdi);
            current = current.forrige;
            while (current != null) {
                s.append(", ");
                s.append(current.verdi);
                current = current.forrige;
            }
        }
        s.append("]");

        return s.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


