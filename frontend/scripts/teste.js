// Exemplo de dados de usuários obtidos da API
const usuarios = [
    { nome: 'João', telefone: '123456789', cep: '12345-678' },
    { nome: 'Maria', telefone: '987654321', cep: '54321-098' },
    // ... outros usuários
  ];

const orcamentos = [
  { nome: 'João', telefone: '123456789', cep: '12345-678', categoria: 'aprovado', planilhador:'Lucas' },
    { nome: 'Maria', telefone: '987654321', cep: '54321-098',  categoria: 'aprovado', planilhador:'Maria' 
   }, {
    nome: 'Maria', telefone: '987654321', cep: '54321-098',  categoria: '', planilhador:'Pedro'},
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
  
  function orcamentosDoMes(orcamentos){
    const qntdOrcamentos = document.querySelector('.qntdOrcamentos');
    const orcamentosAprovados = document.querySelector('.orcamentos-aprovados');
    let aprovados = 0;

    if (qntdOrcamentos) {
      qntdOrcamentos.textContent = orcamentos.length;
      
      for(let i in orcamentos){
        if(orcamentos[i].categoria.toLowerCase() === 'aprovado'){
          aprovados++;
        }
      }
      orcamentosAprovados.textContent = aprovados;
    }
  }

  function orcamentoPorPlanilhador(orcamentos){
    const tabela = document.createElement('table');
    const cabecalho = tabela.createTHead();
    const linhaCabecalho = cabecalho.insertRow();
  
    // Cabeçalho da tabela
    for (let chave in orcamentos[0]) {
      const th = document.createElement('th');
      const texto = document.createTextNode(chave.charAt(0).toUpperCase() + chave.slice(1));
      th.appendChild(texto);
      linhaCabecalho.appendChild(th);
    }
  
    // Linhas com os dados dos usuários
    const corpoTabela = tabela.createTBody();
    orcamentos.forEach((orcamentos) => {
      const linha = corpoTabela.insertRow();
      for (let chave in orcamentos) {
        const cell = linha.insertCell();
        const texto = document.createTextNode(orcamentos[chave]);
        cell.appendChild(texto);
      }
    });
  
    // Adiciona a tabela ao elemento com id "tabela-usuarios"
    document.getElementById('por-planilhador').appendChild(tabela);
  }



  // Chama a função para criar a tabela com os usuários
  ultimosOrcamentos(usuarios);
  orcamentosDoMes(orcamentos);
  orcamentoPorPlanilhador(orcamentos);