var botao = document.querySelector("#importar-pacientes");

botao.addEventListener("click", function (event) {
  event.preventDefault();
  
  var xhr = new XMLHttpRequest();

  xhr.open("GET", "https://api-pacientes.herokuapp.com/pacientes");

  xhr.addEventListener("load", function (event) {
    var erro = document.querySelector("#erro-importar-pacientes");
    if (this.status == 200) {
      erro.classList.add("invisivel");
      var resposta = JSON.parse(this.responseText);

      resposta.forEach(function (paciente) {
        adicionaPacienteNaTabela(paciente);
      });
    } else {
      erro.classList.remove("invisivel");
    }
  });

  xhr.send();
});       