package AnimalCare.InformacionAtenciones.model;

import jakarta.persistence.*;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "usuarios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Schema(description = "Representa a un usuario administrativo")

public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del usuario")
    private Integer id;

    @Column(nullable = false, unique = true)
    @Schema(description = "RUT del usuario")
    private String rut;

    @Column(nullable = false)
    @Schema(description = "Nombre completo del usuario")
    private String nombreCompleto;

    @Column(nullable = false, unique = true)
    @Schema(description = "Correo electrónico del usuario")
    private String correoElectronico;

}

