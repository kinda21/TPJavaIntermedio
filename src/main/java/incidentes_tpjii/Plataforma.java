package incidentes_tpjii;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "plataforma")
public class Plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name = "nombre_plataforma")
    private String nombre_plataforma;

    // Constructor, getters y setters

    // Constructor vacío necesario para JPA
    public Plataforma() {}

    public Plataforma(String nombre_plataforma) {
        this.nombre_plataforma = nombre_plataforma;
    }

}
