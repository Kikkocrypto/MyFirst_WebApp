import { Injectable } from '@angular/core';
import { Ordine } from '../models/Ordine';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdineService {
  constructor(private http: HttpClient) { }
  
  getOrdini(): Observable<any> {
    return this.http.get<Array<Ordine>>("http://localhost:8080/myordine/mygetallorders");
  }

  deleteOrdineById(id: number): Observable<any>{
    return this.http.delete<void>(`http://localhost:8080/myordine/deleteorderbyid/${id}`);
  }

  createOrdine(ordine: Ordine): Observable<Ordine>{
    return this.http.post<Ordine>("http://localhost:8080/myordine/mypostinsertorderobj", ordine);
  }

  updateOrdine(ordine: Ordine): Observable<Ordine>{
    return this.http.put<Ordine>("http://localhost:8080/myordine/myputupdateorderobj", ordine);
  }
}
