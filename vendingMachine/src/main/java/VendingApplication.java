import dao.DenominationDao;
import dao.ProductDao;
import dao.impl.DenominationDaoImpl;
import dao.impl.ProductDaoImpl;
import manager.DenominationManager;
import manager.OrderManager;
import manager.ProductManager;
import manager.impl.DenominationManagerImpl;
import manager.impl.OrderManagerImpl;
import manager.impl.ProductManagerImpl;

public class VendingApplication {

    public static void main(String[] args) throws Exception {

        ProductDao productDao = new ProductDaoImpl();
        DenominationDao denominationDao = new DenominationDaoImpl();

        ProductManager productManager = new ProductManagerImpl(productDao);
        DenominationManager denominationManager = new DenominationManagerImpl(denominationDao);
        OrderManager orderManager = new OrderManagerImpl(productManager, denominationManager);

        try {
            productManager.addProduct("pepsi", 50L, 40L);
            productManager.addProduct("mango", 40L, 8L);
            productManager.addProduct("pepsi", 40L, 20L);
            System.out.println(productManager.getAllProducts());

            denominationManager.addDenomination(100L, 5L);
            denominationManager.addDenomination(50L, 5L);
            denominationManager.addDenomination(20L, 5L);
            denominationManager.addDenomination(10L, 5L);
            denominationManager.addDenomination(5L, 5L);
            System.out.println(denominationManager.getAllDenominations());

            System.out.println(orderManager.getProductCost("pepsi", 40L, 4L));
            System.out.println(orderManager.buyProduct("pepsi", 40L, 4L, 500L));
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}
