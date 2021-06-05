package az.mycompany.turbodatabaseservice.controller;


import az.mycompany.turbodatabaseservice.dto.ModelDto;
import az.mycompany.turbodatabaseservice.entity.ModelEntity;
import az.mycompany.turbodatabaseservice.service.ModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/model")

public class ModelController {
     private final ModelService service;

    public ModelController(ModelService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ModelDto model) {

        return service.create(model);
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return service.get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        return service.delete(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ModelDto model) {
        return service.update(model);
    }
}
