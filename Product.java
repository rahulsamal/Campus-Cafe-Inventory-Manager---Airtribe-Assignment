
public class Product {
    static int totalProducts = 0;   // static variable: one copy shared by all products
    String name;                    // instance variables: each product has its own
    double price;
    int quantity;
    // 1. No-argument constructor: sets default values
    Product() {
        name = "Unknown";
        price = 0;
        quantity = 0;
        totalProducts++;
    }
    // 2. Parameterized constructor
    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        totalProducts++;
    }
    // 3. Copy constructor
    Product(Product other) {
        this.name = other.name;
        this.price = other.price;
        this.quantity = other.quantity;
        totalProducts++;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQty() { return quantity; }
    public void setQty(int quantity) { this.quantity = quantity; }

    // price * quantity (the int quantity is widened to double automatically)
    double stockValue() {
        return price * quantity;
    }

    // 5. Display product details
    void display() {
        System.out.println(name + " | Rs " + price + " | qty " + quantity);
    }
}
