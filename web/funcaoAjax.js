function carregaPagina(pagina) {

    document.getElementById('filhos').style.display = "inline"; // mostra div    

    var requisicaoAjax = iniciaAjax(); // cria objeto Ajax

    if (requisicaoAjax) {
        requisicaoAjax.onreadystatechange = function () {

            if (requisicaoAjax.readyState == 4 && requisicaoAjax.status == 200) { // resposta pronta e status = ok
                document.getElementById("filhos").innerHTML = requisicaoAjax.responseText; // insere retorno na DIV
            }
        };
        
//C�digo 	Descri��o - ONREADYSTATE
//0 	Cria objeto de solicita��o = chamada do OPEN
//1 	Solicita��o possui destino/foi configurada = conex�o estabelecida
//2 	O pedido foi emitido = solicita��o em progresso = servidor recebeu solicita��o
//3 	O pedido est� em processo de download = dados ainda n�o dispon�veis
//4 	O pedido est� completo = dados dispon�veis

        requisicaoAjax.open("GET", pagina, true);
        requisicaoAjax.send(null);

        return true;
    } else {
        return false;
    }
}

// C�digos Status AJAX
// 400 Bad Request
// 401 Unauthorized
// 403 Forbidden
// 404 Not found
// 405 Method Not Allowed
// 406 Not Acceptable
// 408 Request Timeout

// Funcao que cria objeto Ajax XMLHttpRequest
function iniciaAjax() {
    var objetoAjax = false;

    if (window.XMLHttpRequest) { // tenta carregar componente Mozilla/safari
        objetoAjax = new XMLHttpRequest();
    } else if (window.ActiveXObject) { // se falhar, tenta carregar o ActiveX do IE :-(
        try {
            objetoAjax = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                objetoAjax = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (ex) {
                objetoAjax = false;
            }
        }
    }
    return objetoAjax;
}
