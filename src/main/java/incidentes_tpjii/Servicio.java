package incidentes_tpjii;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name = "nombre_servicio")
    private String nombre_servicio;

    @ManyToMany
    @Setter
    @Getter
    @JoinTable(
            name = "servicio_plataforma",
            joinColumns = @JoinColumn(name = "id_servicio"),
            inverseJoinColumns = @JoinColumn(name = "id_plataforma")
    )
    private List<Plataforma> plataformas;

    @ManyToMany
    @Setter
    @Getter
    @JoinTable(
            name = "cliente_servicio",
            joinColumns = @JoinColumn(name = "id_servicio"),
            inverseJoinColumns = @JoinColumn(name = "id_cliente")
    )
    private List<Cliente> clientes;

    // Constructor, getters y setters

    // Constructor vacío necesario para JPA
    public Servicio() {}

    public Servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

}