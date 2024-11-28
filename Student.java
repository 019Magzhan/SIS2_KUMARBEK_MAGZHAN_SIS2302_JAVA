public class Student {
    private int id;
    private String name;
    private String group;
    private double Scholarship;
    private double gpa;
    private String faculty;
    private double newScholarship;

    public Student(int id,String name, String group,double Scholarship,double gpa, String faculty, double newScholarship) {
        this.id=id;
        this.name = name;
        this.group=group;
        this.Scholarship = Scholarship;
        this.gpa=gpa;
        this.faculty=faculty;
        this.newScholarship=newScholarship;
    }
public Integer getId(){
        return id;
}
    public String getName() {
        return name;
    }
    public String getGroup(){
        return group;
    }

    public double getScholarship() {
        return Scholarship;
    }

    public double getGpa(){
        return gpa;
    }

    public String getFaculty(){
        return faculty;
    }
    public double getNewScholarship(){
        return newScholarship;
    }
}

