package az.mycompany.turbodatabaseservice.controller;


import az.mycompany.turbodatabaseservice.dto.CityDto;
import az.mycompany.turbodatabaseservice.entity.CityEntity;

import az.mycompany.turbodatabaseservice.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/city")

public class CityController {

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody CityDto city) {

        return ResponseEntity.ok(service.create(city));
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(service.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CityDto city) {

        return ResponseEntity.ok(service.update(city));
    }


}
