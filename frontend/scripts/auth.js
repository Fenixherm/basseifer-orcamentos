document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const usuario = document.getElementById('username').value;
    const senha = document.getElementById('password').value;

    if (usuario.trim() === '' || senha.trim() === '') {
        alert('Por favor, preencha todos os campos.');
        return;
    }

    fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ usuario: usuario, senha: senha })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro Ao fazer login.');
            }
            return response.json();
        })
        .then(sessionKey => {
            if (sessionKey) {
                window.location.href = './index.html';
            } else {
                alert('Credenciais inválidas');
            }
        })
        .catch(error => {
            console.error('Erro ao fazer login:', error);
            if (error.response) {
                error.response.json().then(errorMessage => {
                    // Exibe as mensagens de erro retornadas pelo backend
                    console.error('Mensagens de erro:', errorMessage);
                    // Exemplo de como exibir os erros em um alerta, ajuste conforme necessário
                    alert('Erro ao fazer login: ' + JSON.stringify(errorMessage));
                });
            } else {
                alert('Erro ao fazer login');
            }
        });
});