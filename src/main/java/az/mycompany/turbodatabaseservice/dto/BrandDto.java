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
public class BrandDto {
    private int id;
    @NotBlank(message ="Brand name can't be empty or null")
    private  String name;
}
