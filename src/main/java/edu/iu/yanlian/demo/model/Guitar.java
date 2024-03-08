package edu.iu.yanlian.demo.model;

public class Guitar {
    private String serialNumber;
    private double price;
    private String builder;
    private String model;
    private String type;
    private String backWood;
    private String topWood;

    public Guitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
    }

    public String getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getBackWood() {
        return backWood;
    }

    public String getTopWood() {
        return topWood;
    }

    public enum Builder {

        FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

        public String toString(){
            switch (this){
                case ANY: return "Any";
                case FENDER: return "Fender";
                case MARTIN: return "Martin";
                case GIBSON: return "Gibson";
                case COLLINGS: return "Collings";
                case OLSON: return "Olson";
                case RYAN: return "Ryan";
                case PRS: return "PRS";
                default: return "Unspecified";
            }
        }}

    public enum Type {

        ACOUSTIC, ELECTRIC;

        public String toString() {
            switch (this) {
                case ACOUSTIC: return "acoustic";
                case ELECTRIC: return "electric";
                default: return "unspecified";
            }
        }
    }
    public enum Wood {


        INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;

        public String toString() {
            switch (this) {
                case INDIAN_ROSEWOOD:
                    return "Indian Rosewood";
                case BRAZILIAN_ROSEWOOD:
                    return "Brazilian Rosewood";
                case MAHOGANY:
                    return "Mahogany";
                case MAPLE:
                    return "Maple";
                case COCOBOLO:
                    return "Cocobolo";
                case CEDAR:
                    return "Cedar";
                case ADIRONDACK:
                    return "Adirondack";
                case ALDER:
                    return "Alder";
                case SITKA:
                    return "Sitka";
                default:
                    return "unspecified";
            }
        }
    }
}
