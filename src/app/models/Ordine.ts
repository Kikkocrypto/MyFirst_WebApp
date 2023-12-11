import { Cliente } from "./Cliente";
import { Prodotto } from "./Prodotto";

export class Ordine{
    id_ordine?:number;
    data?: string;
    prodotto?: Prodotto;
    cliente?: Cliente;


    constructor(
      id_ordine?: number,
        data?: string, 
        prodotto?: Prodotto,
        cliente?: Cliente
    ){
        this.id_ordine = id_ordine;
        this.data = data;
        this.prodotto = prodotto;
        this.cliente = cliente;
    }
}