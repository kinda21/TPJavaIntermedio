package incidentes_tpjii;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "tipoProblema")
public class TipoProblema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name = "nombre_tipo")
    private String nombre_tipo;

    @Setter
    @Getter
    @Column(name = "tiempoenHS_maxResolucion")
    private int tiempoenHS_maxResolucion;

    @ManyToOne
    @Setter
    @Getter
    @JoinColumn (name= "id_especialidad_problema", referencedColumnName = "id_especialidad")
    private Especialidad especialidad_problema;

}