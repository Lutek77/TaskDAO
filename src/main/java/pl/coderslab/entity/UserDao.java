package pl.coderslab.entity;

import java.sql.*;

public class UserDao {

    private static final String CREATE_USER_QUERY =
            "INSERT INTO workshop2.users(username, email, password) VALUES (?, ?, ?)";

    private static final String MODIFY_USER_QUERY =
            "update workshop2.users \n" +
                    "set username = ?,email = ?, password = ?\n" +
                    "where id = ? ;";

    private static final String DELETE_USER_QUERY =
            "DELETE FROM workshop2.users where id = ?;";

    private static final String TAKE_ALL_USER_QUERY =
            "select * from  workshop2.userss;";

    private static final String TAKE_SINGLE_USER_QUERY =
            "select * from workshop2.users where id = ?;";

    public User create(User user) {
        try (Connection conn = DbUtil.DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            // statement.setString(3, hashPassword(user.getPassword()));
            statement.setString(3, "XXXXX");
            statement.executeUpdate();
            //Pobieramy wstawiony do bazy identyfikator, a następnie ustawiamy id obiektu user.
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }



/*        public String hashPassword(String password) {
            return BCrypt.hashpw(password, BCrypt.gensalt());
        }*/


    }

}
