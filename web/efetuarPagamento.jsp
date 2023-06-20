<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="WEB-INF/style.css" media="screen" />
    <title>Efetuar Pagamento</title>
</head>
<body>
    <h1>Efetuar Pagamento</h1>
    
    <form action="gerenciarConfirmacao.jsp" method="post">
        <label for="metodoPagamento">MÈtodo de Pagamento:</label>
        <select id="metodoPagamento" name="metodoPagamento" required>
            <option value="">Selecione</option>
            <option value="debito">Cart„o de DÈbito</option>
            <option value="credito">Cart„o de CrÈdito</option>
            <option value="boleto">Boleto</option>
        </select><br><br>
        
        <div id="detalhesCartao" style="display: none;">
            <label for="numeroCartao">N˙mero do Cart„o:</label>
            <input type="text" id="numeroCartao" name="numeroCartao" required><br><br>
            
            <label for="validadeCartao">Data de Validade:</label>
            <input type="text" id="validadeCartao" name="validadeCartao" required><br><br>
            
            <label for="codigoCartao">CÛdigo de 3 dÌ≠gitos:</label>
            <input type="text" id="codigoCartao" name="codigoCartao" required><br><br>
        </div>
        
        <input type="submit" value="Confirmar">
    </form>
    
    <script>
        // Exibir campos do cart√£o se a op√ß√£o de pagamento for cart√£o de d√©bito ou cr√©dito
        var metodoPagamento = document.getElementById("metodoPagamento");
        var detalhesCartao = document.getElementById("detalhesCartao");
        
        metodoPagamento.addEventListener("change", function() {
            if (metodoPagamento.value === "debito" || metodoPagamento.value === "credito") {
                detalhesCartao.style.display = "block";
            } else {
                detalhesCartao.style.display = "none";
            }
        });
    </script>
</body>
</html>
