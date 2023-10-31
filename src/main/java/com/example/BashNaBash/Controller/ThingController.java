package com.example.BashNaBash.Controller;

import com.example.BashNaBash.Entity.Thing;
import com.example.BashNaBash.Service.Businesslogic;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("/")
public class ThingController {
    private final Businesslogic businesslogic;

    public ThingController(Businesslogic businesslogic) {
        this.businesslogic = businesslogic;
    }

    @PostMapping("create")
    public  String createThing(@RequestParam(name = "file") MultipartFile file, Thing thing) {
        businesslogic.create(thing, file);
        return "thing";
    }

    @GetMapping("getAll")
    public String getAll(@RequestParam(name = "type") String type, Model things){
        things.addAttribute("things", businesslogic.getAll(type));
        return "thing";
    }
}
