import models.Order;
import models.Product;
import models.User;

import java.util.*;

public class ProductManagerImpl implements ProductManager {
    private List<Product> productList;
    private Queue<Order> orderQueue;
    private HashMap<String, User> users;
    private HashMap<String, Product> productMap;


    public ProductManagerImpl() {
        productList = new ArrayList<>();
        orderQueue = new LinkedList<>();
        users = new HashMap<>();
        productMap = new HashMap<>();
    }

    @Override
    public void addProduct(String id, String name, double price) {
        Product p = new Product(id, name, price);
        productList.add(p);
        productMap.put(id, p);
    }

    @Override
    public List<Product> getProductsByPrice() {
        productList.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        return productList;
    }

    @Override
    public List<Product> getProductsBySales(){
        List<Product> sortedList = new ArrayList<>(productList); // Clonar la lista para no modificar la original
        sortedList.sort((p1, p2) -> Integer.compare(p2.getSales(), p1.getSales()));
        return sortedList;
    }

    @Override
    public void addOrder(Order order) {
        orderQueue.add(order);
        String userDni = order.getUser().getDni();
        users.putIfAbsent(userDni, new User(userDni));
        User user = users.get(userDni);
        order.setUser(user);
    }

    @Override
    public int numOrders() {
        return orderQueue.size();
    }

    @Override
    public Order deliverOrder() {
        Order order = orderQueue.poll();
        if (order != null) {
            for (Order.LP lp : order.getProducts()) {
                Product product = productMap.get(lp.getProductId());
                if (product != null) {
                    product.increaseSales(lp.getQuantity());
                }
            }
            order.getUser().addOrder(order);
        }
        return order;
    }

    @Override
    public Product getProduct(String c1) {
        return productMap.get(c1);
    }

    @Override
    public User getUser(String dni) {
        return users.get(dni);
    }
}
