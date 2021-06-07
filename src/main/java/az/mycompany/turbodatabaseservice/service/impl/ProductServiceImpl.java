package az.mycompany.turbodatabaseservice.service.impl;


import az.mycompany.turbodatabaseservice.dto.*;
import az.mycompany.turbodatabaseservice.entity.*;
import az.mycompany.turbodatabaseservice.repository.*;
import az.mycompany.turbodatabaseservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final CityRepository cityRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final ContactInfoRepository contactInfoRepository;

    public ProductServiceImpl
            (
                    ProductRepository productRepository
                    , BrandRepository brandRepository
                    , ModelRepository modelRepository
                    , CityRepository cityRepository
                    , FuelTypeRepository fuelTypeRepository
                    , ContactInfoRepository contactInfoRepository
            ) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.cityRepository = cityRepository;
        this.fuelTypeRepository = fuelTypeRepository;
        this.contactInfoRepository = contactInfoRepository;
    }

    @Override
    public ResponseEntity<?> create(ProductDto productDto) {
        ProductEntity entity = new ProductEntity();
        entity = concertFromDtoEntity(productDto, entity);
        entity = productRepository.save(entity);
        productDto = convertFromEntityToDto(entity);
        return ResponseEntity.ok(productDto);
    }


    @Override
    public ResponseEntity<?> delete(Integer id) {
        ProductEntity entity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product id not founded."));
       entity.setStstus(false);
        productRepository.delete(entity);
        return ResponseEntity.ok(String.format("Raw with %s id successfully deleted.", id));
    }

    @Override
    public ResponseEntity<?> update(ProductDto productDto) {
        ProductEntity entity = getById(productDto.getId());
        entity = concertFromDtoEntity(productDto, entity);
        entity = productRepository.save(entity);
        productDto = convertFromEntityToDto(entity);
        return ResponseEntity.ok(productDto);
    }

    @Override
    public ResponseEntity<?> get() {
        List<ProductDto> list = productRepository
                .findAllByStatus()
                .stream()
                .map(this::convertFromEntityToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }

    ProductDto convertFromEntityToDto(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());

        dto.setBrandDto(new BrandDto(entity.getBrandEntity().getId(),entity.getBrandEntity().getName()));

        dto.setModeldto(new ModelDto(entity.getModel().getId()
                ,entity.getModel().getName()
                ,new BrandDto(entity.getModel().getBrandEntity().getId()
                ,entity.getModel().getBrandEntity().getName())));

        dto.setContactInfoDto(new ContactInfoDto(entity.getContactInfo().getId()
                ,entity.getContactInfo().getName()
                ,entity.getContactInfo().getEmail()
                ,entity.getContactInfo().getPhone()
                ,new CityDto(entity.getContactInfo().getCityEntity().getId(),
                entity.getContactInfo().getCityEntity().getName())));

        dto.setFuelType(new FuelTypeDto(entity.getFuelType().getId(),entity.getFuelType().getName()));
        dto.setEnginePower(entity.getEnginePower());
        dto.setDrive(entity.getDrive());
        dto.setDesc(entity.getDescription());
        dto.setBarter(entity.isBarterStatus());
        dto.setCreditStatus(entity.isCreditStatus());
        dto.setMileage(entity.getMileage());
        dto.setReleaseYear(entity.getReleaseYear());
        dto.setValyuta(entity.getValyuta());
        dto.setPhoto(entity.getPhoto());
        dto.setPrice(entity.getPrice());
        dto.setTransmission(entity.getTransmission());
        dto.setColor(entity.getColor());
        dto.setBodyType(entity.getBodyType());
        dto.setEngineCapacity(entity.getEngineCapacity());
        return dto;
    }

    private ProductEntity getById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product id not founded."));
    }

    private FuelTypeEntity checkFuelType(ProductDto productDto) {
        return fuelTypeRepository
                .findById(productDto.getFuelType().getId())
                .orElseGet(() -> {
                    FuelTypeEntity fuelType = new FuelTypeEntity();
                    fuelType.setName(productDto.getFuelType().getName());
                    fuelType = fuelTypeRepository.save(fuelType);
                    return fuelType;
                });

    }

    private ModelEntity checkModel(ProductDto productDto) {
        return modelRepository
                .findById(productDto.getModeldto().getId())
                .orElseGet(() -> {
                    ModelEntity modelEntity = new ModelEntity();
                    modelEntity.setName(productDto.getModeldto().getName());
                    BrandEntity brand = brandRepository
                            .findById(productDto.getModeldto().getBrandDto().getId())
                            .orElseGet(() -> {
                                BrandEntity brandEntity = new BrandEntity();
                                brandEntity.setName(productDto.getModeldto().getBrandDto().getName());
                                brandEntity = brandRepository.save(brandEntity);
                                return brandEntity;
                            });
                    modelEntity.setBrandEntity(brand);
                    modelEntity = modelRepository.save(modelEntity);
                    return modelEntity;

                });
    }
    private BrandEntity checkBrand(ProductDto productDto){
        return brandRepository
                .findById(productDto.getBrandDto().getId())
                .orElseThrow(() -> new RuntimeException("brand id not found"));
    }

    private ContactInfoEntity checkContact(ProductDto productDto) {
        return contactInfoRepository
                .findById(productDto.getContactInfoDto().getId())
                .orElseGet(() -> {
                    ContactInfoEntity entity = new ContactInfoEntity();
                    entity.setName(productDto.getContactInfoDto().getName());
                    entity.setEmail(productDto.getContactInfoDto().getEmail());
                    entity.setPhone(productDto.getContactInfoDto().getPhone());
                    entity.setCityEntity(cityRepository
                            .findById(productDto.getContactInfoDto().getId())
                            .orElseGet(() -> {
                                CityEntity cityEntity = new CityEntity();
                                cityEntity.setName(productDto.getContactInfoDto().getCity().getName());
                                cityEntity = cityRepository.save(cityEntity);
                                return cityEntity;
                            }));
                    entity = contactInfoRepository.save(entity);
                    return entity;
                });
    }

    private ProductEntity concertFromDtoEntity(ProductDto productDto, ProductEntity entity) {
       entity.setBrandEntity(checkBrand(productDto));
        entity.setModel(checkModel(productDto));
        entity.setContactInfo(checkContact(productDto));
        entity.setFuelType(checkFuelType(productDto));
        entity.setCreditStatus(productDto.isCreditStatus());
        entity.setDrive(productDto.getDrive());
        entity.setEnginePower(productDto.getEnginePower());
        entity.setPhoto(productDto.getPhoto());
        entity.setMileage(productDto.getMileage());
        entity.setPrice(productDto.getPrice());
        entity.setValyuta(productDto.getValyuta());
        entity.setBarterStatus(productDto.isBarter());
        entity.setDescription(productDto.getDesc());
        entity.setReleaseYear(productDto.getReleaseYear());
        entity.setColor(productDto.getColor());
        entity.setEngineCapacity(productDto.getEngineCapacity());
        entity.setBodyType(productDto.getBodyType());
        entity.setTransmission(productDto.getTransmission());
        return entity;
    }


}
