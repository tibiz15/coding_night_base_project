package dao.impl;

import dao.SoApplicationDAO;
import entyties.SoApplication;
import entyties.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SoApplicationDaoImpl implements SoApplicationDAO {

    private static String GET = "SELECT * FROM SO_application WHERE id=?";
    private static final String INSERT = "INSERT INTO SO_application (authorID, name, description, aim, approved," +
            " status, rejectet_text, dekanID, skID) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE SO_application SET authorID=?, name=?, descriptoin=?, aim=?," +
            "approved=?, status=?, rejected_tesxt=?, dekanID=?, dekanID=?, skID=?";
    private static final String DELETE = "DELETE FROM SO_application WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM SO_application";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SoApplication getSoApplication(int id) {
        return null;
    }

    @Override
    public int insert(SoApplication soApplication) {
        return 0;
    }

    @Override
    public void update(SoApplication soApplication) {

    }

    @Override
    public boolean remove(SoApplication soApplication) {
        return false;
    }

    @Override
    public List<SoApplication> getAll() {
        return null;
    }

    private RowMapper<SoApplication> mapper = new RowMapper<SoApplication>() {
        public SoApplication mapRow(ResultSet rs, int rowNum) throws SQLException {
            SoApplication soApplication = new SoApplication();
            soApplication.setApplicationID(rs.getInt("applicationID"));
            soApplication.setAuthorID(rs.getInt("authorID"));
            soApplication.setName(rs.getString("name"));
            soApplication.setDescription(rs.getString("description"));
            soApplication.setAim(rs.getString("aim"));
            soApplication.setApproved(rs.getBoolean("approved"));
            soApplication.setStatus(rs.getInt("status"));
            soApplication.setRejectedText(rs.getString("rejected_text"));
            soApplication.setDekanID(rs.getInt("dekanID"));
            soApplication.setSkID(rs.getInt("skID"));
            return soApplication;
        }
    };
}
