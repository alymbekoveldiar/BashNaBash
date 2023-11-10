package com.example.BashNaBash.Repos;

import com.example.BashNaBash.Entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.nio.file.attribute.FileTime;
import java.util.List;

@Repository
public interface FotoRepo extends JpaRepository<Foto, Long> {
    List<Foto> findAllBy();
}
