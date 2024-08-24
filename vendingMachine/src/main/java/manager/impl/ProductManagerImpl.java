package manager.impl;

import dao.ProductDao;
import entity.Product;
import manager.ProductManager;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ProductManagerImpl implements ProductManager {

    private ProductDao productDao;

    public boolean addProduct(String name, Long price, Long quantity) throws Exception {
        return productDao.addProduct(name, price, quantity);
    }

    public boolean updateProduct(String name, Long price, Long quantity) throws Exception {
        return productDao.updateProduct(name, price, quantity);
    }

    public Product getProduct(String name) throws Exception {
        return productDao.getProduct(name);
    }

    public List<Product> getAllProducts() throws Exception {
        return productDao.getAllProducts();
    }

}
