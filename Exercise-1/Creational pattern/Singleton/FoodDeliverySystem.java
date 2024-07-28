
class FoodDeliveryManager {
    private static FoodDeliveryManager instance;
   
    private FoodDeliveryManager() {
        
    }

    // Public method to provide access to the instance
    public static FoodDeliveryManager getInstance() {
        if (instance == null) {
            synchronized (FoodDeliveryManager.class) {
                if (instance == null) {
                    instance = new FoodDeliveryManager();
                }
            }
        }
        return instance;
    }

    
    public void placeOrder(String orderDetails) {
        // Logic to place an order (for demonstration purposes)
        System.out.println("Order placed: " + orderDetails);
    }

    
    public void cancelOrder(String orderId) {
        // Logic to cancel an order (for demonstration purposes)
	System.out.println();
        System.out.println("Order " + orderId + " has been cancelled.");
    }

    
    public String checkOrderStatus(String orderId) {
        // Logic to check order status (for demonstration purposes)
        System.out.println("Checking status for order " + orderId);
        return "In Progress"; // Assuming the order is in progress
    }
}


public class FoodDeliverySystem {
    public static void main(String[] args) {
        
        FoodDeliveryManager deliveryManager = FoodDeliveryManager.getInstance();
        deliveryManager.placeOrder("Order 123: 2 Pizzas, 1 Coke");
	System.out.println();
        
        String status = deliveryManager.checkOrderStatus("123");
        System.out.println("Order 123 status: " + status);

        
        deliveryManager.cancelOrder("123");
        FoodDeliveryManager anotherDeliveryManager = FoodDeliveryManager.getInstance();
    }
}
