package az.mycompany.turbodatabaseservice.repository;


import az.mycompany.turbodatabaseservice.entity.FuelTypeEntity;
import az.mycompany.turbodatabaseservice.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelTypeEntity,Integer> {
    FuelTypeEntity findByName(String name);
@Query(value = "select * from fuel_type where status=true",nativeQuery = true)
    List<FuelTypeEntity> findAllByStatus();
}
