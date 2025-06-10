document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('form');
    
    form.addEventListener('submit', async (e) => {
        e.preventDefault();

        const email = document.getElementById('emailLogin').value.trim();
        const senha = document.getElementById('senhaLogin').value;

        if (!email || !senha) {
            Swal.fire({
                icon: 'warning',
                title: 'Campos obrigatórios',
                text: 'Preencha e-mail e senha!',
            });
            return;
        }

        try {
            const response = await fetch('http://localhost:8080/api/funcionarios/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ email, senha })
            });

            const data = await response.json();

            if (!response.ok) {
                throw new Error(data || 'Credenciais inválidas');
            }

            Swal.fire({
                icon: 'success',
                title: 'Login realizado!',
                text: `Bem-vindo, ${data.nome}!`,
                confirmButtonText: 'OK',
                timer: 3000
            });

        } catch (error) {
            Swal.fire({
                icon: 'error',
                title: 'Falha no login',
                text: `E-mail ou senha incorretos. Tente novamente.`,
                confirmButtonText: 'OK'
            });
        }
    });
});