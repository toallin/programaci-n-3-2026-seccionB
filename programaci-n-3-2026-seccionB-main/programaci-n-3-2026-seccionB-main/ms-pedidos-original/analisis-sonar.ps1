# Ejecuta mvn clean verify y el analisis de SonarQube. Uso: .\analisis-sonar.ps1 -Etiqueta antes  (o despues)
param([Parameter(Mandatory = $true)][ValidateSet("antes", "despues")][string]$Etiqueta)
$ErrorActionPreference = "Stop"
Set-Location $PSScriptRoot

$env:SONAR_TOKEN = (Read-Host "Token de SonarQube").Trim()

.\mvnw.cmd -B clean verify
if ($LASTEXITCODE -ne 0) { throw "mvn clean verify fallo. Revisa los errores antes de analizar." }

.\mvnw.cmd org.sonarsource.scanner.maven:sonar-maven-plugin:5.5.0.6356:sonar "-Dsonar.projectKey=ms-pedidos" "-Dsonar.host.url=http://localhost:9000"
if ($LASTEXITCODE -ne 0) { throw "El analisis de SonarQube fallo." }

Write-Host "Analisis '$Etiqueta' terminado. Captura el panel: http://localhost:9000/dashboard?id=ms-pedidos" -ForegroundColor Green
Write-Host "Antes de ejecutar el analisis 'despues', captura todas las pantallas del analisis 'antes'." -ForegroundColor Yellow
