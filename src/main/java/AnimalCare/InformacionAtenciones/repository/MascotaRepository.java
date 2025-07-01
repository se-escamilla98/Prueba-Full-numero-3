package AnimalCare.InformacionAtenciones.repository;

import AnimalCare.InformacionAtenciones.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
    List <Mascota> findByEspecieAndRaza (String especie, String raza);

}
