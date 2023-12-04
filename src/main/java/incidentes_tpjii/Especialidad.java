package incidentes_tpjii;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_especialidad;

    @Setter
    @Getter
    @Column(name = "nombre_especialidad")
    private String nombre_especialidad;

    /*@ManyToMany(mappedBy = "especialidades")
    @Setter
    @Getter
    private List<Tecnico> tecnicos;*/

    /* @OneToMany
    @Setter
    @Getter
    private List<TipoProblema> tipoProblemas ;*/

    // Constructor, getters y setters

    // Constructor vacío necesario para JPA
    public Especialidad() {}

    public Especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

    public boolean equals(Especialidad e) {
        if (Objects.equals(this.getNombre_especialidad(), e.getNombre_especialidad())) return true;
        if (e == null || getClass() != e.getClass()) return false;
        else return false;
    }

}
