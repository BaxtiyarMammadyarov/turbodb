package az.mycompany.turbodatabaseservice.controller;


import az.mycompany.turbodatabaseservice.dto.BrandDto;

import az.mycompany.turbodatabaseservice.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private final BrandService brandService;


    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BrandDto brand) {
        return ResponseEntity.ok(brandService.create(brand));
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(brandService.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        return ResponseEntity.ok(brandService.delete(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BrandDto brand) {
        return ResponseEntity.ok(brandService.update(brand));
    }
}
