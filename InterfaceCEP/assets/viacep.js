document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('cep').addEventListener('blur', buscarCEP);
    
    document.getElementById('btnCadastrar').addEventListener('click', salvarCadastro);
});

async function buscarCEP() {
    const cep = document.getElementById('cep').value.trim();
    const erroCep = document.getElementById('erroCep');

    if (cep.length !== 8 || isNaN(cep)) {
        erroCep.classList.remove('d-none');
        return;
    }

    try {
        const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
        const data = await response.json();

        if (data.erro) {
            throw new Error('CEP inválido');
        }

        document.getElementById('endereco').value = data.logradouro || '';
        document.getElementById('bairro').value = data.bairro || '';
        document.getElementById('cidade').value = data.localidade || '';
        document.getElementById('estado').value = data.uf || '';
        
        document.getElementById('cepHidden').value = cep;
        
        erroCep.classList.add('d-none');
    } catch (error) {
        erroCep.classList.remove('d-none');
        limparCamposEndereco();
    }
}

function limparCamposEndereco() {
    document.getElementById('endereco').value = '';
    document.getElementById('bairro').value = '';
    document.getElementById('cidade').value = '';
    document.getElementById('estado').value = '';
}

async function salvarCadastro(event) {
    event.preventDefault();
    
    const campos = {
        nome: document.getElementById('nome').value,
        email: document.getElementById('email').value,
        senha: document.getElementById('senha').value,
        cep: document.getElementById('cepHidden').value,
        endereco: document.getElementById('endereco').value,
        numero: document.getElementById('numero').value,
        bairro: document.getElementById('bairro').value,
        cidade: document.getElementById('cidade').value,
        estado: document.getElementById('estado').value
    };
    
    if (Object.values(campos).some(campo => !campo)) {
        Swal.fire({
            icon: 'warning',
            title: 'Atenção',
            text: 'Preencha todos os campos obrigatórios'
        });
        return;
    }

    try {
        console.log('Enviando dados:', campos);
        
        const response = await fetch('http://localhost:8080/api/funcionarios', {
            method: 'POST',
            headers: { 
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(campos)
        });

        console.log('Resposta recebida:', response);
        
        if (!response.ok) {
            const errorData = await response.json().catch(() => null);
            throw new Error(errorData?.message || 'Erro na resposta da API');
        }

        const data = await response.json();
        
        document.getElementById('formCadastro').reset();
        
        Swal.fire({
            icon: 'success',
            title: 'Sucesso',
            text: 'Cadastro realizado com sucesso!'
        });
    } catch (error) {
        Swal.fire({
            icon: 'error',
            title: 'Erro',
            text: error.message || 'Ocorreu um erro ao cadastrar. Por favor, tente novamente.'
        });
    }
}