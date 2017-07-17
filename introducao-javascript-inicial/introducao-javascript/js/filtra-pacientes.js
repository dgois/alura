var inputFiltra = document.querySelector("#filtra-pacientes");

inputFiltra.addEventListener("input", function () {
  var filtro = this.value;
  var expressao = new RegExp(filtro, "i");

  var pacientes = document.querySelectorAll(".paciente");

  if (filtro.length == 0) {
    pacientes.forEach(function (trPaciente) {
      trPaciente.classList.remove("invisivel");
    });
  } else {
    pacientes.forEach(function (trPaciente) {
      var nome = trPaciente.querySelector(".info-nome").textContent;
      
      if (expressao.test(nome)) {
        trPaciente.classList.remove("invisivel");
      } else {
        trPaciente.classList.add("invisivel");
      }
    });
  }
});