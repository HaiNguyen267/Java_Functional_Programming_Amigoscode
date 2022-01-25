import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer hai = new Customer("Hai", "0362135160");
        Customer lam = new Customer("Lam", "0234412522");



        sayHello.andThen(sayGoodBye).accept(hai);

    }

    static void greetCustomer(Customer customer) {
        System.out.printf(String.format("Hello %s, thank for registering phone number \"%s\"", customer.customerName, customer.customerPhoneNumber));
    }


    static Consumer<Customer> sayGoodBye = s -> System.out.println(s.customerName + "Goodbye");
    static Consumer<Customer> sayHello = customer -> System.out.print(String.format("hi %s, your phone number is %s\n", customer.customerName, customer.customerPhoneNumber));
    static BiConsumer<Customer, Boolean> printInfo = (customer, allowed) -> {
        System.out.println("Customer name " + customer.customerName
                + ", phonenumber: " + (allowed ? customer.customerPhoneNumber : "**********"));
    };

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
