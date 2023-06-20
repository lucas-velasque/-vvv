<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="WEB-INF/style.css" media="screen" />
    <title>Compra de Passagem</title>
</head>
<body>
    <h1>Compra de Passagem</h1>
    
    <form action="efetuarPagamento.jsp" method="post">
        <label for="tipo">Selecione o tipo de transporte:</label>
        <select name="tipo" id="tipo">
            <option value="aviao">Avião</option>
            <option value="trem">Trem</option>
            <option value="onibus">Ônibus</option>
            <option value="navio">Navio</option>
        </select>
        <br><br>
        
        <label for="nome">Nome Completo:</label>
        <input type="text" id="nome" name="nome" required><br><br>
        
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" required><br><br>
        
        <label for="celular">Numero de Celular:</label>
        <input type="text" id="celular" name="celular" required><br><br>
        
        <label for="cidadeDestino">Cidade de Destino:</label>
        <input type="text" id="cidadeDestino" name="cidadeDestino" required><br><br>
        
        <label for="data">Data de partida:</label>
        <input type="date" name="data" id="data">
        <br><br>
        
        <input type="submit" value="Confirmar">
    </form>
</body>
</html>
