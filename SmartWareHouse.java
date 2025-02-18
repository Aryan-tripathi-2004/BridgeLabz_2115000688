import java.util.*;

abstract class WarehouseItem{
    String name;

    public WarehouseItem(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract String getCategory();
}
class Electronics extends WarehouseItem{
    public Electronics(String name){
        super(name);
    }
    public String getCategory(){
        return "Electronics";
    }
}
class Groceries extends WarehouseItem{
    public Groceries(String name){
        super(name);
    }
    public String getCategory(){
        return "Groceries";
    }
}
class Furniture extends WarehouseItem{
    public Furniture(String name){
        super(name);
    }
    public String getCategory(){
        return "Furniture";
    }
}
class Storage<T extends WarehouseItem>{
    private List<T> items = new ArrayList<>();

    public void addItem(T item){
        items.add(item);
    }

    public List<T> getList(){
        return items;
    }

    public void displayAllItems(List<? extends WarehouseItem> list){
        for(WarehouseItem item : list){
            System.out.println(item.getName());
        }
    }
}
class SmartWareHouse{
    public static void main(String args[]){
        WarehouseItem item1 = new Electronics("Charger");
        WarehouseItem item2 = new Groceries("Rice");
        WarehouseItem item3 = new Furniture("chair");

        Storage<WarehouseItem> s = new Storage<>();
        s.addItem(item3);
        s.addItem(item2);
        s.addItem(item1);

        List<WarehouseItem> list = s.getList();

        s.displayAllItems(list);
    }
}