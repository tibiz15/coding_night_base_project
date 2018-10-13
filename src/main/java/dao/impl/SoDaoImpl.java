package dao.impl;

import dao.SoDAO;
import entyties.SO;
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
    private JdbcTemplate jdbcTemplate;

    @Override
    public SO get(int id) {
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    @Override
    public int insert(SO so) {
        return 0;
    }

    @Override
    public void update(SO so) {

    }

    @Override
    public boolean remove(SO so) {
        return false;
    }

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
