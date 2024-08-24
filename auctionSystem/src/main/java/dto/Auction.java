package dto;

import java.util.HashMap;
import java.util.Map;

public class Auction {

    private String id;
    private String name;
    private int minValue;
    private int maxValue;
    private boolean isActive;
    private String seller;
    private Map<String, Integer> buyerBidMap;

    public Auction(String name, int minValue, int maxValue, String seller, boolean isActive) {
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.isActive = isActive;
        this.seller = seller;
        this.buyerBidMap = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Map<String, Integer> getBuyerBidMap() {
        return buyerBidMap;
    }

    public void setBuyerBidMap(Map<String, Integer> buyerBidMap) {
        this.buyerBidMap = buyerBidMap;
    }
}
