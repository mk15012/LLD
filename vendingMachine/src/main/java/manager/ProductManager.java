package manager;

import entity.Product;

import java.util.List;

public interface ProductManager {

    boolean addProduct(String name, Long price, Long quantity) throws Exception;

    boolean updateProduct(String name, Long price, Long quantity) throws Exception;

    Product getProduct(String name) throws Exception;

    List<Product> getAllProducts() throws Exception;

}
