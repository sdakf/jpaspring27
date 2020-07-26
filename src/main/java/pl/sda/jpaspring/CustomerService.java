package pl.sda.jpaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //to spowoduje utworzenie jednej instancji tej klasy (SINGLETON)
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(String firstNameInputValue,
                            String surnameInputValue,
                            String peselInputValue) {
        List<Customer> allByPesel = customerRepository.findAllByPesel(peselInputValue);
        if (!allByPesel.isEmpty()) {
            System.out.printf("Użytkownik z peselem: %s istnieje", peselInputValue);
        } else {
            Customer customer = new Customer(firstNameInputValue,
                    surnameInputValue,
                    peselInputValue);
            customerRepository.save(customer);
        }
    }
}
