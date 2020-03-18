package bhps.labs.controller;

import bhps.labs.dao.JournalRecordJdbc;
import bhps.labs.model.JournalRecord;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalRecordController
{
    private final JournalRecordJdbc journalRecordJdbc;

    public JournalRecordController(JournalRecordJdbc journalRecordJdbc)
    {
        this.journalRecordJdbc = journalRecordJdbc;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/journal/{id}")
    public JournalRecord getJournalRecord(@PathVariable int id)
    {
        return journalRecordJdbc.get(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/journal/all")
    public List<JournalRecord> getAllJournalRecords()
    {
        return journalRecordJdbc.getAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/journal/student/{id}")
    public List<JournalRecord> getJournalRecordsByStudent(@PathVariable int id)
    {
        return journalRecordJdbc.getAllByStudent(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/journal/study_plan/{id}")
    public List<JournalRecord> getJournalRecordsByStudyPlan(@PathVariable int id)
    {
        return journalRecordJdbc.getAllByStudyPlan(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/journal/add")
    public int addNewRecord(@RequestBody JournalRecord jR)
    {
        return journalRecordJdbc.addJournalRecord(jR);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/journal/update")
    public int updateRecord(@RequestBody JournalRecord jR)
    {
        return journalRecordJdbc.updateJournalRecord(jR);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/journal/delete/{id}")
    public int deleteRecordById(@PathVariable int id)
    {
        return journalRecordJdbc.deleteJournalRecord(id);
    }

}
