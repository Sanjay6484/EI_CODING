import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<ItemElement> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(ItemElement item) {
        items.add(item);
    }

    public int calculateTotal() {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElement item : items) {
            sum += item.accept(visitor);
        }
        return sum;
    }
}
