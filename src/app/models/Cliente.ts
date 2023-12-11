export class Cliente{
    id_cliente?:number;
    nome: string;
    cognome: string;
    cartaDiCredito: string;

    constructor(
        id_cliente: number,
        nome: string,
        cognome: string,
        cartaDiCredito: string
    ){
        this.id_cliente = id_cliente;
        this.nome = nome ?? '';
        this.cognome = cognome;
        this.cartaDiCredito = cartaDiCredito;
    }

    
}