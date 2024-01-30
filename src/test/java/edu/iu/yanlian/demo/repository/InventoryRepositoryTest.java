package edu.iu.yanlian.demo.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryRepositoryTest {

    @Test
    public void Test1(){
        InventoryRepository intentory = new InventoryRepository();
        intentory.addGuitar("ZABB13479", 1777, "Zager", "80 series", "travel", "Mahogany", "Mahogany");
        intentory.addGuitar("ZABB13478", 2900, "Zager", "80 series", "stationary", "Mahogany", "Mahogany");
        intentory.addGuitar("ZABB13477", 1650, "Zager", "900 series", "travel", "Sitka", "Engelmann");

        System.out.println(intentory.getGuitar("ZABB13479").getPrice());
        System.out.println(intentory.getGuitar("ZABB13478").getBackWood());
        System.out.println(intentory.getGuitar("ZABB13477").getBuilder());

        intentory.addGuitar("ZABB13476", 1070, "Morson", "80 series", "electric", "Sitka", "Mahogany");
        intentory.addGuitar("ZABB13475", 2080, "Morson", "90 series", "travel", "Mahogany", "Engelmann");
        intentory.addGuitar("ZABB13474", 4090, "Morson", "90 series", "electric", "Sitka", "Engelmann");


        System.out.println(intentory.search(intentory.getGuitar("ZABB13475")).getType());
        System.out.println(intentory.search(intentory.getGuitar("ZABB13474")).getTopWood());
        System.out.println(intentory.search(intentory.getGuitar("ZABB13476")).getBuilder());

    }
    @Test
    public void Test2(){
        InventoryRepository intentory = new InventoryRepository();
        intentory.addGuitar("1", 1802892.99, "Zager", "80 series", "travel", "Mahogany", "Mahogany");
        intentory.addGuitar("2", 182371289.99, "Zager", "80 series", "stationary", "Mahogany", "Mahogany");
        intentory.addGuitar("3", 82323122.99, "Zager", "900 series", "travel", "Sitka", "Engelmann");

        System.out.println(intentory.getGuitar("1").getPrice());
        System.out.println(intentory.getGuitar("2").getBackWood());
        System.out.println(intentory.getGuitar("3").getBuilder());

        intentory.addGuitar("4", 2834792134783928.99, "Morson", "80 series", "electric", "Sitka", "Mahogany");
        intentory.addGuitar("5", 128392832.99, "Morson", "90 series", "travel", "Mahogany", "Engelmann");
        intentory.addGuitar("6", 2937102388.99, "Morson", "90 series", "electric", "Sitka", "Engelmann");


        System.out.println(intentory.search(intentory.getGuitar("4")).getPrice());
        System.out.println(intentory.search(intentory.getGuitar("5")).getTopWood());
        System.out.println(intentory.search(intentory.getGuitar("6")).getModel());
    }

    @Test
    public void Test3(){
        InventoryRepository intentory = new InventoryRepository();
        intentory.addGuitar("ZABB1341", 1.1238729382938, "Zager", "80 series", "travel", "Mahogany", "Mahogany");
        intentory.addGuitar("ZABB1342", 1.23123872937, "Zager", "80 series", "stationary", "Mahogany", "Mahogany");
        intentory.addGuitar("ZABB1343", 2.9237892334534, "Zager", "900 series", "travel", "Sitka", "Engelmann");

        System.out.println(intentory.getGuitar("ZABB1341").getPrice());
        System.out.println(intentory.getGuitar("ZABB1342").getBackWood());
        System.out.println(intentory.getGuitar("ZABB1343").getBuilder());

        intentory.addGuitar("ZABB1344", 4.23123123, "Fender", "80 series", "electric", "Sitka", "Mahogany");
        intentory.addGuitar("ZABB1345", 5.1234123, "Fender", "90 series", "travel", "Mahogany", "Engelmann");
        intentory.addGuitar("ZABB1346", 6.1231232, "chicken", "90 series", "electric", "Sitka", "Engelmann");


        System.out.println(intentory.search(intentory.getGuitar("ZABB1344")).getType());
        System.out.println(intentory.search(intentory.getGuitar("ZABB1345")).getTopWood());
        System.out.println(intentory.search(intentory.getGuitar("ZABB1346")).getBuilder());
    }


}