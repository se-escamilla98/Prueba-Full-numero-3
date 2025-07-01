package AnimalCare.InformacionAtenciones.model;

import jakarta.persistence.*;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "dueños")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representa a un dueño de mascota")

public class Duenos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del dueño")
    private Integer id;

    @Column(nullable = false, unique = true)
    @Schema(description = "RUT del dueño")
    private String rut;

    @Column(nullable = false)
    @Schema(description = "Nombre completo del dueño")
    private String nombreCompleto;

    @Column(nullable = false, unique = true)
    @Schema(description = "Correo electrónico del dueño")
    private String correoElectronico;

    @Column(nullable = false)
    @Schema(description = "Teléfono del dueño")
    private String telefono;


    public Object getNombre() {
    }

    public void setNombre(Object nombre) {

    }
}
