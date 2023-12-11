import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../models/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  getClienti(): Observable<any>{
    return this.http.get<Array<Cliente>>("http://localhost:8080/mycliente/mygetallcustomer");
  }

  getClienteById(id: number){
    return this.http.get<Cliente>(`http://localhost:8080/mycliente/mygetcustomerbyid/${id}`);
  }

  deleteClienteById(id: number): Observable<any>{
    return this.http.delete<void>(`http://localhost:8080/mycliente/deletecustomerbyid/${id}`);
  }

  createCliente(cliente: Cliente): Observable<Cliente>{
    return this.http.post<Cliente>("http://localhost:8080/mycliente/mypostinsertcustomerobj", cliente);
  }

  updateCliente(cliente: Cliente): Observable<Cliente>{
    return this.http.put<Cliente>("http://localhost:8080/mycliente/myputupdatecustomerobj", cliente);
  }
}


