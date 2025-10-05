# Mapeo de los principios SOLID en el proyecto (ES)

## S - Single Responsibility (Responsabilidad única)
Cada clase tiene una única responsabilidad:
- `Tarea`: representa la entidad tarea.
- `Proyecto`: representa un proyecto que agrupa tareas.
- `Usuario`: datos del usuario.
- Repositorios (`TareaRepositorio`, `UsuarioRepositorio`, `ProyectoRepositorio`) manejan almacenamiento.
- Servicios (`TareaServicio`, `ProyectoServicio`, `UsuarioServicio`) contienen la lógica de negocio.
- `GestorTareas` actúa como fachada para orquestar operaciones desde la UI.

## O - Open/Closed (Abierto/Cerrado)
- Exportadores de tareas implementan la interfaz `ExportadorTareas` — se pueden añadir nuevos exportadores sin modificar servicios existentes.
- Las implementaciones de repositorios pueden extenderse (por ejemplo, añadir persistencia a base de datos) sin cambiar las interfaces.

## L - Liskov Substitution (Sustitución de Liskov)
- `UsuarioAdmin` extiende `Usuario` sin cambiar el contrato; cualquier `Usuario` puede reemplazarse por `UsuarioAdmin` donde se requiera un `Usuario`.
- Repositorios e interfaces permiten sustituir implementaciones concretas por otras (por ejemplo, memoria vs base de datos).

## I - Interface Segregation (Segregación de interfaces)
- Interfaces pequeñas y específicas: `CreadorTarea`, `LectorTarea`, `AsignadorTarea`, etc. Clientes dependen sólo de lo que necesitan.

## D - Dependency Inversion (Inversión de dependencias)
- Servicios dependen de abstracciones (interfaces) y no de implementaciones concretas.
- En la UI se realiza inyección manual de dependencias (se pueden usar frameworks para DI si se desea).

