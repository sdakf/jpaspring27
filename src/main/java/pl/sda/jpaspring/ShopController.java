package pl.sda.jpaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShopController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/shop")
    public String shop(Model model){
        List<Product> productList = productsService.findAllProducts();
        List<Customer> customersList = customerService.findAllCustomers();
        model.addAttribute("products", productList);
        model.addAttribute("cccccustomers", customersList);
        return "shopPage";
    }

}
