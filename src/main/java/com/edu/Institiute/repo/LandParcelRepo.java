package com.edu.Institiute.repo;

import com.edu.Institiute.entity.LandParcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LandParcelRepo extends JpaRepository<LandParcel,String> {
    @Query(value = "select * from landParcel where land_parcel_id=:landParcelId", nativeQuery = true)
    LandParcel findByLandParcelId(@Param("landParcelId") String landParcelId);

    @Query(value = "SELECT * FROM landParcel WHERE land_parcel_id=:landParcelId", nativeQuery = true)
    List<LandParcel> getAllLandParcelsForProvidedId(@Param("landParcelId") String landParcelId);

    @Query(value = "SELECT * FROM landParcelId WHERE land_parcel_id=:landParcelId", nativeQuery = true)
    Optional<LandParcel> getLandParcelById(@Param("landParcelId") String landParcelId);
}
