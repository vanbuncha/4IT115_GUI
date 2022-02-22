package logika;

/**
 * Prikaz zobrazitpouch vola metoda introducePouch ze tridy MedicalPouch a tim vypise vsechny itemy, ktere jsou v pytliku.
 * @autor Van Nguyen
 * @version pro skolni rok 2019/2020
 */

public class PrikazZobrazitPouch implements IPrikaz {
    private static final String NAZEV ="obsahpytlik";
    private HerniPlan plan;
    private String actual;

    public HerniPlan getPlan() {
        return this.plan;
    }

    public PrikazZobrazitPouch(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        return this.plan.getMedicalPouch().introducePouch();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
