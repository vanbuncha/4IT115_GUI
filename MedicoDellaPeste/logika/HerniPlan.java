package logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 *
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {

    private Hra hra;
    private Prostor aktualniProstor;
    private int hp = 80;
    private int stamina = 20;
    private MedicalPouch medicalPouch = new MedicalPouch();



    /**
     * Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan(Hra hra) {
        this.hra = hra;
        zalozProstoryHry();

    }

    /**
     * Vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor theShire = new Prostor("theShire","the Shire. Tvé rodné doupě, všude okolo tebe jsou umírající lidi. Nic moc, je tu jen tvoje rodina, která tě vždy bude milovat.",
                "Najdi potřebné itemy a dojdi na konec");
        Prostor na_rozcesti = new Prostor("na_rozcesti","na rozcesti. Tvoje první rozcestí, doufám, že se vyznáš ve světě. Jedna cesta vede do jeskyně Obra Máklatilu, druhá vede do Mordoru!",
                "Stavil bych se nejdřív u Obra Máklatilmu, aby ti dal první ingredienci.");
        Prostor vstup_do_jeskyne = new Prostor ("vstup_do_jeskyne","vstup do jeskyně.Je tu krásně, okolí plného života.",
                "Pamatuj, aby si získal Ucho obra Máklatilu musíš hodit 6 (příkaz hodkostkou), pokud ale hodíš hodnotu 1, tak ztratíš celkem 5 životů!");
        Prostor jeskyne = new Prostor("jeskyne","Jeskyně obra Máklatilu.","Dialog:\n" +
                "Medico: – Vždyť víš, co chci\n" +
                "Obr Maklatilu: -Já vím, ale nejde o to, kdo co chce!\n" +
                "Medico: -Vždyť víš, co chci\n" +
                "Obr Maklatilu: Já vím, ale já mám svoje instrukce!\n" +
                "Medico: -Vždyť víš, co chci\n" +
                "Obr Maklatilu: - Já vím, ale nabídka určuje poptávku\n" +
                "Obr Maklatilu: Zkus hodit 6 a dam ti svoje ucho \uD83D\uDE0A\n");
        Prostor na_rozcesti2 = new Prostor("na_rozcesti2","na rozcestí 2. Tvoje druhé rozcestí, jedna cesta vede za jednorožcem druhá do Mordoru., ","Stavil bych se nejdřív za jednorožcem, aby ti da kousek své žíně.");
        Prostor vstup_do_shed = new Prostor("vstup_do_shed"," vstup do shed. Ve prostřed ničeho, vidíš shed. Před vstupem do shed potkáš studenta z VŠE.","Dialog:\n" +
                "Medico: - Ahoj studente! Hádám, že máš zkouškové období, jak se ti vede?\n" +
                "Student: - Pohoda, je to online, ale nestihám, prokrastinanuji.\n" +
                "Medico: - Proto, děláš semestrálku z Javy na poslední chvíli, co?\n" +
                "Student: - Je to tak, ale je to klikačka pro děti \uD83D\uDE0A\n");
        Prostor theShed = new Prostor("theShed"," the Shed. V shed se nachází jediný a poslední alfa jednorožec, bohužel mluví jen anglicky.","Dialog:\n" +
                "Alfa Unicorn: -Somebody once told me \n" +
                "Medico: – the world is gonna roll me\n" +
                "Alfa Unicorn: - I ain’t the sharpest tool in the shed\n" +
                "Medico: - She was looking kind of dumb with her finger and her thumb\n" +
                "\t- In the shape of an \"L\" on her forehead\n" +
                "Alfa Unicorn: - I see you are men of culture as well, try to roll for my “žíně “, aim for number 6 and I shall give it to you.\n");
        Prostor na_rozcesti3 = new Prostor("na_rozcesti3","na rozcesti 3. Tvoje třetí rozcestí, jedna ceste vede za Klouzavým Psem, který se nachází na louce a druhá do Mordoru."
                ,"Nachází se tu kafe z automatu, pokud hodis 1, tak ti prida 10 zivotu a 2 stamina.");
        Prostor vstup_do_louky = new Prostor("vstup_do_louky"," vstup do louky. Jeden by řekl, že tráva bude až na louce, ale už i před loukou je kupa trávy. Jdeš určitě správným směrem za Klouzavým Psem." +
                " Z nějakého důvodu tu znovu potkáš studenta z VŠE.","Dialog:\n" +
                "Medico: - Co tu děláš?\n" +
                "Student: - To je jedno, co tu dělám, slyšel si o Amway? Začal jsem tam pracovat a mám konečně pasivní příjem. \n Je to fakt jednouchý, máš svého nadřízeného a od něj koupíš produkty od Amway, " +
                "který prodáš dál, ALE můžeš si nechat provizi. A když seš fakt dobrej, tak tě povýší na nadřízeného a sám můžeš pozvat lidi do společnosti a brát od nich peníze.\n" +
                "Medico: - Mám rád pyramidy.\n" +
                "Student: - Fakt? Jsem slyšel, že Amway pomáhá vymýtit mor, hoď mi jednu 6 a máš u mne jeden Amway kit a sampon k tomu zdarma!) \n");
        Prostor louka = new Prostor("louka"," louka. Na louce se nachází Klouzavý pes, který je na první pohled velice vysoký.","Dialog: \n" +
                "Klouzavý Pes: Čau bráchoooo! Jdeš pro aloe vera? Mám to nejlepší aloe vera v okolí!\n" +
                "Medico: Ano, potřebuji aloe vera pro zdravotnický účely.\n" +
                "Klouzavý Pes: Samozřejmě, že zdravotnický hehe, haha, hihi, hoho. Hod mi 6 a dostaneš svoje aloe vera pro “zdravotnický” účely.\n");
        Prostor na_krizovatce = new Prostor("na_krizovatce","na křižovatce. Jseš skoro na konci je čas se rozhodnout o osudu tohohle světa.",
                "\t1) Vydáš-li se do MordorHarem, tak zachráníš pouze hezké holky a ty budeš ten největší alfa samec na světě.\n" +
                "\t2) Vydáš-li se do MordorHomo, tak zachráníš pouze hezký kluky a ty budeš ten největší spasitel homosexuálů. (lidstvo asi eventuálně zahyne)\n" +
                "\t3) Vydáš-li se do MordorHeaven, tak zachráníš celý svět a ty budeš ten největší hrdina na světě. (moc vanilla konec)\n");
        Prostor MordorHarem = new Prostor("MordorHarem","MordorHarem. Uprostřed Mordoru uvidíš oltář, hoď vytvorkamen 11, abys vytvořil kámen mudrců a zachránil pouze " +
                "hezké holky na světě. Než se ale dostaneš k oltáři znova potkáš studenta z VŠE.",
                "Dialog:\n" + "Student: - TY BUDIŽKNIČEMU!! NAPROSTO CHÁPU, CO DĚLÁŠ, ALE ZA JAKOU CENU?? CO TĚ TO BUDE STÁT? ZACHRAŇ MNE TAKY PROSÍM…\n" +
                "Medico: - Promin mi to, chci být ten největší alfa samec na světě… a jediný.\n");
        Prostor MordorHomo = new Prostor("MordorHomo","MordorHomo. Uprostřed Mordoru uvidíš oltář, hoď vytvorkamen 11, abys vytvořil kámen mudrců a zachránil pouze hezký kluky na světě. " +
                "Než se ale dostaneš k oltáři znova potkáš studenta z VŠE.","Dialog:\n" + "Student: - TY BUDIŽKNIČEMU!! NECHÁPU, CO DĚLÁŠ, KDYBY SI ASPOŇ ZACHRÁNIL JEN HEZKÝ HOLKY!! " +
                "JÁ ANI NEJSEM HOMOSEXUÁL, CO BUDU DĚLAT ZBYTEK SVÝHO ŽIVOTA… VŽDYŤ LIDSTVO VYMŘE PO MEČI…\n" +
                "Medico: - Ale Keanu Reeves bude konečně single…\n");
        Prostor MordorHeaven = new Prostor("MordorHeaven","MordorHeaven, Uprostřed Mordoru uvidíš oltář, hoď vytvorkamen 11, abys vytvořil kámen mudrců a zachráni tak celé lidstvo. " +
                "Než se ale dostaneš k oltáři znova potkáš studenta z VŠE","Dialog:\n" +
                "Student: - Díky bohu, už jsem si myslel, že zachráníš pouze holky lol. Ani mne nenapadlo, že by si vybral jenom kluky, lidstvo by totiž zemřelo, že jo… Proti homosexuálním lidem mimochodem nic nemám.\n" +
                "Medico: - Já taky ne.\n");

        // přiřazují se průchody mezi prostory (sousedící prostory)
        theShire.setVychod(na_rozcesti);
        na_rozcesti.setVychod(theShire);
        na_rozcesti.setVychod(na_rozcesti2);
        na_rozcesti.setVychod(vstup_do_jeskyne);
        vstup_do_jeskyne.setVychod(jeskyne);
        vstup_do_jeskyne.setVychod(na_rozcesti);
        jeskyne.setVychod(vstup_do_jeskyne);
        na_rozcesti2.setVychod(vstup_do_shed);
        na_rozcesti2.setVychod(na_rozcesti3);
        na_rozcesti2.setVychod(na_rozcesti);
        vstup_do_shed.setVychod(theShed);
        vstup_do_shed.setVychod(na_rozcesti2);
        theShed.setVychod(vstup_do_shed);
        na_rozcesti3.setVychod(na_krizovatce);
        na_rozcesti3.setVychod(vstup_do_louky);
        na_rozcesti3.setVychod(na_rozcesti2);
        vstup_do_louky.setVychod(na_rozcesti3);
        vstup_do_louky.setVychod(louka);
        louka.setVychod(vstup_do_louky);
        na_krizovatce.setVychod(MordorHarem);
        na_krizovatce.setVychod(MordorHeaven);
        na_krizovatce.setVychod(MordorHomo);

        // genereace quest itemu a jejich vlozeni do prostoru;
        QuestItem ucho = new QuestItem("ucho_obra_Máklátilmu");
        QuestItem zine = new QuestItem("žíně_jednorožce");
        QuestItem aloe = new QuestItem("aloe_vera_klouzavého_psa");
        QuestItem automat = new QuestItem("Automat na kafe");
        QuestItem amwaykit = new QuestItem("AmwayKit");
        QuestItem amwaysampon = new QuestItem("AmwaySampon");
        na_rozcesti3.insertItem(automat);
        jeskyne.insertItem(ucho);
        theShed.insertItem(zine);
        louka.insertItem(aloe);
        vstup_do_louky.insertItem(amwaykit);
        vstup_do_louky.insertItem(amwaysampon);
        /**
         * Insert itemy pro potreby testu na konec hry
         * @author Van Nguyen
         * @version pro skolni rok 2019/2020
         */
        // Pro testovaci potreby je nutne vlozit itemy jiz predem
        medicalPouch.insert2Pouch(ucho);
        medicalPouch.insert2Pouch(zine);
        //medicalPouch.insert2Pouch(aloe);
        //

        // nastaveni aktualniho prostoru
        aktualniProstor = theShire;  // hra začíná v theShire
    }

    /**
     *Metoda pro ukonceni hry
     * @author Van Nguyen
     * @version pro skolni rok 2019/2020
     */
    public void endGame(){
        hra.setKonecHry(true);
        String textKVypsani = null;
        if(this.getAktualniProstor().getNazev() == "MordorHarem"){
            if(getMedicalPouch().pouchHasItem("ucho_obra_Máklátilmu") && getMedicalPouch().pouchHasItem("žíně_jednorožce") && getMedicalPouch().pouchHasItem("aloe_vera_klouzavého_psa")){
                System.out.println("Vytvořil si kámen mudrců a otevřel se ti východ z Mordoru. S pomocí kamene si zachránil všechny hezké holky a stal ses novým Genghis Khan \n. " +
                        "Bohužel díky genitívním vadám se po 5 generačních iterací celé lidstvo zhroutilo a zmutovalo. Takže lidstvo, které známe dnes již neexistuje. ");
            }
            else if(!getMedicalPouch().pouchisEmpty() || getMedicalPouch().pouchHasItem("Amwaykit")|| getMedicalPouch().pouchHasItem("AmwaySampon")){
                System.out.println("Pokusil ses vytvořit kámen mudrců, aniž bys měl všechny ingredience. Ingredience se ti vymkly kontrole a zabil si okamžitě všechny hezké holky na světe. " +
                        "Jelikož si neúspěšný tak východ z Mordoru se nikdy neotevřel a ty si pomalu začal umírat.");
            }
        }
        else if(this.getAktualniProstor().getNazev() == "MordorHomo"){
            if(getMedicalPouch().pouchHasItem("ucho_obra_Máklátilmu") && getMedicalPouch().pouchHasItem("žíně_jednorožce") && getMedicalPouch().pouchHasItem("aloe_vera_klouzavého_psa")){
                System.out.println("Vytvořil si kámen mudrců a otevřel se ti východ z Mordoru. S pomocí kamene si zachránil všechny hezký kluky. Svět byl mnohem klidnější, ale za jakou cenu… " +
                        "Ti, kteří nebyli homosexuálové byli diskriminováni a lidstvo po zhruba 100 letech vymřelo úplně.");
            }
            else if(!getMedicalPouch().pouchisEmpty() || getMedicalPouch().pouchHasItem("Amwaykit")|| getMedicalPouch().pouchHasItem("AmwaySampon")){
                System.out.println("Pokusil ses vytvořit kámen mudrců, aniž by si měl všechny ingredience. Ingredience se ti vymkly kontrole a všichni muži na světě ztratili svůj pohlavní úd. " +
                        "Tento incident neušetřil ani tebe a zemřel si na následky. Lidstvo zemřelo po zhruba 100 letech.");
            }
        }
        else if(this.getAktualniProstor().getNazev() == "MordorHeaven"){
            if(getMedicalPouch().pouchHasItem("ucho_obra_Máklátilmu") && getMedicalPouch().pouchHasItem("žíně_jednorožce") && getMedicalPouch().pouchHasItem("aloe_vera_klouzavého_psa")){
                System.out.println("Vytvořil si kámen mudrců a otevřel se ti východ z Mordoru. S pomocí kamene si zachránil celé lidstvo. Byl si ohlášen jako světový hrdina a žil si prospěšný život. " +
                        "Mor hned zmizel a lidé po celém světě stavěli monumenty na tvoji počest.\n \t HALELUJAH \tHALLELUHAJ \tHALLELUJAH \t HALELUJAH \tHALLELUHAJ \tHALLELUJAH \t HALELUJAH \tHALLELUHAJ \tHALLELUJAH");
            }
            else if(getMedicalPouch().pouchisEmpty() || getMedicalPouch().pouchHasItem("Amwaykit")|| getMedicalPouch().pouchHasItem("AmwaySampon")){
                System.out.println("Pokusil ses vytvořit kámen mudrců, aniž bys měl všechny ingredience. Ingredience se ti vymkly kontrole, bohužel si zahynul, " +
                        "ale stihl ses reinkarnovat a někde byl někdo zvolen jako nový Medic světa. ");
            }
        }
    }

    /**
     * Metoda pro ukonceni hry, je pouzita v pripade, ze uzivateli dosli zivoty nebo stamina
     * @author Van Nguyen
     */
    public void endGameDie(){
        hra.setKonecHry(true);
    }
    /**
     * Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     * @return aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     * Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     * @param prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }

    /**
     * getter pro medicky pouch
     * @return medicky pouch
     */
    public MedicalPouch getMedicalPouch() {
        return this.medicalPouch;
    }

    /**
     * getter pro HP
     * @return hodnotu HP
     */
    public int getHp() {
        return hp;
    }

    /**
     * setter pro HP
     * @param hp nastavi novou hodnotu pro HP
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * getter pro Stamina
     * @return hodnotu Stamina
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * setter pro Stamina
     * @param stamina nastavi novou hodnotu Stamina
     */
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
