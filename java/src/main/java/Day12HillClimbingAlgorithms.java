import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import io.vavr.collection.Stream;
import io.vavr.control.Option;

public class Day12HillClimbingAlgorithms {

    public static void main(String[] args) {
        Day12HillClimbingAlgorithms day12 = new Day12HillClimbingAlgorithms();
        String testInput = "Sabqponm\n" +
                "abcryxxl\n" +
                "accszExk\n" +
                "acctuvwj\n" +
                "abdefghi";
//        day12.findPath(testInput);

        String mainInput="abcccaaaaacccacccccccccccccccccccccccccccccccccccccccccccccccccccccccaaaaaacaccccccaaacccccccccccccccccccccccccccccccccccaaaaaaaaccccccccccccccccccccccccccccccccaaaaaa\n" +
                "abcccaaaaacccaaacaaacccccccccccccccccaaccccccacccaacccccccccccaacccccaaaaaaaaaaaccaaaaaaccccccccccccccccccccccccccccccccccaaaaaccccccccccccccccccccccccccccccccccaaaaaa\n" +
                "abccccaaaaaccaaaaaaaccccccccccccccaaaacccccccaacaaacccccccccaaaaaacccaaaaaaaaaaaccaaaaaacccccccccccccccccccccccccccccccccccaaaaaccccccccccccccaaacccccccccccccccccaaaaa\n" +
                "abccccaacccccaaaaaacccccccccccccccaaaaaacccccaaaaaccccccccccaaaaaacaaaaaaaaaaaaaccaaaaaacccccccccccccccccccccccccccccccccccaacaaccccccccccccccaaaaccccccccccccccccccaaa\n" +
                "abccccccccccaaaaaaaacccccccccccaaccaaaaaccccccaaaaaacccccccccaaaaacaaaaaaaaccccccccaaaaacccccccccccccccccccccccccccccccccccaacccccccccccccccccaaaaccaaacccccccccccccaac\n" +
                "abaaaaaccccaaaaaaaaaaccccccaaccaacaaaaacccccaaaaaaaaaaacccccaaaaacaaaacaaaaacccccccaacaacccccccccccccccccccccccccccccccccccccccccccccccccccccccaaaaaaaaacccccccccccaaac\n" +
                "abaaaaaccccaaaaaaaaaacaacccaaaaaacaccaacccccaaaaaaaaaaacccccaaaaaccccccaaaaaccccccccccaacccccccccccccccccccccccccccccccccccccccccccccccccccccccaaaakkkllccccccccccccccc\n" +
                "abaaaaacccccccaaacaaaaaaccccaaaaaaaccccccaaacccaacccaaaaaaacccccccccccccaaaaacccccccccaaaaaaccccccccccccccccccccccccccaaccccccccccccccccccccccackkkkkklllccccaaaccccccc\n" +
                "abaaaaacccccccaaacaaaaaaacccaaaaaaaccccccaaaacaaacaaaaaaaacccccccccccccaaaaaacccccccccaaaaaaccaacaacccccccccccccccaaaaaacccccccccccccccccccaaakkkkkkkkllllcccaaacaccccc\n" +
                "abaaaaaccccccccaacaaaaaaaacaaaaaaccccccccaaaaaaacaaaaaaaaacccccccccccccaaaacccccccccaaaaaaacccaaaaacccccccccccccccaaaaaaccccccccccccccccjjjjjkkkkkkpppplllcccaaaaaacccc\n" +
                "abaaaccccccccccccccaaaaaaacaaaaaacccccccccaaaaaaccaaaaaaaccccccccccccccccaaaccccccccaaaaaaaccccaaaaacccccccccccccccaaaaaaaccccaaccccccjjjjjjjkkkkppppppplllcccaaaaacccc\n" +
                "abccccccccccccccccaaaaaacccccccaaccccccaaaaaaaacccccaaaaaaccccccccccccccccccccccccccccaaaaaaccaaaaaacccccccccccccccaaaaaaaaaacaacccccjjjjjjjjjkooppppppplllcccaaacccccc\n" +
                "abccccccccccccccccaaaaaacccccccccccccccaaaaaaaaacccaaacaaacccccccccccccccccccccccaaaccaaccaaccaaaaccccccccccccccccaaaaaaaccaaaaaccccjjjjooooooooopuuuupppllccccaaaccccc\n" +
                "abccccccccccccccccccccaaccccccccccccccccaaaaaaaacccaaaccaacccccccccccccccccccccccaaaaaaacccccccaaaccccccccccccccccaaaaaaccccaaaaaaccjjjoooooooooouuuuuupplllccccaaccccc\n" +
                "abccaaaaccccaaacccccccccccccccccccccccccccaaaaaaaccaaccccccccccccaacccccccccccccccaaaaacccaaccaaaccccccccccccccccccccaaacccaaaaaaaccjjjoootuuuuuuuuuuuuppllllccccaccccc\n" +
                "abccaaaaaccaaaacccccccccccccccccccccccccccaacccacccccccccccccccacaaaacccccccccccaaaaaaacccaaaaaaacccccccccccccccccccccccccaaaaaacccciijnoottuuuuuuxxyuvpqqlmmcccccccccc\n" +
                "abcaaaaaaccaaaacccccccaaaaccccccccccacccccaaccccaaaccccccccccccaaaaaacccccccccccaaaaaaaaccaaaaaacccccccccccccccccaacccccccaacaaacccciiinntttxxxxuxxyyvvqqqqmmmmddddcccc\n" +
                "abcaaaaaacccaaacccccccaaaaccccaaaaaaaaccaaaaccccaacaacccccccccccaaaaccccccccccccaaaaaaaacccaaaaaaaacccccccccccccaaaaccccccccccaacccciiinntttxxxxxxxyyvvqqqqqmmmmdddcccc\n" +
                "abcaaaaaacccccccccccccaaaacccccaaaaaacccaaaaaaaaaaaaacccccccccccaaaaccccccccccccccaaacacccaaaaaaaaacccccccccccccaaaacccccccccccccccciiinnnttxxxxxxxyyvvvvqqqqmmmdddcccc\n" +
                "abcccaaccccccccccccccccaaccccccaaaaaacccaaaaaaaaaaaaaaccccccccccaacaccccccccccccccaaaccccaaaaaaaaaacccccccccccccaaaacccccccccccccccciiinnntttxxxxxyyyyyvvvqqqqmmmdddccc\n" +
                "SbccccccccccccccccccccccccccccaaaaaaaaccaaaccaaaaaaaaacccccccccccccccccccccccccccccccccccaaaaaaacccccccccaacccccccccccccccccccccccccciiinntttxxxxEzyyyyyvvvqqqmmmdddccc\n" +
                "abcccccccccccccccccccccccccccaaaaaaaaaacccccccaaaaaacccccccccccccaaacccccaacaacccccccccccccccaaaaaaccccccaacaaacccccccccccccccccccccciiinntttxxxyyyyyyyvvvvqqqmmmdddccc\n" +
                "abcccccccccccccccccccccccccccaaaaaaaaaaccccccaaaaaaaaccccccccccccaaaccccccaaaacccccccccccccccaaaaaaccccccaaaaacccccccccccccccccccccciiinnnttxxyyyyyyyvvvvvqqqqmmmdddccc\n" +
                "abcccccccccccccccccccccccccccacacaaacccccccccaaaaaaacccccccccccaaaaaaaacccaaaaacccccccccccccccaaaaaaaacaaaaaaccccccccccccccccccccccciiinntttxxwyyyyywwvvrrrqqmmmdddcccc\n" +
                "abaccccccccccccccccccccccccccccccaaacccccccccaaacaaaaacccccccccaaaaaaaaccaaaaaacccccccccccccccaaaaaaaacaaaaaaacccccccccccccccccccccchhnnnttwwwwwwwyyywvrrrrnnnnmdddcccc\n" +
                "abaccccccccccccccccccccccccccccccaaccccccccccccccaaaaaacccccccccaaaaaccccaaaacaccccccccccccccccaaaaacccccaaaaaaccccccaaaccccccaaaccchhnmmttswwwwwwywwwrrrrnnnnneeeccccc\n" +
                "abaccccccccccccccccccccccccccccccccccccccccccccccaaaaaacccccaaccaaaaaacccccaaccccccccccccccccccaaaaaaccccaaccaaccccaaaaaacccccaaacahhhmmmsssssssswwwwwrrrnnnneeeecccccc\n" +
                "abaaaccccccccccccccccccccccccccccaaaccccccccccccccaaaaaccccaaaccaaaaaacccccccccccccccccccccccccaaaaaaccccaaccccccccaaaaaacccaaaaaaahhhmmmmsssssssswwwwrrnnnneeeeacccccc\n" +
                "abaaaccccccccccccccccccccccccccccaaaaaaccccccccccaaaaacaaaaaaaccaaaccaccccccccaaaaaccccccccccccaaaacacccccccccccccccaaaaacccaaaaaaahhhhmmmmssssssswwwwrrnnneeeeaacccccc\n" +
                "abaaacccccccccccccccccccccccccccaaaaaaaccccccccccaaaaacaaaaaaaaaacccaaaaacccccaaaaacccccccccacaaaaaccacccccccccccccaaaaacccccaaaaaachhhmmmmmmmmmsssrrrrrnnneeeaaaaacccc\n" +
                "abaccccccccccccccaaaaccccccccccaaaaaaaacccccccccccccccccaaaaaaaaacccaaaaaccccaaaaaacccccccccaaaaaaaaaacccccccccccccaaaaaccccccaaaaachhhhmmmmmmmooossrrronneeeaaaaaacccc\n" +
                "abaccccccccccccccaaaaccccccccccaaaaaaacccccccccccccccccccaaaaaaaccccaaaaaacccaaaaaaccccaaaccaaaaaaaaaacccccccccccaaccccccccccaaaaaacchhhhhggggooooorrroonnfeeaaaaaccccc\n" +
                "abcccccccccccccccaaaaccccccccccccaaaaaacccccccccccccccccaaaaaaccccccaaaaaacccaaaaaaccccaaaaaacaaaaaacccccccccaaccaacccccccccccaacccccchhhhggggggoooooooooffeaaaaacccccc\n" +
                "abccccccccccccccccaacccccccccccccaaaaaacccccccaaccacccccaaaaaaacccccaaaaaaccccaaaccccccaaaaaacaaaaaacccccccccaaaaacccccccccccccccccccccccgggggggggooooooffffaaaaaaccccc\n" +
                "abccccccccccccccccccccccccccaaaccaacccccccccccaaaaacccccaaccaaacccccccaaacccccccccccccaaaaaaacaaaaaacccccccccaaaaaaaaccccccccccccccccccccccaaaggggfooooffffccccaacccccc\n" +
                "abaaccccccccccccccccccccccccaaacaccccccccccccaaaaacccccccccccaacccccccaaaacccaacccccccaaaaaaaaaaaaaaaccccccccccaaaaacccccccccccccaaaccccccccccccggfffffffffcccccccccccc\n" +
                "abaaccccccccccccccccccccccaacaaaaacccccccccccaaaaaacccccccccccccccccccaaaacaaaacccccccaaaaaaaaaccccaccccccccccaaaaaccccccccccccccaaaccccccccccccagfffffffccccccccccccca\n" +
                "abaacccccccaacccccccccccccaaaaaaaaccccccaacccccaaaacccccccccccccccccccaaaaaaaaacccccccccaaacaacaaacccccccccccaaacaaccccaaccaaccaaaaaaaaccccccccaaaccffffcccccccccccccaa\n" +
                "abaaaaaaaccaaccccccccccccccaaaaacccccccaaaacccaaccccccccccccccccccacaaaaaaaaaaccccccccccaaacaaaaaacccccccccccccccaaccccaaaaaaccaaaaaaaacccccccccaacccccccccccccccaaacaa\n" +
                "abaaaaaaaaaaccccccccccccccccaaaaaccccccaaaacccccccccccccccccccccccaaaaaaaaaaaaccccccccccccccaaaaaacccccccccccccccccccccaaaaaacccaaaaaacccccccccaaacccccccccccccccaaaaaa\n" +
                "abaaaacaaaaaaaacccccccccccccaacaaccccccaaaaccccccccccccccccccccccccaaaaaaaaaaacccccccccccccaaaaaaaacccccccccccccccccccaaaaaaaaccaaaaaaccccccccccccccccccccccccccccaaaaa\n";
        day12.findPath(mainInput);
    }


