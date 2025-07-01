package AnimalCare.InformacionAtenciones.model;
import jakarta.persistence.*;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tratamientos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Schema(description = "Representa un tratamiento veterinario")

public class Tratamiento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tratamiento")
    private Integer id;

    @Column(nullable = false, unique = true)
    @Schema(description = "Nombre del tratamiento")
    private String nombre;

    @Column(nullable = false)
    @Schema(description = "Descripción del tratamiento")
    private String descripcion;

}
