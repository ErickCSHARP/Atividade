A API do SheetDB permite utilizar uma planilha do Google Sheets como se fosse um banco de dados REST.

Em JavaScript, você pode utilizar o `fetch()` para:

- Consultar todos os registros.
- Consultar um registro específico.
- Inserir novos registros.
- Atualizar registros existentes.
- Excluir registros.
- Acessar diferentes abas (worksheets) da mesma planilha.

Sua API:

```javascript
https://sheetdb.io/api/v1/yt8trp7wrpv3r
```

## 1. Lendo os dados (GET)

Para consultar todos os registros da aba padrão:

```javascript
const API = "https://sheetdb.io/api/v1/yt8trp7wrpv3r";

async function listar() {
    const resposta = await fetch(API);
    const dados = await resposta.json();
    console.log(dados);
}

listar();
```

Imagine que sua planilha tenha as seguintes colunas:

| ID | Nome  | Idade |
| -- | ----- | ----- |
| 1  | João  | 25    |
| 2  | Maria | 30    |

O retorno será um array de objetos:

```javascript
[
    { ID: "1", Nome: "João", Idade: "25" },
    { ID: "2", Nome: "Maria", Idade: "30" }
]
```

Acessando os dados:

```javascript
const dados = await (await fetch(API)).json();
dados.forEach(p => console.log(p.ID, p.Nome, p.Idade));
```

## 2. Enviando dados (POST)

Para inserir um novo registro, utilize o método `POST`:

```javascript
async function inserir() {
    const resposta = await fetch(API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ data: { ID: 3, Nome: "Pedro", Idade: 28 } })
    });
    console.log(await resposta.json());
}

inserir();
```

O objeto `data` contém os campos correspondentes aos cabeçalhos das colunas da planilha.

## 3. Acessando diferentes abas da planilha

Esta é uma das partes mais importantes: você não precisa criar uma API para cada aba.

Basta utilizar o parâmetro `sheet` na URL.

Por exemplo, imagine que sua planilha tenha estas abas:

- `Clientes`
- `Produtos`
- `Pedidos`
- `Funcionarios`

Para consultar cada uma:

```javascript
const clientes = await (await fetch(`${API}?sheet=Clientes`)).json();
const produtos = await (await fetch(`${API}?sheet=Produtos`)).json();
const pedidos = await (await fetch(`${API}?sheet=Pedidos`)).json();
const funcionarios = await (await fetch(`${API}?sheet=Funcionarios`)).json();
```

Você também pode criar uma função genérica para consultar qualquer aba:

```javascript
async function consultar(aba) {
    const url = `${API}?sheet=${encodeURIComponent(aba)}`;
    const resposta = await fetch(url);
    if (!resposta.ok) throw new Error(`Erro HTTP: ${resposta.status}`);
    return await resposta.json();
}

const clientes = await consultar("Clientes");
const produtos = await consultar("Produtos");
```

O mesmo parâmetro `sheet` pode ser utilizado nas operações de inclusão, alteração e exclusão.&#x20;

