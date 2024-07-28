public class ShoppingCartClient {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Book(20, "1234"));
        cart.addItem(new Book(100, "5678"));
        cart.addItem(new Fruit(10, 2, "Banana"));
        cart.addItem(new Fruit(5, 5, "Apple"));

        int total = cart.calculateTotal();
        System.out.println("Total Cost = " + total);
    }
}
