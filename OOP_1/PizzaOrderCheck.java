package OOP_1;

public class PizzaOrderCheck {
    public static void main(String[] args) {
        PizzaOrder pizzaOrder = new PizzaOrder(NAME_PIZZA.Al_Captchone, SIZE_PIZZA.BIG, true, "Ярославская 101");
        PizzaOrder pizzaOrder2 = new PizzaOrder(NAME_PIZZA.Al_Captchone, SIZE_PIZZA.MEDIUM, false, "Ярославская 102");
        PizzaOrder pizzaOrder3 = new PizzaOrder(NAME_PIZZA.Al_Captchone, SIZE_PIZZA.SMALL, false, "Ярославская 102");
        
        System.out.println(pizzaOrder);
        System.out.println(pizzaOrder2);
        System.out.println(pizzaOrder3);

        pizzaOrder.cancel(); 
        pizzaOrder.order();
        pizzaOrder.order();
        pizzaOrder.cancel();
        pizzaOrder.order();
    }
}
