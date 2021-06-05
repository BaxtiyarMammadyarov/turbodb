package az.mycompany.turbodatabaseservice.service;


import az.mycompany.turbodatabaseservice.dto.ContactInfoDto;
import org.springframework.stereotype.Service;


@Service
public interface ContactInfoService extends CrudService<ContactInfoDto,Integer> {
}
