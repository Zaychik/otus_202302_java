package homework;


import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    Map<Customer, String> cs;
    public CustomerService(){
        cs = new HashMap<>();
    }

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    public Map.Entry<Customer, String> getSmallest() {

        Map.Entry<Customer, String> minEntry = null;
        minEntry = cs.entrySet().stream()
                .min( (x, y) -> Long.compare(x.getKey().getScores(), y.getKey().getScores()))
                .orElse(null);


        return minEntry; // это "заглушка, чтобы скомилировать"
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return null; // это "заглушка, чтобы скомилировать"
    }

    public void add(Customer customer, String data) {
        cs.put(customer, data);
    }
}
