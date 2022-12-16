import io.vavr.Function1;
import io.vavr.collection.HashSet;
import io.vavr.collection.Stream;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day11MonkeyInTheMiddle {
    public static void main(String[] args) {
        Day11MonkeyInTheMiddle day11 = new Day11MonkeyInTheMiddle();

        day11.runMonkeyRounds(List.of(
                new Monkey(
                        toList(79, 98),
                        x -> x.multiply(BigInteger.valueOf(19)),
                        x -> x.mod(BigInteger.valueOf(23)).equals(BigInteger.ZERO) ? 2 : 3,
                        new AtomicInteger()
                ),
                new Monkey(
                        toList(54, 65, 75, 74),
                        x -> x.add(BigInteger.valueOf(6)),
                        x -> x.mod(BigInteger.valueOf(19)).equals(BigInteger.ZERO) ? 2 : 0,
                        new AtomicInteger()
                ),
                new Monkey(
                        toList(79, 60, 97),
                        x -> x.multiply(x),
                        x -> x.mod(BigInteger.valueOf(13)).equals(BigInteger.ZERO) ? 1 : 3,
                        new AtomicInteger()
                ),
                new Monkey(
                        toList(74),
                        x -> x.add(BigInteger.valueOf(3)),
                        x -> x.mod(BigInteger.valueOf(17)).equals(BigInteger.ZERO)? 0 : 1,
                        new AtomicInteger()
                )
        ), calculateThingie(23, 19, 13, 17));

        day11.runMonkeyRounds(
                List.of(
                        new Monkey(
                                toList(71, 86),
                                x -> x.multiply(BigInteger.valueOf(13)),
                                x -> x.mod(BigInteger.valueOf(19)).equals(BigInteger.ZERO) ? 6 : 7
                        ),
                        new Monkey(
                                toList(66, 50, 90, 53, 88, 85),
                                x -> x.add(BigInteger.valueOf(3)),
                                x -> x.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO) ? 5 : 4
                        ),
                        new Monkey(
                                toList(97, 54, 89, 62, 84, 80, 63),
                                x -> x.add(BigInteger.valueOf(6)),
                                x -> x.mod(BigInteger.valueOf(13)).equals(BigInteger.ZERO) ? 4 : 1
                        ),
                        new Monkey(
                                toList(82, 97, 56, 92),
                                x -> x.add(BigInteger.valueOf(2)),
                                x -> x.mod(BigInteger.valueOf(5)).equals(BigInteger.ZERO) ? 6 : 0
                        ),
                        new Monkey(
                                toList(50, 99, 67, 61, 86),
                                x -> x.multiply(x),
                                x -> x.mod(BigInteger.valueOf(7)).equals(BigInteger.ZERO) ? 5 : 3
                        ),
                        new Monkey(
                                toList(61, 66, 72, 55, 64, 53, 72, 63),
                                x -> x.add(BigInteger.valueOf(4)),
                                x -> x.mod(BigInteger.valueOf(11)).equals(BigInteger.ZERO) ? 3 : 0
                        ),
                        new Monkey(
                                toList(59, 79, 63),
                                x -> x.multiply(BigInteger.valueOf(7)),
                                x -> x.mod(BigInteger.valueOf(17)).equals(BigInteger.ZERO) ? 2 : 7
                        ),
                        new Monkey(
                                toList(55),
                                x -> x.add(BigInteger.valueOf(7)),
                                x -> x.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO) ? 2 : 1
                        )
                )
                , calculateThingie(19, 2, 13, 5, 7, 11, 17, 3));
    }

    private static Integer calculateThingie(Integer... values) {
        return Stream.of(values)
                .reduce((l, r) -> {
                            BigInteger a = BigInteger.valueOf(l);
                            BigInteger b = BigInteger.valueOf(r);
                            BigInteger gcd = a.gcd(b);
                            BigInteger abs = a.multiply(b).abs();
                            return abs.divide(gcd).intValue();
                        }
                );
    }

    private static List<BigInteger> toList(int... element) {
        return io.vavr.collection.List.ofAll(element)
                .map(BigInteger::valueOf)
                .asJavaMutable();
    }

    private void runMonkeyRounds(List<Monkey> testMonkeys, int thingie) {

        HashSet<Integer> printAt = HashSet.of(1, 20, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000);

        for (int i = 0; i < 10_000; i++) {
            if (printAt.contains(i)) {
                System.out.println("Round " + i);
                for (int j = 0; j < testMonkeys.size(); j++) {
                    Monkey monkey = testMonkeys.get(j);
                    System.out.println("Monkey " + j + ": " + monkey.inspectionCount.get());
                }
                System.out.println();
            }
            for (Monkey monkey : testMonkeys) {
                for (BigInteger item : monkey.items) {
                    BigInteger inspectedItem = monkey.operation.apply(item).mod(BigInteger.valueOf(thingie));

                    Integer apply = monkey.inspect(inspectedItem);
                    testMonkeys.get(apply).items.add(inspectedItem);
                }
                monkey.items.clear();
            }
        }


        Number product = Stream.ofAll(testMonkeys).map(m -> m.inspectionCount.get())
                .sorted()
                .reverse()
                .take(2)
                .product();

        System.out.println(product);


    }


    record Monkey(List<BigInteger> items,
                  Function1<BigInteger, BigInteger> operation,
                  Function1<BigInteger, Integer> test,
                  AtomicInteger inspectionCount) {

        Monkey(List<BigInteger> items, Function1<BigInteger, BigInteger> operation, Function1<BigInteger, Integer> test) {
            this(
                    items,
                    operation,
                    test,
                    new AtomicInteger());
        }

        private Integer inspect(BigInteger inspectedItem) {
            inspectionCount.incrementAndGet();
            return test.apply(inspectedItem);
        }
    }

}
