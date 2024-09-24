package homework.online_store.storage;

import homework.online_store.model.Order;
import homework.online_store.model.Product;
import homework.online_store.model.User;

import static homework.online_store.Enum.OrderStatus.*;

public class OrderStorage {
    private Order[] orders = new Order[100];
    private int size = 0;

    public void add(Order order) {
        if (size == orders.length) {
            extendStorage();
        }
        orders[size++] = order;
    }

    private void extendStorage() {
        Order[] temp = new Order[orders.length * 2];
        System.arraycopy(orders, 0, temp, 0, orders.length);
        orders = temp;
    }

    public void print() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void printByUser(User user) {
        for (Order order : orders) {
            if(order.getUser().equals(user)) {
                System.out.println(order);
            }
        }
    }

    public void cancelById(String orderId) {
        for (Order order : orders) {
            if(order.getId().equals(orderId)) {
                order.setOrderStatus(CANCELED);
            }
        }
    }

    public void changeStatus() {
        for (Order order : orders) {
            if(order.getOrderStatus() == DELIVERED){
                Product product = order.getProduct();
                product.setStockQty(product.getStockQty() - order.getQty());
                order.setOrderStatus(NEW);
            }
        }
    }
}
