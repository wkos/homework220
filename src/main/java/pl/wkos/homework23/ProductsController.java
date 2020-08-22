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
    public String listOfProducts(@RequestParam(required = false) String  category) {
        Category categoryFromParam = Category.getCategoryFromParameter(category);
        List<Product> productsInCategory = ProductRepository.listOfProductsInCategory(categoryFromParam);
        return ProductUtils.createDataToHtml(productsInCategory) +
                String.format("%.2f",ProductRepository.priceOfAllInCategory(categoryFromParam));
    }

    @GetMapping("/add")
    public String add(@RequestParam String name, @RequestParam Double price, @RequestParam String category) {
        Category categoryFromParam = Category.getCategoryFromParameter(category);
        productRepository.add(new Product(name, price, categoryFromParam));
        return "redirect:add.html";
    }
}
