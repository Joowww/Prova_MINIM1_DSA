package models;

public class Product {

    private  String id;
    private  String name;
    private double price;
    private int sales;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = 0;
    }

    public int getSales() {
        return sales;
    }

    public void increaseSales(int quantity) {
        this.sales += quantity;
    }


    public double getPrice() {
        return price;
    }

}
