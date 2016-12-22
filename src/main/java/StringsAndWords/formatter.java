package main.java.Strings;

/**
 * Package: StringsAndWords
 * Created by lusinabrian on 05/09/16 or 05 Sep of 2016,
 * Time: 06:25.
 * Project: JxProjects
 * Description:
 */
public class formatter {
    public static String buildString(String... args) {
        return "I like " + String.join(", ", args);
    }

    public static void main(String[] args) {
        System.out.println(buildString("Cheese", "Milk", "Bread", "Steak"));
    }
}
