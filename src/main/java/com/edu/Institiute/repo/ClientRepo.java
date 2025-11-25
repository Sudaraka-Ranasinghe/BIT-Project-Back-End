package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Client;
import com.edu.Institiute.entity.Course;
import com.edu.Institiute.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client,String> {
    @Query(value = "SELECT * FROM client WHERE id=:clientId", nativeQuery = true)
    Client findByClientId(@Param("clientId") String clientId);

    @Query(value = "SELECT * FROM client WHERE id=:clientCode", nativeQuery = true)
    List<Client> getAllClientForProvidedId(@Param("clientCode") String clientCode);

    @Query(value = "SELECT * FROM client WHERE id=:clientId", nativeQuery = true)
    Optional<Client> getClientsById(@Param("clientId")String clientId);

}
