package manager;

import dto.Auction;
import repository.AuctionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AuctionManager {

    public Auction getAuctionByName(String auctionName) {
        List<Auction> auctionList = AuctionRepository.getAuctionList();
        Optional<Auction> auction = auctionList.stream()
                .filter(x -> x.getName().equals(auctionName))
                .findFirst();

        return auction.orElse(null);
    }

    public String getAuctionWinner(Auction auction) {
        Map<String, Integer> buyerBidderMap = auction.getBuyerBidMap();
        Map<Integer, Integer> bidFrequencyMap = new HashMap<>();

        for (String key : buyerBidderMap.keySet()) {
            if (bidFrequencyMap.containsKey(buyerBidderMap.get(key))) {
                bidFrequencyMap.put(buyerBidderMap.get(key), bidFrequencyMap.get(buyerBidderMap.get(key)) + 1);
            } else {
                bidFrequencyMap.put(buyerBidderMap.get(key), 1);
            }
        }

        int maxBid = Integer.MIN_VALUE;
        String auctionWinner = "NONE";
        boolean flag = true;
        for (Integer key : bidFrequencyMap.keySet()) {
            if (bidFrequencyMap.get(key) == 1) {
                if (key > maxBid) {
                    maxBid = key;
                    flag = false;
                }
            }
        }

        if (flag) {
            throw new RuntimeException("NO Winner");
        }

        for (String key : buyerBidderMap.keySet()) {
            if (buyerBidderMap.get(key) == maxBid) {
                auctionWinner = key;
                break;
            }
        }

        System.out.println(auctionWinner + " IS WINNER");
        return auctionWinner;
    }
}
