# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Navn NIlab Sarwari.
* s362083
* gruppe 91.

# Arbeidsfordeling


# Oppgavebeskrivelse

Oppgave1:

    sjekker vi om tabellen er tom hvis ja så kaster vi en Exception
    lager en methode for å fjerne nullVerdier i tablen.
    lager vi første node
    Vi setter hode like den første node.
    Så går vi inn i et for løkke som looper oppdater ny node og antall.
    oppdatere node som mener jeg at den setter aktuell sin neste peker og samme med førrige sin peker.
    setter vi hale lik node.

Oppgave2A:

    Her så skal vi lage metoden toString
    I lager vi StringBuilder
    Oppreter vi Node og setter det like hode.
    Vi lopper gjenom alle noder fram til verdi er ikke lik null.
    Vi gjøre det sammen bare motsattt vei oå omvendtString.

Oppgave2B:

    vi må sjekke at null verdier er ikke tillat.
    sjekker vi om antall noder er støre en null så oppdatere vi pekere til neste og den førrige peker.
    Hvis antall element er null så setter vi hode lik ny og hale lik ny.
    plusser vi på antall og endringer.
Oppgave3A:

    i Hjelpemetode tar inn en indeks og returnere en node.
    hvis indeks>antall/2 så starter vi lettingen fra hode.
    else så starter vi lettingen fra hale.
    I methoden sjekker vi først om indeks er uløvlig.
    når finner vi node verdi for indeksen og returnere det.
    I methoden Oppdater tar inn en ny verdi og en indeks
    Vi først sjekker om den nye verdi null hvis ja så kaster vi exception.
    sjekker vi igejn om indeksen er ukøvlig.
    etter det oppdaterer vi gammelVerdi med en ny verdi vi har tatt inn.
    returnerer vi den gammele verdi.

Oppgave 3b:

    først oppretter vi  fraTilKontroll() for å sjekke om løvlig verider.
     sjekker om fra<0 også om fra til>antall også til slutt og fra>til.
    lager vi Subliste som tar innn fra og til en liste.
    etterpå lager vi den føste node og setter lik hode også itrer vi derfra.
    Vi oppretter Subliste også fyller sublisteInput med verdiene til [fra-til> sine noder
    returnerr vi Subliste.

Oppgave4:

    sjekker om tabellen er tom eller ikke null hvis det er tom så returernere vi -1
    Etter det begynner vi fra node hode og looper framover
    i forløkke så sjekker vi så sjekker vi om verdi på node er like verdi vi letter etter .  
    når vi finner det så returnere vi possijon til verid.
    hvis ikke så hopper vi på neste node.

Oppgave5:

    sjekke vi  først for at indeks ikke er negative og om den er mindre enn antall.
    Etter det så sjekker vi om antall er lik null hvis den er 0 så betyr det at tabellen er tom og legger vi inn verdien.
    Vi har skal kunne legge verdien i begynelsen av tabellen, i slutten og mellom to verdier.
    Koden er skrevet slik at den kan gjøre alle alternativene.
    Til slutt så plusser vi på antall da vi har lagt inn et nytt element og plusser vi på endringer.

Oppgave6A:

    Vi sjekker først om indeks er negative eller om om indeks er støre eller like antall. Da kaster vi en exception.
    Vi lager en veriabel T for å returnere.
    Først så sjekker vi om siste element skal fjernes
    Etter det så sjekker om første noden skal fjernes
    så sjekker vi om siste noden skal fjernes
    Til slutt så sjekker om noden skal fjernes er mellom to noden
    til slutt så reduserer vi antall og øker endringer.

Oppgave6B:

    boolean fjernes sjekker vi først om verdeien som skal fjernes er lik null hvis den var null returenerer vi false;
    Vi looper for å gå gjenom alle noder til å sjekke om node verdi er like verdi.
    hvis antall lik 1 så oppdater vi hode og hale og setter dem like.
    Til slutt så reduserer vi antallet og øker endringer.

Oppgave8:

    sjekker VI iteratorendirnger er like endringer hvis ikke så kaster vi en exception.
    Vi sjekkerom  METHODEN hasNext er ikke ture så kaster vi en exception
    hvis fjernOk er true så kan man bruke remove() methoden.
    Til slutt returnerer vi denneverdi sin verdien.



