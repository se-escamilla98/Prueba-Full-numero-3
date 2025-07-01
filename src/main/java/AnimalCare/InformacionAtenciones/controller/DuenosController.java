package AnimalCare.InformacionAtenciones.controller;

import AnimalCare.InformacionAtenciones.model.Duenos;
import AnimalCare.InformacionAtenciones.services.DuenosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/duenos_mascotas")
public class DuenosController {

    @Autowired
    private DuenosService duenosService;

    @GetMapping
    public List<Duenos> listarDuenos() {
        return duenosService.listarDueno();
    }

    @PostMapping
    public Duenos registrarDuenos(@RequestBody Duenos duenos) {
        return duenosService.registrarDuenos(duenos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Duenos> obtenerDuenosPorId(@PathVariable Integer id) {
        Optional<Duenos> duenos = duenosService.obtenerDuenosPorId(id);
        return duenos.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Duenos> actualizarDuenos(@PathVariable Integer id, @RequestBody Duenos duenosActualizado) {
        Optional<Duenos> duenos = duenosService.actualizarDuenos(id, duenosActualizado);
        return duenos.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Integer id) {
        boolean eliminado = duenosService.eliminarDuenos(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<Duenos> buscarPorCorreo(@RequestParam String correoElectronico) {
        Optional<Duenos> dueno = duenosService.buscarPorCorreoElectronico(correoElectronico);
        return dueno.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
