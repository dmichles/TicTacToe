public enum State {
    Xwins ("X wins"),
    Owins ("O wins"),
    Draw ("Draw"),
    NotFinished ("Game not finished");

    private String state;

    private State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}