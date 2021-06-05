package az.mycompany.turbodatabaseservice.controller;


import az.mycompany.turbodatabaseservice.dto.BrandDto;
import az.mycompany.turbodatabaseservice.entity.BrandEntity;

import az.mycompany.turbodatabaseservice.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/brand")

public class BrandController {
private final BrandService service;

    public BrandController(BrandService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BrandDto brand) {
        return ResponseEntity.ok(service.create(brand));
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return  ResponseEntity.ok(service.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BrandDto brand) {
        return ResponseEntity.ok(service.update(brand));
    }
}