[image](https://www.google.com/s2/favicons?domain=https://docs.sheetdb.io\&sz=32)

SheetDB+2



## 4. Inserindo dados em uma aba específica

Exemplo: inserir um produto na aba `Produtos`.

```javascript
async function inserir(aba, registro) {
    const resposta = await fetch(API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ data: [registro], sheet: aba })
    });
    if (!resposta.ok) throw new Error(`Erro HTTP: ${resposta.status}`);
    return await resposta.json();
}

await inserir("Produtos", { ID: "10", Nome: "Teclado", Preco: "150.00" });
```

Observe que agora utilizamos `data` como um array, mesmo para inserir somente um registro.

Também é possível inserir vários registros de uma só vez:

```javascript
await inserir("Produtos", [
    { ID: "11", Nome: "Mouse", Preco: "80.00" },
    { ID: "12", Nome: "Monitor", Preco: "900.00" }
]);
```

Para suportar essa segunda forma, basta implementar a função assim:

```javascript
async function inserir(aba, registros) {
    const resposta = await fetch(API, { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify({ data: Array.isArray(registros) ? registros : [registros], sheet: aba }) });
    if (!resposta.ok) throw new Error(`Erro HTTP: ${resposta.status}`);
    return await resposta.json();
}
```

[image](https://www.google.com/s2/favicons?domain=https://docs.sheetdb.io\&sz=32)

SheetDB API documentation

## 5. Atualizando registros (PATCH)

Para alterar um produto, identificamos o registro pelo seu ID:

```javascript
async function atualizar(aba, id, dados) {
    const url = `${API}/ID/${encodeURIComponent(id)}?sheet=${encodeURIComponent(aba)}`;
    const resposta = await fetch(url, { method: "PATCH", headers: { "Content-Type": "application/json" }, body: JSON.stringify({ data: dados }) });
    if (!resposta.ok) throw new Error(`Erro HTTP: ${resposta.status}`);
    return await resposta.json();
}

// Altera somente o preço do produto 10
await atualizar("Produtos", 10, { Preco: "180.00" });
```

Os outros campos permanecem inalterados.&#x20;

[image](https://www.google.com/s2/favicons?domain=https://docs.sheetdb.io\&sz=32)

SheetDB



## 6. Excluindo registros (DELETE)

```javascript
async function excluir(aba, id) {
    const url = `${API}/ID/${encodeURIComponent(id)}?sheet=${encodeURIComponent(aba)}`;
    const resposta = await fetch(url, { method: "DELETE" });
    if (!resposta.ok) throw new Error(`Erro HTTP: ${resposta.status}`);
    return await resposta.json();
}

await excluir("Produtos", 10);
```

Atenção: a exclusão remove todos os registros que correspondem ao critério informado. Por isso, utilize uma coluna com identificador único.&#x20;

[image](https://www.google.com/s2/favicons?domain=https://docs.sheetdb.io\&sz=32)

SheetDB+1



## 7. Pesquisando registros

Você também pode filtrar os registros diretamente pela API, sem precisar baixar a planilha inteira.

```javascript
async function pesquisar(aba, campo, valor) {
    const url = `${API}/search?${encodeURIComponent(campo)}=${encodeURIComponent(valor)}&sheet=${encodeURIComponent(aba)}`;
    const resposta = await fetch(url);
    if (!resposta.ok) throw new Error(`Erro HTTP: ${resposta.status}`);
    return await resposta.json();
}

const resultado = await pesquisar("Clientes", "Nome", "João");
console.log(resultado);
```

Também é possível combinar critérios:

```javascript
const url = `${API}/search?Cidade=Lages&Ativo=Sim&sheet=Clientes`;
const clientes = await (await fetch(url)).json();
```

Os critérios desse endpoint são combinados com AND: todos precisam ser atendidos.&#x20;

[image](https://www.google.com/s2/favicons?domain=https://docs.sheetdb.io\&sz=32)

SheetDB API documentation



## 8. Classe JavaScript para centralizar tudo

Minha recomendação é encapsular as operações em uma classe. Assim, você não precisa repetir URLs, configurações e tratamento de erros pelo sistema.

```javascript
class SheetDB {
    constructor(url) { this.url = url; }
    async request(path = "", method = "GET", body = null, sheet = null) {
        const url = new URL(this.url + path);
        if (sheet) url.searchParams.set("sheet", sheet);
        const options = { method, headers: { "Content-Type": "application/json" } };
        if (body !== null) options.body = JSON.stringify(body);
        const response = await fetch(url, options);
        if (!response.ok) throw new Error(`SheetDB: HTTP ${response.status} - ${await response.text()}`);
        return response.json();
    }
    listar(sheet) { return this.request("", "GET", null, sheet); }
    buscar(sheet, campo, valor) { return this.request(`/search?${encodeURIComponent(campo)}=${encodeURIComponent(valor)}`, "GET", null, sheet); }
    inserir(sheet, dados) { return this.request("", "POST", { data: Array.isArray(dados) ? dados : [dados] }, sheet); }
    atualizar(sheet, campo, valor, dados) { return this.request(`/${encodeURIComponent(campo)}/${encodeURIComponent(valor)}`, "PATCH", { data: dados }, sheet); }
    excluir(sheet, campo, valor) { return this.request(`/${encodeURIComponent(campo)}/${encodeURIComponent(valor)}`, "DELETE", null, sheet); }
}

const db = new SheetDB("https://sheetdb.io/api/v1/yt8trp7wrpv3r");
```

Utilização:

```javascript
// Consultar
const clientes = await db.listar("Clientes");

// Pesquisar
const cliente = await db.buscar("Clientes", "ID", 10);

// Inserir
await db.inserir("Clientes", { ID: 10, Nome: "Carlos", Cidade: "Lages" });

// Atualizar
await db.atualizar("Clientes", "ID", 10, { Nome: "Carlos Silva" });

// Excluir
await db.excluir("Clientes", "ID", 10);
```

## 9. Algumas observações importantes

- Os nomes das abas precisam corresponder exatamente aos nomes existentes no Google Sheets.
- Os cabeçalhos da primeira linha são utilizados como nomes dos campos JSON.
- Normalmente, os valores retornam como strings, inclusive números.
- A API precisa ter permissões habilitadas para as operações desejadas.
- Se utilizar diretamente no navegador, lembre-se de que o endereço da API fica visível. Não utilize esse modelo para dados sensíveis ou operações que precisem de controle de acesso. Prefira um backend intermediário nesses casos.&#x20;

  [image](https://www.google.com/s2/favicons?domain=https://docs.sheetdb.io\&sz=32)

  SheetDB+1



Documentação oficial: [SheetDB API Documentation](https://docs.sheetdb.io/?utm_source=chatgpt.com).

Uma sugestão: essa classe pode servir como uma pequena camada de persistência para projetos JavaScript, permitindo trabalhar com diferentes abas como se fossem tabelas de um banco de dados.