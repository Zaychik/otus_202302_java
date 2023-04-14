package homework;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    TreeMap<Customer, String> cs;

    public CustomerService() {
        cs = new TreeMap<>(Comparator.comparingLong(o -> o.getScores()));
    }
    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        return cs.firstEntry(); // это "заглушка, чтобы скомилировать"
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return cs.higherEntry(customer); // это "заглушка, чтобы скомилировать"
    }

    public void add(Customer customer, String data) {
        cs.put(customer, data);
    }
}
