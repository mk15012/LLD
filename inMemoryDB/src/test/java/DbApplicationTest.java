import dao.TableDao;
import dao.TableDaoImpl;
import entity.TableColumn;
import enums.Constraints;
import enums.Type;
import manager.DbMangerImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DbApplicationTest {


    @Test
    public void testTableCreation() throws Exception {

        TableDao tableDao = new TableDaoImpl();
        DbMangerImpl dbService = new DbMangerImpl(tableDao);

        boolean result = dbService.createTable("mk", Arrays.asList(
                new TableColumn("Name", Type.STRING, false, Constraints.STRING_LENGTH_20),
                new TableColumn("Age", Type.INT, false, Constraints.INT_RANGE_1024)
        ));

        Assert.assertTrue(result);
    }

    @Test
    public void testInvalidDeleteTable() throws Exception {

        TableDao tableDao = new TableDaoImpl();
        DbMangerImpl dbService = new DbMangerImpl(tableDao);

        try {
            boolean result = dbService.deteleTable("mk");
        } catch (Exception ex) {
            Assert.assertEquals("Table " + "mk" + " doesn't exist", ex.getMessage());

        }
    }


}
