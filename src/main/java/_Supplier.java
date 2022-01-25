import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionURL());
        System.out.println(dbConnectSupplier.get());
        System.out.println(supplier.get());
    }

    static String getDBConnectionURL() {
        return "jdbc://localhost.53231/users";
    }

    static Supplier<String> dbConnectSupplier = () -> "jdbc://localhost.53231/users";

    static Supplier<List<String>> supplier = () -> List.of("Hai", "Lam", "Hieu");

}
