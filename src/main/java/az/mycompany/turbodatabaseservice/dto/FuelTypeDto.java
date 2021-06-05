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
public class FuelTypeDto {
    private int id;
    @NotBlank(message =" fuel type name can't be empty or null")
    private String name;
}
