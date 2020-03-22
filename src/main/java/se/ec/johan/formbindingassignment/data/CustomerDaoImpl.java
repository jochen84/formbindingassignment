package se.ec.johan.formbindingassignment.data;

import org.springframework.stereotype.Component;
import se.ec.johan.formbindingassignment.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDaoImpl implements CustomerDao {

    List<Customer> customerList = new ArrayList<>();

    @Override
    public Customer save(Customer customer) {
        if(customerList.contains(customer)){
            throw new IllegalArgumentException("Customer already exists");
        }
        customerList.add(customer);
        return findById(customer.getCustomerId()).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Optional<Customer> findById(String customerId) {
        return customerList.stream().filter(customer -> customer.getCustomerId().equals(customerId)).findFirst();
    }

    @Override
    public Optional<Customer> findbyEmail(String email) {
        return customerList.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email)).findFirst();
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> clonedList = customerList.stream().collect(Collectors.toList());
        return clonedList;
    }

    @Override
    public boolean delete(String customerId) {
        Optional<Customer> optional = findById(customerId);
        if (optional.isPresent()){
            return customerList.remove(optional.get());
        }
        return false;
    }
}
