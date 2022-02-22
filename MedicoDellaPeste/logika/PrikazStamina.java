package logika;

/**
 * PrikazStamina je trida, ktera slouzi k vypisu kolik stamina hrac ma.
 * @autor Van Nguyen
 * @version pro skolni rok 2019/2020
 */
public class PrikazStamina implements IPrikaz {
    private static final String NAZEV = "ukazStamina";
    private HerniPlan plan;
    private String text;
    public PrikazStamina(HerniPlan plan) {
        this.plan = plan;
    }


    public String ukazStamina(){
        String textkVraceni = Integer.toString(this.plan.getStamina());
        return textkVraceni;
    }
    @Override
    public String provedPrikaz(String... parametry) {
        return "Mas tolik stamina: " + ukazStamina();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
