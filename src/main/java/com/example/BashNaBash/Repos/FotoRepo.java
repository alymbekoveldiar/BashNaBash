package com.example.BashNaBash.Repos;

import com.example.BashNaBash.Entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepo extends JpaRepository<Foto, Long> {
}
