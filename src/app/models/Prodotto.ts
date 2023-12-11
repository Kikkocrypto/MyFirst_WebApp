export class Prodotto{
    id_prodotto?:number;
    nome?: string;
    marca?: string;
    prezzo?: number;

    constructor(
        id_prodotto: number,
        nome: string,
        marca: string,
        prezzo: number
    ){
        this.id_prodotto = id_prodotto;
        this.nome = nome ?? '';
        this.marca = marca;
        this.prezzo = prezzo;
    }
}