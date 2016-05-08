package co.kiwitea.model;

public class Item {

    private final int id;
    private final String name;
    private final double price;
    private final Category category;

    public Item(final int id, final String name, final double price, final Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }
}
