import io.vavr.collection.*;
import io.vavr.control.Option;

public class Day5SupplyStacks {

    public static void main(String[] args) {
        String testInput=
                """
                            [D]   \s
                        [N] [C]   \s
                        [Z] [M] [P]
                         1   2   3\s

                        move 1 from 2 to 1
                        move 3 from 1 to 3
                        move 2 from 2 to 1
                        move 1 from 1 to 2""";
        Day5SupplyStacks.operateCrane(testInput);


        String mainInput = "    [C]             [L]         [T]\n" +
                "    [V] [R] [M]     [T]         [B]\n" +
                "    [F] [G] [H] [Q] [Q]         [H]\n" +
                "    [W] [L] [P] [V] [M] [V]     [F]\n" +
                "    [P] [C] [W] [S] [Z] [B] [S] [P]\n" +
                "[G] [R] [M] [B] [F] [J] [S] [Z] [D]\n" +
                "[J] [L] [P] [F] [C] [H] [F] [J] [C]\n" +
                "[Z] [Q] [F] [L] [G] [W] [H] [F] [M]\n" +
                " 1   2   3   4   5   6   7   8   9 \n" +
                "\n" +
                "move 1 from 5 to 6\n" +
                "move 5 from 6 to 7\n" +
                "move 10 from 7 to 3\n" +
                "move 4 from 8 to 4\n" +
                "move 2 from 5 to 4\n" +
                "move 4 from 3 to 6\n" +
                "move 6 from 2 to 4\n" +
                "move 8 from 6 to 9\n" +
                "move 5 from 9 to 2\n" +
                "move 7 from 2 to 7\n" +
                "move 2 from 1 to 4\n" +
                "move 3 from 3 to 8\n" +
                "move 1 from 5 to 9\n" +
                "move 1 from 3 to 8\n" +
                "move 1 from 1 to 2\n" +
                "move 11 from 4 to 6\n" +
                "move 2 from 5 to 6\n" +
                "move 10 from 9 to 1\n" +
                "move 4 from 8 to 3\n" +
                "move 7 from 7 to 1\n" +
                "move 9 from 1 to 2\n" +
                "move 1 from 6 to 5\n" +
                "move 1 from 5 to 9\n" +
                "move 5 from 3 to 8\n" +
                "move 2 from 9 to 1\n" +
                "move 5 from 3 to 9\n" +
                "move 3 from 6 to 8\n" +
                "move 5 from 9 to 6\n" +
                "move 6 from 6 to 3\n" +
                "move 3 from 3 to 2\n" +
                "move 1 from 9 to 8\n" +
                "move 13 from 2 to 3\n" +
                "move 3 from 8 to 1\n" +
                "move 11 from 1 to 4\n" +
                "move 3 from 4 to 1\n" +
                "move 2 from 6 to 5\n" +
                "move 4 from 6 to 8\n" +
                "move 17 from 3 to 9\n" +
                "move 1 from 1 to 8\n" +
                "move 1 from 6 to 5\n" +
                "move 1 from 3 to 7\n" +
                "move 1 from 7 to 4\n" +
                "move 3 from 4 to 1\n" +
                "move 1 from 3 to 8\n" +
                "move 4 from 8 to 1\n" +
                "move 3 from 5 to 9\n" +
                "move 1 from 6 to 4\n" +
                "move 4 from 4 to 8\n" +
                "move 2 from 8 to 4\n" +
                "move 2 from 1 to 6\n" +
                "move 4 from 8 to 6\n" +
                "move 1 from 8 to 3\n" +
                "move 6 from 6 to 3\n" +
                "move 6 from 3 to 9\n" +
                "move 6 from 1 to 4\n" +
                "move 5 from 8 to 4\n" +
                "move 1 from 3 to 6\n" +
                "move 3 from 1 to 7\n" +
                "move 1 from 6 to 7\n" +
                "move 4 from 4 to 5\n" +
                "move 24 from 9 to 5\n" +
                "move 2 from 9 to 1\n" +
                "move 27 from 5 to 7\n" +
                "move 13 from 7 to 2\n" +
                "move 1 from 5 to 9\n" +
                "move 7 from 2 to 7\n" +
                "move 1 from 9 to 8\n" +
                "move 5 from 2 to 8\n" +
                "move 1 from 2 to 5\n" +
                "move 1 from 5 to 7\n" +
                "move 21 from 4 to 1\n" +
                "move 1 from 4 to 6\n" +
                "move 1 from 6 to 5\n" +
                "move 22 from 7 to 5\n" +
                "move 2 from 7 to 8\n" +
                "move 7 from 5 to 4\n" +
                "move 1 from 4 to 5\n" +
                "move 2 from 7 to 9\n" +
                "move 5 from 5 to 2\n" +
                "move 5 from 4 to 2\n" +
                "move 3 from 5 to 1\n" +
                "move 7 from 8 to 7\n" +
                "move 1 from 4 to 1\n" +
                "move 23 from 1 to 8\n" +
                "move 2 from 9 to 4\n" +
                "move 11 from 8 to 3\n" +
                "move 3 from 1 to 3\n" +
                "move 1 from 4 to 2\n" +
                "move 12 from 3 to 2\n" +
                "move 7 from 7 to 3\n" +
                "move 3 from 2 to 1\n" +
                "move 1 from 4 to 9\n" +
                "move 1 from 1 to 3\n" +
                "move 9 from 8 to 6\n" +
                "move 2 from 5 to 4\n" +
                "move 3 from 1 to 7\n" +
                "move 3 from 2 to 4\n" +
                "move 7 from 2 to 3\n" +
                "move 9 from 3 to 4\n" +
                "move 7 from 5 to 2\n" +
                "move 2 from 7 to 2\n" +
                "move 1 from 7 to 2\n" +
                "move 13 from 4 to 6\n" +
                "move 1 from 9 to 8\n" +
                "move 2 from 8 to 2\n" +
                "move 12 from 2 to 1\n" +
                "move 3 from 3 to 1\n" +
                "move 1 from 8 to 1\n" +
                "move 5 from 3 to 7\n" +
                "move 3 from 2 to 8\n" +
                "move 7 from 2 to 5\n" +
                "move 3 from 8 to 3\n" +
                "move 1 from 4 to 8\n" +
                "move 22 from 6 to 4\n" +
                "move 1 from 3 to 6\n" +
                "move 3 from 5 to 8\n" +
                "move 4 from 5 to 8\n" +
                "move 1 from 3 to 9\n" +
                "move 8 from 4 to 2\n" +
                "move 8 from 8 to 3\n" +
                "move 1 from 6 to 3\n" +
                "move 4 from 2 to 6\n" +
                "move 1 from 9 to 4\n" +
                "move 5 from 3 to 9\n" +
                "move 2 from 8 to 1\n" +
                "move 3 from 2 to 1\n" +
                "move 10 from 4 to 8\n" +
                "move 4 from 7 to 6\n" +
                "move 10 from 1 to 3\n" +
                "move 9 from 8 to 2\n" +
                "move 1 from 7 to 1\n" +
                "move 15 from 3 to 1\n" +
                "move 1 from 8 to 9\n" +
                "move 4 from 4 to 1\n" +
                "move 17 from 1 to 3\n" +
                "move 3 from 2 to 3\n" +
                "move 3 from 6 to 8\n" +
                "move 5 from 9 to 7\n" +
                "move 11 from 1 to 8\n" +
                "move 4 from 7 to 8\n" +
                "move 6 from 2 to 5\n" +
                "move 2 from 1 to 4\n" +
                "move 4 from 6 to 8\n" +
                "move 16 from 8 to 6\n" +
                "move 2 from 6 to 1\n" +
                "move 1 from 9 to 5\n" +
                "move 1 from 7 to 5\n" +
                "move 2 from 5 to 6\n" +
                "move 5 from 6 to 3\n" +
                "move 2 from 8 to 5\n" +
                "move 1 from 2 to 1\n" +
                "move 10 from 6 to 3\n" +
                "move 6 from 5 to 9\n" +
                "move 2 from 1 to 2\n" +
                "move 2 from 4 to 2\n" +
                "move 1 from 2 to 4\n" +
                "move 5 from 9 to 2\n" +
                "move 1 from 4 to 3\n" +
                "move 1 from 9 to 7\n" +
                "move 1 from 6 to 1\n" +
                "move 1 from 1 to 7\n" +
                "move 2 from 7 to 5\n" +
                "move 7 from 2 to 5\n" +
                "move 6 from 5 to 1\n" +
                "move 1 from 2 to 3\n" +
                "move 1 from 4 to 1\n" +
                "move 2 from 8 to 9\n" +
                "move 8 from 1 to 3\n" +
                "move 2 from 5 to 3\n" +
                "move 29 from 3 to 9\n" +
                "move 5 from 3 to 8\n" +
                "move 6 from 8 to 5\n" +
                "move 1 from 6 to 5\n" +
                "move 6 from 3 to 2\n" +
                "move 2 from 2 to 4\n" +
                "move 1 from 1 to 7\n" +
                "move 18 from 9 to 6\n" +
                "move 2 from 2 to 9\n" +
                "move 2 from 2 to 8\n" +
                "move 13 from 6 to 8\n" +
                "move 1 from 7 to 4\n" +
                "move 3 from 5 to 6\n" +
                "move 1 from 5 to 7\n" +
                "move 1 from 7 to 4\n" +
                "move 14 from 9 to 3\n" +
                "move 3 from 4 to 5\n" +
                "move 1 from 9 to 7\n" +
                "move 14 from 3 to 2\n" +
                "move 1 from 7 to 3\n" +
                "move 4 from 2 to 5\n" +
                "move 16 from 8 to 6\n" +
                "move 11 from 6 to 9\n" +
                "move 13 from 6 to 4\n" +
                "move 5 from 5 to 2\n" +
                "move 12 from 2 to 4\n" +
                "move 19 from 4 to 3\n" +
                "move 7 from 4 to 5\n" +
                "move 14 from 5 to 2\n" +
                "move 2 from 3 to 6\n" +
                "move 3 from 9 to 5\n" +
                "move 2 from 6 to 2\n" +
                "move 1 from 5 to 2\n" +
                "move 3 from 5 to 4\n" +
                "move 3 from 4 to 1\n" +
                "move 7 from 9 to 6\n" +
                "move 4 from 6 to 1\n" +
                "move 1 from 1 to 8\n" +
                "move 3 from 6 to 9\n" +
                "move 1 from 8 to 7\n" +
                "move 1 from 9 to 6\n" +
                "move 4 from 1 to 2\n" +
                "move 1 from 7 to 2\n" +
                "move 2 from 9 to 8\n" +
                "move 10 from 2 to 9\n" +
                "move 2 from 2 to 9\n" +
                "move 11 from 3 to 7\n" +
                "move 1 from 8 to 9\n" +
                "move 2 from 3 to 7\n" +
                "move 1 from 1 to 7\n" +
                "move 10 from 2 to 4\n" +
                "move 3 from 4 to 1\n" +
                "move 4 from 1 to 8\n" +
                "move 1 from 6 to 5\n" +
                "move 6 from 7 to 9\n" +
                "move 3 from 9 to 1\n" +
                "move 1 from 5 to 1\n" +
                "move 4 from 4 to 2\n" +
                "move 5 from 2 to 1\n" +
                "move 1 from 2 to 7\n" +
                "move 2 from 7 to 6\n" +
                "move 1 from 2 to 1\n" +
                "move 2 from 9 to 1\n" +
                "move 3 from 4 to 7\n" +
                "move 1 from 3 to 7\n" +
                "move 2 from 8 to 3\n" +
                "move 2 from 6 to 5\n" +
                "move 2 from 5 to 8\n" +
                "move 10 from 7 to 2\n" +
                "move 6 from 9 to 1\n" +
                "move 1 from 7 to 3\n" +
                "move 2 from 8 to 9\n" +
                "move 7 from 3 to 7\n" +
                "move 7 from 3 to 9\n" +
                "move 1 from 8 to 9\n" +
                "move 6 from 2 to 8\n" +
                "move 13 from 9 to 1\n" +
                "move 6 from 9 to 8\n" +
                "move 2 from 2 to 7\n" +
                "move 3 from 7 to 1\n" +
                "move 1 from 8 to 1\n" +
                "move 1 from 1 to 6\n" +
                "move 16 from 1 to 4\n" +
                "move 2 from 7 to 5\n" +
                "move 12 from 4 to 9\n" +
                "move 4 from 8 to 6\n" +
                "move 2 from 5 to 1\n" +
                "move 8 from 8 to 4\n" +
                "move 2 from 4 to 5\n" +
                "move 1 from 8 to 6\n" +
                "move 4 from 6 to 8\n" +
                "move 19 from 1 to 9\n" +
                "move 3 from 8 to 5\n" +
                "move 1 from 6 to 9\n" +
                "move 2 from 2 to 1\n" +
                "move 10 from 4 to 9\n" +
                "move 1 from 1 to 2\n" +
                "move 2 from 1 to 5\n" +
                "move 4 from 7 to 9\n" +
                "move 1 from 8 to 2\n" +
                "move 1 from 2 to 6\n" +
                "move 7 from 5 to 4\n" +
                "move 11 from 9 to 8\n" +
                "move 1 from 4 to 3\n" +
                "move 10 from 8 to 1\n" +
                "move 1 from 2 to 3\n" +
                "move 29 from 9 to 3\n" +
                "move 2 from 6 to 5\n" +
                "move 1 from 5 to 3\n" +
                "move 5 from 9 to 3\n" +
                "move 1 from 8 to 9\n" +
                "move 1 from 9 to 3\n" +
                "move 6 from 4 to 6\n" +
                "move 1 from 5 to 1\n" +
                "move 1 from 6 to 3\n" +
                "move 2 from 1 to 5\n" +
                "move 1 from 9 to 5\n" +
                "move 37 from 3 to 2\n" +
                "move 3 from 6 to 2\n" +
                "move 1 from 6 to 2\n" +
                "move 1 from 6 to 4\n" +
                "move 3 from 1 to 3\n" +
                "move 2 from 1 to 6\n" +
                "move 35 from 2 to 1\n" +
                "move 1 from 6 to 8\n" +
                "move 5 from 1 to 8\n" +
                "move 7 from 1 to 6\n" +
                "move 5 from 3 to 7\n" +
                "move 1 from 8 to 7\n" +
                "move 3 from 7 to 5\n" +
                "move 4 from 2 to 9\n" +
                "move 1 from 2 to 1\n" +
                "move 1 from 4 to 3\n" +
                "move 3 from 7 to 1\n" +
                "move 1 from 3 to 6\n" +
                "move 1 from 1 to 9\n" +
                "move 5 from 9 to 2\n" +
                "move 18 from 1 to 3\n" +
                "move 6 from 1 to 8\n" +
                "move 6 from 3 to 7\n" +
                "move 4 from 8 to 6\n" +
                "move 4 from 6 to 7\n" +
                "move 9 from 7 to 8\n" +
                "move 3 from 2 to 7\n" +
                "move 4 from 6 to 1\n" +
                "move 3 from 5 to 3\n" +
                "move 3 from 2 to 5\n" +
                "move 3 from 6 to 1\n" +
                "move 4 from 7 to 4\n" +
                "move 6 from 5 to 9\n" +
                "move 3 from 1 to 9\n" +
                "move 1 from 6 to 1\n" +
                "move 15 from 8 to 2\n" +
                "move 1 from 8 to 5\n" +
                "move 3 from 4 to 8\n" +
                "move 1 from 5 to 1\n" +
                "move 1 from 6 to 5\n" +
                "move 11 from 3 to 9\n" +
                "move 12 from 2 to 3\n" +
                "move 3 from 8 to 1\n" +
                "move 15 from 1 to 2\n" +
                "move 8 from 9 to 4\n" +
                "move 8 from 4 to 9\n" +
                "move 4 from 2 to 5\n" +
                "move 1 from 4 to 6\n" +
                "move 1 from 2 to 8\n" +
                "move 1 from 6 to 7\n" +
                "move 4 from 3 to 1\n" +
                "move 1 from 8 to 5\n" +
                "move 5 from 3 to 9\n" +
                "move 14 from 9 to 2\n" +
                "move 1 from 7 to 4\n" +
                "move 4 from 1 to 3\n" +
                "move 1 from 4 to 7\n" +
                "move 8 from 3 to 7\n" +
                "move 8 from 7 to 5\n" +
                "move 1 from 7 to 9\n" +
                "move 3 from 3 to 2\n" +
                "move 7 from 9 to 8\n" +
                "move 1 from 9 to 5\n" +
                "move 2 from 8 to 5\n" +
                "move 7 from 5 to 4\n" +
                "move 4 from 9 to 2\n" +
                "move 6 from 4 to 3\n" +
                "move 18 from 2 to 5\n" +
                "move 1 from 4 to 7\n" +
                "move 15 from 5 to 4\n" +
                "move 1 from 4 to 6\n" +
                "move 2 from 2 to 7\n" +
                "move 3 from 8 to 5\n" +
                "move 1 from 7 to 3\n" +
                "move 8 from 2 to 6\n" +
                "move 4 from 2 to 3\n" +
                "move 1 from 7 to 5\n" +
                "move 3 from 4 to 6\n" +
                "move 5 from 6 to 9\n" +
                "move 8 from 5 to 6\n" +
                "move 2 from 4 to 3\n" +
                "move 7 from 4 to 2\n" +
                "move 2 from 8 to 5\n" +
                "move 7 from 5 to 6\n" +
                "move 3 from 5 to 8\n" +
                "move 1 from 8 to 9\n" +
                "move 13 from 3 to 8\n" +
                "move 2 from 2 to 7\n" +
                "move 9 from 8 to 9\n" +
                "move 6 from 8 to 5\n" +
                "move 5 from 5 to 2\n" +
                "move 2 from 7 to 8\n" +
                "move 9 from 2 to 5\n" +
                "move 1 from 7 to 5\n" +
                "move 1 from 5 to 7\n" +
                "move 21 from 6 to 2\n" +
                "move 1 from 7 to 8\n" +
                "move 3 from 8 to 9\n" +
                "move 1 from 4 to 2\n" +
                "move 23 from 2 to 7\n" +
                "move 8 from 9 to 8\n" +
                "move 20 from 7 to 4\n" +
                "move 3 from 7 to 2\n" +
                "move 1 from 2 to 7\n" +
                "move 1 from 6 to 7\n" +
                "move 3 from 5 to 4\n" +
                "move 8 from 5 to 9\n" +
                "move 2 from 7 to 1\n" +
                "move 1 from 8 to 7\n" +
                "move 4 from 2 to 4\n" +
                "move 2 from 8 to 7\n" +
                "move 2 from 8 to 2\n" +
                "move 1 from 7 to 6\n" +
                "move 3 from 9 to 7\n" +
                "move 2 from 2 to 7\n" +
                "move 5 from 7 to 1\n" +
                "move 8 from 9 to 6\n" +
                "move 15 from 4 to 3\n" +
                "move 4 from 4 to 7\n" +
                "move 6 from 1 to 4\n" +
                "move 11 from 3 to 4\n" +
                "move 8 from 6 to 1\n" +
                "move 24 from 4 to 7\n" +
                "move 6 from 1 to 8\n" +
                "move 27 from 7 to 3\n" +
                "move 2 from 7 to 8\n" +
                "move 5 from 8 to 3\n" +
                "move 4 from 8 to 4\n" +
                "move 1 from 8 to 6\n" +
                "move 1 from 6 to 9\n" +
                "move 1 from 6 to 5\n" +
                "move 2 from 4 to 2\n" +
                "move 1 from 8 to 1\n" +
                "move 1 from 5 to 2\n" +
                "move 4 from 1 to 6\n" +
                "move 1 from 7 to 5\n" +
                "move 1 from 5 to 8\n" +
                "move 1 from 8 to 7\n" +
                "move 1 from 7 to 8\n" +
                "move 1 from 8 to 1\n" +
                "move 1 from 2 to 3\n" +
                "move 2 from 4 to 8\n" +
                "move 7 from 9 to 6\n" +
                "move 2 from 8 to 1\n" +
                "move 3 from 3 to 8\n" +
                "move 3 from 1 to 8\n" +
                "move 2 from 2 to 3\n" +
                "move 1 from 4 to 1\n" +
                "move 1 from 1 to 8\n" +
                "move 5 from 8 to 3\n" +
                "move 8 from 6 to 2\n" +
                "move 1 from 9 to 4\n" +
                "move 2 from 4 to 8\n" +
                "move 2 from 8 to 3\n" +
                "move 2 from 6 to 2\n" +
                "move 33 from 3 to 2\n" +
                "move 2 from 8 to 7\n" +
                "move 1 from 6 to 1\n" +
                "move 1 from 1 to 7\n" +
                "move 2 from 3 to 8\n" +
                "move 2 from 8 to 4\n" +
                "move 1 from 4 to 8\n" +
                "move 2 from 7 to 2\n" +
                "move 2 from 3 to 7\n" +
                "move 12 from 2 to 1\n" +
                "move 1 from 8 to 4\n" +
                "move 1 from 4 to 8\n" +
                "move 1 from 4 to 3\n" +
                "move 1 from 8 to 2\n" +
                "move 3 from 7 to 2\n" +
                "move 37 from 2 to 7\n" +
                "move 1 from 1 to 7\n" +
                "move 12 from 7 to 1\n" +
                "move 13 from 1 to 7\n" +
                "move 1 from 3 to 4\n" +
                "move 35 from 7 to 6\n" +
                "move 1 from 4 to 5\n" +
                "move 3 from 7 to 4\n" +
                "move 1 from 5 to 7\n" +
                "move 2 from 3 to 4\n" +
                "move 23 from 6 to 9\n" +
                "move 3 from 1 to 5\n" +
                "move 3 from 3 to 7\n" +
                "move 1 from 3 to 6\n" +
                "move 2 from 5 to 3\n" +
                "move 23 from 9 to 8\n" +
                "move 2 from 4 to 9\n" +
                "move 16 from 8 to 2\n" +
                "move 2 from 7 to 3\n" +
                "move 1 from 5 to 8\n" +
                "move 3 from 7 to 6\n" +
                "move 1 from 9 to 8\n" +
                "move 3 from 8 to 1\n" +
                "move 1 from 9 to 1\n" +
                "move 11 from 6 to 5\n" +
                "move 2 from 4 to 1\n" +
                "move 4 from 8 to 6\n" +
                "move 16 from 2 to 3\n" +
                "move 9 from 1 to 9\n" +
                "move 1 from 8 to 4\n" +
                "move 3 from 9 to 3\n" +
                "move 1 from 1 to 4\n" +
                "move 1 from 9 to 4\n" +
                "move 7 from 5 to 2\n" +
                "move 6 from 2 to 5\n" +
                "move 1 from 8 to 6\n" +
                "move 22 from 3 to 7\n" +
                "move 8 from 5 to 8\n" +
                "move 4 from 4 to 9\n" +
                "move 2 from 1 to 8\n" +
                "move 16 from 7 to 2\n" +
                "move 1 from 3 to 5\n" +
                "move 14 from 2 to 7\n" +
                "move 2 from 2 to 4\n" +
                "move 6 from 9 to 3\n";
        operateCrane(mainInput);

    }

