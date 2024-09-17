package strategy;

public class SearchFactory {
    public static SearchStrategy getSearchStrategy(String type) {
        if (type.equalsIgnoreCase("name")) {
            return new NameSearchStrategy();
        } else if (type.equalsIgnoreCase("number")) {
            return new NumberSearchStrategy();
        }
        throw new IllegalArgumentException("Invalid search type");
    }
}
