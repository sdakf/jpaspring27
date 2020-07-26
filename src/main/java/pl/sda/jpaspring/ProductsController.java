package pl.sda.jpaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping("/products")
    public String productsForm() {
        return "productsForm";
    }

    @RequestMapping("/addProduct")
    public String addProduct(String productNameInput,
                             String isbnInput,
                             String productTypeInput) {
        productsService.addProduct(productNameInput, isbnInput, productTypeInput);

        return "productsForm";
    }
}
