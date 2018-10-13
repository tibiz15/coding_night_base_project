package dao.impl;

import dao.SoDAO;
import entyties.SO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SoDaoImpl implements SoDAO {

    private static String GET = "SELECT * FROM SO WHERE id=?";
    private static String INSERT = "INSERT INTO SO (soID, applicationID, name, description, aim, head, address, tel_num," +
            " email, facebook)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static String UPDATE = "UPDATE SO SET soID=?, applicationID=?, name=?, description=?, aim=?, head=?, " +
            "address=?, tel_num=?, email=?, facebook=?";
    private static String DELETE = "DELETE FROM SO WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM SO";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SO get(int id) {
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    @Override
    public int insert(SO so) {
        return jdbcTemplate.update(INSERT, UPDATE, so.getSoID(), so.getApplicationID(), so.getName(), so.getDescription(),
                so.getAim(), so.getHead(), so.getAddress(), so.getTel_num(), so.getEmail(), so.getFacebook());
    }

    @Override
    public void update(SO so) {
        jdbcTemplate.update(UPDATE, so.getSoID(), so.getApplicationID(), so.getName(), so.getDescription(),
                so.getAim(), so.getHead(), so.getAddress(), so.getTel_num(), so.getEmail(), so.getFacebook());
    }

    @Override
    public void remove(SO so) {
        jdbcTemplate.update(DELETE, so.getSoID());    }

    @Override
    public List<SO> getAll() {
        return jdbcTemplate.query(GET_ALL, mapper);
    }

    private RowMapper<SO> mapper = new RowMapper<SO>() {
        public SO mapRow(ResultSet rs, int rowNum) throws SQLException {
            SO so = new SO();
            so.setSoID(rs.getInt("soID"));
            so.setApplicationID(rs.getInt("applicationID"));
            so.setName(rs.getString("name"));
            so.setDescription(rs.getString("description"));
            so.setAim(rs.getString("aim"));
            so.setHead(rs.getString("head"));
            so.setAddress(rs.getString("address"));
            so.setEmail(rs.getString("email"));
            so.setTel_num(rs.getString("tel_num"));
            so.setFacebook(rs.getString("facebook"));
            return so;
        }
    };
}
