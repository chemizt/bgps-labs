package bgps.labs.controller;

import bgps.labs.dao.StudyGroupJdbc;
import bgps.labs.model.StudyGroup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudyGroupController
{
    private final StudyGroupJdbc studyGroupJdbc;

    public StudyGroupController(StudyGroupJdbc studyGroupJdbc)
    {
        this.studyGroupJdbc = studyGroupJdbc;
    }

    @GetMapping("/group/{id}")
    public StudyGroup getStudyGroup(@PathVariable int id)
    {
        return studyGroupJdbc.get(id);
    }

    @GetMapping("/group/all")
    public List<StudyGroup> getAllStudents()
    {
        return studyGroupJdbc.getAll();
    }

}
