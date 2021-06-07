package az.mycompany.turbodatabaseservice.service.impl;



import az.mycompany.turbodatabaseservice.dto.CityDto;
import az.mycompany.turbodatabaseservice.entity.CityEntity;
import az.mycompany.turbodatabaseservice.repository.CityRepository;
import az.mycompany.turbodatabaseservice.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public ResponseEntity<?> create(CityDto cityDto) {
        CityEntity entity = new CityEntity();
        entity.setName(cityDto.getName());
        entity = cityRepository.save(entity);
        cityDto = convertFromEntityToDto(entity);
        return ResponseEntity.ok(cityDto);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        CityEntity entity = getById(id);
        entity.setStstus(false);
        cityRepository.save(entity);
        return ResponseEntity.ok(String.format("Raw with %s id successfully deleted.", id));
    }

    @Override
    public ResponseEntity<?> update(CityDto cityDto) {
        CityEntity entity = getById(cityDto.getId());
        entity.setName(cityDto.getName());
        entity = cityRepository.save(entity);
        cityDto = convertFromEntityToDto(entity);
        return ResponseEntity.ok(cityDto);
    }

    @Override
    public ResponseEntity<List<CityDto>> get() {
        List<CityDto> list = cityRepository
                .findAllByStatus().stream()
                .map(this::convertFromEntityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    private CityDto convertFromEntityToDto(CityEntity entity) {
        return new CityDto(entity.getId(), entity.getName());
    }

    private CityEntity getById(Integer id) {
        return cityRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Brand id not founded."));
    }
}
