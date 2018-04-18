package ua.pr.dao;

import ua.pr.entities.Student;

public interface StudentsDao {
    public void addStudent(Student student);
    public Student getStudentById(int id);
}