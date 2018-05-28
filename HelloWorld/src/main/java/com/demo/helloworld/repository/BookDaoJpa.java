package com.demo.helloworld.repository;

import com.demo.helloworld.entity.BookJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookDaoJpa extends JpaRepository<BookJpa, Integer>,JpaSpecificationExecutor<BookJpa> {
}
