package decorator_design_pattern;
import java.util.ArrayList;
import java.util.List;

interface Pizzeria {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
class ConcretePizzeria implements Pizzeria {
    private List<Observer> observers = new ArrayList<>();
    private String pizzaSpecial;
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);}
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(pizzaSpecial);}
    }

    public void setPizzaSpecial(String pizzaSpecial) {
        this.pizzaSpecial = pizzaSpecial;
        notifyObservers();}
}


interface Observer {void update(String pizzaSpecial);}
class Customer implements Observer {
    private String name;
    public Customer(String name) {this.name = name;}
    @Override
    public void update(String pizzaSpecial) {
        System.out.println("Hello, "+ name+ "! Today's special pizza is " + pizzaSpecial);
    }
}
public class Main {
    public static void main(String[] args) {
        ConcretePizzeria pizzeria = new ConcretePizzeria();
        Customer customer1 = new Customer("Beka");
        Customer customer2 = new Customer("Baha");
        Customer customer3 = new Customer("Era");
        pizzeria.registerObserver(customer1);
        pizzeria.registerObserver(customer2);
        pizzeria.registerObserver(customer3);
        pizzeria.setPizzaSpecial("Margaritta");
        pizzeria.removeObserver(customer2);
        pizzeria.setPizzaSpecial("Pepperoni");
        pizzeria.removeObserver(customer1);
        pizzeria.setPizzaSpecial("Hawaii");
    }
}
