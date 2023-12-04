package incidentes_tpjii;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name = "cuit")
    private int cuit;

    @Setter
    @Getter
    @Column(name = "razon_social")
    private String razon_social;

    @ManyToMany
    @Getter
    @Setter
    @JoinTable(
            name = "cliente_servicio",
            joinColumns = @JoinColumn(name = "id_servicio"),
            inverseJoinColumns = @JoinColumn(name = "id_cliente")
    )
    private List<Servicio> servicios;



    // Constructor, getters y setters

    // Constructor vacío necesario para JPA
    public Cliente() {}

    public Cliente(String razon_social) {
        this.razon_social = razon_social;
    }

}