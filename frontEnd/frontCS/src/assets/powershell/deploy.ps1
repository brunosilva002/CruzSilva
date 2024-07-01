# Caminho do diretório do projeto Angular
$angularProjectPath = "C:\Users\bruno\IdeaProjects\CruzSilva\frontEnd\frontCS"

# Comando para realizar o build do projeto Angular em modo de produção
#ng build --configuration=production

# Caminho do diretório de saída do build
$outputPath = Join-Path $angularProjectPath "dist\front-cs"

# Informações do servidor FTP
$ftpServer = "ftp.bruno3430.c35.integrator.host"
$ftpUsername = "bruno3430"
$ftpPassword = "vn8uGtA9h9uLqsp"
$ftpPort = 21

# Caminho remoto no servidor FTP
$remotePath = "/public_html/"

# Importa o módulo WinSCP
Add-Type -Path "C:\Program Files (x86)\WinSCP\WinSCPnet.dll"

# Criação da sessão FTP
$sessionOptions = New-Object WinSCP.SessionOptions
$sessionOptions.Protocol = [WinSCP.Protocol]::Ftp
$sessionOptions.HostName = $ftpServer
$sessionOptions.PortNumber = $ftpPort
$sessionOptions.UserName = $ftpUsername
$sessionOptions.Password = $ftpPassword

$session = New-Object WinSCP.Session

try {
    # Conecta ao servidor FTP
    $session.Open($sessionOptions)

    # Envia os arquivos para o servidor FTP
    $transferOptions = New-Object WinSCP.TransferOptions
    $transferOptions.TransferMode = [WinSCP.TransferMode]::Binary

    $transferResult = $session.PutFiles("$outputPath\*", $remotePath, $false, $transferOptions)

    # Verifica se a transferência foi bem-sucedida
    if ($transferResult.IsSuccess) {
        Write-Host "Transferência bem-sucedida!"
    } else {
        Write-Host "Erro durante a transferência: $($transferResult.Failures[0].Message)"
    }
} finally {
    # Fecha a sessão FTP
    $session.Dispose()
}
