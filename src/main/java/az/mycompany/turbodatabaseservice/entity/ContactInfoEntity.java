package az.mycompany.turbodatabaseservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contact_info", schema = "turbo")
public class ContactInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column( nullable = false,unique = true)
    private String name;
    @Column(name = "phone", nullable = false,unique = true)
    private String phone;
    @Column(name = "email", nullable = false, length = 50,unique = true)
    private String email;
    @ManyToOne(targetEntity = CityEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityEntity cityEntity;


}
