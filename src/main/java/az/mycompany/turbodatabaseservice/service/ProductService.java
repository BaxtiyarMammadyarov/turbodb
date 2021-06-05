package az.mycompany.turbodatabaseservice.service;


import az.mycompany.turbodatabaseservice.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductService extends CrudService<ProductDto,Integer> {
}
