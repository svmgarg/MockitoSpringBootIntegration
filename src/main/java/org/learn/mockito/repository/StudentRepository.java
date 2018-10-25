package org.learn.mockito.repository;

import org.learn.mockito.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {


}
