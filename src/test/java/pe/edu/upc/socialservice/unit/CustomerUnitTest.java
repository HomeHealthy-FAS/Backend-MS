package pe.edu.upc.socialservice.unit;

import org.junit.jupiter.api.Test;
import pe.edu.upc.socialservice.entity.Customer;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerUnitTest {

    @Test
    public void createCustomerWithValidEmail(){

        Customer customer = new Customer();
        String email = "test@email.com";
        customer.setEmail(email);

        assertThat(customer.getEmail()).isEqualTo(email);
    }

    @Test
    public void createCustomerWithValidUsername(){

        Customer customer = new Customer();
        String username = "testUsername";
        customer.setUsername(username);

        assertThat(customer.getUsername()).isEqualTo(username);
    }

    @Test
    public void createCustomerWithValidPassword(){

        Customer customer = new Customer();
        String password = "testpasword123";
        customer.setPassword(password);

        assertThat(customer.getPassword()).isEqualTo(password);
    }

    @Test
    public void createCustomerWithValidPhonenumber(){

        Customer customer = new Customer();
        Long phone = 98769876L;
        customer.setPhone(phone);

        assertThat(customer.getPhone()).isEqualTo(phone);
    }

    @Test
    public void createCustomerWithValidStatus(){

        Customer customer = new Customer();
        String status = "CREATED";
        customer.setStatus(status);

        assertThat(customer.getStatus()).isEqualTo(status);
    }

    @Test
    public void createCustomerWithValidAddress(){

        Customer customer = new Customer();
        String address = "Fake street 123";
        customer.setAddress(address);

        assertThat(customer.getAddress()).isEqualTo(address);
    }
}
