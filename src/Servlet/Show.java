package Servlet;

import Dao.Game;
import Dao.SqlDao;
import Dao.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author wuyi
 * @date 2019/8/8 18:00
 */
public class Show {
    public static ArrayList<Game> showTo() throws SQLException {

        Connection conn = SqlDao.getConnection();
        String sql = "select * from game";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Game> result = new ArrayList<Game>();
        while (rs.next()) {
            Game game = new Game();
            game.setNumber(rs.getInt("number"));
            game.setGameName(rs.getString("gameName"));
            game.setPrice(rs.getInt("price"));
            game.setType(rs.getString("type"));
            result.add(game);
        }
        conn.close();
        return result;
    }

    public static Game showOne(int number) throws SQLException {
        Connection conn = SqlDao.getConnection();
        String sql = "select * from game where number=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, number);
        Game game = new Game();
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            game.setNumber(rs.getInt("number"));
            game.setGameName(rs.getString("gameName"));
            game.setPrice(rs.getInt("price"));
            game.setType(rs.getString("type"));
            return game;
        }
        return null;
    }


    public static void delete(int gameNumber) throws SQLException {

        Connection conn = SqlDao.getConnection();
        String sql = "delete from game where number= ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, gameNumber);
        pstm.execute();
        conn.close();
    }

    public static boolean add(String gameName, String type, int price) throws SQLException {
        Connection conn = SqlDao.getConnection();
        String sql = "INSERT INTO game (gameName,type,price) VALUES (?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, gameName);
        pstm.setString(2, type);
        pstm.setInt(3, price);
        boolean no = pstm.execute();
        conn.close();
        return no;
    }

    public static boolean update(int number, String gameName, String type, int price) throws SQLException {
        Connection conn = SqlDao.getConnection();
        String sql = "UPDATE game SET gameName=?,type=?,price=? where number= ? ";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, gameName);
        pstm.setString(2, type);
        pstm.setInt(3, price);
        pstm.setInt(4, number);
        boolean no = pstm.execute();
        conn.close();
        return no;
    }

    public static User selectUser(String userName, String passWord) throws SQLException {
        Connection conn = SqlDao.getConnection();
        String sql = "SELECT id,userName from user where userName= ? and passWord= ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, passWord);
        ResultSet rs = pstm.executeQuery();
        User user = new User();
        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("userName"));
            conn.close();
            return user;
        } else {
            conn.close();
            return null;
        }

    }

}
