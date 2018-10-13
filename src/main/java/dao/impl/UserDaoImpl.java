package dao.impl;

import dao.UserDAO;
import entyties.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDAO {

    private static String GET = "SELECT * FROM User WHERE id=?";
    private static final String INSERT = "INSERT INTO User (role, name, email, tel_num) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE User SET role=?, name=?, email=?, tel_num=?";
    private static final String DELETE = "DELETE FROM User WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public User get(int id) {
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public boolean remove(User user) {
        return false;
    }

    @Override
    public boolean ifExists(User user) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    private RowMapper<User> mapper = new RowMapper<User>() {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("userID"));
            user.setRole(rs.getString("role"));
            user.setName(rs.getString("name"));
            user.setEmail("email");
            user.setTel_num(rs.getString("tel_num"));

            return user;
        }
    };
}
