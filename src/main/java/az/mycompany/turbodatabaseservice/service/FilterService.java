package az.mycompany.turbodatabaseservice.service;



import az.mycompany.turbodatabaseservice.dto.enums.SearchDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public interface FilterService {

    ResponseEntity<?> getProduct(String brandName,String modelName,
                                 BigDecimal minPrice,
                                 BigDecimal maxPrice,
                                 Short minYear,
                                 Short maxYear,
                                 String cityName );

    ResponseEntity<?>search(SearchDto dto);


}
