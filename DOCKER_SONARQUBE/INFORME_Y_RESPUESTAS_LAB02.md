# Informe de Laboratorio 02 - Docker, SonarQube y MySQL con Spring Boot

## 1. Respuestas a las Preguntas de la Guía

1. **¿Por qué SonarQube no puede utilizar MySQL como base de datos interna?**
   Porque SonarQube restringe los motores de base de datos soportados para su almacenamiento interno (PostgreSQL, Microsoft SQL Server u Oracle, además de H2 embebida solo para prácticas/evaluación) y no ofrece soporte JDBC para MySQL como base de datos del servidor.

2. **¿Cuál es la función de MySQL en el sistema y cuál es la función de H2 en SonarQube?**
   MySQL 8.4 gestiona la persistencia de negocio del microservicio (`bd_pedidos`, tabla `pedido`), mientras que la base H2 embebida en SonarQube almacena únicamente los metadatos, métricas y reportes de análisis estático durante el laboratorio académico.

3. **¿Qué ventaja tiene separar el dominio de los adaptadores de persistencia?**
   Mantiene la lógica y el modelo de negocio independientes de frameworks o motores de base de datos, permite probar los casos de uso de forma aislada y rápida mediante dobles en memoria (sin red ni contenedor) y facilita sustituir la tecnología de persistencia sin afectar el núcleo del negocio.

4. **¿Por qué no deben almacenarse credenciales en `application.properties` ni en Git?**
   Porque cualquier usuario con acceso al repositorio o código fuente podría leer las contraseñas o tokens, y el historial de versiones de Git conserva los secretos incluso si se eliminan en commits posteriores.

5. **¿Qué diferencia existe entre análisis estático, pruebas unitarias y cobertura?**
   - **Análisis estático (SonarQube):** inspecciona el código fuente sin ejecutarlo para detectar problemas de mantenibilidad, seguridad y duplicación.
   - **Pruebas unitarias (JUnit 5):** ejecutan unidades aisladas de código para comprobar que cumplen los resultados y excepciones esperadas.
   - **Cobertura (JaCoCo):** mide el porcentaje de líneas o ramas ejecutadas durante las pruebas automatizadas (sin garantizar por sí sola ausencia total de errores).

6. **¿Qué requisitos adicionales aplicarías para desplegar el entorno en producción?**
   Usar una base de datos externa soportada para SonarQube (como PostgreSQL) en lugar de H2, gestionar migraciones de esquema con Flyway o Liquibase (en vez de `spring.jpa.hibernate.ddl-auto=update`), utilizar un gestor de secretos, habilitar HTTPS/TLS, aplicar autenticación/autorización, monitoreo y logs centralizados, y restringir puertos de red.

---

## 2. Tabla Comparativa de Resultados (Completar con tus capturas)

| Métrica o evidencia | Antes | Después |
| :--- | :--- | :--- |
| Problemas de mantenibilidad | Registrar cantidad | Registrar cantidad |
| Hallazgos de seguridad | Registrar cantidad | Registrar cantidad |
| Cobertura de pruebas | Registrar porcentaje | Registrar porcentaje |
| Duplicación del código | Registrar porcentaje | Registrar porcentaje |
| Quality Gate | Registrar estado | Registrar estado |
| API y MySQL | Pendiente / disponible | Validado |
