package AnimalCare.InformacionAtenciones.repository;


import AnimalCare.InformacionAtenciones.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Date;

public interface ConsultaRepository extends JpaRepository <Consulta, Integer> {
    List<Consulta> findByFechaConsultaAndMascotaId(Date fechaConsulta, Integer mascotaId);

}

