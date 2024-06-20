#.\Script_Generator.ps1 -dataBase master -tabelas Animals, City, Competitor, Country, Estate, Judge, Roping, RopingDivision, RopingDivisionRank, RopingProduct

param (
    [string]$dataBase,
    [string[]]$tabelas
)

function CopiarEAtualizarArquivo {
    param (
        [string]$objeto,
        [string]$classe,
        [string]$packge,
        [string]$sufixo,
        [string]$modelo,
        [string]$dataBase
    )

    $caminhoRef      = (get-item $PSScriptRoot ).parent.parent.FullName+"\java\br\cruzsilva\CruzSilva" #'C:\Users\bruno\IdeaProjects\brnApis\brnApis\src\main\java\br'
    $caminhoModelo   =$PSScriptRoot+'\basic'

    $caminhoRefPadrao=$caminhoModelo+'\'+$modelo+$sufixo
Write-Host $packge
    $caminhoDestino  =$caminhoRef+'\'+$packge+'\'+$classe+$sufixo+'.java'

    # Verifique se o arquivo de destino já existe
    if (Test-Path -Path $caminhoDestino -PathType Leaf) {
        Write-Host "O arquivo de destino já existe: $caminhoDestino"
        return
    }

   # Verifique se o arquivo de origem existe
   if (Test-Path -Path $caminhoRefPadrao -PathType Leaf) {
   #    # Leia o conteúdo do arquivo de origem
       $conteudo = Get-Content -Path $caminhoRefPadrao
   
   #    # Substitua os textos desejados
       $conteudo = $conteudo -creplace $modelo          , $classe
       $conteudo = $conteudo -creplace $modelo.ToLower(), $objeto
       $conteudo = $conteudo -creplace "nameDb" , $dataBase
   #
   #    # Salve o conteúdo no arquivo de destino
       $conteudo | Set-Content -Path $caminhoDestino
   #
       Write-Host "Arquivo copiado e texto substituído com sucesso. Caminho do arquivo de destino: $caminhoDoArquivoDestino"
   } else {
       Write-Host "O arquivo de origem não foi encontrado: $caminhoDoArquivoOrigem"
   }
}

function CriaEstrtura {
    param (
        [string]$class,
        [string]$dataBase
    )

    $object = $class.ToLower()
    $repository="repository\"+$dataBase+"DataBase"

    # Chame a função com os parâmetros desejados  
    CopiarEAtualizarArquivo -dataBase $dataBase -modelo "Basic" -objeto $object -classe $class -packge "mapper"                    -sufixo "Mapper"
    CopiarEAtualizarArquivo -dataBase $dataBase -modelo "Basic" -objeto $object -classe $class -packge "bo"                        -sufixo "BO"
    CopiarEAtualizarArquivo -dataBase $dataBase -modelo "Basic" -objeto $object -classe $class -packge $repository                 -sufixo "Repository"
    CopiarEAtualizarArquivo -dataBase $dataBase -modelo "Basic" -objeto $object -classe $class -packge "rest"                      -sufixo "Resource"
    CopiarEAtualizarArquivo -dataBase $dataBase -modelo "Basic" -objeto $object -classe $class -packge "service\impl"              -sufixo "ServiceImpl"
    CopiarEAtualizarArquivo -dataBase $dataBase -modelo "Basic" -objeto $object -classe $class -packge "service"                   -sufixo "Service"

}
Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy RemoteSigned

# Verificar se o parâmetro dataBase foi fornecido
if (-not $dataBase) {
    Write-Host "Por favor, forneça o argumento para o banco de dados usando -dataBase."
    exit
}

# Verificar se pelo menos uma tabela foi fornecida
if (-not $tabelas) {
    Write-Host "Por favor, forneça pelo menos uma tabela usando -tabelas."
    exit
}

# Exibir o valor de dataBase
Write-Host "DataBase: $dataBase"

foreach ($classe in $tabelas){
    Write-Host $classe
    CriaEstrtura -class $classe -dataBase $dataBase
}

# Defina o caminho para o Maven
#$mavenHome = "C:\Users\bruno\.m2\wrapper\dists\apache-maven-3.9.5-bin\2adeog8mj13csp1uusqnc1f2mo\apache-maven-3.9.5"

# Comando Maven com as opções clean e install
#$mvnCommand = "clean install"

# Caminho para o diretório do projeto Maven
#$projectDirectory = "C:\Users\bruno\OneDrive\PROJETOS\JAVA\matrix_erp\matrix_erp"

# Execute o Maven usando o IntelliJ IDEA
#Start-Process -FilePath "cmd.exe" -ArgumentList "/c $mavenHome\bin\mvn.cmd $mvnCommand" -WorkingDirectory $projectDirectory
