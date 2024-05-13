package com.ajaycodes.dao;

import com.ajaycodes.models.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentDao {

    @PersistenceContext
    private EntityManager em;

    public void save(Student student) {
        em.persist(student);

    }
}
