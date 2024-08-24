package manager;

import entity.Denomination;

import java.util.List;

public interface OrderManager {

    Long getProductCost(String productName, Long price, Long quantity) throws Exception;

    List<Denomination> buyProduct(String productName, Long price, Long quantity, Long inputAmount) throws Exception;

}
