package manager;

import dto.Seller;
import repository.SellerRepository;

import java.util.List;
import java.util.Optional;

public class SellerManager {

    public Seller getSellerByName(String sellerName) {
        List<Seller> sellerList = SellerRepository.getSellerList();
        Optional<Seller> seller = sellerList.stream()
                .filter(x -> x.getName().equals(sellerName))
                .findFirst();

        return seller.orElse(null);
    }
}
