package az.mycompany.turbodatabaseservice.controller;



import az.mycompany.turbodatabaseservice.dto.UserDto;
import az.mycompany.turbodatabaseservice.service.impl.MyUserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final MyUserServiceImpl service;

    public UserController(MyUserServiceImpl myUserService) {
        this.service = myUserService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserDto dto) {
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
    public ResponseEntity<?> update(@RequestBody UserDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }


    @PostMapping("/findUsername")
   public ResponseEntity<?> findUsername(String username){
       return service.findUser(username);
    }
    @PostMapping("/existsEmail")
   public ResponseEntity<?>existsEmail(@RequestBody String email){
        return service.existsByEmail(email);
    }
    @PostMapping("/existsUsername")
    public ResponseEntity<?>existsUsername(@RequestBody String username){
        return service.existsByUsername(username);
        }
    @PostMapping("/existsPinCode")
   public ResponseEntity<?> existsPinCode(@RequestBody String pinCode){
        return service.existsByPinCode(pinCode);
    }
    @PostMapping("/existsPhone")
    public ResponseEntity<?> existsPhone(String phone){
        return service.existsByPhone(phone);
    }
}
