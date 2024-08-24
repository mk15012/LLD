package dao.impl;

import dao.ProductDao;
import entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProductDaoImpl implements ProductDao {

    private final Map<String, Product> productMap;

    public ProductDaoImpl() {
        productMap = new HashMap<>();
    }

    @Override
    public boolean addProduct(String name, Long price, Long quantity) throws Exception {
        if (Objects.nonNull(productMap.get(name)) && productMap.get(name).getPriceToQuantityMap().containsKey(price)) {
            throw new Exception("Product " + name + " already exists with price " + price);
        }

        Product product = null;
        if (Objects.isNull(productMap.get(name))) {

            Map<Long, Long> mp = new HashMap<>();
            mp.put(price, quantity);
            product = new Product(name, mp);
            productMap.put(name, product);
        } else {
            Map<Long, Long> priceToQuantityMap = productMap.get(name).getPriceToQuantityMap();
            priceToQuantityMap.putIfAbsent(price, quantity);

            productMap.get(name).setPriceToQuantityMap(priceToQuantityMap);
        }
        return true;
    }


    @Override
    public boolean updateProduct(String name, Long price, Long quantity) throws Exception {
        if (Objects.isNull(productMap.get(name))) {
            throw new Exception("Product " + name + " doesn't exist");
        }

        Map<Long, Long> priceToQuantityMap = productMap.get(name).getPriceToQuantityMap();
        if (priceToQuantityMap.containsKey(price)) {
            priceToQuantityMap.put(price, priceToQuantityMap.get(price) + quantity);
        } else {
            throw new Exception("Prodcut " + name + " doesn't have any peice with price " + price);
        }

        return true;
    }


    @Override
    public Product getProduct(String name) throws Exception {
        if (Objects.isNull(productMap.get(name))) {
            throw new Exception("Product " + name + " doesn't exist");
        }

        return productMap.get(name);

    }


    @Override
    public List<Product> getAllProducts() throws Exception {
        return new ArrayList<>(productMap.values());
    }
}
