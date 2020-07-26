package pl.sda.jpaspring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.pesel = ?1")
    List<Customer> findAllByPesel(String peselInputValue);

}
