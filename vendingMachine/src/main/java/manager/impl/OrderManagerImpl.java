package manager.impl;

import entity.Denomination;
import entity.Product;
import manager.DenominationManager;
import manager.OrderManager;
import manager.ProductManager;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
public class OrderManagerImpl implements OrderManager {

    private ProductManager productManager;
    private DenominationManager denominationManager;

    public Long getProductCost(String productName, Long price, Long quantity) throws Exception {

        Product product = productManager.getProduct(productName);
        Map<Long, Long> priceToQuantityMap = product.getPriceToQuantityMap();

        if (Objects.isNull(priceToQuantityMap.get(price)) || priceToQuantityMap.get(price) < quantity) {
            throw new Exception("Required Product not available");
        }

        return price * quantity;
    }

    public List<Denomination> buyProduct(String productName, Long price, Long quantity, Long inputAmount) throws Exception {

        Product product = productManager.getProduct(productName);
        Map<Long, Long> priceToQuantityMap = product.getPriceToQuantityMap();

        if (Objects.isNull(priceToQuantityMap.get(price)) || priceToQuantityMap.get(price) < quantity) {
            throw new Exception("Required Product not available");
        }

        Long cost = price * quantity;
        if (inputAmount < cost) {
            throw new Exception("Insufficient amount provided");
        }

        List<Denomination> result = new ArrayList<>();

        List<Denomination> denominationList = denominationManager.getAllDenominations();

        List<Denomination> modifiableDenominationList = new ArrayList<>(denominationList);
        modifiableDenominationList.sort((d1, d2) -> Long.compare(d2.getDenomination(), d1.getDenomination()));

        Long remainingAmount = inputAmount - cost;

        for (Denomination denomination : modifiableDenominationList) {
            Long value = denomination.getDenomination();
            Long actualCount = denomination.getQuantity();
            Long requiredCount = remainingAmount / value;
            Long usedCount = Math.min(requiredCount, actualCount);
            denomination.setQuantity(actualCount - usedCount);
            remainingAmount -= value * usedCount;

            if(usedCount > 0) {
                result.add(new Denomination(value, usedCount));
            }
        }

        return result;
    }
}
