package bgps.labs.dao;

import bgps.labs.model.JournalRecord;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JournalRecordJdbc
{
    private final JdbcTemplate jdbcTemplate;

    public JournalRecordJdbc(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JournalRecord get(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM \"journal\" WHERE \"id\" = ?", this::mapJournalRecord, id);
    }

    public List<JournalRecord> getAll()
    {
        return jdbcTemplate.queryForObject("SELECT * FROM \"journal\"", this::mapAllJournalRecords);
    }

    public List<JournalRecord> getAllByStudent(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM \"journal\" WHERE \"student_id\" = ?", this::mapAllJournalRecords, id);
    }

    public List<JournalRecord> getAllByStudyPlan(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM \"journal\" WHERE \"study_plan_id\" = ?", this::mapAllJournalRecords, id);
    }

    private JournalRecord mapJournalRecord(ResultSet rs, int i) throws SQLException
    {
        return new JournalRecord(
                rs.getInt("id"),
                rs.getInt("student_id"),
                rs.getInt("study_plan_id"),
                rs.getBoolean("in_time"),
                rs.getInt("count"),
                rs.getInt("mark_id")
        );
    }

    private List<JournalRecord> mapAllJournalRecords(ResultSet rs, int i) throws SQLException
    {
        List<JournalRecord> journalRecordList = new ArrayList<>();

        do
        {
            journalRecordList.add(new JournalRecord(
                    rs.getInt("id"),
                    rs.getInt("student_id"),
                    rs.getInt("study_plan_id"),
                    rs.getBoolean("in_time"),
                    rs.getInt("count"),
                    rs.getInt("mark_id")));
        }
        while (rs.next());

        return journalRecordList;
    }
}
