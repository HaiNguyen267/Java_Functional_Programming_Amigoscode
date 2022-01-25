package combinator;

import java.time.LocalDate;
import java.util.Locale;

import static combinator.CustomerRegistrationValidator.*;
import static combinator.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Hai",
                "bongnghin52@gmail.com",
                "03626246160",
                LocalDate.of(2012, 11, 14)
        );


        // if valid, we can store the customer in the database

        // using combinator pattern
        CustomerRegistrationValidator validator = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult());

        ValidationResult result = validator.apply(customer);
        if (result != SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }
}
