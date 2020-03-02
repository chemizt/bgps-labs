package bgps.labs.dao;

import bgps.labs.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentJdbc
{
    private final JdbcTemplate jdbcTemplate;

    public StudentJdbc(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student get(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM \"student\" WHERE \"id\" = ?", this::mapStudent, id);
    }

    public List<Student> getAll()
    {
        return jdbcTemplate.queryForObject("SELECT * FROM \"student\"", this::mapAllStudents);
    }

    public List<Student> getAllByGroup(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM \"student\" WHERE \"study_group_id\" = ?", this::mapAllStudents, id);
    }

    private Student mapStudent(ResultSet rs, int i) throws SQLException
    {
        return new Student(
                rs.getInt("id"),
                rs.getInt("study_group_id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("second_name")
        );
    }

    private List<Student> mapAllStudents(ResultSet rs, int i) throws SQLException
    {
        List<Student> studentList = new ArrayList<>();

        do
        {
            studentList.add(new Student(rs.getInt("id"),
                    rs.getInt("study_group_id"),
                    rs.getString("surname"),
                    rs.getString("name"),
                    rs.getString("second_name")));
        }
        while (rs.next());

        return studentList;
    }
}
