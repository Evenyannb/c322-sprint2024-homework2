package edu.iu.yanlian.demo.repository;
import edu.iu.yanlian.demo.model.Guitar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryRepository {

    private List<Guitar> guitars;
    private static final String DATABASE_FILE = "guitars_database.txt";

    public InventoryRepository() {
        guitars = new ArrayList<>();
    }

    public void addGuitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
        Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        guitars.add(guitar);
        writeToDatabase(guitar);
    }

    private void writeToDatabase(Guitar guitar) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE, true))) {
            writer.write(guitarToString(guitar));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to the database file: " + e.getMessage());
        }
    }

    public Guitar getGuitar(String serialNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            List<Guitar> guitars = reader.lines()
                    .map(this::stringToGuitar)
                    .filter(g -> g.getSerialNumber().equals(serialNumber))
                    .collect(Collectors.toList());

            if (!guitars.isEmpty()) {
                return guitars.get(0);
            }
        } catch (IOException e) {
            System.err.println("Error reading the database file: " + e.getMessage());
        }
        return null;
    }
    public Guitar search(Guitar searchGuitar) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            List<Guitar> guitars = reader.lines()
                    .map(this::stringToGuitar)
                    .filter(g -> g.getBuilder().equals(searchGuitar.getBuilder()) || searchGuitar.getBuilder() == null)
                    .filter(g -> g.getModel().equals(searchGuitar.getModel()) || searchGuitar.getModel() == null)
                    .filter(g -> g.getType().equals(searchGuitar.getType()) || searchGuitar.getType() == null)
                    .filter(g -> g.getBackWood().equals(searchGuitar.getBackWood()) || searchGuitar.getBackWood() == null)
                    .filter(g -> g.getTopWood().equals(searchGuitar.getTopWood()) || searchGuitar.getTopWood() == null)
                    .collect(Collectors.toList());

            if (!guitars.isEmpty()) {
                return guitars.get(0); // return the first match
            }
        } catch (IOException e) {
            System.err.println("Error reading the database file: " + e.getMessage());
        }
        return null;
    }
    private String guitarToString (Guitar guitar){
        return guitar.getSerialNumber() + ", " +
                guitar.getPrice() + ", " +
                guitar.getBuilder() + ", " +
                guitar.getModel() + ", " +
                guitar.getType() + ", " +
                guitar.getBackWood() + ", " +
                guitar.getTopWood();
    }
    private Guitar stringToGuitar(String line) {
        String[] parts = line.split(", ");
        if (parts.length < 7) {
            return null;
        }
        return new Guitar(parts[0], Double.parseDouble(parts[1]), parts[2], parts[3], parts[4], parts[5], parts[6]);
    }
}
