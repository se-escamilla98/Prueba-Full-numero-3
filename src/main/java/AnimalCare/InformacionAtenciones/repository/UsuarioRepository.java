package AnimalCare.InformacionAtenciones.repository;

import AnimalCare.InformacionAtenciones.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
    Optional<Usuario> findByRut(String rut);
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);

}
