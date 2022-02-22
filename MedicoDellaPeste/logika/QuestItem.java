package logika;

/**
 * Trida QuestItem slouzi k definici quest itemu ve hre, pozdeji se pouziva i k implementaci non-quest itemu
 * @author Van Nhuyen
 * @version pro skolni rok 2019/2020
 */
public class QuestItem {
    private String itemName;

    public QuestItem(String itemName) {
        this.itemName = itemName;
    }

    /**
     * getter pro zisk jmena
     *
     * @return nazev quest itemu
     */
    public String getItemName() {
        return itemName;
    }
}

