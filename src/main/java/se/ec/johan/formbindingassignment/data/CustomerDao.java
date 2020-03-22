package se.ec.johan.formbindingassignment.data;

import se.ec.johan.formbindingassignment.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    Customer save(Customer customer);
    Optional<Customer> findById(String customerId);
    Optional<Customer> findbyEmail(String email);
    List<Customer> findAll();
    boolean delete(String customerId);
}
