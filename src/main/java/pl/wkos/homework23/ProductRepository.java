package pl.wkos.homework23;

import org.springframework.stereotype.Repository;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private static List<Product> productList;

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

    public static List<Product> getAll() {
        return new ArrayList<>(productList);
    }

    public static double priceOfAllInCategory(Category category) {
        List<Product> products = listOfProductsInCategory(category);
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static List<Product> listOfProductsInCategory(Category category) {
        List<Product> products = getAll();
        if (category == null) {
            return products;
        } else {
            return products.stream()
                    .filter(product -> product.getCategory().equals(category))
                    .collect(Collectors.toList());
        }
    }
}