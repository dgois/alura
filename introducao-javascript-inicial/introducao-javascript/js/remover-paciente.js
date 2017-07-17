var tabelaPacientes = document.querySelector("#tabela-pacientes");

tabelaPacientes.addEventListener("dblclick", function(event) {
  event.target.parentNode.classList.add("fade-out");
  event.target.parentNode.addEventListener("transitionend", function () {
    this.remove();
  });
});


