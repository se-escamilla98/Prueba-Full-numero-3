package AnimalCare.InformacionAtenciones.controller;
import AnimalCare.InformacionAtenciones.model.Mascota;
import AnimalCare.InformacionAtenciones.services.MascotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mascotas")
@Tag(name = "Mascotas", description = "Operaciones CRUD para mascotas")

public class MascotasController {
    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    @Operation(summary = "Obtener todas las mascotas")
    public List<Mascota> getAllMascotas() {
        return mascotaService.getAllMascotas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una mascota por ID")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable Integer id) {
        Mascota mascota = mascotaService.getMascotaById(id);
        return mascota != null ? ResponseEntity.ok(mascota) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Crear una nueva mascota")
    public Mascota createMascota(@RequestBody Mascota mascota) {
        return mascotaService.createMascota(mascota);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una mascota existente")
    public ResponseEntity<Mascota> updateMascota(@PathVariable Integer id, @RequestBody Mascota mascota) {
        Mascota updatedMascota = mascotaService.updateMascota(id, mascota);
        return updatedMascota != null ? ResponseEntity.ok(updatedMascota) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una mascota por ID")
    public ResponseEntity<Void> deleteMascota(@PathVariable Integer id) {
        boolean deleted = mascotaService.deleteMascota(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

                                                                        }
}