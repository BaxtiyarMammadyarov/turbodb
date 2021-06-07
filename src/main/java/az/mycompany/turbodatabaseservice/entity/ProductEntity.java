package az.mycompany.turbodatabaseservice.entity;



import az.mycompany.turbodatabaseservice.dto.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "product", schema = "turbodb")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = BrandEntity.class)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private BrandEntity brandEntity;
    @ManyToOne(targetEntity = ModelEntity.class)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private ModelEntity model;
    @ManyToOne(targetEntity = FuelTypeEntity.class)
    @JoinColumn(name = "fuel_id", referencedColumnName = "id")
    private FuelTypeEntity fuelType;//yanacaq novu
    @Enumerated(EnumType.STRING)
    @Column(name = "drive",nullable = false)
    private DriveEnum drive;//outrun
    @Column(length = 19,nullable = false)
    private BigDecimal price;//qiymeti
    @Enumerated(EnumType.STRING)
    @Column(name = "valyuta",nullable = false)
    private Valyuta valyuta;
    @Column(name = "mile_age",nullable = false)
    private int mileage;//yuruyusu
    @Column(name = "engine_power")
    private Short enginePower;//muherrik gucu
    private Short releaseYear;//istehsal tarixi
    @Column(name = "credit_status",nullable = false )
    private boolean creditStatus;//kredit statusu
    @Column(name = "barter_status",nullable = false)
    private boolean barterStatus;
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo;
    @ManyToOne(targetEntity =ContactInfoEntity.class)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private ContactInfoEntity contactInfo;
    @Enumerated(EnumType.STRING)
    private Body_Type bodyType;
    @Enumerated(EnumType.STRING)
    private Colors color;
    private float engineCapacity;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    private boolean ststus=true;

}
