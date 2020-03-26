package bhps.labs.model;

public class Student
{
    private int id;
    private Integer studyGroupId;
    private String surname;
    private String name;
    private String secondName;

    public Student(Integer id, Integer studyGroupId, String surname, String name, String secondName)
    {
        this.id = id;
        this.studyGroupId = studyGroupId;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
    }

    public Student()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Integer getStudyGroupId()
    {
        return studyGroupId;
    }

    public void setStudyGroupId(Integer studyGroupId)
    {
        this.studyGroupId = studyGroupId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getSecondName()
    {
        return secondName;
    }

    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }

}
