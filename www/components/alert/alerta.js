
/*
    1. HTML
        Você só precisa declarar a estrutura uma única vez na página:

        <div id="alerta" class="card-erro escondido">
            <span id="alerta-icone" class="icone"></span>
            <span id="alerta-mensagem"></span>
            <button id="alerta-fechar" type="button">✕</button>
        </div>

    2. CSS
        Você precisa incluir o arquivo de estilos correspondente:
        <link rel="stylesheet" href="components/alert/styles.css">

    3. JavaScript
        Você precisa incluir o arquivo de script correspondente:
        <script src="components/alert/alerta.js"></script>

    4. Utilização
        Após incluir o HTML, CSS e JavaScript, você pode utilizar o componente de alerta conforme os exemplos abaixo:

        Como utilizar o componente de alerta
        Alerta.mostrar("Cliente cadastrado com sucesso!", "sucesso");

        Alerta.mostrar("Nenhum registro encontrado.", "info");

        Alerta.mostrar("Preencha todos os campos obrigatórios.", "aviso");

        Alerta.mostrar("Não foi possível salvar os dados.", "erro");

        // Fecha manualmente
        Alerta.fechar();

    5. Exemplo com Fetch API
    
    async function salvar(dados) {
        try {
            const resposta = await fetch("/api/clientes", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(dados)
            });

            if (!resposta.ok) throw new Error("Erro ao salvar cliente.");

            Alerta.mostrar("Cliente salvo com sucesso!", "sucesso");
        }
        catch (erro) {
            Alerta.mostrar(erro.message, "erro");
        }
    }
*/

const Alerta = (() => {
    const el_root = document.getElementById("alerta");
    const el_mensagem = document.getElementById("alerta-mensagem");
    const el_icone = document.getElementById("alerta-icone");
    const el_fechar = document.getElementById("alerta-fechar");

    const estados = {
        sucesso: { icone: "✅" },
        info:    { icone: "ℹ️" },
        aviso:   { icone: "⚠️" },
        erro:    { icone: "❌" }
    };

    function mostrar(texto, estado = "info") {
        const config = estados[estado] ?? estados.info;

        el_root.className = `card-erro ${estado in estados ? estado : "info"}`;
        el_mensagem.textContent = texto;
        el_icone.textContent = config.icone;
    }

    function fecharAlerta() {
        el_root.classList.add("escondido");
    }

    el_fechar.addEventListener("click", fecharAlerta);

    return { mostrar, fechar: fecharAlerta };
})();

export default Alerta;

/*

    Exemplo de utilização com Fetch API:

    async function salvar(dados) {
        try {
            const resposta = await fetch("/api/clientes", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(dados)
            });

            if (!resposta.ok) throw new Error("Erro ao salvar cliente.");

            Alerta.mostrar("Cliente salvo com sucesso!", "sucesso");
        }
        catch (erro) {
            Alerta.mostrar(erro.message, "erro");
        }
    }

Uma vantagem dessa implementação: o componente é independente da operação que o chamou. 
Ele não sabe se você está cadastrando clientes, atualizando contratos ou excluindo registros. 
Apenas recebe uma mensagem e um estado e apresenta o resultado.

Além disso, o uso de textContent evita interpretar mensagens recebidas como HTML, oferecendo maior 
segurança.

Você pode utilizar esse mesmo componente em todas as páginas do seu sistema, carregando o alerta.js uma única vez em cada página.

*/

