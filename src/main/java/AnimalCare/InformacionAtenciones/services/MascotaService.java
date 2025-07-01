package AnimalCare.InformacionAtenciones.services;

import AnimalCare.InformacionAtenciones.model.Mascota;
import AnimalCare.InformacionAtenciones.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    public Mascota getMascotaById(Integer id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    public Mascota createMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Mascota updateMascota(Integer id, Mascota mascota) {
        if (mascotaRepository.existsById(id)) {
            mascota.setId(id);
            return mascotaRepository.save(mascota);
        }
        return null;
    }

    public boolean deleteMascota(Integer id) {
        if (mascotaRepository.existsById(id)) {
            mascotaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Mascota> getMascotasByEspecieAndRaza(String especie, String raza) {
        return mascotaRepository.findByEspecieAndRaza(especie, raza);
    }
}