package com.example.BashNaBash.Service;

import com.example.BashNaBash.Entity.Foto;
import com.example.BashNaBash.Entity.Thing;
import com.example.BashNaBash.Repos.FotoRepo;
import com.example.BashNaBash.Repos.ThingRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class Businesslogic {
    final private String basePath = "C:\\Users\\EAlymbekov\\Desktop\\File\\";
    private final FotoRepo fotoRepo;
    private final ThingRepo thingRepo;

    public Businesslogic(FotoRepo fotoRepo, ThingRepo thingRepo) {
        this.fotoRepo = fotoRepo;
        this.thingRepo = thingRepo;
    }

    public void create(Thing thing, MultipartFile file) {
        Foto foto1;
        if (file.getSize() != 0) {
            foto1 = toFotoEntoty(file);
            thing.addFoto(foto1);
        }

//        thing1.setType(thing.getType());
//        thing1.setAddress(thing.getAddress());
//        thing1.setShortDescription(thing.getShortDescription());
//        thing1.setPhoneNumber(thing.getPhoneNumber());
//        thing1.setFoto(thing.getFoto());
        Thing thing2 = thingRepo.save(thing);
        thing2.setFotos(thing2.getFotos());
        thingRepo.save(thing2);
    }

    private Foto toFotoEntoty(MultipartFile multipartFile) {
        String name = String.valueOf(System.currentTimeMillis());
        String extension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().toString().lastIndexOf('.'));
        try {
            Files.copy(multipartFile.getInputStream(), Paths.get(basePath + name + "." + extension));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Foto foto = new Foto();
        foto.setOriginalName(multipartFile.getOriginalFilename());
        foto.setName(name + "." + extension);
        foto.setPath(basePath + multipartFile.getOriginalFilename());
        foto.setSize(multipartFile.getSize());
        return fotoRepo.save(foto);
//
//        Foto foto = new Foto();
//        foto.setOriginalName(file.getOriginalFilename());
//        foto.setName(file.getName());
//        foto.setSize(file.getSize());
//        foto.setPath("пока ничего");
//        return foto;
    }

    public List<Thing> getAll(String type) {
        if (type != null) thingRepo.findByType(type);
        return thingRepo.findAll();
    }

    public String delete(Long id){
        thingRepo.deleteById(id);
        return id+" удален из списка";
    }

}


