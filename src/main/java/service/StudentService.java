package service;

import aop.AopRequestLogger;
import database.Specialty;
import database.Subject;
import database.University;
import database.User;
import repository.StudentRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AopRequestLogger
@Stateless
public class StudentService {
    @EJB
    private StudentRepository repo;

    public List<User> getAllStudents() {
        return repo.getAllStudents();
    }

    public Subject getSubjectById(int subjId) {
        return repo.getSubjectById(subjId);
    }

    public Specialty getSpecialtyById(int id) {
        return repo.getSpecialtyById(id);
    }

    public List<Specialty> getSpecialtiesOfSubject(int subjId) {
        return repo.getSpecialtiesOfSubject(subjId);
    }

    public List<University> getUniversitiesBySpecialtyId(int specId) {
        return repo.getUniversitiesBySpecialtyId(specId);
    }

    public List<Subject> getUniversitySubjects(int uniId) {
        University university = repo.getUniversityById(uniId);
        Specialty specialty = repo.getSpecialtyById(university.getSpecialty().getSpecialtyID());

        return specialty.getSpecialtySubjects();
    }

    public List<Subject> getSpecialtySubjects(int specId) {
        return repo.getSpecialtySubjects(specId);
    }
}
