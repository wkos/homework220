package pl.wkos.homework23;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    List<Product> productList;

    public ProductRepository() {
        productList = new ArrayList<>();
        productList.add(new Product("chleb", 3.60, Category.CROCERIES));
        productList.add(new Product("masło", 5.80, Category.CROCERIES));
        productList.add(new Product("mleko", 2.50, Category.CROCERIES));
        productList.add(new Product("pralka", 1200.00, Category.HOUSEHOLD));
        productList.add(new Product("lodówka", 2200.00, Category.HOUSEHOLD));
        productList.add(new Product("rower", 1500.00, Category.OTHER));
        productList.add(new Product("motorower", 3300.00, Category.OTHER));
        productList.add(new Product("skuter", 5500.00, Category.OTHER));
        productList.add(new Product("motocykl", 41500.00, Category.OTHER));
    }

    public void add(Product product) {
        productList.add(product);
    }

    public List<Product> getAll() {
        return new ArrayList<>(productList);
    }

}