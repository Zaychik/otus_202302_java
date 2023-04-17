package homework;


import java.util.LinkedList;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    private LinkedList<Customer> l;

    public CustomerReverseOrder(){
        l = new LinkedList();
    }
    public void add(Customer customer) {
        l.add(customer);
    }

    public Customer take() {
        return l.pollLast();
    }
}
