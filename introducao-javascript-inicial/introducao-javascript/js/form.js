var botaoAdicionar = document.querySelector("#adicionar-paciente");
botaoAdicionar.addEventListener("click", function (event) {
  event.preventDefault();
  
  var form = document.querySelector("#form-novo-paciente");

  var paciente = obtemPacienteDoForm(form);

  var erros = validaPaciente(paciente);

  if (erros.length > 0) {
    exibeMensagensDeErro(erros);
    return;
  }

  adicionaPacienteNaTabela(paciente)

  form.reset();

  limpaMensagensErro();

});

function obtemPacienteDoForm(form) {
  var paciente = {
    nome: form.nome.value,
    peso: form.peso.value,
    altura: form.altura.value,
    gordura: form.gordura.value,
    imc: calculaImc(form.peso.value, form.altura.value)
  }

  return paciente;
}

function montaTr (paciente) {
  var pacienteTr = document.createElement("tr");
  pacienteTr.classList.add("paciente");

  pacienteTr.appendChild(montaTd(paciente.nome, "info-nome"));
  pacienteTr.appendChild(montaTd(paciente.peso, "info-peso"));
  pacienteTr.appendChild(montaTd(paciente.altura, "info-altura"));
  pacienteTr.appendChild(montaTd(paciente.gordura, "info-gordura"));
  pacienteTr.appendChild(montaTd(paciente.imc, "info-imc"));

  return pacienteTr;
}

function montaTd (dado, classe) {

  var td = document.createElement("td");
  td.classList.add(classe);
  td.textContent = dado;

  return td;
}

function adicionaPacienteNaTabela (paciente) {
  var pacienteTr = montaTr(paciente);
  var tabelaPacientes = document.querySelector("#tabela-pacientes");
  tabelaPacientes.appendChild(pacienteTr);
}

function validaPaciente (paciente) {
  var erros = [];

  if (!validaPeso(paciente.peso)) erros.push("Peso inválido!");
  if (!validaAltura(paciente.altura)) erros.push("Altura inválida!");
  if (paciente.peso.length == 0) erros.push("O campo Peso não pode ser em branco");
  if (paciente.altura.length == 0) erros.push("O campo Altura não pode ser em branco");
  if (paciente.nome.length == 0) erros.push("O campo Nome não pode ser em branco");
  if (paciente.gordura.length == 0) erros.push("O campo Gordura não pode ser em branco");

  return erros;
}

function exibeMensagensDeErro (erros) {
    limpaMensagensErro();
    var mensagensErro = document.querySelector(".mensagens-erro");


    erros.forEach(function (erro) {
      var li = document.createElement("li");
      li.textContent = erro;
      mensagensErro.appendChild(li);
    });
}

function limpaMensagensErro () {
    var mensagensErro = document.querySelector(".mensagens-erro");
    mensagensErro.innerHTML = " ";
}