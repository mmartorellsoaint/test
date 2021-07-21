package com.soaint.test.demo.log.repository;

import com.soaint.test.demo.log.domain.LogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogModel, Long> {
}
