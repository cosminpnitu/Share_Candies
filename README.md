Aplicație - Împarte surprize
Deoarece niciodată nu este greșit să dăruiești, în acest capitol vom implementa o aplicație menită să gestioneze un set de surprize.

Scop final
Scopul final este de a obține un sistem generic capabil să:

utilizeze mai multe tipuri de surprize (i.e. ce implementează o interfață comună)
implementeze diverși algoritmi de stocare și dăruire a surprizelor
folosească un mecanism puternic, aleator de generare a unui set (nou) de surprize
Genericitate
Orice programator software de elită implementează aplicații uitându-se mereu la viitor. Deoarece nimeni nu poate cunoaște cu precizie cum va evolua mediul real și implicit programul scris, aplicația va fi dezvoltată pornind de la niște specificații abstracte de design, pentru fiecare tip de componentă în parte.

Dacă până acum am dezvoltat aplicații având în vedere funcționalitatea finală (i.e. implementarea efectivă a fiecărei clase, metode etc.) target-ul actual este mult mai înalt. Concret, aplicația curentă va fi dezvoltată pornind de la premisa de genericitate și capacitatea de a defini noi componente sau de a actualiza pe cele existente cu ușurință, într-un mod transparent față de restul aplicației.
Mai exact, considerând scopul final al aplicației dorim să putem:

defini cu ușurință noi tipuri de dorințe, care pot fi ușor integrate cu cele deja existente
crea noi algoritmi de gestiune a unei colecții de surprize, care ulterior să poată înlocui sau extinde setul existent fără modificari majore în codul existent
lucra în mod comun cu orice tipuri de surprize
gestiona surprizele într-un mod generic, indiferent de tipul (actual) de container
Înainte de a începe...
Similar cu proiectul trecut, implementarea efectivă reprezintă doar o parte (i.e. 40%) din punctajul final. Este important să înțelegi motivul definirii fiecărei componente și rolul acesteia în sistem. Prin urmare, este recomandat să îți creezi mai întâi o privire de ansamblu asupra sistemului proiectat și abia apoi să implementezi fiecare componentă.
Arhitectură
1. Tipuri de surprize
Fiecare surpriză va implementa următoarea interfață, ce permite „deschiderea“ surprizei:

ISurprise
package surprise;
 
public interface ISurprise {
 
  // Opens the surprise and enjoys it
  void enjoy();
}
Tipurile de surprize sunt următoarele:

Surpriză	Detalii
FortuneCookie	Reprezintă o surpriză de tipul Fortune Cookie în care persoana va primi un mesaj simbolic, care să o călăuzească în viitor.
Operare:	Clasa primește mesajul (i.e. String) la construcția obiectului. Acesta va fi afișat la output în momentul „deschiderii surprizei“.
Candies	Surpriza conține un număr aleator de bomboane, de un anumit tip.
Operare:	Constructorul clasei va primi numărul de bomboane și tipul acestora. La execuția surprizei se va afișa un mesaj relevant, în funcție de starea internă a obiectului-surpriză.
MinionToy	Surpriza va fi o jucărie Minion.
Operare:	Clasa primește la crearea obiectelor numele minionului. La deschiderea surprizei, se va afișa un mesaj sugestiv la output, ce include detaliile jucăriei primite.
Fiecare clasă-surpriză va conține și o metodă statică generate(), care va crea o surpriză de tipul respectiv. Pentru fiecare tip de surpriză, detaliile algoritmului de generare sunt:

Surpriză	Algoritm de generare
FortuneCookie	Clasa va conține un vector de minim 20 de zicale (+ autorul acestora) la alegere. Poți lua colecția de zicale de pe un site de specialitate.
La apelul metodei generate(), metoda va genera un număr aleator și va alege elementul din array în consecință. Ulterior, va crea o (nouă) surpriză corespunzător.
Candies	Clasa va menține intern o colecție de tipuri de bomboane. De exemplu: [chocolate, jelly, fruits, vanilla].
La generarea unei noi surprize, metoda va genera 2 numere aleatoare, pentru a decide tipul bomboanelor (i.e. o surpriză conține un singur tip de bomboane) și respectiv numărul acestora. Ulterior, va crea o (nouă) surpriză corespunzător.
MinionToy	Clasa va stoca o colecție de nume de minioni. De exemplu: [Dave, Carl, Kevin, Stuart, Jerry, Tim].
La generarea unei noi surprize, se va alege în ordine următorul tip de minion, conform colecției ordonate prezentate anterior. Concret, prima surpriză generată va oferi un minion Dave, următoarea un Carl, ș.a.m.d.
→ Hint: vei avea nevoie de un contor intern pentru a reține ultimul minion oferit.
Generarea numerelor aleatoare în Java
În Java, se pot genera numere aleatoare folosind biblioteca Java API - Random. Analizând metodele disponibile, observăm că putem genera numere reale, întregi, valori logice, ș.a.m.d.

