package AnimalCare.InformacionAtenciones.services;

import AnimalCare.InformacionAtenciones.model.Duenos;
import AnimalCare.InformacionAtenciones.repository.DuenosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenosService {

    @Autowired
    private DuenosRepository duenosRepository;

    public List<Duenos> listarDueno() {
        return duenosRepository.findAll();
    }

    public Duenos registrarDuenos(Duenos duenos) {
        return duenosRepository.save(duenos);
    }

    public Optional<Duenos> obtenerDuenosPorId(Integer id) {
        return duenosRepository.findById(id);
    }

    public Optional<Duenos> actualizarDuenos(Integer id, Duenos duenosActualizado) {
        return duenosRepository.findById(id).map(duenosExistente -> {
            duenosExistente.setNombreCompleto(duenosActualizado.getNombreCompleto());
            duenosExistente.setRut(duenosActualizado.getRut());
            duenosExistente.setTelefono(duenosActualizado.getTelefono());
            duenosExistente.setCorreoElectronico(duenosActualizado.getCorreoElectronico());
            return duenosRepository.save(duenosExistente);
        });
    }

    public boolean eliminarDuenos(Integer id) {
        if (duenosRepository.existsById(id)) {
            duenosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Duenos> buscarPorCorreoElectronico(String correoElectronico) {
        return duenosRepository.findByCorreoElectronico(correoElectronico);
    }
}
