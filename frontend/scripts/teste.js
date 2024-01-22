// Exemplo de dados de usuários obtidos da API
const usuarios = [
  { nome: 'Jonas', telefone: '123456789', cep: '12345-678' },
  { nome: 'Lucas', telefone: '987654321', cep: '54321-098' },
  { nome: 'Pedro', telefone: '987656321', cep: '54321-047' }
  // ... outros usuários
];

const orcamentos = [
  { nome: 'João', telefone: '123456789', cep: '12345-678', categoria: 'aprovado', planilhador: 'Lucas' },
  {
    nome: 'Maria', telefone: '987654321', cep: '54321-098', categoria: 'aprovado', planilhador: 'Jonas'
  }, {
    nome: 'aloha', telefone: '987654321', cep: '54321-098', categoria: '', planilhador: 'Pedro'
  },
]

function ultimosOrcamentos(usuarios) {
  const tabela = document.createElement('table');
  const cabecalho = tabela.createTHead();
  const linhaCabecalho = cabecalho.insertRow();

  // Cabeçalho da tabela
  for (let chave in usuarios[0]) {
    const th = document.createElement('th');
    const texto = document.createTextNode(chave.charAt(0).toUpperCase() + chave.slice(1));
    th.appendChild(texto);
    linhaCabecalho.appendChild(th);
    console.log(linhaCabecalho)
  }

  // Linhas com os dados dos usuários
  const corpoTabela = tabela.createTBody();
  usuarios.forEach((usuario) => {
    const linha = corpoTabela.insertRow();
    for (let chave in usuario) {
      const cell = linha.insertCell();
      const texto = document.createTextNode(usuario[chave]);
      cell.appendChild(texto);
    }
  });

  // Adiciona a tabela ao elemento com id "tabela-usuarios"
  document.getElementById('ultimos-orcamentos').appendChild(tabela);
}

function orcamentosDoMes(orcamentos) {
  const qntdOrcamentos = document.querySelector('.qntdOrcamentos');
  const orcamentosAprovados = document.querySelector('.orcamentos-aprovados');
  let aprovados = 0;

  if (qntdOrcamentos) {
    qntdOrcamentos.textContent = orcamentos.length;

    for (let i in orcamentos) {
      if (orcamentos[i].categoria.toLowerCase() === 'aprovado') {
        aprovados++;
      }
    }
    orcamentosAprovados.textContent = aprovados;
  }
}

 // Função para criar a tabela com o número de orçamentos por planilhador
 function criarTabelaOrcamentos(orcamentos, usuarios) {
  // Objeto para armazenar a contagem de orçamentos por planilhador
  const contagemPorPlanilhador = {};

  // Calcula a contagem de orçamentos por planilhador
  orcamentos.forEach((orcamento) => {
    const planilhador = orcamento.planilhador;
    contagemPorPlanilhador[planilhador] = (contagemPorPlanilhador[planilhador] || 0) + 1;
  });

  // Cria a tabela dinamicamente
  const tabela = document.createElement('table');
  const cabecalho = tabela.createTHead();
  const linhaCabecalho = cabecalho.insertRow();
  const colunaPlanilhador = linhaCabecalho.insertCell();
  colunaPlanilhador.textContent = 'Planilhador';
  const colunaContagem = linhaCabecalho.insertCell();
  colunaContagem.textContent = 'Número de Orçamentos';

  // Adiciona as linhas com a contagem por planilhador
  for (const planilhador in contagemPorPlanilhador) {
    const linha = tabela.insertRow();
    const celulaPlanilhador = linha.insertCell();
    celulaPlanilhador.textContent = planilhador;
    const celulaContagem = linha.insertCell();
    celulaContagem.textContent = contagemPorPlanilhador[planilhador];
  }

  // Adiciona a tabela ao elemento com id "tabela-orcamentos"
  document.getElementById('tabela-orcamentos').appendChild(tabela);
}

// Chama a função para criar a tabela com o número de orçamentos por planilhador
criarTabelaOrcamentos(orcamentos, usuarios);


// Chama a função para criar a tabela com os usuários
ultimosOrcamentos(usuarios);
orcamentosDoMes(orcamentos);