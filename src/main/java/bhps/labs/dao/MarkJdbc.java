package bhps.labs.dao;

import bhps.labs.model.Mark;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MarkJdbc
{
    private final JdbcTemplate jdbcTemplate;

    public MarkJdbc(JdbcTemplate template)
    {
        this.jdbcTemplate = template;
    }

    public Mark get(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM \"mark\" WHERE \"id\" = ?", this::mapMark, id);
    }

    public Mark search(String mark)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM \"mark\" WHERE \"id\" = ?", Mark.class, mark);
    }

    private Mark mapMark(@NotNull ResultSet rs, int i) throws SQLException
    {
        return new Mark(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("value")
        );
    }
}
