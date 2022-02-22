package logika;

/**
 * Trida PrikazHP funguje k vypsani mnozstvi HP, ktery hrac ma.
 * @author Van Nguyen
 * @version pro skolni rok 2019/2020
 */
public class PrikazHP implements IPrikaz {
    private static final String NAZEV = "ukazHP";
    private HerniPlan plan;
    private String text;
    public PrikazHP(HerniPlan plan) {
        this.plan = plan;
    }


    public String ukazHP(){
        String textkVraceni = Integer.toString(this.plan.getHp());
        return textkVraceni;
    }
    @Override
    public String provedPrikaz(String... parametry) {
        return "Mas tolik HP: " + ukazHP();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
