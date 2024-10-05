import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Laptop
class Laptop {
    private final String brand;
    private final String model;
    private final String processor;
    private final int ram; // in GB
    private final int storage; // in GB
    private final double price; // in USD or your local currency

    public Laptop(String brand, String model, String processor, int ram, int storage, double price) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.price = price;
    }

    // Getter methods
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public double getPrice() {
        return price;
    }

    // Method to display laptop details
    public void displayLaptopInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Processor: " + processor);
        System.out.println("RAM: " + ram + "GB");
        System.out.println("Storage: " + storage + "GB");
        System.out.println("Price: $" + price);
    }
}

// Laptop management system class
public class Laptop_Management_System {
    private final ArrayList<Laptop> laptops = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    // Method to add a laptop to the system
    public void addLaptop() {
        System.out.println("Enter laptop brand:");
        String brand = scanner.nextLine();

        System.out.println("Enter laptop model:");
        String model = scanner.nextLine();

        System.out.println("Enter laptop processor:");
        String processor = scanner.nextLine();

        System.out.println("Enter laptop RAM (in GB):");
        int ram = scanner.nextInt();

        System.out.println("Enter laptop storage (in GB):");
        int storage = scanner.nextInt();

        System.out.println("Enter laptop price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // clear the buffer

        Laptop laptop = new Laptop(brand, model, processor, ram, storage, price);
        laptops.add(laptop);

        System.out.println("Laptop added successfully!");
    }

    // Method to display all laptops
    public void viewAllLaptops() {
        if (laptops.isEmpty()) {
            System.out.println("No laptops available.");
            return;
        }

        for (int i = 0; i < laptops.size(); i++) {
            System.out.println("\nLaptop " + (i + 1));
            laptops.get(i).displayLaptopInfo();
        }
    }

    // Method to search for a laptop by brand or model
    public void searchLaptop() {
        System.out.println("Enter brand or model to search:");
        String searchQuery = scanner.nextLine();

        boolean found = false;
        for (Laptop laptop : laptops) {
            if (laptop.getBrand().equalsIgnoreCase(searchQuery) ||
                    laptop.getModel().equalsIgnoreCase(searchQuery)) {
                laptop.displayLaptopInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Laptop not found.");
        }
    }

    // Method to remove a laptop
    public void removeLaptop() {
        System.out.println("Enter the model of the laptop to remove:");
        String modelToRemove = scanner.nextLine();

        for (int i = 0; i < laptops.size(); i++) {
            if (laptops.get(i).getModel().equalsIgnoreCase(modelToRemove)) {
                laptops.remove(i);
                System.out.println("Laptop removed successfully.");
                return;
            }
        }
        System.out.println("Laptop not found.");
    }

    // Main method
    public static void main(String[] args) {
        Laptop_Management_System system = new Laptop_Management_System();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLaptop Management System Menu:");
            System.out.println("1. Add Laptop");
            System.out.println("2. View All Laptops");
            System.out.println("3. Search Laptop");
            System.out.println("4. Remove Laptop");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    system.addLaptop();
                    break;
                case 2:
                    system.viewAllLaptops();
                    break;
                case 3:
                    system.searchLaptop();
                    break;
                case 4:
                    system.removeLaptop();
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }
}
