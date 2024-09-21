package homework.online_store.storage;

import homework.online_store.model.Product;

public class ProductStorage {
    private Product[] products = new Product[100];
    private int size = 0;

    public void add(Product product) {
        if (size == products.length) {
            extendStorage();
        }
        products[size++] = product;
    }

    private void extendStorage() {
        Product[] temp = new Product[products.length * 2];
        System.arraycopy(products, 0, temp, 0, products.length);
        products = temp;
    }

    public void print() {
        for (Product product : products) {
            System.out.println(product);
        }
    }


    public void deleteById(String id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(id)) {
                for (int j = i -1; j < size; j++) {
                    products[j] = products[j + 1];
                }
                size--;
                return;
            }
        }
    }

    public Product searchById(String productId) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(productId)) {
                return products[i];
            }
        }
        return null;
    }
}
