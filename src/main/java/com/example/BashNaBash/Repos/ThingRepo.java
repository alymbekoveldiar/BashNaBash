package com.example.BashNaBash.Repos;

import com.example.BashNaBash.Entity.Thing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThingRepo extends JpaRepository<Thing, Long> {
    List<Thing> findByType(String type);
}
