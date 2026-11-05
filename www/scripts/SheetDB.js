// const db = new SheetDB("https://sheetdb.io/api/v1/yt8trp7wrpv3r");

export default class SheetDB 
{
  constructor(url) 
  {
    this.url = url;
  }

  async request(path = "", method = "GET", body = null, sheet = null) 
  {
    const url = new URL(this.url + path);
    if (sheet) url.searchParams.set("sheet", sheet);
    const options = { method, headers: { "Content-Type": "application/json" } };
    if (body !== null) options.body = JSON.stringify(body);
    const response = await fetch(url, options);
    if (!response.ok)
      throw new Error(`SheetDB: HTTP ${response.status} - ${await response.text()}`,);
    return response.json();
  }

  listar(sheet) 
  {
    return this.request("", "GET", null, sheet);
  }

  buscar(sheet, campo, valor) 
  {
    return this.request(
      `/search?${encodeURIComponent(campo)}=${encodeURIComponent(valor)}`,
      "GET",
      null,
      sheet,
    );
  }

  inserir(sheet, dados) {
    return this.request(
      "",
      "POST",
      { data: Array.isArray(dados) ? dados : [dados] },
      sheet,
    );
  }

  atualizar(sheet, campo, valor, dados) 
  {
    return this.request(
      `/${encodeURIComponent(campo)}/${encodeURIComponent(valor)}`,
      "PATCH",
      { data: dados },
      sheet,
    );
  }

  excluir(sheet, campo, valor) 
  {
    return this.request(
      `/${encodeURIComponent(campo)}/${encodeURIComponent(valor)}`,
      "DELETE",
      null,
      sheet,
    );
  }
}

export class SheetDbUrl 
{
  constructor(urlBase, tableName) 
  {
    if (!urlBase) throw new Error("URL base não fornecida");
    this._urlBase = urlBase;
    this._tableName = tableName;
  }
  //static _urlBase;
  setTableName(tableName) 
  {
    this._tableName = tableName;
  }

  getUrl() 
  {
    //return this._urlBase + (this._tableName ? `/search?sheet=${this._tableName}` : '');
    return (this._urlBase + (this._tableName ? `/?sheet=${this._tableName}` : ""));
  }
}


/*

Exemplo de uso:
const clientes = await db.listar("Clientes");

// Pesquisar
const cliente = await db.buscar("Clientes", "ID", 10);

// Inserir
await db.inserir("Clientes", { ID: 10, Nome: "Carlos", Cidade: "Lages" });

// Atualizar
await db.atualizar("Clientes", "ID", 10, { Nome: "Carlos Silva" });

// Excluir
await db.excluir("Clientes", "ID", 10);



*/
