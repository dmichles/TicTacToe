public enum Symbol {
    X ('X'),
    O ('O'),
    EMPTY (' ')
    ;
    private char symbol;

    private Symbol(char symbol) {
        this.symbol = symbol;
    }
    public char getSymbol() {
        return symbol;
    }
}
