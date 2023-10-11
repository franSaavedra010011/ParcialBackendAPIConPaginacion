package com.example.demo.repositories;

import com.example.demo.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {

    //Anotación de método de Query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    /*
    boolean existByDni(int dni);
     */

    //Anotación JPQL con parámetros nombrados
    @Query (value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%'")
    List<Persona> search(@Param("filtro") String filtro);

    @Query (value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%'")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    /*
    //Anotación JPQL con parámetros indexados
    @Query (value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%'")
    List<Persona> search(String filtro);
    */

    @Query(
            value = "SELECT * FROM persona WHERE persona.first_name LIKE '%?1%' OR persona.last_name LIKE '%?1%'",
            nativeQuery = true
    )
    List<Persona> searchNativo(String filtro);

    @Query(
            value = "SELECT * FROM persona WHERE persona.first_name LIKE '%?1%' OR persona.last_name LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(String filtro, Pageable pageable);


}