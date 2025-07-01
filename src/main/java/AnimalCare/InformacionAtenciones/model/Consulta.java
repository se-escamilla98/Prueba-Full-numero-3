package AnimalCare.InformacionAtenciones.model;


import jakarta.persistence.*;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Entity
@Table(name = "consultas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Schema(description = "Representa una consulta veterinaria")

public class Consulta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la consulta")
    private Integer id;

    @Column(nullable = false)
    @Schema(description = "Fecha de la consulta")
    private Date fechaConsulta;

    @Column(nullable = false)
    @Schema(description = "Observaciones de la consulta")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "mascota_id", nullable = false)
    @Schema(description = "Mascota asociada a la consulta")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "tratamiento_id", nullable = false)
    @Schema(description = "Tratamiento aplicado en la consulta")
    private Tratamiento tratamiento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @Schema(description = "Usuario administrativo que registró la consulta")
    private Usuario usuario;
}
