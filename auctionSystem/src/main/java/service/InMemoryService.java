package service;

import repository.AuctionRepository;
import repository.BuyerRepository;
import repository.SellerRepository;

public class InMemoryService {

    AuctionRepository auctionRepository = new AuctionRepository();
    BuyerRepository buyerRepository = new BuyerRepository();
    SellerRepository sellerRepository = new SellerRepository();
}
