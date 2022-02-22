package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková
 * @version  pro školní rok 2016/2017
 */
public class HraTest {
    private Hra hra1;
    private int hp = 80;
    private int stamina = 20;
    private MedicalPouch medicalPouch = new MedicalPouch();

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra(); }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void testPrubehHry() {
        assertEquals("domeček", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi les");
        assertEquals(false, hra1.konecHry());
        assertEquals("les", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi hluboký_les");
        assertEquals(false, hra1.konecHry());
        assertEquals("hluboký_les", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("konec");
        assertEquals(true, hra1.konecHry());
    }
    @Test
    public void testMordorHeavenGood(){
        // Nez se tento test spusti je treba vlozit itemy do medical pouche jiz v Hernim planu

        // Cesta k jednomu z cilu (MordorHeaven)
        hra1.zpracujPrikaz("jdi na_rozcesti");
        hra1.zpracujPrikaz("jdi na_rozcesti2");
        hra1.zpracujPrikaz("jdi na_rozcesti3");
        hra1.zpracujPrikaz("jdi na_krizovatce");
        hra1.zpracujPrikaz("jdi MordorHeaven");
        //
        // Tvorba kamene mudrcu
        // Je zde cyklus while aby byla garance hozeni 11
        int count =1;
        while(count <30){
            System.out.println(hra1.zpracujPrikaz("vytvorkamen"));
            count++;
        }
        assertEquals(true,hra1.konecHry());
    }
    @Test
    public void testNevzatelnostiItemu(){
        // Cesta k prostoru, kde se item, ktery nejde vzit
        hra1.zpracujPrikaz("jdi na_rozcesti");
        hra1.zpracujPrikaz("jdi na_rozcesti2");
        hra1.zpracujPrikaz("jdi na_rozcesti3");
        // Pro usnadneni > PrikazHodKostkou Max 6 Min 6 > Uzivatel zjisti, ze by technicky vzto mel dostat automat na kafe, ale automat se mu neprida do inventare
        System.out.println(hra1.zpracujPrikaz("hodkostkou"));
    }

    }

