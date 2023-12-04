package incidentes_tpjii;

import lombok.Getter;
import lombok.Setter;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import javax.persistence.*;

@Entity
@Table(name="incidente")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name = "descripcion_incidente")
    private String descripcion_incidente;

    @Getter
    @Column(name = "fecha_ingreso")
    private LocalDateTime fecha_ingreso;

    @Getter
    @Column(name = "fecha_resolucion_estimada")
    private LocalDateTime fecha_resolucion_estimada;

    @Getter
    @Column(name = "fecha_resolucion_final")
    private LocalDateTime fecha_resolucion_final;

    @Setter
    @Getter
    @Column(name = "tiempo_extra_enHS")
    private int tiempo_extra_enHS;

    @Setter
    @Getter
    @Column(name = "consideraciones")
    private String consideraciones;

    @OneToMany
    @Setter
    @Getter
    //@Column(name = "problemas")
    private List<Problema> problemas;

    @ManyToMany
    @Getter
    //@Column(name = "especialidades")
    @JoinTable(
            name="incidentes_especialidad",
            joinColumns = @JoinColumn(name="incidente_id"),
            inverseJoinColumns = @JoinColumn(name="especialidad_id")
    )
    private List<Especialidad> especialidades;

    @OneToOne
    @Setter
    @Getter
    private Cliente cliente;

    @OneToOne
    @Setter
    @Getter
    private Servicio servicio;

    @OneToOne
    @Setter
    @Getter
    private Tecnico tecnico;

    @Enumerated(EnumType.STRING)
    @Setter
    @Getter
    private EstadosIncidente estado;

    void setFechaEstimada() {

        int hsacumuladasxproblema = problemas.stream().mapToInt(Problema::getTiempoenHS_estimado).sum();
        fecha_resolucion_estimada = LocalDateTime.now().plusHours(hsacumuladasxproblema+tiempo_extra_enHS);
    }

    void setEspecialidades() {
        List<Especialidad> lista = new ArrayList<Especialidad>();
        lista = problemas.stream().map(Problema::getTipoProblema).map(TipoProblema::getEspecialidad_problema).collect(Collectors.toList());
        Set<Especialidad> set = new HashSet<Especialidad>(lista.size());
        lista.removeIf(p -> !set.add(p));
        especialidades = lista;
    }
    void setFechaResolucion() {
        fecha_resolucion_final = LocalDateTime.now();
    }

    void setFechaResolucion(int extra) {
        fecha_resolucion_final = LocalDateTime.now().plusHours(extra);
    }

    void setFechaIngreso() {
        fecha_ingreso = LocalDateTime.now();
    }
}