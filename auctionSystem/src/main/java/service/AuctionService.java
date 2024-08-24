package service;

import dto.Auction;
import dto.Seller;
import manager.AuctionManager;
import manager.SellerManager;
import repository.AuctionRepository;
import repository.SellerRepository;

public class AuctionService {

    SellerManager sellerManager = new SellerManager();
    AuctionManager auctionManager = new AuctionManager();

    public void createAuction(String auctionName, int minBid, int maxBid, String sellerName) {
        Seller seller = sellerManager.getSellerByName(sellerName);
        if (!(SellerRepository.getSellerList().contains(seller))) {
            throw new RuntimeException("Invalid Seller");
        }

        Auction auction = new Auction(auctionName, minBid, maxBid, sellerName, true);
        AuctionRepository.getAuctionList().add(auction);
        seller.getAuctionList().add(auction);
    }

    public void closeAuction(String auctionName) {

        Auction auction = auctionManager.getAuctionByName(auctionName);
        if (!(AuctionRepository.getAuctionList().contains(auction))) {
            throw new RuntimeException("Invalid Auction");
        }

        String winner = auctionManager.getAuctionWinner(auction);
        auction.setActive(false);
    }
}