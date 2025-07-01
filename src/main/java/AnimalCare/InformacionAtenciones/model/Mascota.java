package AnimalCare.InformacionAtenciones.model;

import jakarta.persistence.*;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "mascotas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Schema(description = "Representa a una mascota")

public class Mascota {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la mascota")
    private Integer id;

    @Column(nullable = false)
    @Schema(description = "Nombre de la mascota")
    private String nombre;

    @Column(nullable = false)
    @Schema(description = "Especie de la mascota")
    private String especie;

    @Column(nullable = false)
    @Schema(description = "Raza de la mascota")
    private String raza;

    @Column(nullable = false)
    @Schema(description = "Edad de la mascota")
    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "dueño_id", nullable = false)
    @Schema(description = "Dueño de la mascota")
    private Duenos dueno;

}
