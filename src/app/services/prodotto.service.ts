import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../models/Cliente';
import { Prodotto } from '../models/Prodotto';

@Injectable({
  providedIn: 'root'
})
export class ProdottoService {

  constructor(private http: HttpClient) { }
  
  getProdotti(): Observable<any> {
    return this.http.get<Array<Prodotto>>("http://localhost:8080/myprodotto/mygetallproducts");
  }

  deleteProdottoById(id: number): Observable<any>{
    return this.http.delete<void>(`http://localhost:8080/myprodotto/deleteproductbyid/${id}`);
  }

  createProdotto(prodotto: Prodotto): Observable<Prodotto>{
    return this.http.post<Prodotto>("http://localhost:8080/myprodotto/mypostinsertproductobj", prodotto);
  }
  updateProdotto(prodotto: Prodotto): Observable<Prodotto>{
    return this.http.put<Prodotto>("http://localhost:8080/myprodotto/myputupdateproductobj", prodotto);
  }
}
