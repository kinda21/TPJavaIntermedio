package incidentes_tpjii;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "problema")
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name = "descripcion_problema")
    private String descripcion_problema;

    @Getter
    @Column
    private int tiempoenHS_estimado;

    @ManyToOne
    @Setter
    @Getter
    private TipoProblema tipoProblema;

    @ManyToOne
    @Setter
    @Getter
    @JoinColumn(name="incidente_id", referencedColumnName = "id")
    private Incidente incidente;

    void setTiempoEstimado() {
        tiempoenHS_estimado = tipoProblema.getTiempoenHS_maxResolucion();
    }
}