    private static void operateCrane(String input) {
        Stream<String> lines = Stream.ofAll(input.lines());
        Stream<String> initialStackConfig = lines
                .takeUntil(String::isEmpty);

        SortedMap<Integer, List<Character>> stacks = initialStackConfig.reverse()
                .tail() //drop column count
                .flatMap(line -> Stream.ofAll(line.toCharArray())
                        .sliding(3, 4)
                        .map(s -> s.get(1))
                        .zipWithIndex())
                .foldLeft(TreeMap.empty(Integer::compare), (acc, tup) -> {
                    Integer index = tup._2 + 1;
                    Option<List<Character>> objects = acc.get(index);
                    List<Character> arr = objects.getOrElse(List::empty);
                    if(Character.isSpaceChar(tup._1)) {
                        return acc.put(index, arr);
                    } else {
                        return acc.put(index, arr.prepend(tup._1));
                    }
                });

        System.out.println("START");
        printStack(stacks);
        System.out.println();

        Stream<String> moves = lines.takeRightUntil(String::isEmpty);
        SortedMap<Integer, List<Character>> result = moves
                .map(Move::new)
                .foldLeft(stacks, (s, move) -> move.applyBulkMove(s));




    }

    record Move(Integer times,Integer from, Integer to) {

         Move(String instruction) {
            this(instruction.split(" "));

        }
        Move(String[] s) {
            this(Integer.parseInt(s[1]),Integer.parseInt(s[3]), Integer.parseInt(s[5]));
        }

