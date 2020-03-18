package bhps.labs.controller;

import bhps.labs.dao.MarkJdbc;
import bhps.labs.model.Mark;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkController
{
    private final MarkJdbc markJdbc;

    public MarkController(MarkJdbc markJdbc)
    {
        this.markJdbc = markJdbc;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/mark/{id}")
    public Mark getMark(@PathVariable int id)
    {
        return markJdbc.get(id);
    }
}
