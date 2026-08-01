# inventario-e-commerce

## 🚀 Ruta de Aprendizaje: Sistema de Inventario E-Commerce

Este proyecto documenta mi evolución en Java, desde los fundamentos de la programación orientada a objetos en consola hasta la integración con bases de datos relacionales.

### 🎛️ Fase 1: Fundamentos de POO y Consola
- [x] **Crear el molde del dominio:** Diseñar la clase `Producto` con atributos encapsulados (`private`), constructor, *getters*, *setters* y sobreescribir `toString()`.
- [x] **Estructura de almacenamiento:** Implementar un `ArrayList<Producto>` para mantener los datos en la memoria RAM durante la ejecución.
- [x] **Interfaz de usuario rústica:** Configurar un bucle interactivo `while` con `Scanner` y un `switch` para el menú de opciones.
- [x] **Lógica de negocio básica:** Programar el algoritmo de búsqueda por ID dentro de la lista para simular ventas y validar que exista stock suficiente antes de restar unidades.

### 🛠️ Fase 2: Refactorización y Buenas Prácticas (Nivel Medio)
- [x] **Arquitectura en capas:** Separar el código organizándolo en paquetes profesionales (`model`, `repository`, `service`, `main`).
- [x] **Manejo de errores robusto:** Implementar bloques `try-catch` para evitar que el programa se rompa si el usuario introduce texto en campos numéricos.
- [x] **Tipos de datos seguros:** Introducir un `enum` para clasificar los productos por categorías fijas (Electrónica, Ropa, Libros, etc.).

### ⚡ Fase 3: Programación Funcional y Datos Reales (Nivel Avanzado)
- [ ] **Migración a Java Streams:** Reemplazar los bucles tradicionales `for` por operaciones funcionales (`.stream()`, `.filter()`, `.forEach()`) para buscar y filtrar el catálogo.
- [x] **Gestión de dependencias:** Migrar el proyecto manual a una estructura basada en **Maven** o **Gradle**.
- [x] **Persistencia con JDBC:** Conectar la aplicación a una base de datos real (**PostgreSQL** vía Supabase).
- [x] **Eliminación de la memoria volátil:** Sustituir el `ArrayList` por consultas SQL nativas (`SELECT`, `INSERT`, `UPDATE`) para que los datos no se borren al cerrar la consola.
- [x] **Patrón DAO:** Aislar por completo las sentencias de SQL de las reglas del negocio de la tienda.

## Cómo ejecutar

1. Copia `src/main/resources/database.properties.example` a `src/main/resources/database.properties` y completa tus credenciales de PostgreSQL/Supabase.
2. `mvn clean package`
3. `java -jar target/mi-tienda-poo-1.0-SNAPSHOT.jar`
