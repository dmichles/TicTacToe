public interface Player {
    static Player of(String type) {
        switch (type) {
            case "hard":
                return new HardAI();
            case "medium":
                return new MediumAI();
            case "easy":
                return new EasyAI();
            case "user":
                return new RealUser();
            default:
                return null;
        }
    }

    void move(Board board);
}
