package logika;
/**
 * Trida MedicalPouchtest funguje k testovani zda jde vlozit itemy do pytliku
 * @autor Van Nguyen
 * @version pro skolni rok 2019/2020
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class MedicalPouchTest {
    MedicalPouch medicalPouch = new MedicalPouch();
    @Test
    public void insert2Pouch() {
        QuestItem testitem = new QuestItem("testItem");
        assertEquals(true,medicalPouch.insert2Pouch(testitem));
        assertEquals(false,medicalPouch.pouchisEmpty());
    }
    @Test
    public void isPouchEmpty(){
        assertEquals(true,medicalPouch.pouchisEmpty());
    }
    @Test
    public void isPouchFull(){
        QuestItem testItem0 = new QuestItem("testitem0");
        QuestItem testItem1 = new QuestItem("testitem1");
        QuestItem testItem2 = new QuestItem("testitem2");
        QuestItem testItem3 = new QuestItem("testitem3");
        QuestItem testItem4 = new QuestItem("testitem4");
        QuestItem testItem5 = new QuestItem("testitem5");
        QuestItem testItem6 = new QuestItem("testitem6");
        QuestItem testItem7 = new QuestItem("testitem7");
        QuestItem testItem8 = new QuestItem("testitem8");
        QuestItem testItem9 = new QuestItem("testitem9");
        QuestItem testItem10 = new QuestItem("testitem10");
        medicalPouch.insert2Pouch(testItem0);
        medicalPouch.insert2Pouch(testItem1);
        medicalPouch.insert2Pouch(testItem2);
        medicalPouch.insert2Pouch(testItem3);
        medicalPouch.insert2Pouch(testItem4);
        medicalPouch.insert2Pouch(testItem5);
        medicalPouch.insert2Pouch(testItem6);
        medicalPouch.insert2Pouch(testItem7);
        medicalPouch.insert2Pouch(testItem8);
        medicalPouch.insert2Pouch(testItem9);
        medicalPouch.insert2Pouch(testItem10);
        assertEquals(true,medicalPouch.fullPouch());

    }
}