package com.pszymczyk.abstraction.leaky;

import java.util.List;

/**
 * @author pawel szymczyk
 */
public class LeakyAbstraction {

    public static void printFruitsWithStones(List<Fruit> fruits) {

        for (Fruit fruit : fruits) {

            if (fruit.getStone() != null) {
                System.out.println(fruit.name());
            }

        }

    }

    interface Fruit {
        String name();
        Stone getStone();
    }

    class Stone { }

    class Banana implements Fruit {

        @Override
        public String name() {
            return "banana";
        }

        @Override
        public Stone getStone() {
            return null;
        }
    }

    class Peach implements Fruit {

        @Override
        public String name() {
            return "banana";
        }

        @Override
        public Stone getStone() {
            return new Stone();
        }
    }

    class Plum implements Fruit {

        @Override
        public String name() {
            return "plum";
        }

        @Override
        public Stone getStone() {
            return new Stone();
        }
    }
}
