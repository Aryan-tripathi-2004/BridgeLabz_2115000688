class Order{
    private String orderID;
    private String orderDate;

    public Order(String orderID, String orderDate){
        this.orderID = orderID;
        this.orderDate = orderDate;
    }

    public void getOrderStatus(){
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Date: " + orderDate);
    }

}
class ShippedOrder extends Order{
    private String trackingNumber;
    
    public ShippedOrder(String orderID, String orderDate, String trackingNumber){
        super(orderID, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public void getOrderStatus(){
        System.out.println();
        super.getOrderStatus();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}
class DeliveredOrder extends ShippedOrder{
    private String deliveryDate;

    public DeliveredOrder(String orderID, String orderDate, String trackingNumber, String deliveryDate){
        super(orderID, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public void getOrderStatus(){
        System.out.println();
        super.getOrderStatus();
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Thank you for shopping with us");
    }
}

class RetailOrder{
    public static void main(String args[]){
        Order order = new Order("123", "12/12/2020");
        order.getOrderStatus();

        ShippedOrder shippedOrder = new ShippedOrder("123", "12/12/2020", "123456");
        shippedOrder.getOrderStatus();

        DeliveredOrder deliveredOrder = new DeliveredOrder("123", "12/12/2020", "123456", "12/12/2020");
        deliveredOrder.getOrderStatus();
    }
}