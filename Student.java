
package za.ac.tut.entity;


public class Student {
    
    private Integer studNum;
    private String name;
    private String surname;

    public Student() {
    }

    public Student(Integer studNum, String name, String surname) {
        this.studNum = studNum;
        this.name = name;
        this.surname = surname;
    }

    public Integer getStudNum() {
        return studNum;
    }

    public void setStudNum(Integer studNum) {
        this.studNum = studNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Student{" + "studNum=" + studNum + ", name=" + name + ", surname=" + surname + '}';
    }
    
    
    
}
