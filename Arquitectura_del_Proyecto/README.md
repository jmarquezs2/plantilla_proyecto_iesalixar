# **Mapa del sitio**

El mapa esta compuesto por archivos .jsp que serán los encargados de llevar el html de la página.

Empezaria en **index.jsp** (Página principal). Esta tendrá algo de información de la web y un Login (Para usuarios registrados) y un botón de registro (Para usuarios nuevos) que le redirigirá a **register.jsp** (Similar a index.jsp pero con un formulario de registro).

Una vez logueados llegariamos a **notes.jsp** donde se visualizarán todos los apuntes del usuario así como botones que redirijan a otras páginas.

El primero será **createNote.jsp** donde el usuario tendra un formulario para crear un nuevo apunte.

Luego vendrá **note.jsp**, esta web visualizará un apunte seleccionado y mostrará los datos correspondientes. Dentro de esta habrá un enlace para modificar o borrar dicho apunte (**edit.jsp**).

Y por último tendrá un botón para acceder a todos los apuntes que los usuarios tengan como público (**allNotes.jsp**) ademas de redireccionar a note.jsp si hemos seleccionado alguno.

