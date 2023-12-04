# TPJavaIntermedio

Para hacerlo funcionar solo hace falta crear una db que se llame "incidentes_tpjii" (si, con doble i al final), ya que en el main mismo está la carga de datos porque fui probando q funcionara hibernate. Otra cosa que tuve que cambiar fue el dialecto de hibernate porque sino no me creaba nada, tuve que ponerlo en MariaDB53, que es el mysql que te instala xampp. 

De todas formas tambien está el dump de la base de datos por si prefieren importar por ahi.

Los casos de uso que requería la consigna están completos. Faltaron algunos detalles como el técnico personalizando sus tiempos máximos, dar lugar en el modelo a RRHH y hacer el caso de uso en el que se crea un incidente que capaz es el unico del CRUD con un flujo un poco más interesante, pero pude poner en los métodos de donde sale el tiempo estimado y la asignacion de especialidades que era lo mas interesante por lo menos. Tambien un historial de estados real en vez de una enumeración.

Pero eso queda para la proxima iteración!

Autor: Hudson, Ismael
