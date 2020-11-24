function preencheragencias(lista){
    var saida="";
    for (cont=0;cont<lista.length;cont++){
        saida+=
        "<option value='"+lista[cont].id+"'>" + lista[cont].nomeArtistico + "</option>";
    }
    document.getElementById("inputAg").innerHTML=saida;
}

function carregaragencias(){
    fetch("http://localhost:8080/agencia")
    .then(res=> res.json())
    .then(res=> preencheragencias(res));
}