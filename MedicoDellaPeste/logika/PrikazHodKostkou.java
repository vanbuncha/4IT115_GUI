package logika;

/**
 * Trida PrikazHodKostkou je zakladem cele hry. Vsechny itemy se ziskaji skrze hod kostkou.
 * @autor Van Nguyen
 * @version pro skolni rok 2019/2020
 */
public class PrikazHodKostkou implements IPrikaz {
    private static final String NAZEV = "hodkostkou";
    private HerniPlan plan;


    public PrikazHodKostkou(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * metoda pro hod kostkou a zaroven konverze int typu do String
     * @param max maxmalni hodnota, kterou muzeme kostkou hodit
     * @param min minimalni hodnota, kterou muzeme kostkou hodit
     * @return String hodnoty "hozene" kostky
     * @autor https://www.java67.com/2015/01/how-to-get-random-number-between-0-and-1-java.html
     */
    public static  String getRandom(int max, int min){
        int randomNum = 0;
        randomNum = ((int)(Math.random()*(max - min))) + min;
        String printNumber = Integer.toString(randomNum);
        return printNumber;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        String textKVypsani = null;
        int newHP = 0;
        this.plan.setHp(this.plan.getHp()-2);
        if (this.plan.getHp() <= 0) {
            textKVypsani = "Provedl si moc hodů kostky a máš tím pádem 0 hp, zemčel si";
            this.plan.endGameDie();
        } else {
            switch (getRandom(7, 1)) {
                case "1":
                    if(this.plan.getAktualniProstor().getNazev() == "na_rozcesti3") {
                        this.plan.setHp(this.plan.getHp()+10);
                        this.plan.setStamina(this.plan.getStamina() + 2);
                        textKVypsani = "Hodil si 1 a vypil si kafe z automatu";
                    }
                    else{
                        this.plan.setHp(this.plan.getHp()-4);
                        textKVypsani = "Hodil si 1 a ztracis 5 zivotu! ";
                    }
                    break;
                case "2":
                    textKVypsani = "Hodil si 2 a ztracis 1 zivot, zkus to znova! ";
                    break;
                case "3":
                    textKVypsani = "Hodil si 3 a ztracis 1 zivot, zkus to znova! ";
                    break;
                case "4":
                    textKVypsani = "Hodil si 4 a ztracis 1 zivot, zkus to znova! ";
                    break;
                case "5":
                    textKVypsani = "Hodil si 5 a ztracis 1 zivot, zkus to znova! ";
                    break;
                case "6":
                    textKVypsani = "Congrats hodil si 6";
                    if (this.plan.getAktualniProstor().getNazev() == "jeskyne") {
                        QuestItem questItem = new QuestItem("ucho_obra_Máklátilmu");
                        this.plan.getMedicalPouch().insert2Pouch(questItem);
                        this.plan.getAktualniProstor().removeItem("ucho_obra_Máklátilmu");
                        textKVypsani += " a ziskal si ucho_obra_Máklátilmu";
                    } else if (this.plan.getAktualniProstor().getNazev() == "theShed") {
                        QuestItem questItem = new QuestItem("žíně_jednorožce");
                        this.plan.getMedicalPouch().insert2Pouch(questItem);
                        this.plan.getAktualniProstor().removeItem("žíně_jednorožce");
                        textKVypsani += " a ziskal si žíně_jednorožce";
                    } else if (this.plan.getAktualniProstor().getNazev() == "louka") {
                        QuestItem questItem = new QuestItem("aloe_vera_klouzavého_psa");
                        this.plan.getMedicalPouch().insert2Pouch(questItem);
                        this.plan.getAktualniProstor().removeItem("aloe_vera_klouzavého_psa");
                        textKVypsani += " a ziskal si aloe_vera_klouzavého_psa";

                    }else if (this.plan.getAktualniProstor().getNazev() == "na_rozcesti3") {
                        textKVypsani += " ,ale automat, fakt do pytliku nenarves";
                    }

                    else if (this.plan.getAktualniProstor().getNazev() == "vstup_do_louky") {
                        this.plan.setHp(this.plan.getHp()-50);
                        QuestItem questItem = new QuestItem("AmwayKit");
                        QuestItem questItem1 = new QuestItem("AmwaySampon");
                        this.plan.getMedicalPouch().insert2Pouch(questItem);
                        this.plan.getMedicalPouch().insert2Pouch(questItem1);
                        this.plan.getAktualniProstor().removeItem("AmwayKit");
                        this.plan.getAktualniProstor().removeItem("AmwaySampon");
                        textKVypsani += " a SPADL DO PYRAMIDOVEHO SCHEMATU HAHA ZTRACIS 50HP";
                        textKVypsani += ", ale ziskal si sampon od Amway a jejich AmwayKit!!!";
                        if(this.plan.getHp() <= 0){
                            this.plan.endGameDie();
                            textKVypsani += "\n" + " BOHUZEL SI ALE ZEMREL JESUS";
                        }

                    }
                    else {
                        textKVypsani += ", ale nic tady neni";
                    }

            }

        }
        return textKVypsani;
    }


    @Override
    public String getNazev() {
        return NAZEV;
    }
}
