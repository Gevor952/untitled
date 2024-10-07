package homework.online_store.util;

import homework.online_store.model.Order;
import homework.online_store.model.Product;
import homework.online_store.model.User;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerializeUtil {
    private static final String USER_DATA_PATH = "C:\\Users\\NITRO\\IdeaProjects\\untitled\\src\\homework\\online_store\\data\\users.data";
    private static final String PRODUCT_DATA_PATH = "C:\\Users\\NITRO\\IdeaProjects\\untitled\\src\\homework\\online_store\\data\\products.data";
    private static final String ORDER_DATA_PATH = "C:\\Users\\NITRO\\IdeaProjects\\untitled\\src\\homework\\online_store\\data\\oder.data";

    public static void serializeUserData(List<User> userList) {
        File file = new File(USER_DATA_PATH);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(userList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeProductDate(List<Product> productList) {
        File file = new File(PRODUCT_DATA_PATH);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(productList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeOrderDate(List<Order> orderList) {
        File file = new File(ORDER_DATA_PATH);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(orderList);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<User> deserializeUserData() {
        File file = new File(USER_DATA_PATH);
        try {
            if(file.exists()){
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
                    return (List<User>) ois.readObject();
                }
            }
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<Product> deserializeProductData(){
        File file = new File(PRODUCT_DATA_PATH);
        try {
            if(file.exists()){
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    return (List<Product>) ois.readObject();
                }
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<Order> deserializeOrderData() {
        File file = new File(ORDER_DATA_PATH);
        try {
            if (file.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    return (List<Order>) ois.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
