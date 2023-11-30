# Gestión de Turnos

Esta es una aplicación para una entidad gubernamental en la cual debemos crear un usuario. Este va a ser capaz de crear turnos introduciendo los datos que se le pidan en los diferentes formularios de la aplicación.

# Creacion de un Ciudadano

![Screenshot 2023-11-30 at 5 18 13 AM](https://github.com/dmillanlpez/deMillanDiego_pruebatec2/assets/97486464/2f11fdba-c7d5-460b-aa33-e78e42ee5f2f)

En la imagen se puede observar un formulario en el cual podemos realizar dos acciones.

Primer formulario: Creación de un Ciudadano. En este formulario, deberemos introducir el nombre, apellidos, DNI y un teléfono.

Segundo formulario: Búsqueda e impresión en una tabla de los diferentes datos de un usuario. Para que la tabla sea invocada, simplemente debemos poner un ID y, si este es correcto, nos mostrará al ciudadano.

Todos los campos anteriormente nombrados contienen sus diferentes validaciones en caso de que los campos estén vacíos o los formatos no sean los adecuados.

# Barra de Navegacion

![Screenshot 2023-11-30 at 5 21 54 AM](https://github.com/dmillanlpez/deMillanDiego_pruebatec2/assets/97486464/33962f2f-dc4d-42a5-841b-bed7ee51428d)

Podemos observar que en este encabezado disponemos de diferentes botones, los cuales nos van a permitir navegar por la página.

# Agregar un Turno

![Screenshot 2023-11-30 at 5 26 22 AM](https://github.com/dmillanlpez/deMillanDiego_pruebatec2/assets/97486464/d464804f-2aff-4537-b48a-1f323a98b9e7)

En esta pestaña tenemos de nuevo un formulario en el cual una vez rellenados todos los datos que se nos piden se va a introducir en la base de datos un turno asociado a una persona.

# Listar todos los turnos

![Screenshot 2023-11-30 at 5 32 48 AM](https://github.com/dmillanlpez/deMillanDiego_pruebatec2/assets/97486464/383c0f58-ac96-422a-a63f-765fda3ede82)

Aquí se muestran todos los turnos disponibles en la página. Inicialmente, esta sección aparece vacía hasta que se selecciona la opción de mostrar todos los turnos. Esta funcionalidad proporciona una visión general y detallada de los turnos programados.

# Filtrar turnos por fecha

![Screenshot 2023-11-30 at 5 38 46 AM](https://github.com/dmillanlpez/deMillanDiego_pruebatec2/assets/97486464/80432029-e19d-4a4b-b453-9984ae8b1229)

Esta sección de la aplicación está diseñada para la filtración de turnos por una fecha específica. Mediante un formulario intuitivo, los usuarios tienen la capacidad de seleccionar una fecha y visualizar todos los turnos asignados a los distintos días. Además, se facilita la posibilidad de actualizar el estado de los turnos, por ejemplo, cambiando un turno del estado "En espera" a "Atendido" y viceversa. 

# Filtrar por fecha y por estado del turno

![Screenshot 2023-11-30 at 5 43 26 AM](https://github.com/dmillanlpez/deMillanDiego_pruebatec2/assets/97486464/5aa43f79-2643-4c13-b80a-dd7ee3e148d7)

Esta funcionalidad amplía la capacidad de filtrado de turnos, permitiendo a los usuarios no solo buscar por fecha sino también por el estado específico del turno. Esta característica es particularmente útil para gestionar y organizar los turnos de manera más eficiente, facilitando la visualización de los turnos en diferentes categorías como "En espera" y "Ya atendido". 

# Funciones futuras 

Modificación de Datos de Usuarios
Una funcionalidad clave a implementar es la capacidad de modificar los datos de los usuarios. Esto permitiría a los administradores actualizar información importante como nombres, apellidos, DNI, teléfonos, entre otros, asegurando que los registros se mantengan precisos y actualizados.

Integración con Calendario
Integrar la aplicación con aplicaciones de calendario (como Google Calendar) para que los usuarios puedan sincronizar sus turnos directamente con sus calendarios personales. Esto facilitaría la gestión personal de horarios y compromisos.

Sistema de Feedback
Incorporar un sistema de retroalimentación donde los ciudadanos puedan valorar su experiencia y ofrecer sugerencias. Esta información sería valiosa para mejorar continuamente el servicio.

# Tecnologías utilizadas

- JSP
- Java + Servlets
- JPA
- MySQL
- Colecciones
- Objetos
- Streams
- Funciones lambda
