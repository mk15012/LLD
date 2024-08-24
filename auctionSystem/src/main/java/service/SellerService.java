package service;

import dto.Seller;
import repository.SellerRepository;

import java.util.ArrayList;

public class SellerService {

    public void addSeller(String sellerName) {
        Seller seller = new Seller(sellerName, new ArrayList<>());
        SellerRepository.getSellerList().add(seller);
    }


}
