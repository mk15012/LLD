package repository;

import dto.Buyer;

import java.util.ArrayList;
import java.util.List;

public class BuyerRepository {

    static List<Buyer> buyerList;

    public BuyerRepository() {
        buyerList = new ArrayList<>();
    }

    public static List<Buyer> getBuyerList() {
        return buyerList;
    }
}
