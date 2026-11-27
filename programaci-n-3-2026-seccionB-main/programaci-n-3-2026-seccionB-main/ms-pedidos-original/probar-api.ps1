# Ejecuta las tres pruebas HTTP de la guia. Dejar ejecutando ejecutar-api.ps1 en otra ventana.
$ErrorActionPreference = "Continue"
$url = "http://localhost:8081/api/pedidos"
$casos = @(
    @{ Nombre = "Valida: cantidad 2, precio 10.005"; Cuerpo = @{ cantidad = 2; precioUnitario = 10.005 }; Esperado = 201 },
    @{ Nombre = "Cantidad 0"; Cuerpo = @{ cantidad = 0; precioUnitario = 10.00 }; Esperado = 400 },
    @{ Nombre = "Precio 0"; Cuerpo = @{ cantidad = 1; precioUnitario = 0 }; Esperado = 400 }
)
$resultados = @()
foreach ($c in $casos) {
    $json = $c.Cuerpo | ConvertTo-Json
    try {
        $r = Invoke-WebRequest -Uri $url -Method Post -ContentType "application/json" -Body $json -UseBasicParsing
        $codigo = [int]$r.StatusCode
        $respuesta = $r.Content
    } catch {
        $codigo = [int]$_.Exception.Response.StatusCode
        $respuesta = ""
    }
    $resultados += [pscustomobject]@{
        Prueba     = $c.Nombre
        Esperado   = $c.Esperado
        Obtenido   = $codigo
        Resultado  = if ($codigo -eq $c.Esperado) { "OK" } else { "REVISAR" }
        Respuesta  = $respuesta
    }
}
$resultados | Format-Table -AutoSize
$resultados | Export-Csv -NoTypeInformation -Encoding UTF8 -Path "pruebas-api.csv"
Write-Host "Resultados guardados en pruebas-api.csv (copia los codigos a la seccion 4 del documento)." -ForegroundColor Green
