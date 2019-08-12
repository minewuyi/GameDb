package Dao;

/**
 * @author wuyi
 * @date 2019/8/8 16:26
 */
public class Game {
    private int number;
    private String gameName;
    private String type;
    private int price;

    public Game() {
    }

    public Game(int number, String gameName, String type, int price) {
        this.number = number;
        this.gameName = gameName;
        this.type = type;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
