package LLD.Design_Patterns.Behavioral;

import java.util.*;

public class Strategy {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addToCart(Arrays.asList("Apple", "Chips", "Chocolate"));
        shoppingCart.checkOut(new CashPayment(), 150);
    }
}
class ShoppingCart{
    private PaymentStrategy paymentStratergy;
    private List<String> itemList;
    ShoppingCart(){
        itemList = new ArrayList<>();
    }
    public void addToCart(List<String> items){
        itemList.addAll(items);
    }
    public void checkOut(PaymentStrategy paymentStratergy, int amount){
        if(itemList.isEmpty()) throw new RuntimeException("Please add items to cart before Checkout");

        this.paymentStratergy = paymentStratergy;
        paymentStratergy.pay(amount);
        System.out.println("Payment done for items "+itemList.toString());

        itemList = new ArrayList<>();
    }
}
interface PaymentStrategy{
    void pay(int amount);
}
class UPIPayment implements  PaymentStrategy{
    public void pay(int amount){
        // Payment Processing for UPI
        System.out.println("Recived UPI Amount: "+amount);
    }
}
class CashPayment implements PaymentStrategy{
    public void  pay(int amount){
        // Payment Processing for Cash
        System.out.println("Recived Cash Amount: "+amount);
    }
}