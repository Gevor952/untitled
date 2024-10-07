package homework.online_store.storage;

import homework.online_store.model.Product;
import homework.online_store.util.SerializeUtil;

import java.util.ArrayList;
import java.util.List;

public class ProductStorage {
    List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
        SerializeUtil.serializeProductDate(products);
    }


    public void print() {
        for (Product product : products) {
            System.out.println(product);
        }

    }


    public void deleteById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);
            }
        }
        SerializeUtil.serializeProductDate(products);
    }

    public Product searchById(String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public void deserializeProducts() {
        this.products = SerializeUtil.deserializeProductData();
    }

    public void uppFiles() {
        SerializeUtil.serializeProductDate(products);
    }
}
