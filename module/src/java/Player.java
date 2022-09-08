package module.src.java;

public abstract class Player {
    
    public String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract int getScore();

    public abstract String toString();
}
