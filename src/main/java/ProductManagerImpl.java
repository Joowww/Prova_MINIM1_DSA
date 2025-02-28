import models.Order;
import models.Product;
import models.User;

import java.util.*;

public class ProductManagerImpl implements ProductManager {
    private List<Product> productList;
    private Queue<Order> orderQueue;
    private HashMap<String, User> users;


    public ProductManagerImpl() {
        productList = new ArrayList<>();
        orderQueue = new LinkedList<>();
    }

    @Override
    public void addProduct(String id, String name, double price) {
        productList.add(new Product(id, name, price));

    }

    @Override
    public List<Product> getProductsByPrice() {
        return productList;
    }

    @Override
    public void addOrder(Order order) {
        orderQueue.add(order);

    }

    @Override
    public int numOrders() {
        return 0;
    }

    @Override
    public Order deliverOrder() {
        Order order = orderQueue.poll();
        // TO-DO
        return order;
    }

    @Override
    public Product getProduct(String c1) {
        return null;
    }

    @Override
    public User getUser(String number) {
        return null;
    }
}
