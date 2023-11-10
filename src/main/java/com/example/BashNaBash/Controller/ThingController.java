package com.example.BashNaBash.Controller;

import com.example.BashNaBash.Entity.Foto;
import com.example.BashNaBash.Entity.Thing;
import com.example.BashNaBash.Entity.User;
import com.example.BashNaBash.Service.Businesslogic;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController("/")
public class ThingController {
    private final Businesslogic businesslogic;

    public ThingController(Businesslogic businesslogic) {
        this.businesslogic = businesslogic;
    }



    @GetMapping("getAll")
    public String getAll(@RequestParam(name = "type") String type, Model things){
        things.addAttribute("things", businesslogic.getAll(type));
        return "thing";
    }

    @GetMapping("getAllFoto")
    List<Foto> getAlll(){
         return businesslogic.getAllFoto();
    }
    @GetMapping("getAllThing")
    List<Thing> getAllll(){
        return businesslogic.getAllThing();
    }
    @PostMapping("createThing")
    public Thing createThing (Thing thing){
        return businesslogic.createThing(thing);
    }

    @PostMapping("createFoto")
    public String createFoto(@RequestParam(name = "file" )MultipartFile file){
        return businesslogic.toFotoEntoty(file);
    }

    @GetMapping("getByType/{type}")
    List<Thing> getByType(@PathVariable String type){
        return businesslogic.getByName(type);
    }

    @GetMapping("getById/{id}")
    public Thing getById(@PathVariable Long id){
        return businesslogic.getById(id);
    }

}
