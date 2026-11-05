export class ArgumentoInvalidoError extends Error 
{
    constructor(mensagem) 
    {
        super(mensagem);
        this.name = "ArgumentoInvalidoError";
    }
}

export class FormularioError extends Error 
{
    constructor(mensagem, dataForm = null) 
    {
        super(mensagem);
        this.name = "FormularioError";
        this.dataForm = dataForm;
    }
}
