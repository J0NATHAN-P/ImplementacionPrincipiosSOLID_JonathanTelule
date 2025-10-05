# Gestor de Tareas - Ejemplo SOLID (Java) - Español

Proyecto de ejemplo que implementa los cinco principios SOLID, ahora con:
- IDs numéricos incrementales empezando en 1.
- Posibilidad de asignar tareas a proyectos y usuarios.
- Menú en consola en español con opciones para ver usuarios y proyectos.

Estructura:
- `modelos` : clases de dominio (Tarea, Proyecto, Usuario)
- `interfaces`: interfaces segregadas y repositorios.
- `repositorios`: implementaciones in-memory con generación de IDs.
- `servicios`: servicios y gestores que respetan DIP.
- `ui`: menú de consola en español.

