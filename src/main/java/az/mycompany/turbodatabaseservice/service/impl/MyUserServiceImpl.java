package az.mycompany.turbodatabaseservice.service.impl;

import az.mycompany.turbodatabaseservice.dto.UserDto;
import az.mycompany.turbodatabaseservice.entity.UserEntity;
import az.mycompany.turbodatabaseservice.repository.UserRepository;
import az.mycompany.turbodatabaseservice.service.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MyUserServiceImpl implements CrudService<UserDto,Integer> {
    private final UserRepository repository;

    public MyUserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }



    @Override
    public ResponseEntity<?> create(UserDto userDto) { System.out.println("servis daxili");
        UserEntity entity=new UserEntity();
        entity.setName(userDto.getName());
        entity.setSurname(userDto.getSurname());
        entity.setFatherName(userDto.getFatherName());
        entity.setEmail(userDto.getEmail());
        entity.setPhone(userDto.getPhone());
        entity.setPassword(userDto.getPassword());
        entity.setUserName(userDto.getUserName());
        entity.setPin(userDto.getPin());
       entity= repository.save(entity);
        userDto= convertEntityToDto(entity);

        return ResponseEntity.ok(userDto);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> get() {
        return null;
    }


    public ResponseEntity<?> findUser(String username) {
        UserEntity entity=repository.findByUserName(username);
        UserDto dto= convertEntityToDto(entity);
        return ResponseEntity.ok(dto) ;
    }


    public ResponseEntity<?> existsByEmail(String email) {
        return ResponseEntity.ok(repository.existsByEmail(email));
    }


    public ResponseEntity<?> existsByUsername(String username) {
        System.out.println("exsist user isledi");
        return ResponseEntity.ok(repository.existsByUserName(username));
    }


    public ResponseEntity<?> existsByPinCode(String finCode) {
      return ResponseEntity.ok(repository.existsByPin(finCode));

    }


    public ResponseEntity<?> existsByPhone(String phone) {
        return ResponseEntity.ok(repository.existsByPhone(phone));
    }

    private UserDto convertEntityToDto(UserEntity entity){
        UserDto dto=new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setFatherName(entity.getFatherName());
        dto.setUserName(entity.getUserName());
        dto.setEmail(entity.getEmail());
        dto.setPin(entity.getPin());
        dto.setPassword(entity.getPassword());
        dto.setCreateDateTime(entity.getCreateDateTime());
        dto.setUpdateDateTime(entity.getUpdateDateTime());

        return dto;

    }

}
