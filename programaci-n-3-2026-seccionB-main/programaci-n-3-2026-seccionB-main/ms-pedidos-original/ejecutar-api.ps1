# Arranca ms-pedidos contra el MySQL instalado en Windows (puerto 3306, usuario root, sin clave).
# Ejecutar desde la carpeta ms-pedidos.
$ErrorActionPreference = "Stop"
Set-Location $PSScriptRoot

# La base bd_pedidos se crea sola si no existe.
$env:DB_URL  = "jdbc:mysql://localhost:3306/bd_pedidos?createDatabaseIfNotExist=true"
$env:DB_USER = "root"
# Sin clave: application.properties usa ${DB_PASSWORD:} (vacio por defecto).

# Primera ejecucion: update crea la tabla pedido. Despues puedes usar validate.
if (-not $env:DB_DDL_AUTO) { $env:DB_DDL_AUTO = "update" }
Write-Host "Conectando a $env:DB_URL como $env:DB_USER (DB_DDL_AUTO = $env:DB_DDL_AUTO)"

.\mvnw.cmd spring-boot:run
