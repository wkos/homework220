package pl.wkos.homework23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductsController {
    ProductRepository productRepository;

    @Autowired
    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ResponseBody
    @GetMapping("/products")
    public String listOfProducts(@RequestParam(required = false) String category) {
        List<Product> productList = productRepository.getAll();

        Category categoryFromParam = ProductUtils.getCategoryFromParameter(category);
        List<Product> productsInCategory;
        if (categoryFromParam == null) {
            productsInCategory = productList;
        } else {
            productsInCategory = ProductUtils.listOfProductsInCategory(productList, categoryFromParam);
        }

        return ProductUtils.createDataToHtmlWithPrice(productsInCategory, categoryFromParam);
    }

    @GetMapping("/add")
    public String add(@RequestParam String name, @RequestParam Double price, @RequestParam String category) {
        Category categoryFromParam = ProductUtils.getCategoryFromParameter(category);
        productRepository.add(new Product(name, price, categoryFromParam));
        return "redirect:add.html";
    }
}
