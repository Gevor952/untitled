package homework.online_store.storage;

import homework.online_store.model.Order;
import homework.online_store.model.Product;
import homework.online_store.model.User;
import homework.online_store.util.SerializeUtil;

import java.util.ArrayList;
import java.util.List;

import static homework.online_store.Enum.OrderStatus.*;

public class OrderStorage {
    List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
        SerializeUtil.serializeOrderDate(orders);
    }



    public void print() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void printByUser(User user) {
        for (Order order : orders) {
            if (order.getUser().equals(user)) {
                System.out.println(order);
            }
        }
    }

    public void cancelById(String orderId) {
        for (Order order : orders) {
            if (order.getId().equals(orderId)) {
                order.setOrderStatus(CANCELED);
            }
        }
        SerializeUtil.serializeOrderDate(orders);
    }

    public void changeStatus() {
        for (Order order : orders) {
            if (order.getOrderStatus() == NEW) {
                Product product = order.getProduct();
                product.setStockQty(product.getStockQty() - order.getQty());
                order.setOrderStatus(DELIVERED);
            }
        }
        SerializeUtil.serializeOrderDate(orders);
    }

    public void deserializeOrders() {
        this.orders = SerializeUtil.deserializeOrderData();
    }
}
