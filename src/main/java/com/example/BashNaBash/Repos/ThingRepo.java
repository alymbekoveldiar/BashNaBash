package com.example.BashNaBash.Repos;

import com.example.BashNaBash.Entity.Thing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThingRepo extends JpaRepository<Thing, Long> {
    @Value(value = "select * from thing where upper(type) like  upper(: type)")
    List<Thing> findByType(@Param(value = "type")String type);
}
