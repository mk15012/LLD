import dao.TableDao;
import dao.TableDaoImpl;
import entity.TableColumn;
import enums.Constraints;
import enums.Type;
import manager.DbMangerImpl;

import java.util.Arrays;

public class DbApplication {

    public static void main(String[] args) {

        TableDao tableDao = new TableDaoImpl();
        DbMangerImpl dbService = new DbMangerImpl(tableDao);

        System.out.println("In Memory Database Started ......");

        try {
            dbService.createTable("Employee", Arrays.asList(
                    new TableColumn("Name", Type.STRING, false, Constraints.STRING_LENGTH_20),
                    new TableColumn("Age", Type.INT, false, Constraints.INT_RANGE_1024)
            ));

            dbService.insertEntry("Employee", Arrays.asList("Umang", 24));

            System.out.println(dbService.getAllTableNames());
            System.out.println(dbService.getAllRowsOfTable("Employee"));

            dbService.updateEntry("Employee", 1, Arrays.asList("Umang", 25));
            System.out.println(dbService.getAllRowsOfTable("Employee"));

        } catch (Exception ex) {
            System.out.print(ex);
        }

    }
}
