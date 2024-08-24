package repository;

import dto.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerRepository {

    static List<Seller> sellerList;

    public SellerRepository() {
        sellerList = new ArrayList<>();
    }

    public static List<Seller> getSellerList() {
        return sellerList;
    }

}
