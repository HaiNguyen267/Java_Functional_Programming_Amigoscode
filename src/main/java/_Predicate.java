import java.util.function.Function;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        String phoneNumber = "0362135160";
        String phoneNumber2 = "236643ds2";

        System.out.println(isPhoneNumberValid(phoneNumber));
        System.out.println(isPhoneNumberValid(phoneNumber2));

        System.out.println("Using predicate:");
        System.out.println(checkValidNumber.test(phoneNumber));
        System.out.println(checkValidNumber.test(phoneNumber2));

        System.out.println(
                checkValidNumber.and(contain3).test(phoneNumber2)
        );

    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("036") && phoneNumber.length() == 10;
        // phone number
    }

    static Predicate<String> checkValidNumber = phoneNumber -> phoneNumber.startsWith("036") && phoneNumber.length() == 10;

    static Predicate<String> contain3 = phoneNumber -> phoneNumber.contains("3");

    static Predicate<String> combine = phoneNumber -> checkValidNumber.and(contain3).test(phoneNumber);
    static Function<String, Boolean> hihi = phoneNumber -> phoneNumber.startsWith("036") && phoneNumber.length() == 10;
}
