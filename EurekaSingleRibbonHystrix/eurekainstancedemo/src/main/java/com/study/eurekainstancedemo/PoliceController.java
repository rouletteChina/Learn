package com.study.eurekainstancedemo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PoliceController {

    @RequestMapping(value = "/police/{id}", method = RequestMethod.GET)
    public Police call(@PathVariable Integer id) {
        Police police = new Police();
        police.setId(id);
        police.setName("Hello Police");
        return police;
    }

    @PostMapping("/getpolice")
    public Police getPolice(@RequestBody Police police) {
        return police;
    }
}
