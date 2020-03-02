package bgps.labs.controller;

import bgps.labs.dao.JournalRecordJdbc;
import bgps.labs.model.JournalRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JournalRecordController
{
    private final JournalRecordJdbc journalRecordJdbc;

    public JournalRecordController(JournalRecordJdbc journalRecordJdbc)
    {
        this.journalRecordJdbc = journalRecordJdbc;
    }

    @GetMapping("/journal/{id}")
    public JournalRecord getJournalRecord(@PathVariable int id)
    {
        return journalRecordJdbc.get(id);
    }

    @GetMapping("/journal/all")
    public List<JournalRecord> getAllJournalRecords()
    {
        return journalRecordJdbc.getAll();
    }

    @GetMapping("/journal/student/{id}")
    public List<JournalRecord> getJournalRecordsByStudent(@PathVariable int id)
    {
        return journalRecordJdbc.getAllByStudent(id);
    }

    @GetMapping("/journal/study_plan/{id}")
    public List<JournalRecord> getJournalRecordsByStudyPlan(@PathVariable int id)
    {
        return journalRecordJdbc.getAllByStudyPlan(id);
    }

}
