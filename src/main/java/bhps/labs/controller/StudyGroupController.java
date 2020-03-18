package bhps.labs.controller;

import bhps.labs.dao.StudyGroupJdbc;
import bhps.labs.model.StudyGroup;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudyGroupController
{
    private final StudyGroupJdbc studyGroupJdbc;

    public StudyGroupController(StudyGroupJdbc studyGroupJdbc)
    {
        this.studyGroupJdbc = studyGroupJdbc;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/group/{id}")
    public StudyGroup getStudyGroup(@PathVariable int id)
    {
        return studyGroupJdbc.get(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/group/all")
    public List<StudyGroup> getAllStudents()
    {
        return studyGroupJdbc.getAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/group/new")
    public int addStudyGroup(@RequestBody StudyGroup sG)
    {
        return studyGroupJdbc.add(sG);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/group/update")
    public int updateStudyGroup(@RequestBody StudyGroup sG)
    {
        return studyGroupJdbc.update(sG);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/group/delete/{id}")
    public int deleteStudyGroup(@PathVariable int id)
    {
        return studyGroupJdbc.delete(id);
    }

}