    record Position(Integer i, Integer j) {

        public Position goLeft() {
            return new Position(i - 1, j);
        }

        public Position goUp() {
            return new Position(i, j + 1);
        }

        public Position goRight() {
            return new Position(i + 1, j);
        }

        public Position goDown() {
            return new Position(i, j - 1);
        }
    }

    private void findPath(String input) {
        Grid grid = new Grid(List.ofAll(input.lines())
                .map(line -> List.ofAll(line.toCharArray())));

        Navigator visitor = new Navigator(grid);
        System.out.println(visitor.walkUntilFinished());
    }

    record Grid(List<List<Character>> grid) {

        public Position findStartPosition() {
            return findPositionOf('S');
        }

        public Position findEndPosition() {
            return findPositionOf('E');
        }

        private Position findPositionOf(char e) {
            for (int i = 0; i < grid.size(); i++) {
                for (int j = 0; j < grid.get(i).size(); j++) {
                    if (grid.get(i).get(j) == e) {
                        return new Position(i, j);
                    }
                }
            }
            throw new RuntimeException();
        }


        public Option<Character> heightOf(Position position) {
            if (position.i < 0 || position.i >= grid.size() || position.j < 0 || position.j >= grid.get(position.i).size()) {
                return Option.none();
            }
            return Option.some(valueOf(position))
                    .map(height -> switch (height) {
                        case 'E' -> 'z';
                        case 'S' -> 'a';
                        default -> height;
                    });
        }

