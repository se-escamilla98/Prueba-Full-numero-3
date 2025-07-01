package AnimalCare.InformacionAtenciones.repository;

import AnimalCare.InformacionAtenciones.model.Duenos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DuenosRepository extends JpaRepository<Duenos, Integer>{
    Optional<Duenos> findByRut(String rut);
    Optional<Duenos> findByCorreoElectronico(String correoElectronico);


}
