package az.mycompany.turbodatabaseservice.dto;



import az.mycompany.turbodatabaseservice.dto.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Integer id;
    @NotBlank(message = "brand name can't be empty or null")
    private BrandDto brandDto;
    @NotBlank(message = "model name can't be empty or null")
    private ModelDto modeldto;
    @NotBlank(message = "fuel name can't be empty or null")
    private FuelTypeDto fuelType;//yanacaq novu
    @NotBlank(message = "drive  can't be empty or null")
    @Enumerated(EnumType.STRING)
    private DriveEnum drive;//oturucu
    @NotBlank(message = "release Year  can't be empty or null")
    private Short releaseYear;//istehsal tarixi
     @NotBlank(message =" price can't be empty or null")
    private BigDecimal price;//qiymeti
    @NotBlank(message = "valyuta can't be empty or null")
    @Enumerated(EnumType.STRING)
    private Valyuta valyuta;
    @NotBlank(message = "mileage  can't be empty or null")
    private int mileage;//yuruyusu
    @NotBlank(message = "engnePower  can't be empty or null")
    private Short enginePower;//muherrik gucu
    private boolean creditStatus;//kredit statusu
    private boolean barter;
    private String desc;
    private String photo;
    private Body_Type bodyType;
    private Colors color;
    private float engineCapacity;
    private Transmission transmission;
    @NotBlank(message = "contact info  can't be empty or null")
    private ContactInfoDto contactInfoDto;


}
