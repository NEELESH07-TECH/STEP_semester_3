class Cart {
    private int[] prices;
    private int count;
    private final String cartId;

    Cart(String cartId, int size) {
        this.cartId = cartId;
        prices = new int[size];
        count = 0;
    }

    void addItem(int price) {
        if (count < prices.length && price >= 0) {
            prices[count++] = price;
        }
    }

    int getTotal() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            total += prices[i];
        }

        return total;
    }

    int getItemCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println(cart.getTotal());
        System.out.println(cart.getItemCount());
    }
}