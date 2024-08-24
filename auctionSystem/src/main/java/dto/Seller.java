package dto;

import java.util.List;

public class Seller {

    private String name;
    private List<Auction> auctionList;

    public Seller(String name, List<Auction> auctionList) {
        this.name = name;
        this.auctionList = auctionList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Auction> getAuctionList() {
        return auctionList;
    }

    public void setAuctionList(List<Auction> auctionList) {
        this.auctionList = auctionList;
    }

}