Un exemplu de utilizare pentru generarea de numere întregi este:

import java.util.Random;
 
public class Main {
  public static void main(String[] args) {
 
    Random random = new Random();
 
    int n = random.nextInt();
 
    System.out.println(n);
    System.out.println(random.nextInt());
    System.out.println(random.nextInt());
  }
}
Exemplu de Output

Într-un mod similar se folosesc și alte metode din API-ul clasei. Alege metoda potrivită pentru scenariul actual.

O implementare ineficientă ar crea un obiect de tipul Random la fiecare apel al metodei generate(). Ținând cont că același obiect random poate fi reutilizat, gândește-te la o implementare eficientă.
2. Depozitarea surprizelor
Toate surprizele vor fi depozitate în diverse tipuri de containere, care vor dicta modul de stocare și mai ales ordinea în care surprizele vor fi împărțite. Deoarece dorim să operăm cu orice tip de container într-un mod transparent, independent de implementare, vom utiliza o interfață ce va defini protocolul concret de comunicare. Astfel:

Implementare: fiecare container va implementa interfața comună.
Utilizare: fiecare entitate-utilizator va folosi un container din perspectiva interfeței, utilizând implicit numai metodele definite de acea interfață.
Interfața va defini următoarele metode:

IBag.java
public interface IBag {
 
  // adds a surprise in the bag
  void put(ISurprise newSurprise);
 
  // adds all the surprises from another IBag
  //   -> the 'bagOfSurprises' will be empty() afterwards
  void put(IBag bagOfSurprises);
 
  // removes a surprise from the bag and returns it
  ISurprise takeOut();
 
  // Checks if the bag is empty or not
  boolean isEmpty();
 
  // Returns the number of surprises
  int size();
}
Se implementează următoarele tipuri de „tolbe de surprize“:

O tolbă care va da cadourile din interior într-o ordine aleatoare
O tolbă care va da cadourile în ordinea în care acestea au fost introduse (strategie numită FIFO)
O tolbă care va da cadourile în ordinea inversă introducerii (strategie numită LIFO)
Pentru implementarea diverșilor containeri, poți folosi o strategie similară ca în proiectul [P1] Sistem de gestiune înscrieri, unde stocarea elementelor se realiza într-un ArrayList.
3. Crearea surprizelor
Pentru a genera un set de surprize aleatoare, vom implementa o clasă „specială“, GatherSurprises, care va conține:

o metodă statică, gather(int n), ce primește un număr întreg n și returnează un array conținând n surprize.
o metodă statică, gather(), care va returna o singură surpriză.
Observații:

deși intern metodele generează aleator surprizele, aceasta simbolizează acțiunea reală de a colecta surprizele pregătite de oameni darnici pentru cei mici (i.e. în preajma sărbătorilor).
Deoarece fiecare om pregătește ce surpriză dorește, colecția / surpriza întoarsă va fi de fiecare dată diferită.
Se utilizează 2 mecanisme de generare aleatoare:
cel implementat deja, prin care se generează aleator o surpriză aparținând unui anumit tip.
un număr random pentru a se alege tipul de surpriză generată, la fiecare pas.
Specificații
Prin definiție, clasa GatherSurprises nu ar trebui să permită crearea instanțelor și nici moștenirea, deoarece implementarea sa este definitivă și toate metodele sale sunt statice. Deși Java nu permite marcarea unei clase static, putem recurge la următoarele artificii:

instanțiere: putem crea un (singur) constructor, de formă, pe care să îl marcăm private.
Obs: Într-un astfel de caz, trebuie să avem grijă ca toate entitățile clasei să fie statice, altfel acestea nu vor putea fi accesate vreodată.
moștenire: ce keyword folosim pentru a împiedica extinderea clasei?
4. Crearea containerelor
Deoarece există mai multe tipuri de containere, ne dorim implementarea unui mecanism unic prin care să generăm un nou container (gol). Un astfel de șablon de programare (eng: design pattern) este unul des utilizat în programare și se numește Factory Pattern.

Interfața comună pentru crearea de containere va fi (în cazul de față):

IBagFactory.java
public interface IBagFactory {
 
  // Create a new container, according to the specified type
  IBag makeBag(String type);
}
În funcție de valoarea String-ului, se va crea o nouă colecție. Tipurile posibile corespund containerelor definite în secțiunea anterioară:

