import { ArgumentoInvalidoError } from "./Execptions.js";
import { FormularioError } from "./Execptions.js";

const SHEETDB_API_URL = "https://sheetdb.io/api/v1/yt8trp7wrpv3r";
const LabelButtonSubmit = "Enviar Respostas";
// FUNCOES DO FORMULARIO
// =====================

// Função para capturar informações do navegador e versão no input oculto antes do envio do formulário
async function ObterInfoNavegadorAsync() {
    try {
        if (navigator.userAgentData) {
            const ua = await navigator.userAgentData.getHighEntropyValues(['brand', 'version']);
            const navegador = ua.brands.find(b => b.brand !== 'Not A;Brand');
            return navegador ? `${navegador.brand} (v${navegador.version})` : navigator.userAgent;
        }
        return navigator.userAgent;
    }
    catch (error) {
        console.error("Erro ao capturar informações do navegador:", error);
        return "Navegador não disponível";
    }
}

// Função para capturar os dados do formulário antes do envio
// retorna um objeto com os dados do formulário ou null em caso de erro
async function ObterDadosFormularioAsync() {
    const dados = { data: {} };
    try {
        dados.data.nome = document.getElementById("nome").value;
        dados.data.turma = document.getElementById("turma").value;
        dados.data.data = new Date().toLocaleString("pt-BR");
        dados.data.browser = await ObterInfoNavegadorAsync();
        dados.data.q1 = document.getElementById("q1").value;
        dados.data.q2 = document.getElementById("q2").value;
        dados.data.q3 = document.getElementById("q3").value;
        //dados.questao4 = document.getElementById("q4").value;
        //dados.questao5 = document.getElementById("q5").value;
        return dados;
    }
    catch (error) {
        console.error("Erro ao capturar os dados do formulário:", error);
        throw new Error("Erro ao capturar os dados do formulário", { cause: error });
    }

}

// Função para exportar em formato JSON 
function ExportarRespostas(json) {
    if (!json) throw new ArgumentoInvalidoError("Argumento JSON não fornecido.");

    try {
        const blob = new Blob([json], { type: "application/json" });
        const url = URL.createObjectURL(blob);
        const a = document.createElement("a");
        a.href = url;
        a.download = "respostas.json";
        a.click();
        URL.revokeObjectURL(url);
    }
    catch (error) {
        console.error("Erro ao baixar o arquivo JSON:", error);
        throw new Error("Erro ao tentar baixar o arquivo JSON", { cause: error });
    }
}

// Função de envio do formulário para o SheetDB 
async function enviarDadosFormularioAsync(api_url, dados) {
    if (!api_url) throw new ArgumentoInvalidoError("Argumento api_url não fornecido.");
    if (!dados) throw new ArgumentoInvalidoError("Argumento dados não fornecido.");
    try {
        //throw new Error(`Erro simulado`);



        const response = await fetch(api_url, {
            method: "POST",
            headers: { Accept: "application/json", "Content-Type": "application/json" },
            body: JSON.stringify(dados)
        });

        if (!response.ok) throw new Error(`HTTP ${response.status}`);

        const data = await response.json();
        alert("Enviado com sucesso! Suas respostas foram gravadas.");

        document.getElementById("provaForm").reset();

    }
    catch (error) {
        console.error("Erro ao enviar dados:", error);
        throw new Error("Erro ao enviar dados.", { cause: error });
    }

}


// SUBMIT FORMULÁRIO
document
    .getElementById("provaForm")
    ?.addEventListener("submit", async function (e) {
        e.preventDefault();

        const sendOk = false;
        let dados = null;
        try {
            // Desabilitar o botão e mudar a texto para aguarde ...
            LimparErro();
            StateSubmitButton(false, "Aguarde...");

            var api_url = SHEETDB_API_URL;
            dados = await ObterDadosFormularioAsync();
            await enviarDadosFormularioAsync(api_url, dados);
            sendOk = true;
            document.getElementById("provaForm").reset();
        }
        catch (error) {
            console.error("Erro ao enviar dados:", error);

            if (error instanceof ArgumentoInvalidoError) {
                alert(error.message);
                return;
            }

            alert("Não foi possível enviar os dados");
            MostrarErro("Erro ao enviar dados: \n\nDetalhes:\n" + JSON.stringify(error));

            
        }
        finally {
            StateSubmitButton(true, LabelButtonSubmit);
        }

        if (!sendOk) {
             if (confirm("Erro ao enviar dados. Deseja baixar o arquivo com as respostas")) {
                ExportarRespostas(JSON.stringify(dados) );
            }
        }

        function StateSubmitButton(enabled, text) {
            const submitButton = GetSubmitButton();
            if (enabled === undefined || enabled === null) {
                submitButton.disabled = true;
            } else {
                submitButton.disabled = !enabled;
            }
            if (text !== undefined)
                submitButton.textContent = text;
            if (text == null)
                submitButton.textContent = LabelButtonSubmit;

            console.log(`Submit button state disabled: ${submitButton.disabled}, text: ${text}`);
        }
        function GetSubmitButton() {
            return document.querySelector("#provaForm button[type='submit']");
        }

    });

document
    .getElementById('btn-fechar-erro')
    ?.addEventListener('click', EsconderErro);    

// FUNCOES AUXILIARES
// =====================
function MostrarErro(mensagem) {
    const alertaErro = document.getElementById("alerta-erro");
    if (alertaErro) {
        var msgError = alertaErro.querySelector("#mensagem-erro");
        if (msgError)
        {
            msgError.textContent = mensagem;
            alertaErro.classList.remove("escondido");
        }
        console.error(mensagem);
    }
}
function LimparErro() {
    const alertaErro = document.getElementById("alerta-erro");
    if (alertaErro) {
        const msgError = alertaErro.querySelector("#mensagem-erro");
        if (msgError) {
            msgError.textContent = "";
        }
        alertaErro.classList.add("escondido");
    }
}
function EsconderErro() {
    const alertaErro = document.getElementById("alerta-erro");
    if (alertaErro) {
        alertaErro.classList.add("escondido");
    }
}

