package az.mycompany.turbodatabaseservice.dto;



import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserDto {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String fatherName;
    @NotBlank(message = "fin code cannot be empty")
    private String pin;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    private Date createDateTime;

    private Date updateDateTime;


}
