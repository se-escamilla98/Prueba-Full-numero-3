package AnimalCare.InformacionAtenciones.services;
import AnimalCare.InformacionAtenciones.model.Duenos;

import java.util.List;
import java.util.Optional;


public interface DuenosInterface {
    List<Duenos> listarDuenos();
    static Duenos registrarDuenos(Duenos duenos);
    Optional<Duenos> obtenerDuenoPorId(Long id);
    Optional<Duenos> actualizarDuenos(Long id, Duenos duenosActualizado);
    boolean eliminarDuenos(Long id);
    List<Duenos> buscarPorNombre(String nombre);
}
