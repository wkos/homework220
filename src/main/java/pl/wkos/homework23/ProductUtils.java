package pl.wkos.homework23;

import java.util.List;
import java.util.stream.Collectors;

public final class ProductUtils {
    private ProductUtils() {
    }

    public static double priceOfAllInCategory(List<Product> products, Category category) {
        double sum;
        if (category == null) {
            sum = products.stream()
                    .mapToDouble(Product::getPrice)
                    .sum();
        } else {
            sum = products.stream()
                    .filter(product -> product.getCategory().equals(category))
                    .mapToDouble(Product::getPrice)
                    .sum();
        }
        return sum;
    }

    public static List<Product> listOfProductsInCategory(List<Product> products, Category category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public static String createDataToHtml(List<Product> products) {
        String listOfProducts = "";
        for (Product product : products) {
            listOfProducts += "nazwa: " + product.getName() + ", " +
                    "cena: " + product.getPrice() + ", " +
                    "kategoria: " + product.getCategory().getName() + "<br/>";
        }
        return listOfProducts;
    }

    public static String createDataToHtmlWithPrice(List<Product> products, Category category) {
        return createDataToHtml(products) + priceOfAllInCategory(products, category) + "<br/>";
    }

    public static Category getCategoryFromParameter(String parameter) {
        switch (parameter) {
            case "spozywcze":
                return Category.CROCERIES;
            case "domowe":
                return Category.HOUSEHOLD;
            case "inne":
                return Category.OTHER;
            default:
                return null;
        }
    }
}
