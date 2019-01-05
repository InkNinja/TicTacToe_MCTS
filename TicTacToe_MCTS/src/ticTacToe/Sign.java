package ticTacToe;

public enum Sign {

    CROSS {
        @Override
        public Sign next() {
            return CIRCLE;
        }

        @Override
        public void print() {
            System.out.print("X");
        }
    },

    CIRCLE {
        @Override
        public Sign next() {
            return CROSS;
        }

        @Override
        public void print() {
            System.out.print("O");
        }
    };

    public abstract Sign next();

    public abstract void print();

}
