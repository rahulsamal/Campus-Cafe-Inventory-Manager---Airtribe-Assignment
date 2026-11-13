import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);   // reading input: provided for you
            Product[] products = new Product[10];
            Product prd = new Product();// an array with room for 10 products
            int count = 0;
            double stockValue = 0;
            double totalRate =0;
            // how many products are stored so far
            int choice;
            do {
                System.out.println("\n--- Campus Cafe Inventory ---");
                System.out.println("1. Add product");
                System.out.println("2. Display all products");
                System.out.println("3. Total stock value");
                System.out.println("4. Average price");
                System.out.println("5. Restock a product");
                System.out.println("6. Duplicate a product");
                System.out.println("0. Exit");
                System.out.print("Choose: ");
                choice = sc.nextInt();
                sc.nextLine();   // clears the leftover newline after nextInt()
                if (choice < 0 || choice > 6) {
                    System.out.println("Invalid choice, try again.");
                }
                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Quantity: ");
                        int quantity = sc.nextInt();
                        sc.nextLine();

                        if(count == products.length){
                            System.out.println("Array is full");
                        }

                        else if(price<=0 || quantity<=0) {
                            System.out.println("Price/Qty must be greater than 0.");

                        }


                        else{
                            products[count] = new Product(name, price, quantity);
                            count++;

                            System.out.println("Product added successfully.");
                    }
                        // TODO: if the array is full (count is 10), print a message
                        // TODO: else if price <= 0 or quantity < 0, print an error message
                        // TODO: otherwise create the Product with the parameterized
                        //       constructor, store it at products[count] and increase count
                        break;
                    case 2:

                        if(products.length == 0){
                            System.out.println("there are no Products in this Inventory");
                        }
                        else{
                            for(int i=0;i<count;i++){
                                System.out.println((i+1) + ": " );
                                products[i].display();
                            }
                        }
                        // TODO: if count is 0 print a message, otherwise loop from 0 to
                        //       count - 1 and call display() on each product
                        //       (print the number i + 1 before each one)
                        break;
                    case 3:
                        for(Product prod : products){
                            if(prod != null){
                                double rate = prod.getPrice();
                                int qty = prod.getQty();
                                stockValue += rate*qty;
                            }

                        }
                        System.out.println("Total Stock Value: "+stockValue);

                        // TODO: loop over the stored products, add up stockValue()
                        //       and print the total (message if count is 0)
                        break;
                    case 4:
                        for(Product prod : products){
                            if(prod != null){
                                double rate = prod.getPrice();
                                totalRate += rate;
                            }
                        }
                        double avg = totalRate/count;
                        System.out.println("average price without casting: "+avg);
                        System.out.println("average price with casting: "+(int)avg);
                        // TODO: calculate the average price as a double and print it
                        //       also print it rounded down using an explicit cast
                        break;
                    case 5:
                        System.out.print("Product number: ");
                        int num = sc.nextInt();
                        System.out.print("Quantity to add: ");
                        int extra = sc.nextInt();
                        sc.nextLine();
                        if(num<0 || num > count){
                            System.out.println("Invalid Product number, try again.");
                        }
                        else if(extra <=0){
                            System.out.println("Quantity must be greater than zero");
                        }
                        else{
                            Product product_1 = products[num-1];
                            int qty  =  product_1.getQty();
                            int new_qty = extra+qty;
                            product_1.setQty(new_qty);
                            product_1.display();

                            System.out.println("Quantity updated successfully");
                            System.out.println("Current count: " + count);
                        }
                        // TODO: check num is between 1 and count and extra is above 0,
                        //       otherwise print an error; then add extra to the quantity
                        //       of products[num - 1]
                        break;
                    case 6:

                        System.out.print("Product number: ");
                        int n = sc.nextInt();
                        sc.nextLine();

                        if (n <=0 || n > count) {
                            System.out.println("Invalid product number.");
                        }
                        else if (count == products.length) {
                            System.out.println("Array is full. Cannot duplicate product.");
                        }
                        else {
                            Product copy = new Product(products[n - 1]);

                            copy.setName(copy.getName() + " (copy)");

                            products[count] = copy;
                            count++;

                            System.out.println("Product duplicated successfully!");
                        }
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                }
            } while (choice != 0);
            System.out.println("Products created in total: " + Product.totalProducts);


            Product p1 = new Product("Tea", 10.5, 5);

            Product p2 = new Product(p1);

            p2.name = "Coffee";

            p1.display();
            p2.display();

            System.out.println("Total Products: " + Product.totalProducts);

            System.out.println("Tea Stock Value: " + p1.stockValue());
        }



    }
