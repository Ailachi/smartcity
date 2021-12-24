package repository;

import database.Specialty;
import database.Subject;
import database.University;
import database.User;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class StudentRepository extends Repository{

    public List<User> getAllStudents() {
        List<User> students = em.createQuery("SELECT u from User u WHERE u.role.name = :role")
                .setParameter("role", "STUDENT")
                .getResultList();

        return students;
    }

    public List<University> getUniversitiesBySpecialtyId(int id) {
        return em.createQuery("SELECT s.universities from Specialty s WHERE s.specialtyID = :id")
                .setParameter("id", id)
                .getResultList();
    }

    public List<Specialty> getSpecialtiesOfSubject(int id) {
        return em.createQuery("SELECT s.specialties from Subject s WHERE s.subjectID =:id")
                .setParameter("id", id)
                .getResultList();
    }

    public Subject getSubjectById(int subjId) {
        return em.find(Subject.class, subjId);
    }

    public Specialty getSpecialtyById(int id) {
        return em.find(Specialty.class, id);
    }

    public University getUniversityById(int id) {
        return em.find(University.class, id);
    }

    public List<Subject> getSpecialtySubjects(int specId) {
        Specialty specialty = em.find(Specialty.class, specId);
        return specialty.getSpecialtySubjects();
    }

}
