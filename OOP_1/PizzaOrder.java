package OOP_1;

public class PizzaOrder {
    private String name;
    private String size;
    private String sauceAvailability;
    private String deliveryAddress;
    private boolean orderAccepted = false;

    public PizzaOrder(NAME_PIZZA name, SIZE_PIZZA size, boolean sauce, String deliveryAddress){
        this.name = pizzaName(name);
        this.size = pizzaSize(size);
        this.sauceAvailability = pizzaSauce(sauce);
        this.deliveryAddress = deliveryAddress;
    }

    private String pizzaName(NAME_PIZZA name){
        if (name == NAME_PIZZA.Al_Captchone){
            return "Аль-Капчоне";
        }
        else{
            return "None";
        }
    }

    private String pizzaSize(SIZE_PIZZA size){
        if (size == SIZE_PIZZA.SMALL){
            return "Маленькая";
        }
        else if (size == SIZE_PIZZA.MEDIUM){
            return "Средняя";
        }
        else if (size == SIZE_PIZZA.BIG){
            return "Большая";
        }
        else{
            return "None";
        }
    }

    private String pizzaSauce (boolean sauce){
        if (sauce){
            return "с соусом";
        }
        else{
            return "без соуса";
        }
    }

    public void order(){
        if (!orderAccepted){
            System.out.print("Заказ принят. ");
            System.out.println(String.format("%s пицца '%s' %s на адрес %s", this.size, this.name, this.sauceAvailability, this.deliveryAddress));
            orderAccepted = true;
        }
        else{
            System.out.println("Заказ уже принят.");
        }
    }

    public void cancel(){
        if (orderAccepted){
            System.out.println("Заказ отменен.");
            this.orderAccepted = false;
        }
        else{
            System.out.println("Заказ не был принят.");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSauceAvailability(String sauceAvailability) {
        this.sauceAvailability = sauceAvailability;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getName() {
        return name;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String toString(){
        return String.format("%s пицца '%s' %s на адрес %s", this.size, this.name, this.sauceAvailability, this.deliveryAddress);
    }
}
