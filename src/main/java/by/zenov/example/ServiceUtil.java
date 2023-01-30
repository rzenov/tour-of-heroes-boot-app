package by.zenov.example;

public class ServiceUtil {
    public static String entityNotFoundMessage(String entityName, String heroId) {
        return entityName
                .concat(" with id ")
                .concat(heroId)
                .concat(" has not been found.");
    }
}
