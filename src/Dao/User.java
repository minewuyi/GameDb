package Dao;

/**
 * @author wuyi
 * @date 2019/8/10 10:25
 */
public class User {
    private String UserName;
    private int id;

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", id=" + id +
                '}';
    }

    public User() {
    }

    public User(String userName, int id) {
        UserName = userName;
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
