package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
=======
>>>>>>> origin/master
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
<<<<<<< HEAD
    Page<Student> findByNameContaining(String firstName, Pageable pageable);

    @Query("select s from Student  s where s.score > 8 ")
    Page<Student>findNameByOrderScoreGreaterThan8(Pageable pageable);
=======
    Page<Student> findByNameContaining(String firstName , Pageable pageable);
>>>>>>> origin/master
}
