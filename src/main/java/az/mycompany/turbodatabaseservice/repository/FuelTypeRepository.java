package az.mycompany.turbodatabaseservice.repository;


import az.mycompany.turbodatabaseservice.entity.FuelTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelTypeEntity,Integer> {
    FuelTypeEntity findByName(String name);
}
