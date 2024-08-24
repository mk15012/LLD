package service;

import dto.Auction;
import dto.Buyer;
import manager.AuctionManager;
import repository.BuyerRepository;

import java.util.ArrayList;

public class BuyerService {

    AuctionManager auctionManager = new AuctionManager();

    public void addBuyer(String buyerName) {
        Buyer buyer = new Buyer(buyerName, new ArrayList<>());
        BuyerRepository.getBuyerList().add(buyer);
    }

    public void createBid(String buyerName, String auctionName, int bidAmount) {
        Auction auction = auctionManager.getAuctionByName(auctionName);
        if (!auction.isActive())
            throw new RuntimeException("No Auction Found");
        if (bidAmount < auction.getMinValue() && bidAmount > auction.getMaxValue())
            throw new RuntimeException("Bid AMount Not in Range");

        auction.getBuyerBidMap().put(buyerName, bidAmount);
    }

    public void withdrawBid(String buyerName, String auctionName) {
        Auction auction = auctionManager.getAuctionByName(auctionName);
        if (!auction.isActive())
            throw new RuntimeException("Auction is Closed");
        auction.getBuyerBidMap().remove(buyerName);
    }

    public void updateBid(String buyerName, String auctionName, int bidAmount) {
        Auction auction = auctionManager.getAuctionByName(auctionName);
        if (!auction.isActive())
            throw new RuntimeException("Auction is Closed");
        auction.getBuyerBidMap().put(buyerName, bidAmount);
    }
}
