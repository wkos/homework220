package pl.wkos.homework23;

import java.util.List;
import java.util.stream.Collectors;

public final class ProductUtils {
    private ProductUtils() {
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
}
