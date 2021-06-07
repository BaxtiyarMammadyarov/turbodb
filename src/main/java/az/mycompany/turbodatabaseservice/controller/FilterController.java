package az.mycompany.turbodatabaseservice.controller;


import az.mycompany.turbodatabaseservice.dto.enums.SearchDto;
import az.mycompany.turbodatabaseservice.service.FilterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("/filter")
public class FilterController {

       private final FilterService service;

    public FilterController(FilterService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public ResponseEntity<?> getSearch(
            @RequestParam (defaultValue =" ")String brandName,
            @RequestParam(defaultValue =" ") String modelName,
            @RequestParam (defaultValue =""+Double.MIN_VALUE)BigDecimal minPrice,
            @RequestParam(defaultValue =""+Double.MAX_VALUE) BigDecimal maxPrice,
            @RequestParam(defaultValue =""+Short.MIN_VALUE) Short minYear ,
            @RequestParam (defaultValue =""+Short.MAX_VALUE)Short maxYear,
            @RequestParam(defaultValue =" ") String cityName ) {
        return service.getProduct(brandName,modelName,minPrice,maxPrice,minYear,maxYear,cityName);
    }

     @PostMapping("/filtir")
    public ResponseEntity<?> search(@RequestBody SearchDto dto){
        return service.search(dto);
    }


}
