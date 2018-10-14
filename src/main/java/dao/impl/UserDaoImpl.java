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
    private static final String GET_ALL = "SELECT * FROM User";
    private static final String GET_BY_NAME = "SELECT * FROM User WHERE name=?";


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public User get(int id) {
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    @Override
    public User getByName(String name) {
        return jdbcTemplate.queryForObject(GET_BY_NAME, User.class, name);
    }

    @Override
    public int insert(User user) {
        return jdbcTemplate.update(INSERT, user.getRole(), user.getName(), user.getEmail(), user.getTel_num());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update(UPDATE, user.getRole(), user.getName(), user.getEmail(), user.getTel_num());
    }

    @Override
    public void remove(User user) {
        jdbcTemplate.update(DELETE, user.getUserId());
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query(GET_ALL, mapper);
    }

    private RowMapper<User> mapper = new RowMapper<User>() {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("userID"));
            user.setRole(rs.getString("role"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setTel_num(rs.getString("tel_num"));
            return user;
        }
    };
}
