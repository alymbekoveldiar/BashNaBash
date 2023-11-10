package com.example.BashNaBash.Service;

import com.example.BashNaBash.Entity.Foto;
import com.example.BashNaBash.Entity.Thing;
import com.example.BashNaBash.Entity.User;
import com.example.BashNaBash.Repos.FotoRepo;
import com.example.BashNaBash.Repos.ThingRepo;
import com.example.BashNaBash.Repos.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class Businesslogic {
    final private String basePath = "C:\\Users\\EAlymbekov\\Desktop\\File\\";
    private final FotoRepo fotoRepo;
    private final ThingRepo thingRepo;
    private final UserRepo userRepo;

    public Businesslogic(FotoRepo fotoRepo, ThingRepo thingRepo, UserRepo userRepo) {
        this.fotoRepo = fotoRepo;
        this.thingRepo = thingRepo;
        this.userRepo = userRepo;
    }

//    public void create(MultipartFile file, Thing thing) {
//        Foto foto1;
//        foto1 = toFotoEntoty(file);
//        thing.addFoto(foto1);
//        if (file.getSize() != 0) {
//            foto1 = toFotoEntoty(file);
//            thing.addFoto(foto1);
//        }

//        Thing thing1 = new Thing();
//        thing1.setType(thing.getType());
//        thing1.setAddress(thing.getAddress());
//        thing1.setShortDescription(thing.getShortDescription());
//        thing1.setPhoneNumber(thing.getPhoneNumber());
//        thing1.setFoto(thing.getFoto());
//        thingRepo.save(thing1);

//        Thing thing2 = thingRepo.save(thing);
//        thing2.setFotos(thing2.getFotos());
//        thingRepo.save(thing2);
//    }

    public Thing createThing(Thing thing) {
        Thing thing1 = new Thing();
        thing1.setType(thing.getType());
        thing1.setAddress(thing.getAddress());
        thing1.setShortDescription(thing.getShortDescription());
        thing1.setPhoneNumber(thing.getPhoneNumber());
        thing1.setAuthor(thing.getAuthor());
        thing1.setFoto(thing.getFoto());
        thingRepo.save(thing1);
        return thing1;
    }

    public String toFotoEntoty(MultipartFile multipartFile) {
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
        fotoRepo.save(foto);
        return "Готово";
    }

    public List<Thing> getAll(String type) {
        if (type != null) thingRepo.findByType(type);
        return thingRepo.findAll();
    }

    public List<Thing> getByName(String type){
        return thingRepo.findByType(type);
    }

//    public List<User> getAllUser(){
//        return userRepo.getUserByGmailAndAmountOfDeals();
//    }

    public List<Foto> getAllFoto() {
        return fotoRepo.findAllBy();
    }

    public List<Thing> getAllThing() {
        return thingRepo.findAll();
    }

    public Thing getById(Long id) {
        return thingRepo.getById(id);
    }

    public String delete(Long id) {
        thingRepo.deleteById(id);
        return id + " удален из списка";
    }

}


