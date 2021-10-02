package pe.edu.upc.socialservice.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Customer;

import java.util.List;

@Service
public interface CustomerService {

    public List<Customer> findAllCustomers();

    public Customer getCustomer(Long id);

    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Customer customer);
}
