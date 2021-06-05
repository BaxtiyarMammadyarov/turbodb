package az.mycompany.turbodatabaseservice.service;


import az.mycompany.turbodatabaseservice.dto.BrandDto;
import org.springframework.stereotype.Service;

@Service
public interface BrandService extends CrudService<BrandDto,Integer> {
}
