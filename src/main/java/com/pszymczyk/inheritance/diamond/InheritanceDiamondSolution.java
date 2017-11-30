package com.pszymczyk.inheritance.diamond;

/**
 * @author pawel szymczyk
 */
class InheritanceDiamondSolution {

    static class Machine {
        void start() {

        }
    }

    static class Shaver extends Machine {
        void shave() {

        }
    }

    static class Trimmer extends Machine {
        void trim() {

        }
    }

    static class ShaverWithTrimmer {

        Shaver shaver;
        Trimmer trimmer;

        void start() {
            shaver.start();
        }
    }
}
