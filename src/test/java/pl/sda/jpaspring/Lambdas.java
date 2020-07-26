package pl.sda.jpaspring;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Lambdas {


    List<String> stringList = Arrays.asList("aaa", "b", "c");

    @Test
    public void lambdas() {

        Predicate<String> stringPredicate = e -> e.length() < 3;
        Predicate<String> stringPredicateAnonymous = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() < 3;
            }
        };

        stringList.stream()
                .filter(stringPredicate)
                .forEach(System.out::println);
    }

    @FunctionalInterface
    interface SuperMathOperation<A,B,C>{
        C calculate(A a, B b);
    }

    @Test
    public void math(){
        SuperMathOperation<Integer, Long, BigDecimal> adder =
                (a, b) -> BigDecimal.valueOf(a + b);
        SuperMathOperation<Integer, Long, String> subtractor =
                (a, b) -> String.valueOf(a - b);

        BigDecimal calculate = adder.calculate(4, 6L);
        String calculate1 = subtractor.calculate(4, 7L);
        System.out.println(calculate);
        System.out.println(calculate1);

    }

}
