package az.mycompany.turbodatabaseservice.repository;


import az.mycompany.turbodatabaseservice.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {


    @Query(name = "select * from brand where brand.name=?1", nativeQuery = true)
    Optional<BrandEntity> findByName(String name);


    @Query(value = "select * from brand where status=true ", nativeQuery = true)
    List<BrandEntity> findAllByStatus();


}
