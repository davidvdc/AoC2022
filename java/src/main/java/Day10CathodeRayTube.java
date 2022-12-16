import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Stream;

public class Day10CathodeRayTube {

    public static void main(String[] args) {
        String testInput = "noop\n" +
                "addx 3\n" +
                "addx -5\n";
        String testInput2 = "addx 15\n" +
                "addx -11\n" +
                "addx 6\n" +
                "addx -3\n" +
                "addx 5\n" +
                "addx -1\n" +
                "addx -8\n" +
                "addx 13\n" +
                "addx 4\n" +
                "noop\n" +
                "addx -1\n" +
                "addx 5\n" +
                "addx -1\n" +
                "addx 5\n" +
                "addx -1\n" +
                "addx 5\n" +
                "addx -1\n" +
                "addx 5\n" +
                "addx -1\n" +
                "addx -35\n" +
                "addx 1\n" +
                "addx 24\n" +
                "addx -19\n" +
                "addx 1\n" +
                "addx 16\n" +
                "addx -11\n" +
                "noop\n" +
                "noop\n" +
                "addx 21\n" +
                "addx -15\n" +
                "noop\n" +
                "noop\n" +
                "addx -3\n" +
                "addx 9\n" +
                "addx 1\n" +
                "addx -3\n" +
                "addx 8\n" +
                "addx 1\n" +
                "addx 5\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "addx -36\n" +
                "noop\n" +
                "addx 1\n" +
                "addx 7\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "addx 2\n" +
                "addx 6\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "addx 1\n" +
                "noop\n" +
                "noop\n" +
                "addx 7\n" +
                "addx 1\n" +
                "noop\n" +
                "addx -13\n" +
                "addx 13\n" +
                "addx 7\n" +
                "noop\n" +
                "addx 1\n" +
                "addx -33\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "addx 2\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "addx 8\n" +
                "noop\n" +
                "addx -1\n" +
                "addx 2\n" +
                "addx 1\n" +
                "noop\n" +
                "addx 17\n" +
                "addx -9\n" +
                "addx 1\n" +
                "addx 1\n" +
                "addx -3\n" +
                "addx 11\n" +
                "noop\n" +
                "noop\n" +
                "addx 1\n" +
                "noop\n" +
                "addx 1\n" +
                "noop\n" +
                "noop\n" +
                "addx -13\n" +
                "addx -19\n" +
                "addx 1\n" +
                "addx 3\n" +
                "addx 26\n" +
                "addx -30\n" +
                "addx 12\n" +
                "addx -1\n" +
                "addx 3\n" +
                "addx 1\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "addx -9\n" +
                "addx 18\n" +
                "addx 1\n" +
                "addx 2\n" +
                "noop\n" +
                "noop\n" +
                "addx 9\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "addx -1\n" +
                "addx 2\n" +
                "addx -37\n" +
                "addx 1\n" +
                "addx 3\n" +
                "noop\n" +
                "addx 15\n" +
                "addx -21\n" +
                "addx 22\n" +
                "addx -6\n" +
                "addx 1\n" +
                "noop\n" +
                "addx 2\n" +
                "addx 1\n" +
                "noop\n" +
                "addx -10\n" +
                "noop\n" +
                "noop\n" +
                "addx 20\n" +
                "addx 1\n" +
                "addx 2\n" +
                "addx 2\n" +
                "addx -6\n" +
                "addx -11\n" +
                "noop\n" +
                "noop\n" +
                "noop\n";
        Day10CathodeRayTube day10 = new Day10CathodeRayTube();
        day10.signalStrenths(testInput2);
        String mainInput = "addx 2\n" +
                "addx 3\n" +
                "addx 3\n" +
                "addx -2\n" +
                "addx 4\n" +
                "noop\n" +
                "addx 1\n" +
                "addx 4\n" +
                "addx 1\n" +
                "noop\n" +
                "addx 4\n" +
                "addx 1\n" +
                "noop\n" +
                "addx 2\n" +
                "addx 5\n" +
                "addx -28\n" +
                "addx 30\n" +
                "noop\n" +
                "addx 5\n" +
                "addx 1\n" +
                "noop\n" +
                "addx -38\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "addx 5\n" +
                "addx 5\n" +
                "addx 3\n" +
                "addx 2\n" +
                "addx -2\n" +
                "addx 2\n" +
                "noop\n" +
                "noop\n" +
                "addx -2\n" +
                "addx 12\n" +
                "noop\n" +
                "addx 2\n" +
                "addx 3\n" +
                "noop\n" +
                "addx 2\n" +
                "addx -31\n" +
                "addx 32\n" +
                "addx 7\n" +
                "noop\n" +
                "addx -2\n" +
                "addx -37\n" +
                "addx 1\n" +
                "addx 5\n" +
                "addx 1\n" +
                "noop\n" +
                "addx 31\n" +
                "addx -25\n" +
                "addx -10\n" +
                "addx 13\n" +
                "noop\n" +
                "noop\n" +
                "addx 18\n" +
                "addx -11\n" +
                "addx 3\n" +
                "noop\n" +
                "noop\n" +
                "addx 1\n" +
                "addx 4\n" +
                "addx -32\n" +
                "addx 15\n" +
                "addx 24\n" +
                "addx -2\n" +
                "noop\n" +
                "addx -37\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "addx 5\n" +
                "addx 5\n" +
                "addx 21\n" +
                "addx -20\n" +
                "noop\n" +
                "addx 6\n" +
                "addx 19\n" +
                "addx -5\n" +
                "addx -8\n" +
                "addx -22\n" +
                "addx 26\n" +
                "addx -22\n" +
                "addx 23\n" +
                "addx 2\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "addx 8\n" +
                "addx -10\n" +
                "addx -27\n" +
                "addx 33\n" +
                "addx -27\n" +
                "noop\n" +
                "addx 34\n" +
                "addx -33\n" +
                "addx 2\n" +
                "addx 19\n" +
                "addx -12\n" +
                "addx 11\n" +
                "addx -20\n" +
                "addx 12\n" +
                "addx 18\n" +
                "addx -11\n" +
                "addx -14\n" +
                "addx 15\n" +
                "addx 2\n" +
                "noop\n" +
                "addx 3\n" +
                "addx 2\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "addx -33\n" +
                "noop\n" +
                "addx 1\n" +
                "addx 2\n" +
                "noop\n" +
                "addx 3\n" +
                "addx 4\n" +
                "noop\n" +
                "addx 1\n" +
                "addx 2\n" +
                "noop\n" +
                "noop\n" +
                "addx 7\n" +
                "addx 1\n" +
                "noop\n" +
                "addx 4\n" +
                "addx -17\n" +
                "addx 18\n" +
                "addx 5\n" +
                "addx -1\n" +
                "addx 5\n" +
                "addx 1\n" +
                "noop\n" +
                "noop\n" +
                "noop\n" +
                "noop\n";
        day10.signalStrenths(mainInput);
    }


    private void signalStrenths(String input) {
        Stream<Tuple2<Integer, Integer>> stream = Stream.ofAll(input.lines())
                .flatMap(line ->
                        switch (line.substring(0, 4)) {
                            case "noop" -> List.of(0);
                            case "addx" -> List.of(0, Integer.parseInt(line.substring(5)));
                            default -> throw new RuntimeException();
                        }
                ).scanLeft(1, Integer::sum)
                .zipWithIndex()
                .map(x -> x.swap().map1(y -> y + 1));

        stream
                .sliding(40, 40)
                .forEach(line -> {
                    line.forEach(pixel -> {
                        Integer pixelPosition = (pixel._1 % 40) - 1;
                        Integer spritePosition = pixel._2;
                        if (Math.abs(pixelPosition - spritePosition) <= 1) {
                            System.out.print("#");
                        } else {
                            System.out.print(" ");
                        }

                    });
                    System.out.println();
                });

    }
}
