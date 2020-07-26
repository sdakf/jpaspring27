package pl.sda.jpaspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {

    @RequestMapping("/products")
    public String productsForm() {
        return "productsForm";
    }

    @RequestMapping("/addProduct")
    public String addProduct(String productNameInput,
                             String isbnInput,
                             String productTypeInput) {
        return "productsForm";
    }
}
