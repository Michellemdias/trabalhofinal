function carregardados() {
    var usuariologado = localStorage.getItem("logado");
    if (usuariologado == null) {
        window.location = "login.html";
    } else {
        var usuariojson = JSON.parse(usuariologado);
        document.getElementById("foto").innerHTML =
            "<img width='25%' heigth='25%' alt='Foto não encontrada'src=imagens/" + usuariojson.foto + ">";
        document.getElementById("dados").innerHTML =
            "<h3>" + usuariojson.nome + "<br>" + usuariojson.email + "<br>ID:" + usuariojson.id + "<br> </h3>"
    }
}

function montartabela(lista){
    var saida = 
    "<table border='1' align='center'> <tr>" +
    "<th>Musica</th>   <th>Artista</th>  <th>Cadastro</th> </tr>";

    
    for (cont=0;cont<lista.length;cont++){
        saida+=
        "<tr>" +
        "<td>" + lista[cont].titulo + "</td>" + 
        "<td>" + lista[cont].artista.nomeArtistico + "</td>" + 
        "<td>" + lista[cont].cadastro + "</td>" + 
        "</tr>";
    }

    saida += "</table>";
    document.getElementById("resultado").innerHTML=saida;

}


function filtrar(){
    if(
        document.getElementById("chkagencia").checked==false && 
        document.getElementById("chkcliente").checked==false &&
        document.getElementById("chkdata").checked==false
        )
        {
        window.alert("Escolha uma opção de filtro!")
    }else {
        var rota = "relatoriopor";
        if(document.getElementById("chkagencia").checked==true){
            rota+="titulo";
        }
        if(document.getElementById("chkartista").checked==true){
            rota+="artista";
        }
      var objeto = {
          titulo : document.getElementById("chkagencia").value,
          artista : {
              id : document.getElementById("cmbartistas").value
          }
      };

      var cabecalho = {
          method:"POST",
          body: JSON.stringify(objeto),
          headers : {
              "content-type" : "application/json"
          }
      }

      fetch("http://localhost:8080/" + rota , cabecalho)
      .then(res=> res.json())
      .then(res => montartabela(res))
      .catch(err => {window.alert("Musica não encontrada")});   

    }

}
function preencherartistas(lista){
    var saida="";
    for (cont=0;cont<lista.length;cont++){
        saida+=
        "<option value='"+lista[cont].id+"'>" + lista[cont].nomeArtistico + "</option>";
    }
    document.getElementById("cmbartistas").innerHTML=saida;
}

function carregarartistas(){
    fetch("http://localhost:8080/artistas")
    .then(res=> res.json())
    .then(res=> preencherartistas(res));
}

function gravar(){
    var data = document.getElementById("txtcadastro").value;
    var ano = data.substring(0,4);
    var mes = data.substring(5,7);
    var dia = data.substring(8);
    var databrasil= dia + "/" + mes + "/" + ano


    var objeto = {
        titulo : document.getElementById("txttitulo").value,
        cadastro : document.getElementById("txtcadastro").value,
        lancamento : document.getElementById("cmblancamento").value,
        artista : {
            id: document.getElementById("cmbartistas").value
        }
    }

    var cabecalho = {
        method : "POST",
        body: JSON.stringify(objeto),
        headers: {
            "Content-type": "application/json"
        }
    }
    fetch("http://localhost:8080/novamusica",cabecalho)
    .then(res => res.json())
    .then(res => {window.alert("Gravado com sucesso")})
    .catch(err => {window.alert("Ocorreu um erro")});






}