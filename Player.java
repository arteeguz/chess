package application;

public class Player {
    
    private String name;
    private boolean isPlayingBlack;

    public Player(String name, boolean isPlayingBlack) {
        this.name = name;
        this.isPlayingBlack = isPlayingBlack;
    }

    public String getName() {
        return name;
    }

    public boolean isBlack() {
        return isPlayingBlack;
    }
}