"RANDOM"
"FIFO"
"LIFO"
Existența unei interfețe pentru crearea de obiecte-container permite definirea mai multor „fabrici“ de tipuri de bag-uri, care pot fi optimizate pentru diverse constrângeri (i.e. viteza de acces, spațiul de stocare etc.). De exemplu, putem defini 2 tipuri de fabrici de obiecte:

class BagFactoryOptimizeStorage implements IBagFactory: care va construi containere optimizate pentru stocare.
class BagFactoryOptimizeAccess implements IBagFactory: care va construi containere optimizate pentru viteza de accesare a elementelor.
Implementare
În cadrul aplicației, crearea bag-ului se va face prin intermediul unei instanțe a clasei care implementează IBagFactory. Este suficient să avem un singur tip de Factory deoarece avem o singură categorie de stocare (i.e. cea bazată pe ArrayList).

Obs: încearcă să eviți instanțierea multiplă a clasei definite. Folosește aceeași instanță pentru generarea oricâtor containere.
5. Împărțirea surprizelor
Până în acest pas, am implementat: (1) diverse tipuri de surprize, (2) câteva tipuri de containere pentru stocarea acestora și (3) un generator aleator, automat, de surprize. Însă ce rost au toate acestea fără bucuria de a dărui?

5.1. Împărțirea surprizelor - mecanism abstract
În cadrul acestui task, vom implementa un mecanism de a împărți surprizele, utilizându-ne de funcționalitatea implementată anterior. Pentru aceasta, se definește clasa abstractă AbstractGiveSurprises, conform următoarelor specificații:

class AbstractGiveSurprises

Stare
Câmp	Descriere
un container (i.e. tolbă)	Va avea tipul în conformitate cu parametrul primit (la construire).

Obs: Cu ajutorul interfețelor, putem stoca (în același câmp) orice tip de tolbă, în funcție de parametrul constructorului. Remarcăm deci un scenariu de compunere generic, în care clasa AbstractGiveSurprises poate accepta orice tip concret de obiect-componentă, compatibil cu interfața IBag.
int waitTime	Un timp de așteptare între distribuirea surprizelor, dat ca număr de secunde.

Construire
Constructor	Descriere
(…)	Constructorul va primi 2 parametri:
1. tipul containerului (i.e. unul dintre tipurile de containere definite anterior - "RANDOM", "FIFO" sau "LIFO"). Parametrul are tipul String.
2. un timp de așteptare. Utilizarea concretă a acestuia va fi explicată în continuare.

Funcționalitate
Metodă	Descriere
void put(ISurprise newSurprise)	Adaugă o nouă surpriză în container.
void put(IBag surprises)	Mută toate surprizele din container-ul parametru în acest container.
give()	Oferă o surpriză.
→ Obs: ordinea de distribuire a surprizelor depinde de tipul tolbei.
giveAll()	Oferă toate surprizele din tolbă, pe rând.
După fiecare surpriză oferită, se așteaptă un interval de timp corespunzător waitTime.
Pentru implementare, se poate folosi următoarea secțiune de cod. Înțelegerea detaliată a acesteia se va face într-un curs următor.
import java.util.concurrent.TimeUnit;
 
// Sleep for X seconds - code snippet
try {
  TimeUnit.SECONDS.sleep(10); // number of seconds to sleep
} catch (InterruptedException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
}
boolean isEmpty()	Întoarce true dacă tolba este goală, false altfel.
abstract void giveWithPassion()	O metodă abstractă, care ține locul unei acțiuni ce va fi efectuată după dăruirea fiecărei surprize (ex: aplauze, o îmbrățișare etc.).
→ Obs: această metodă va fi apelată imediat după oferirea unei surprize, indiferent de metoda apelată pentru împărțirea surprizelor (i.e. give() sau giveAll()).
→ Obs2: metoda va fi vizibilă doar în interiorul pachetului și pe lanțul de moștenire.
5.2. Împărțirea surprizelor - moduri posibile
Clasa abstractă va fi extinsă de 3 tipuri de clase normale, după cum urmează:

Clasă	Detalii de moștenire
GiveSurpriseAndApplause	Va implementa metoda abstractă, afișând un mesaj corespunzător.
Exemplu:	Loud applause to you… For it is in giving that we receive.
GiveSurpriseAndSing	Va implementa metoda abstractă, afișând un mesaj corespunzător.
Exemplu:	Singing a nice song, full of joy and genuine excitement…
GiveSurpriseAndHug	Va implementa metoda abstractă, afișând un mesaj corespunzător.
Exemplu:	Warm wishes and a big hug!
