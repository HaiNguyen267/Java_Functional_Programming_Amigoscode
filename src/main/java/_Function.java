import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // Function examples, takes 1 argument and produces the result
        int a = 1;
        a = incrementByOneFunction.apply(a);
        a = multiplyBy10.apply(a);
        System.out.println("result of a: " +a);

        int b = 1;
        int resultOfB = incrementByOneFunction.andThen(multiplyBy10).apply(b);
        System.out.printf("result of b: %d\n", resultOfB);

        Function<Integer, Integer> incrementAndMultiply = incrementByOneFunction.andThen(multiplyBy10);
        System.out.println("result of c: " + incrementAndMultiply.apply(1));


        Function<String, Boolean> func1 = s -> s.length() % 2 == 0;
        Function<Boolean, Integer> func2 = s -> s? 2: 3;

        Function<String, Integer> func3 = s -> func1.andThen(func2).apply(s);


        /// BiFunction example
        System.out.println("Example; ");
        System.out.println(beeTogether.apply(3, 100));

    }





    static Function<Integer, Integer> incrementByOneFunction = number -> number++;
    static Function<Integer, Integer> incr1 = _Function::increment;
    static Function<Integer, Integer> multiplyBy10 = number -> number * 10;

    static int increment(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> beeTogether =
            (number, factor) -> (number + 1) * factor;

}
