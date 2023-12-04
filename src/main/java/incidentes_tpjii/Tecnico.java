package incidentes_tpjii;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name = "legajo")
    private Long legajo;

    @Setter
    @Getter
    @Column(name = "medio_notificacion")
    private String medio;

    @Setter
    @Getter
    @Column(name = "nombre_tecnico")
    private String nombre_tecnico;

    @ManyToMany
    @Setter
    @Getter
    private List<Especialidad> especialidades;



    // Constructor, getters y setters

    // Constructor vacío necesario para JPA
    public Tecnico() {}

    public Tecnico(String nombre_tecnico) {
        this.nombre_tecnico = nombre_tecnico;
    }

}