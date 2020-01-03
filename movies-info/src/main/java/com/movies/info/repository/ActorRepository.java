package com.movies.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.info.entity.Actor;

@Repository
public interface ActorRepository  extends JpaRepository<Actor, Long> {
}
