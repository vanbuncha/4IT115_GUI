package logika;

/**
 * Trida PrikazVytvorKamen slouzi jako prikaz k ukonceni hry. Ukonceni hry je pouze mozne v urcitych mistnostech
 * @author Van Nguyen
 * @version pro skolni rok 2019/2020
 */
public class PrikazVytvorKamen implements IPrikaz {
    private static final String NAZEV = "vytvorkamen";
    private HerniPlan plan;


    public PrikazVytvorKamen(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * metoda pro hod kostkou a zaroven konverze int typu do String
     * @param max maxmalni hodnota, kterou muzeme kostkou hodit
     * @param min minimalni hodnota, kterou muzeme kostkou hodit
     * @return String hodnoty "hozene" kostky
     * @autor @autor https://www.java67.com/2015/01/how-to-get-random-number-between-0-and-1-java.html
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
        this.plan.setHp(this.plan.getHp()-2);
        if(this.plan.getMedicalPouch().pouchisEmpty()){
            return "Pokusil ses vytvorit kamen bez ingredienci, moc ti to asi nemysli";
        }
        else{
            switch(getRandom(12,1)) {
                case "1":
                    this.plan.setHp(this.plan.getHp()-4);
                    textKVypsani = "Hodil si 1 a ztracis 5 zivotu zkus to znova! ";
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
                    textKVypsani = "Hodil si 6 a ztracis 1 zivot, zkus to znova! ";
                    break;
                case "7":
                    textKVypsani = "Hodil si 7 a ztracis 1 zivot, zkus to znova! ";
                    break;
                case "8":
                    textKVypsani = "Hodil si 8 a ztracis 1 zivot, zkus to znova! ";
                    break;
                case "9":
                    textKVypsani = "Hodil si 9 a ztracis 1 zivot, zkus to znova! ";
                    break;
                case "10":
                    textKVypsani = "Hodil si 10 a ztracis 1 zivot, zkus to znova! ";
                    break;
                case "11":
                    if(this.plan.getAktualniProstor().getNazev() == "MordorHomo"){
                        textKVypsani = " ";
                        this.plan.endGame();

                    }
                    else if(this.plan.getAktualniProstor().getNazev() == "MordorHarem"){
                        textKVypsani = " ";
                        this.plan.endGame();

                    }
                    else if(this.plan.getAktualniProstor().getNazev() == "MordorHeaven"){
                        textKVypsani = " ";
                        this.plan.endGame();

                    }
                    else{
                        textKVypsani = "Nejsi u oltare na vytvoreni kamene mudrcu";
                    }
                    break;

            }

        }
        return textKVypsani;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
