var titulo = document.querySelector(".titulo");

var trsDosPacientes = document.querySelectorAll(".paciente");

for (var i = 0; i < trsDosPacientes.length; i++) {
  var trPaciente = trsDosPacientes[i];

  var tdPeso = trPaciente.querySelector(".info-peso");
  var peso = tdPeso.textContent;

  var tdAltura = trPaciente.querySelector(".info-altura");
  var altura = tdAltura.textContent;

  var tdImc = trPaciente.querySelector(".info-imc")

  var pesoEhValido = validaPeso(peso);

  if (!pesoEhValido) {
    tdImc.textContent = "Peso inválido!";
    pesoEhValido = false;
    trPaciente.classList.add("paciente-invalido");
  }

  var alturaEhValido = validaAltura(altura);

  if (!alturaEhValido) {
    tdImc.textContent = "Altura inválida!";
    alturaEhValido = false;
    trPaciente.classList.add("paciente-invalido");
  }

  if (pesoEhValido && alturaEhValido) {
    tdImc.textContent = calculaImc(peso, altura);  
  }

}

function calculaImc (peso, altura) {
  var imc = 0;
  
  imc =  peso / (altura * altura);

  return imc.toFixed(2);
}

function validaPeso (peso) {
  if (peso <= 0 || peso >= 1000) {
    return false;
  }
  return true;
}

function validaAltura (altura) {
  if (altura <= 0 || altura >= 3.0) {
    return false;
  }
  return true;
}