        public SortedMap<Integer, List<Character>> applyTo(SortedMap<Integer, List<Character>> stacks) {
            System.out.println(this);

            SortedMap<Integer, List<Character>> result = Stream.fill(times, this)
                    .foldLeft(stacks, (s, m) -> m.applySingleMove(s));


            printStack(result);
            return result;
        }

        SortedMap<Integer, List<Character>> applyBulkMove(SortedMap<Integer, List<Character>> stacks) {
            System.out.println(this);
            List<Character> fromStack = stacks.get(from).get();
            List<Character> toStack = stacks.get(to).get();
            List<Character> crateToMove = fromStack.take(times);
            SortedMap<Integer, List<Character>> result = stacks
                    .put(from, fromStack.drop(times))
                    .put(to, toStack.prependAll(crateToMove));
            printStack(result);
            return result;
        }

        private SortedMap<Integer, List<Character>> applySingleMove(SortedMap<Integer, List<Character>> stacks) {
            List<Character> fromStack = stacks.get(from).get();
            List<Character> toStack = stacks.get(to).get();
            Character crateToMove = fromStack.head();
            SortedMap<Integer, List<Character>> result = stacks.put(from, fromStack.tail()).put(to, toStack.prepend(crateToMove));

            return result;
        }


    }

    private static void printStack(SortedMap<Integer, List<Character>> stacks) {
        String stackString = List.of(stacks.keySet().map(s -> " " + s + " ").mkString(" ")
                ).appendAll(
                        Stream.continually(stacks.values())
                                .zipWithIndex()
                                .map(tup -> {
                                    Integer index = tup._2;
                                    Seq<List<Character>> lists = tup._1;
                                    return lists.map(l ->
                                            l.dropRight(index).lastOption().map(s -> "[" + s + "]").getOrElse("   ")
                                    ).mkString(" ");

                                }).takeWhile(l -> !l.isBlank())


                )
                .reverse()
                .mkString("\n");
        System.out.println(stackString);
    }


}
