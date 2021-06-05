package az.mycompany.turbodatabaseservice.controller;


import az.mycompany.turbodatabaseservice.dto.ContactInfoDto;
import az.mycompany.turbodatabaseservice.entity.ContactInfoEntity;

import az.mycompany.turbodatabaseservice.service.ContactInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contactinfo")

public class ContactInfoControler {
   private final ContactInfoService service;

    public ContactInfoControler(ContactInfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ContactInfoDto dto) {
        return ResponseEntity.ok(service.create(dto));
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
    public ResponseEntity<?> update(@RequestBody ContactInfoDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

}
