// Captura o modal e o botão de fechar
var modal = document.getElementById('modal');
var closeBtn = document.getElementsByClassName('close')[0];

// Captura o botão para abrir o modal
var openModalBtn = document.getElementById('openModal');

// Quando o usuário clicar no botão, abre o modal
openModalBtn.addEventListener('click', function() {
  modal.style.display = 'block';
});

// Quando o usuário clicar no botão de fechar, fecha o modal
closeBtn.addEventListener('click', function() {
  modal.style.display = 'none';
});

// Quando o usuário clicar fora do modal, fecha o modal
window.addEventListener('click', function(event) {
  if (event.target === modal) {
    modal.style.display = 'none';
  }
});

// Manipula o formulário de orçamento
var orcamentoForm = document.getElementById('orcamentoForm');
orcamentoForm.addEventListener('submit', function(event) {
  event.preventDefault(); // previne o comportamento padrão do formulário
  
  // Aqui você pode capturar os valores do formulário e enviá-los para uma API ou armazená-los localmente
  var cliente = document.getElementById('cliente').value;
  var descricao = document.getElementById('descricao').value;
  
  // Exemplo de como você pode manipular os dados do formulário
  console.log('Cliente: ', cliente);
  console.log('Descrição: ', descricao);
  
  // Aqui você pode adicionar lógica para enviar os dados para uma página de orçamentos ou um backend
  // Depois de salvar os dados, você pode fechar o modal
  modal.style.display = 'none';
});
