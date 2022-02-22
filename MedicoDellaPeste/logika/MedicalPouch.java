package logika;
/**
 * Trida MedicalPouch funguje jako tzv. Inventar.
 * slouzi k pridavani Itemu
 * @author Van Nguyen
 * @version pro skolni rok 2019/2020
 */

import java.util.HashMap;
import java.util.Map;

public class MedicalPouch {
    private Map<String, QuestItem> questitems = new HashMap<>();

    /**
     * metoda pro zjisteni z da inventar je plny nebo ne
     * nikdy nenastane jelikoz je pouze 5 itemu ve hre, slouzi jen pro potreby testovani
     * @return true - kdyyz je inventar plny, false kdyz neni
     * @author Van Nguyen
     * @version pro skolni rok 2019/2020
     */
    public boolean fullPouch(){
        if(questitems.size()>10){
            return true;
        }
        else return false;
    }
    /**
     *Kontrola zda je quest item v pouchi ci ne
     * @param nazev nazev itemu pozadovneho itemu
     * @return true = je tam, false = neni tam
     */
    public boolean pouchHasItem(String nazev){
        return questitems.containsKey(nazev);
    }
    public boolean pouchisEmpty(){
        if(questitems.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * Insert quest itemu do pouche
     * @param questItem item, ktery bude insernut do pouche
     * @return jestli item bude vlozenn vrati se nam jmeno itemu, jestli ne, tak se nam vrati null
     */
    public boolean insert2Pouch(QuestItem questItem){
            questitems.put(questItem.getItemName(),questItem);
            if(questitems.containsKey(questItem.getItemName()))
                return true;
            return false; // pouze v pripade, ze by tu byl limit

    }

    /**
     * Zobrazeni zdravotnickeho pouche
     * @return zobrazi obsah dle poctu itemu v pouchi
     */
    public String introducePouch(){
        String vracenyText = "V medical pytliku mas tento jeden krasny item:"  +"\n";
        String vracenyText2 = "V medical pytliku mas tyto itemy:"+"\n";
        String vracenyText3 = "Nemas v pytliku nic kamo :("+"\n";
        String fintext = null;
        if(questitems.size() == 0){
            fintext = vracenyText3;
        }
        else if(questitems.size() ==1){
            for(Map.Entry<String, QuestItem> ob: questitems.entrySet()){
                vracenyText += ob.getKey();
            }
            fintext = vracenyText;
        }
        else if(questitems.size() > 1) {
            for(Map.Entry<String, QuestItem> ob: questitems.entrySet()){
                vracenyText2 += ob.getKey() + "\n";
                fintext = vracenyText2;
                
            }
        }
        else{
            System.out.println("Nekde je chyba");
        }
        return fintext;
        }


    }


