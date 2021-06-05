package az.mycompany.turbodatabaseservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactInfoDto {
    private Integer id;
    @NotBlank(message =" name can't be empty or null")
    private String name;
    @NotBlank(message =" email can't be empty or null")
    private String email;
    @NotBlank(message =" phone can't be empty or null")
    private String phone;
    @NotBlank(message =" city can't be empty or null")
    private CityDto city;
}
