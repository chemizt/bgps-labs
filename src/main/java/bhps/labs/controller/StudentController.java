package bhps.labs.controller;

import bhps.labs.dao.StudentJdbc;
import bhps.labs.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    private final StudentJdbc studentJdbc;

    public StudentController(StudentJdbc studentJdbc)
    {
        this.studentJdbc = studentJdbc;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id)
    {
        return studentJdbc.get(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/student/all")
    public List<Student> getAllStudents()
    {
        return studentJdbc.getAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/student/group/{id}")
    public List<Student> getStudentsFromGroup(@PathVariable int id)
    {
        return studentJdbc.getAllByGroup(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/student/new")
    public int addNewStudent(@RequestBody Student stud)
    {
        return studentJdbc.add(stud);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/student/update")
    public int updateStudent(@RequestBody Student stud)
    {
        return studentJdbc.update(stud);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/student/delete/{id}")
    public int deleteStudent(@PathVariable int id)
    {
        return studentJdbc.delete(id);
    }

}
