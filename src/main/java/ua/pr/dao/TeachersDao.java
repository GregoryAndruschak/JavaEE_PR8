package ua.pr.dao;

import ua.pr.entities.Teacher;

public interface TeachersDao {

    void addTeacher(Teacher teacher);

    Teacher getTeacherById(int id);

    void saveTacher(Teacher teacher);
}