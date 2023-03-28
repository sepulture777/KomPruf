package com.example.kompruf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //make it a controller all beans are generated automatically
public class KomPrufController {

    @GetMapping("/")    //we generate a mapping to cause a Http200 response
    public void beAvailable(){
    }
}
