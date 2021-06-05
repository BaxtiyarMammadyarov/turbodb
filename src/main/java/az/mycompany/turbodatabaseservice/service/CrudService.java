package az.mycompany.turbodatabaseservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface CrudService<DTO, ID> {
    ResponseEntity<?> create(DTO dto);

    ResponseEntity<?> delete(ID id);

    ResponseEntity<?> update(DTO dto);

    ResponseEntity<?> get();


//    default ResponseEntity<?> create(ID id,DTO dto){
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }
//    default ResponseEntity<?> delete(ID id){
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }
//    default ResponseEntity<?> update(DTO dto){
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }
//    default ResponseEntity<?> get(){
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }

}
