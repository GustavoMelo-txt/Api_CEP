document.getElementById('cep').addEventListener('blur', async function () {
  const cep = this.value.trim();
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

    document.getElementById('endereco').value = data.logradouro;
    document.getElementById('bairro').value = data.bairro;
    document.getElementById('cidade').value = data.localidade;
    document.getElementById('estado').value = data.uf;
    erroCep.classList.add('d-none');
  } catch (error) {
    erroCep.classList.remove('d-none');
    document.getElementById('endereco').value = '';
    document.getElementById('bairro').value = '';
    document.getElementById('cidade').value = '';
    document.getElementById('estado').value = '';
  }
});
