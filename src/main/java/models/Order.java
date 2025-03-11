package models;

import java.util.*;

public class Order {
    private String userDni;
    private User user;
    //private Map<String, Integer> products;
    private List<LP> lps;

    public Order(String dni) {
        this.userDni = dni;
        //this.products = new HashMap<>();
        this.lps = new LinkedList<>();
    }


    public void addLP(int quantity, String productId) {
        Product product=null;
        lps.add(new LP(quantity, productId));
/*        +7if (product != null) {
         ç   products.put(productId, products.getOrDefault(productId, 0) + quantity);

 */

    }

    public User getUser() {
        if (user == null) {
            user = new User(userDni); // Crear usuario si es necesario
        }
        return user;
    }



    public List<LP> getProducts() {
        return lps;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public class LP{
        private int quantity;
        private String productId;

        public LP(int quantity, String productId) {
            this.quantity = quantity;
            this.productId = productId;
        }
        public int getQuantity() {
            return quantity;
        }

        public String getProductId() {
            return productId;
        }
    }
}
