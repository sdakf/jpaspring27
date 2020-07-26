package pl.sda.jpaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //to miejsce będzie reagować na requesty z zewnątrz
public class CustomerController {

    //    CustomerService customerService = new CustomerService();
    @Autowired //Spring uzupełni w tym miejscu referencję do serwisu - DEPENDENCY INJECTION
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String customersForm() {
        return "customersForm"; // to jest nazwa pliku html, który zostanie wyświetlony
    }

    @RequestMapping("/addCustomer") //to miejsce będzie reagować na requesty pod adres "/addCustomer"
    public String addCustomer(String firstNameInputValue,
                              String surnameInputValue,
                              String peselInputValue) { //te wartości przyjdą z formularza

        customerService.addCustomer(firstNameInputValue,
                surnameInputValue,
                peselInputValue);
        return "customersForm"; // to jest nazwa pliku html, który zostanie wyświetlony
    }


}
