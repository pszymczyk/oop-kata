package com.pszymczyk.inheritance.diamond;

/**
 * @author pawel szymczyk
 */
class InheritanceDiamondProblem {

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

    /*
    static class ShaverWithTrimmer extends Shaver, Trimmer {
        @Override
        void start() {

            //Start shaver or trimmer?
            super.start();
        }
    }
    */
}
