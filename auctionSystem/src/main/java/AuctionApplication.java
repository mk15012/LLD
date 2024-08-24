import constants.Commands;
import service.AuctionService;
import service.BuyerService;
import service.InMemoryService;
import service.SellerService;

import java.util.Scanner;

public class AuctionApplication {

    public static void main(String[] args) {

        InMemoryService inMemoryService = new InMemoryService();
        BuyerService buyerService = new BuyerService();
        SellerService sellerService = new SellerService();
        AuctionService auctionService = new AuctionService();

        Scanner scanner = new Scanner(System.in);
            while (true) {
                try {
                String inputStr = scanner.nextLine();
                String[] command = inputStr.trim().split(" ");
                switch (command[0]) {
                    case Commands.ADD_BUYER:
                        buyerService.addBuyer(command[1]);
                        break;
                    case Commands.ADD_SELLER:
                        sellerService.addSeller(command[1]);
                        break;
                    case Commands.CREATE_AUCTION:
                        auctionService.createAuction(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]), command[4]);
                        break;
                    case Commands.CREATE_BID:
                        buyerService.createBid(command[1], command[2], Integer.parseInt(command[3]));
                        break;
                    case Commands.WITHDRAW_BID:
                        buyerService.withdrawBid(command[1], command[2]);
                        break;
                    case Commands.UPDATE_BID:
                        buyerService.updateBid(command[1], command[2], Integer.parseInt(command[3]));
                        break;
                    case Commands.CLOSE_AUCTION:
                        auctionService.closeAuction(command[1]);
                        break;
                }
            } catch (RuntimeException ex) {
                System.out.println(ex);
            }
        }
    }
}
