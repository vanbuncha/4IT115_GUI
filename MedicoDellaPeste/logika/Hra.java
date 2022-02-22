package logika;

import java.util.Random;

/**
 *  Třída Hra - třída představující logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */

/**
 * Upravy pri napsani spatne prikazu
 * @author Van Nguyen
 * @version pro skolni rok 2019/2020
 */

public class Hra implements IHra {
    private SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private HerniPlan herniPlan;
    private boolean konecHry = false;

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Hra() {
        herniPlan = new HerniPlan(this);
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazHodKostkou(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazZobrazitPouch(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazVytvorKamen(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazHP(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazStamina(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        return "\n Vítej!\n" +
               "Píše se rok 1656, na alternativní planetě, která je podobná naší zemi, dříve kypřícím životě vypukl mor…\n" +
               "Lidé umírají doma i na ulici, a to s rodinou, a i bez ní.\n" +
                "Lidstvo už ztrácí naději v budoucnost, kdo je zachrání, kdo bude jejím spasitelem?\n" +
                "Jsi to právě ty! The Plague Doctor! Je čas, aby si zužitkoval svoje znalosti medicíny a stal se hrdinou.\n" +
                "Pouze jediná možnost zbývá... Úkol téměř nemožný… Úkol všemi obávaný... Úkol za honbou kamene mudrců… neboli také znám jako lapis philosophorum.\n" +
                "Tvým cílem je najít jeho 3 klíčové ingredience spojit je a zachránit lidstvo. \n" +
                "1)\tUcho ohnivého obra Máklátilmu.\n" +
                "2)\tŽíně jednorožce.\n" +
                "3)\tVýtažek z aloe vera, který byl požehnán bohyní duhy Iris. \n"+
                "Máš pouze 80 životů a za každé hození hození kostky se ti odebe 2 nebo 5 životů a to včetně tvorby kamene, za každý výlet ztratiš 1 stamina, más jen 20 stamina, tak pozor!\n" +
                 "Můžeš použít tyto příkazy: \n [vytvorkamen] [odkostkou] [ukazHP] [ukazStamina] [obsahpytlik] [jdi] [nápověda] [konec]" + "\n Čeká tě mnoho překážek, hodně štěstí! \n" +
               "\n" +
                "\n" +
                "\n" +
               herniPlan.getAktualniProstor().dlouhyPopis();
    }
    
    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return "Dík, že jste si zahráli.  Ahoj.";
    }
    
    /** 
     * Vrací true, pokud hra skončila.
     */
     public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for(int i=0 ;i<parametry.length;i++){
           	parametry[i]= slova[i+1];  	
        }
        String textKVypsani=" .... ";
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.provedPrikaz(parametry);
        }
        else {
            final String[] listOfErrors = {"Tam se odsud jít nedá!", "Spatne kamo, zkus to znova!", "Co delas? ZNOVA!"," Nevis co? Zkus to znova.","Interpunkce je zlo, zkus to znova"," " +
                    "Pozor na velky pismena, znova!"," Klidne kopiruj jmena, je to rychlejsi"," Nevim co chces","Pis pomalu mozna to pomuze","Hehe, spatne","Haha, neznam tento prikaz typu String",
            "Zpomal kamarade, Zkus to znova"};
            Random random = new Random();
            int index = random.nextInt(listOfErrors.length);
            textKVypsani = listOfErrors[index];
            return textKVypsani;
        }
        return textKVypsani;
    }
    
    
     /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.
     *  
     *  @param  konecHry  hodnota false= konec hry, true = hra pokračuje
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }
    
     /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  
     *  @return     odkaz na herní plán
     */
     public HerniPlan getHerniPlan(){
        return herniPlan;
     }
    
}

