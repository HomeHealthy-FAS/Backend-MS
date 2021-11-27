package pe.edu.upc.socialservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.socialservice.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
