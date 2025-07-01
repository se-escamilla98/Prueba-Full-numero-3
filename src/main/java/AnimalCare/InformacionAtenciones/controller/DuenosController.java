package AnimalCare.InformacionAtenciones.controller;

import AnimalCare.InformacionAtenciones.model.Duenos;
import AnimalCare.InformacionAtenciones.services.DuenosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/duenos_mascotas")


public class DuenosController {

    @Autowired
    private DuenosInterface duenosInterface;


    @GetMapping
    public List<Duenos> listarDuenos() {
        return duenosInterface.listarDuenos();
    }


    @PostMapping
    public Duenos registrarDuenos(@RequestBody Duenos duenos) {
        return DuenosInterface.registrarDuenos(duenos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Duenos> obtenerDuenosPorId(@PathVariable Long id) {
        Optional<Duenos> duenos = duenosInterface.obtenerDuenoPorId(id);
        return duenos.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Duenos> actualizarDuenos(@PathVariable Long id, @RequestBody Duenos duenosActualizado) {
        Optional<Duenos> duenos = duenosInterface.actualizarDuenos(id, duenosActualizado);
        return duenos.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        boolean eliminado = duenosInterface.eliminarDuenos(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }


    @GetMapping("/buscar")
    public List<Duenos> buscarPorNombre(@RequestParam String nombre) {
        return duenosInterface.buscarPorNombre(nombre);
    }

}
