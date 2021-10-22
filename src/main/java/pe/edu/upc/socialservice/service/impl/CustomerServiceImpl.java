package pe.edu.upc.socialservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Customer;
import pe.edu.upc.socialservice.repository.CustomerRepository;
import pe.edu.upc.socialservice.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customerDb = customerRepository.findById(customer.getId()).orElse(null);
        if (customerDb != null){
            return customerDb;
        }
        customer.setStatus("CREATED");
        customerDb = customerRepository.save(customer);
        return customerDb;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerDb = customerRepository.findById(customer.getId()).orElse(null);
        if (customerDb == null){
            return  null;
        }
        customerDb.setEmail(customer.getEmail());
        customerDb.setUsername(customer.getUsername());
        customerDb.setPassword(customer.getPassword());
        customerDb.setName(customer.getName());
        customerDb.setLastname(customer.getLastname());
        customerDb.setAddress(customer.getAddress());
        customerDb.setBirthday(customer.getBirthday());
        customerDb.setPhone(customer.getPhone());
        customerDb.setStatus(customer.getStatus());

        return  customerRepository.save(customerDb);
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customerDb = customerRepository.findById(id).orElse(null);
        if (customerDb ==null){
            return  null;
        }
        customerDb.setStatus("DELETED");
        return customerRepository.save(customerDb);
    }
}
