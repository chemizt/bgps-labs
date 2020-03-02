package bgps.labs.controller;

import bgps.labs.dao.StudentJdbc;
import bgps.labs.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController
{
    private final StudentJdbc studentJdbc;

    public StudentController(StudentJdbc studentJdbc)
    {
        this.studentJdbc = studentJdbc;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id)
    {
        return studentJdbc.get(id);
    }

    @GetMapping("/student/all")
    public List<Student> getAllStudents()
    {
        return studentJdbc.getAll();
    }

    @GetMapping("student/group/{id}")
    public List<Student> getStudentsFromGroup(@PathVariable int id)
    {
        return studentJdbc.getAllByGroup(id);
    }

}
