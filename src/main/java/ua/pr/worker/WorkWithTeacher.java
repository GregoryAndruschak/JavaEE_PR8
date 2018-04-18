package ua.pr.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import ua.pr.dao.TeachersDao;
import ua.pr.entities.Teacher;

@Transactional
public class WorkWithTeacher {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private TeachersDao teachersDao;

    public Teacher addTeacher(final Teacher teacher) {
        transactionTemplate.execute(new TransactionCallback<Void>() {
            public Void doInTransaction(TransactionStatus txStatus) {
                try {
                    teachersDao.addTeacher(teacher);
                    System.out.println("Teacher has been added " + teacher);
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
        return teacher;
    }

    public Teacher getTeacherById(final int id) {
        transactionTemplate.execute(new TransactionCallback<Teacher>() {
            public Teacher doInTransaction(TransactionStatus txStatus) {
                try {
                    return teachersDao.getTeacherById(id);

                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
            }
        });
        return null;

    }

    public void saveTacher(final Teacher teacher) {
        transactionTemplate.execute(new TransactionCallback<Void>() {
            public Void doInTransaction(TransactionStatus txStatus) {
                try {
                    teachersDao.saveTacher(teacher);
                    System.out.println("Teacher has been saved " + teacher);
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });

    }

}