package pl.sda.jpaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //to spowoduje utworzenie jednej instancji tej klasy (SINGLETON)
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(String firstNameInputValue, String surnameInputValue) {
        Customer customer = new Customer(firstNameInputValue, surnameInputValue);
        customerRepository.save(customer);
    }
}
