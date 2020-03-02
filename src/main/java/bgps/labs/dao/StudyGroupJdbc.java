package bgps.labs.dao;

import bgps.labs.model.StudyGroup;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudyGroupJdbc
{
    private final JdbcTemplate jdbcTemplate;

    public StudyGroupJdbc(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudyGroup get(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM \"study_group\" WHERE \"id\" = ?", this::mapStudyGroup, id);
    }

    public List<StudyGroup> getAll()
    {
        return jdbcTemplate.queryForObject("SELECT * FROM \"study_group\"", this::mapAllStudyGroups);
    }

    private StudyGroup mapStudyGroup(ResultSet rs, int i) throws SQLException
    {
        return new StudyGroup(
                rs.getInt("id"),
                rs.getString("name")
        );
    }

    private List<StudyGroup> mapAllStudyGroups(ResultSet rs, int i) throws SQLException
    {
        List<StudyGroup> groupList = new ArrayList<>();

        do
        {
            groupList.add(new StudyGroup(rs.getInt("id"),
                    rs.getString("name")));
        }
        while (rs.next());

        return groupList;
    }
}
