package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@ToString
public class Product {

    private String name;
    private Map<Long, Long> priceToQuantityMap;

    public Product(String name) {
        this.name = name;
        this.priceToQuantityMap = new HashMap<>();
    }



}
