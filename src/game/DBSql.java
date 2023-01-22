package game;
import gameobjects.Enemy;
import java.sql.*;
import java.util.Scanner;

public class DBSql {

    private Connection connection;
    private Statement stmt;

    public Connection connectToDatabase() {
        Connection connection = null;
        String stmt = null;

        try {

            String url = "jdbc:sqlite:C://Users/aikke/IdeaProjects/SpilProjektv2/WarlockOfFiretopMountain.db";
            connection = DriverManager.getConnection(url);


            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public Enemy createEnemy(int id) {
        connection = connectToDatabase();
        String sql;
        Enemy enemy = new Enemy();

        try {
            //undersøg om det er som i enemy klassen
            sql = "SELECT * FROM enemy" +
                    " WHERE id='" + id +
                    "'";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();

            //ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                enemy = new Enemy(rs.getInt("id"),
                        rs.getString("navn"),
                        rs.getString("desciption"),
                        rs.getInt("skill"),
                        rs.getInt("stamina"),
                        rs.getInt("item_fk"));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enemy;
    }
}