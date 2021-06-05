package az.mycompany.turbodatabaseservice.controller;


import az.mycompany.turbodatabaseservice.dto.ProductDto;

import az.mycompany.turbodatabaseservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")

public class ProductController {
  private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return service.get();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductDto product) {
        return service.create(product);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductDto product) {
        return service.update(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {

        return service.delete(id);
    }

}
