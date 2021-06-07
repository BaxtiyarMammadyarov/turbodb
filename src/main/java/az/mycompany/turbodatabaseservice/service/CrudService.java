package az.mycompany.turbodatabaseservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface CrudService<DTO, ID> {
    ResponseEntity<?> create(DTO dto);

    ResponseEntity<?> delete(ID id);

    ResponseEntity<?> update(DTO dto);

    ResponseEntity<?> get();


}
