package com.movies.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.info.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
