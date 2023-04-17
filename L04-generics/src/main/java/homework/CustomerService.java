package homework;


import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    public TreeMap<Customer, String> cs;

    public CustomerService() {
        //cs = new TreeMap<>(Comparator.comparingLong(o -> o.getScores()));
        cs = new TreeMap<>((c1, c2) -> Long.compare(c1.getScores(), c2.getScores()));
    }
    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry<Customer, String> entry = cs.firstEntry();
        return entry == null ? null:  new AbstractMap.SimpleEntry(new Customer(entry.getKey().getId(), entry.getKey().getName(), entry.getKey().getScores()), entry.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> entry = cs.higherEntry(customer);
        return entry == null ? null:  new AbstractMap.SimpleEntry(new Customer(entry.getKey().getId(), entry.getKey().getName(), entry.getKey().getScores()), entry.getValue());
    }

    public void add(Customer customer, String data) {
        cs.put(new Customer(customer.getId(), customer.getName(), customer.getScores()), data);
        //cs.put(customer, data);
    }
}
