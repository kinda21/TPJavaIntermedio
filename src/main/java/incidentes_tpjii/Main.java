package incidentes_tpjii;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

class Main {
    public static void main(String[] args) {
        // Crear el EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("IncidentesPersistencia");

        // Crear el EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Operaciones con la base de datos
        // Inicializo la DB
        //Creo especialidades
        Especialidad espec1 = new Especialidad();
        espec1.setNombre_especialidad("Network");

        Especialidad espec2 = new Especialidad();
        espec2.setNombre_especialidad("Troubleshooting");

        Especialidad espec3 = new Especialidad();
        espec3.setNombre_especialidad("Config");

        Especialidad espec4 = new Especialidad();
        espec4.setNombre_especialidad("Miscelaneo");

        //Creo Tipos de Problema

        TipoProblema tipop1 = new TipoProblema();
        tipop1.setNombre_tipo("Conexion Fallida");
        tipop1.setEspecialidad_problema(espec1);
        tipop1.setTiempoenHS_maxResolucion(8);

        TipoProblema tipop2 = new TipoProblema();
        tipop2.setNombre_tipo("Token invalido");
        tipop2.setEspecialidad_problema(espec2);
        tipop2.setTiempoenHS_maxResolucion(14);

        TipoProblema tipop3 = new TipoProblema();
        tipop3.setNombre_tipo("Problemas con filtros");
        tipop3.setEspecialidad_problema(espec3);
        tipop3.setTiempoenHS_maxResolucion(6);

        TipoProblema tipop4 = new TipoProblema();
        tipop4.setNombre_tipo("Usuario incorrecto");
        tipop4.setEspecialidad_problema(espec2);
        tipop4.setTiempoenHS_maxResolucion(6);

        TipoProblema tipop5 = new TipoProblema();
        tipop5.setNombre_tipo("Contraseña olvidada");
        tipop5.setEspecialidad_problema(espec4);
        tipop5.setTiempoenHS_maxResolucion(6);

        TipoProblema tipop6 = new TipoProblema();
        tipop6.setNombre_tipo("Error al iniciar");
        tipop6.setEspecialidad_problema(espec2);
        tipop6.setTiempoenHS_maxResolucion(32);

       /* no tuve q hacer nada de esto, magia hibernate
        List<TipoProblema> lista1 = new ArrayList<TipoProblema>();
        lista1.add(tipop1);
        List<TipoProblema> lista2 = new ArrayList<TipoProblema>();
        lista2.add(tipop2);
        //lista2.add(tipop4);
        //lista2.add(tipop6);
        List<TipoProblema> lista3 = new ArrayList<TipoProblema>();
        lista3.add(tipop3);
        List<TipoProblema> lista4 = new ArrayList<TipoProblema>();
        lista4.add(tipop6);

        espec1.setTipoProblemas(lista1);
        espec2.setTipoProblemas(lista2);
        espec3.setTipoProblemas(lista3);
        espec4.setTipoProblemas(lista4);*/

        //Creo Tecnicos

        List<Especialidad> listaespec1 = new ArrayList<Especialidad>();
        Tecnico tecnico1 = new Tecnico();
        tecnico1.setLegajo(33125L);
        tecnico1.setNombre_tecnico("pancho");
        tecnico1.setMedio("e-mail");
        listaespec1.add(espec1);
        tecnico1.setEspecialidades(listaespec1);

        List<Especialidad> listaespec2 = new ArrayList<Especialidad>();
        Tecnico tecnico2 = new Tecnico();
        tecnico2.setLegajo(11125L);
        tecnico2.setNombre_tecnico("pancho");
        tecnico2.setMedio("whatsapp");
        listaespec2.add(espec2);
        tecnico2.setEspecialidades(listaespec2);

        List<Especialidad> listaespec3 = new ArrayList<Especialidad>();
        Tecnico tecnico3 = new Tecnico();
        tecnico3.setLegajo(48125L);
        tecnico3.setNombre_tecnico("jose");
        tecnico3.setMedio("e-mail");
        listaespec3.add(espec3);
        tecnico3.setEspecialidades(listaespec3);

        List<Especialidad> listaespec4 = new ArrayList<Especialidad>();
        Tecnico tecnico4 = new Tecnico();
        tecnico4.setLegajo(18455L);
        tecnico4.setNombre_tecnico("tomas");
        tecnico4.setMedio("whatsapp");
        listaespec4.add(espec1);
        listaespec4.add(espec2);
        tecnico4.setEspecialidades(listaespec4);

        List<Especialidad> listaespec5 = new ArrayList<Especialidad>();
        Tecnico tecnico5 = new Tecnico();
        tecnico5.setLegajo(2245L);
        tecnico5.setNombre_tecnico("capo");
        tecnico5.setMedio("whatsapp");
        listaespec5.add(espec1);
        listaespec5.add(espec2);
        listaespec5.add(espec3);
        listaespec5.add(espec4);
        tecnico5.setEspecialidades(listaespec5);

        //Creo Incidentes

        Incidente incid1 = new Incidente();
        Incidente incid2 = new Incidente();
        Incidente incid3 = new Incidente();
        Incidente incid4 = new Incidente();

        //Creo Problemas

        Problema prob1 = new Problema();
        prob1.setDescripcion_problema("al intentar obtener los asientos contables salta un cartel que dice conexión fallida");
        prob1.setIncidente(incid1);
        prob1.setTipoProblema(tipop1);
        prob1.setTiempoEstimado();

            Problema prob2 = new Problema();
            prob2.setDescripcion_problema("despues de ingresar mi usuario y contraseña aparece un error que dice Token invalido");
        prob2.setIncidente(incid2);
        prob2.setTipoProblema(tipop2);
        prob2.setTiempoEstimado();

        Problema prob3 = new Problema();
        prob3.setDescripcion_problema("intento filtrar los spreadsheet por fecha y monto y salta una excepcion");
        prob3.setIncidente(incid3);
        prob3.setTipoProblema(tipop3);
        prob3.setTiempoEstimado();

        Problema prob4 = new Problema();
        prob4.setDescripcion_problema("me olvide el usuario y se lockeo el login");
        prob4.setIncidente(incid4);
        prob4.setTipoProblema(tipop4);
        prob4.setTiempoEstimado();

        Problema prob5 = new Problema();
        prob5.setDescripcion_problema("olvide la contraseña y se lockeo el login");
        prob5.setIncidente(incid4);
        prob5.setTipoProblema(tipop5);
        prob5.setTiempoEstimado();

        Problema prob6 = new Problema();
        prob6.setDescripcion_problema("al intentar abrir la aplicación crashea");
        prob6.setIncidente(incid2);
        prob6.setTipoProblema(tipop6);
        prob6.setTiempoEstimado();

        //Creo Plataformas

        Plataforma plat1 = new Plataforma();
        plat1.setNombre_plataforma("Windows");

        Plataforma plat2 = new Plataforma();
        plat2.setNombre_plataforma("Linux Ubuntu");

        Plataforma plat3 = new Plataforma();
        plat3.setNombre_plataforma("Mac OS");

        //Creo Clientes

        Cliente cliente1 = new Cliente();
        cliente1.setCuit(214556841);
        cliente1.setRazon_social("terrabusi");

        Cliente cliente2 = new Cliente();
        cliente2.setCuit(214556852);
        cliente2.setRazon_social("taragui");

        Cliente cliente3 = new Cliente();
        cliente3.setCuit(214556893);
        cliente3.setRazon_social("sc Johnson");

        Cliente cliente4 = new Cliente();
        cliente4.setCuit(214556814);
        cliente4.setRazon_social("Coop soda chicho");

        //Creo Servicios

        Servicio serv1 = new Servicio();
        serv1.setNombre_servicio("Tango");
        List<Plataforma> listaplats1 = new ArrayList<Plataforma>();
        listaplats1.add(plat1);
        listaplats1.add(plat2);
        listaplats1.add(plat3);
        serv1.setPlataformas(listaplats1);
        List<Cliente> listaclients1 = new ArrayList<Cliente>();
        listaclients1.add(cliente1);
        listaclients1.add(cliente2);
        listaclients1.add(cliente3);
        listaclients1.add(cliente4);
        serv1.setClientes(listaclients1);

            Servicio serv2 = new Servicio();
            serv2.setNombre_servicio("SAP");
        List<Plataforma> listaplats2 = new ArrayList<Plataforma>();
        listaplats2.add(plat1);
        listaplats2.add(plat2);
        listaplats2.add(plat3);
        serv2.setPlataformas(listaplats2);
        List<Cliente> listaclients2 = new ArrayList<Cliente>();
        listaclients2.add(cliente1);
        listaclients2.add(cliente2);
        listaclients2.add(cliente3);
        serv2.setClientes(listaclients2);

        Servicio serv3 = new Servicio();
        serv3.setNombre_servicio("Moodle");
        List<Plataforma> listaplats3 = new ArrayList<Plataforma>();
        listaplats3.add(plat1);
        listaplats3.add(plat1);
        serv3.setPlataformas(listaplats3);
        List<Cliente> listaclients3 = new ArrayList<Cliente>();
        listaclients3.add(cliente1);
        listaclients3.add(cliente2);
        serv3.setClientes(listaclients3);

        Servicio serv4 = new Servicio();
        serv4.setNombre_servicio("vBulletin");
        List<Plataforma> listaplats4 = new ArrayList<Plataforma>();
        listaplats4.add(plat1);
        serv4.setPlataformas(listaplats4);
        List<Cliente> listaclients4 = new ArrayList<Cliente>();
        listaclients4.add(cliente1);
        serv4.setClientes(listaclients4);

        /* Relleno clientes con sus servicios
        NO hizo falta, hibernate magico

        List<Servicio> listaservic1 = new ArrayList<Servicio>();
        listaservic1.add(serv1);
        listaservic1.add(serv2);
        listaservic1.add(serv3);
        listaservic1.add(serv3);
        cliente1.setServicios(listaservic1);

        List<Servicio> listaservic2 = new ArrayList<Servicio>();
        listaservic2.add(serv1);
        listaservic2.add(serv2);
        listaservic2.add(serv3);
        cliente2.setServicios(listaservic2);

        List<Servicio> listaservic3 = new ArrayList<Servicio>();
        listaservic3.add(serv1);
        listaservic3.add(serv2);
        cliente3.setServicios(listaservic3);

        List<Servicio> listaservic4 = new ArrayList<Servicio>();
        listaservic4.add(serv1);
        cliente4.setServicios(listaservic4); */

        // Relleno Incidentes

        incid1.setServicio(serv1);
        incid1.setCliente(cliente4);
        incid1.setDescripcion_incidente("rip tango");
        incid1.setFechaIngreso();
        List<Problema> listprob1 = new ArrayList<Problema>();
        listprob1.add(prob1);
        incid1.setProblemas(listprob1);
        incid1.setTiempo_extra_enHS(120);
        incid1.setEstado(EstadosIncidente.CREADO);
        incid1.setTecnico(tecnico1);
        incid1.setEspecialidades();
        incid1.setFechaEstimada();

        incid2.setServicio(serv2);
        incid2.setCliente(cliente4);
        incid2.setDescripcion_incidente("complejo, tiene 2 problemas crashea o dice token invalido");
        incid2.setFechaIngreso();
        List<Problema> listprob2 = new ArrayList<Problema>();
        listprob2.add(prob2);
        listprob2.add(prob6);
        incid2.setProblemas(listprob2);
        incid2.setTiempo_extra_enHS(480);
        incid2.setEstado(EstadosIncidente.EN_PROGRESO);
        incid2.setTecnico(tecnico2);
        incid2.setEspecialidades();
        incid2.setFechaEstimada();

        incid3.setServicio(serv1);
        incid3.setCliente(cliente3);
        incid3.setDescripcion_incidente("ERROR FILTROS");
        incid3.setFechaIngreso();
        List<Problema> listprob3 = new ArrayList<Problema>();
        listprob3.add(prob3);
        incid3.setProblemas(listprob3);
        incid3.setTiempo_extra_enHS(0);
        incid3.setEstado(EstadosIncidente.RESUELTO);
        incid3.setTecnico(tecnico3);
        incid3.setEspecialidades();
        incid3.setFechaEstimada();
        incid3.setConsideraciones("Bug legitimo. Mas dificil de lo esperado hubo que reescribir codigo.");
        incid3.setFechaResolucion(240);

        incid4.setServicio(serv4);
        incid4.setCliente(cliente3);
        incid4.setDescripcion_incidente("Un boludo se olvido el usuario Y la contraseña");
        incid4.setFechaIngreso();
        List<Problema> listprob4 = new ArrayList<Problema>();
        listprob4.add(prob4);
        listprob4.add(prob5);
        incid4.setProblemas(listprob4);
        incid4.setTiempo_extra_enHS(0);
        incid4.setEstado(EstadosIncidente.RESUELTO);
        incid4.setTecnico(tecnico5);
        incid4.setEspecialidades();
        incid4.setFechaEstimada();
        incid4.setConsideraciones("tiempo record, lo encontro en un txt");
        incid4.setFechaResolucion(120);


        // Iniciar una transacción
        entityManager.getTransaction().begin();

        // Persistir el objeto en la base de datos
        entityManager.persist(espec1);
        entityManager.persist(espec2);
        entityManager.persist(espec3);
        entityManager.persist(espec4);
        entityManager.persist(tipop1);
        entityManager.persist(tipop2);
        entityManager.persist(tipop3);
        entityManager.persist(tipop4);
        entityManager.persist(tipop5);
        entityManager.persist(tipop6);
        entityManager.persist(tecnico1);
        entityManager.persist(tecnico2);
        entityManager.persist(tecnico3);
        entityManager.persist(tecnico4);
        entityManager.persist(tecnico5);
        entityManager.persist(plat1);
        entityManager.persist(plat2);
        entityManager.persist(plat3);
        entityManager.persist(serv1);
        entityManager.persist(serv2);
        entityManager.persist(serv3);
        entityManager.persist(serv4);
        entityManager.persist(cliente1);
        entityManager.persist(cliente2);
        entityManager.persist(cliente3);
        entityManager.persist(cliente4);
        entityManager.persist(prob1);
        entityManager.persist(prob2);
        entityManager.persist(prob3);
        entityManager.persist(prob4);
        entityManager.persist(prob5);
        entityManager.persist(prob6);
        entityManager.persist(incid1);
        entityManager.persist(incid2);
        entityManager.persist(incid3);
        entityManager.persist(incid4);

        try {
            // Commit de la transacción
            entityManager.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Quien fue el tecnico con más incidentes resueltos en N días");
            System.out.println("2. Quien fue el tecnico con mas incidentes resueltos de una especialidad en N días");
            System.out.println("3. Quien fue el tecnico que mas rapido resolvio los incidentes");
            System.out.println("4. Emitir Reporte de incidentes asignados");
            System.out.println("5. Salir");
            System.out.print("Elija la opción: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Consulta: Quien fue el tecnico con mas incidentes resueltos en N días?");
                    int cantdias;
                    System.out.println("Ingrese la antigüedad de los incidentes a evaluar (en dias)");
                    cantdias = scanner.nextInt();
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DAY_OF_YEAR, -cantdias);
                    java.sql.Date fechaabuscar = new java.sql.Date(calendar.getTimeInMillis());
                    String jpql = "SELECT i FROM Incidente i JOIN FETCH i.tecnico WHERE i.fecha_resolucion_final >= "+ fechaabuscar +" AND i.estado='RESUELTO'";
                    TypedQuery<Incidente> query = entityManager.createQuery(jpql, Incidente.class);
                    List<Incidente> incidentes = query.getResultList();
                    if (incidentes.isEmpty()) {
                        System.out.println("No hay resultados");
                        break;
                    }
                    Map<Tecnico, Integer> countMap = new HashMap<>();
                    for (Incidente incidente : incidentes) {
                        Tecnico tecnico = incidente.getTecnico();
                        if (countMap.containsKey(tecnico)) {
                            countMap.put(tecnico, countMap.get(tecnico) + 1);
                        } else {
                            countMap.put(tecnico, 1);
                        }
                    }
                    for (Map.Entry<Tecnico, Integer> entry : countMap.entrySet()) {
                        Tecnico tecnicoamostrar = entry.getKey();
                        int conteo = entry.getValue();
                        System.out.println(tecnicoamostrar.getNombre_tecnico() + " resolvió " + conteo + " Incidente/s.");
                    }


                     /*  System.out.println("Incidente: " + incidente.getDescripcion_incidente());
                        System.out.println("Estado: " + incidente.getEstado());
                        if (incidente.getTecnico() != null) {
                            System.out.println("Dirección: " + incidente.getTecnico().getNombre_tecnico());
                        } else {
                            System.out.println("Sin tecnico registrado.");
                        }
                        System.out.println("--------------------");
                    }*/
                    break;
                case 2:
                    System.out.println("Quien fue el tecnico con mas incidentes resueltos de una especialidad en N días");
                    int cantdiasopc2;
                    System.out.println("Ingrese la antigüedad de los incidentes a evaluar (en dias)");
                    cantdiasopc2 = scanner.nextInt();
                    String especialidadabuscar;
                    System.out.println("Ingrese la especialidad de los incidentes");
                    especialidadabuscar= scanner.next();
                    LocalDate fechaabuscaropc2 = LocalDate.now().minusDays(cantdiasopc2);
                    String jpqlopc2 = "SELECT i FROM Incidente i JOIN FETCH i.tecnico JOIN FETCH i.especialidades e WHERE fecha_resolucion_final >= "+ fechaabuscaropc2.toString()+" AND i.estado='RESUELTO' AND e.nombre_especialidad='"+especialidadabuscar+"'";
                    TypedQuery<Incidente> queryopc2 = entityManager.createQuery(jpqlopc2, Incidente.class);
                    List<Incidente> incidentesopc2 = queryopc2.getResultList();
                    if (incidentesopc2.isEmpty()) {
                        System.out.println("No hay resultados");
                        break;
                    }
                    Map<Tecnico, Integer> countMapopc2 = new HashMap<>();
                    for (Incidente incidente : incidentesopc2) {
                        Tecnico tecnico = incidente.getTecnico();
                        if (countMapopc2.containsKey(tecnico)) {
                            countMapopc2.put(tecnico, countMapopc2.get(tecnico) + 1);
                        } else {
                            countMapopc2.put(tecnico, 1);
                        }
                    }
                    for (Map.Entry<Tecnico, Integer> entry : countMapopc2.entrySet()) {
                        Tecnico tecnicoamostrar = entry.getKey();
                        int conteo = entry.getValue();
                        System.out.println(tecnicoamostrar.getNombre_tecnico() + " resolvió " + conteo + " Incidente/s.");
                    }
                    break;
                case 3:
                    System.out.println("Quien fue el tecnico que mas rapido resolvio los incidentes?");
                    String jpqlopc3 = "SELECT i FROM Incidente i WHERE i.estado='RESUELTO'";
                    TypedQuery<Incidente> queryopc3 = entityManager.createQuery(jpqlopc3, Incidente.class);
                    List<Incidente> incidentesopc3 = queryopc3.getResultList();
                    if (incidentesopc3.isEmpty()) {
                        System.out.println("No hay resultados");
                        break;
                    }
                    HashMap<Tecnico, Duration> duracionincidentesmap = new HashMap<>();

                    for (Incidente incidente : incidentesopc3) {
                        Tecnico tecnico = incidente.getTecnico();
                        LocalDateTime fecha_ingreso = incidente.getFecha_ingreso();
                        LocalDateTime fecha_final = incidente.getFecha_resolucion_final();
                        Duration duracion = Duration.between(fecha_ingreso,fecha_final);
                        duracionincidentesmap.put(tecnico, duracion);
                    }

                    Tecnico mejorTecnico = null;
                    Duration menorDuracion = null;

                    for (Map.Entry<Tecnico, Duration> entry : duracionincidentesmap.entrySet()) {
                        Tecnico tecnico = entry.getKey();
                        Duration duracion = entry.getValue();
                        if (menorDuracion == null || duracion.compareTo(menorDuracion) < 0) {
                            menorDuracion = duracion;
                            mejorTecnico = tecnico;
                        }

                    }
                    System.out.println("¡Técnico más veloz!");
                    System.out.println("Técnico: " + mejorTecnico.getNombre_tecnico() +
                            ", Duracion total de los incidentes asignados: " + menorDuracion.toHours() + " horas");
                    break;
                case 4:
                    System.out.println("Reporte de incidentes no completados");
                    String jpqlopc4 = "SELECT i FROM Incidente i WHERE i.estado!='RESUELTO'";
                    TypedQuery<Incidente> queryopc4 = entityManager.createQuery(jpqlopc4, Incidente.class);
                    List<Incidente> incidentesopc4 = queryopc4.getResultList();
                    if (incidentesopc4.isEmpty()) {
                        System.out.println("No hay resultados");
                        break;
                    }
                    for (Incidente incidente : incidentesopc4) {
                        System.out.println("Incidente: " + incidente.getDescripcion_incidente());
                        System.out.println("Fecha de Ingreso: " + incidente.getFecha_ingreso());
                        System.out.println("Cliente: " + incidente.getCliente().getRazon_social());
                        System.out.println("Estado: " + incidente.getEstado());
                        System.out.println("Fecha de resolución estimada: " + incidente.getFecha_resolucion_estimada());
                        System.out.println("Técnico asignado: " + incidente.getTecnico().getNombre_tecnico());
                        System.out.println("--------------------");
                        System.out.println("Especialidades asignadas");
                        System.out.println("--------------------");
                        for (Especialidad especialidad : incidente.getEspecialidades()) {
                            System.out.println("Incidente: " + especialidad.getNombre_especialidad());
                            System.out.println("--------------------");
                        }
                        System.out.println("--------------------");
                        System.out.println("Problemas");
                        System.out.println("--------------------");
                        for (Problema problema : incidente.getProblemas()) {
                            System.out.println("Tipo de Problema: " + problema.getTipoProblema().getNombre_tipo());
                            System.out.println("Tiempo estimado: " + problema.getTiempoenHS_estimado() + " horas");
                            System.out.println("Descripción de Problema: " + problema.getDescripcion_problema());
                            System.out.println("--------------------");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}