        private Character valueOf(Position position) {
            return grid.get(position.i).get(position.j);
        }

        public List<Position> findAllOf(char character) {
            return Stream.range(0, grid.size())
                    .flatMap(i -> Stream.range(0, grid.get(i).size()).map(j -> new Position(i,j)))
                    .filter(pos -> valueOf(pos) == character)
                    .toList();
        }
    }

    public static class Navigator {
        private final Position endPosition;
        Set<Position> activePositions;
        Set<Position> visited;

        Grid grid;

        public Navigator(Grid grid) {
            activePositions = HashSet.of(grid.findStartPosition()).addAll(grid.findAllOf('a'));
            endPosition = grid.findEndPosition();
            this.grid = grid;
            visited = HashSet.empty();
        }

        public int walkUntilFinished() {
            printState();
            for (int i = 1; i < 10000; i++) {
                takeStep();
                printState();
                if(hasReachedEnd()) {
                    return i;
                }
            }
            throw new RuntimeException("Reached 10000 iterations without finding the end");
        }

        private void printState() {
            System.out.println();
            for (int i = 0; i < grid.grid.size(); i++) {
                for (int j = 0; j < grid.grid.get(i).size(); j++) {
                    Position pos = new Position(i, j);
                    if(activePositions.contains(pos)) {
                        System.out.print("#");
                    } else if(visited.contains(pos)){
                        System.out.print(".");
                    } else {
                        System.out.print(grid.valueOf(pos));
                    }
                }
                System.out.println();
            }
        }

        public void takeStep() {
            visited = visited.addAll(activePositions);
            activePositions = activePositions
                    .flatMap(pos ->
                            allNextPossibleStepsFrom(pos)
                                    .removeAll(visited)
                    );
        }

        public boolean hasReachedEnd() {
           return activePositions.contains(endPosition);
        }

        public HashSet<Position> allNextPossibleStepsFrom(Position position) {
            final Character currentHeight = grid.heightOf(position).get();
            return HashSet.of(position.goLeft(),
                            position.goUp(),
                            position.goRight(),
                            position.goDown())
                    .flatMap(pos -> grid.heightOf(pos)
                            .filter(height -> height - currentHeight <= 1)
                            .isDefined() ? Option.some(pos) : Option.none());

        }

    }


}
