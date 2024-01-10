// Exemplo de dados de usuários obtidos da API
const usuarios = [
    { nome: 'João', telefone: '123456789', cep: '12345-678' },
    { nome: 'Maria', telefone: '987654321', cep: '54321-098' },
    // ... outros usuários
  ];

  function criarTabelaUsuarios(usuarios) {
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
  
  // Chama a função para criar a tabela com os usuários
  criarTabelaUsuarios(usuarios);