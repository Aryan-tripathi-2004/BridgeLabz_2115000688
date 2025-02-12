import java.util.Scanner;

class Item {
    String itemName;
    int itemId, quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head = null;

    public void addAtBeginning(Item newItem) {
        newItem.next = head;
        head = newItem;
    }

    public void removeById(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + ", ID: " + temp.itemId + ", Qty: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Item: " + temp.itemName + ", ID: " + temp.itemId + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    public void sortInventoryByPrice() {
        if (head == null || head.next == null) return;

        boolean swapped;
        Item ptr1;
        Item lptr = null;

        do {
            swapped = false;
            ptr1 = head;

            while (ptr1.next != lptr) {
                if (ptr1.price > ptr1.next.price) {
                    swapData(ptr1, ptr1.next);
                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            lptr = ptr1;
        } while (swapped);
    }

    private void swapData(Item a, Item b) {
        String tempName = a.itemName;
        int tempId = a.itemId;
        int tempQty = a.quantity;
        double tempPrice = a.price;

        a.itemName = b.itemName;
        a.itemId = b.itemId;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemName = tempName;
        b.itemId = tempId;
        b.quantity = tempQty;
        b.price = tempPrice;
    }
}

public class InventoryApp {
    private static final Scanner scanner = new Scanner(System.in);

    private static Item takeItemInput() {
        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter Item ID: ");
        int itemId = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        return new Item(itemName, itemId, quantity, price);
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        int choice;

        while (true) {
            System.out.println("\nInventory Menu:");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Display Inventory");
            System.out.println("3. Remove Item");
            System.out.println("4. Update Quantity");
            System.out.println("5. Search by ID");
            System.out.println("6. Calculate Total Value");
            System.out.println("7. Sort by Price (Ascending)");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    inventory.addAtBeginning(takeItemInput());
                    break;
                case 2:
                    inventory.displayInventory();
                    break;
                case 3:
                    System.out.print("Enter Item ID to Remove: ");
                    inventory.removeById(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Item ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter New Quantity: ");
                    inventory.updateQuantity(id, scanner.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Item ID: ");
                    inventory.searchById(scanner.nextInt());
                    break;
                case 6:
                    inventory.calculateTotalValue();
                    break;
                case 7:
                    inventory.sortInventoryByPrice();
                    System.out.println("Inventory sorted by price in ascending order.");
                    break;
                case 8:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
