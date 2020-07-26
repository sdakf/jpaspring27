package pl.sda.jpaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //to spowoduje utworzenie jednej instancji tej klasy (SINGLETON)
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductsService productsService;

    public void addCustomer(String firstNameInputValue,
                            String surnameInputValue,
                            String peselInputValue) {
        List<Customer> allByPesel = customerRepository.findAllByPesel(peselInputValue);
        if (!allByPesel.isEmpty()) {
            System.out.printf("Użytkownik z peselem: %s istnieje", peselInputValue);
        } else {

            List<Product> products = productsService.findAllProducts().stream()
                    .limit(2)
                    .collect(Collectors.toList());

            Customer customer = new Customer(firstNameInputValue,
                    surnameInputValue,
                    peselInputValue,
                    products);


            customerRepository.save(customer);
        }
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
