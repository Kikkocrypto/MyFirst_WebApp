import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { ClienteService } from '../../services/cliente.service';
import { Observable } from 'rxjs';
import { Cliente } from '../../models/Cliente';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente',
  standalone: true,
  imports: [
    CommonModule,
    MatButtonModule,
    MatCardModule,
    MatSelectModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    ReactiveFormsModule,
  ],
  templateUrl: './cliente.component.html',
  styleUrl: './cliente.component.scss',
})
export class ClienteComponent {
  clienti?: Observable<Array<Cliente>>;
  cliente?: Observable<Cliente>;
  mostraLista: boolean = false;

  constructor(private service: ClienteService, private router: Router) {}

  navigateToHome(): void {
    this.router.navigate(['/']);
  }
  ngOnInit(): void {
    this.getAllClienti();
  }

  // agganciati al soggetto() e subscribe tiene d'occhio i cambiamenti
  getAllClienti() {
    this.clienti = this.service.getClienti();
    this.clienti.subscribe();
  }

//   getAllClienti(){
//     this.service.getClienti().subscribe({
//       next: (data) => {console.log(data)},
//       error: () => {}
//     })
// }

//   deleteClienteById(id: number | undefined){
//     if (id !== undefined) {
//     this.service.deleteClienteById(id).subscribe({
//       next: () => {this.getAllClienti();},
//       error: () => {}
//     })
//   }
// }
  // ELIMINA CLIENTE
  deleteClienteById(id: number | undefined) {
    if (id !== undefined) {
      this.service.deleteClienteById(id).subscribe(
        () => {
          this.getAllClienti();
        },
        (error) => {
          console.error('Errore eliminazione:', error);
        }
      );
    }
  }

  //ADD CLIENTE
  // clienteAggiunto:Cliente = new Cliente();
  clienteForm = new FormGroup({
    nome: new FormControl('', [Validators.required]),
    cognome: new FormControl('', [Validators.required]),
    cartaDiCredito: new FormControl('', [Validators.required]),
  });

  submitForm() {
    if (this.clienteForm.valid) {
      const formValues = this.clienteForm.value;
      //Pulizia valori per evitare 'null' o 'undefined'
      const nome = formValues.nome ?? '';
      const cognome = formValues.cognome ?? '';
      const cartaDiCredito = formValues.cartaDiCredito ?? '';

      // creo nuova istanza di cliente e faccio il cast degli elementi (causa errore)
      const nuovoCliente: Cliente = {
        nome: nome as string,
        cognome: cognome as string,
        cartaDiCredito: cartaDiCredito as string,
      };

      this.service.createCliente(nuovoCliente).subscribe(
        (response) => {
          console.log(response);
          this.getAllClienti();
          alert("cliente creato");
          this.clienteForm.reset();
        },
        (errore) => {
          console.error('Errore inserimento: ', errore);
        }
      );
    }
  }

  // UPDATE FORM
  updateForm = new FormGroup({
    id_cliente: new FormControl('', [Validators.required]),
    nome: new FormControl('', [Validators.required]),
    cognome: new FormControl('', [Validators.required]),
    cartaDiCredito: new FormControl('', [Validators.required]),
  });

  updateByForm() {
    if (this.updateForm.valid) {
      const formValues = this.updateForm.value;
      const id_cliente = formValues.id_cliente ?? 0;
      const nome = formValues.nome ?? '';
      const cognome = formValues.cognome ?? '';
      const cartaDiCredito = formValues.cartaDiCredito ?? '';

      const cliente: Cliente = {
        id_cliente: id_cliente as unknown as number,
        nome: nome as string,
        cognome: cognome as string,
        cartaDiCredito: cartaDiCredito as string,
      };

      this.service.updateCliente(cliente).subscribe(
        (response) => {
          console.log('Cliente aggiornato:', response);
          this.getAllClienti();
          this.updateForm.reset();
          alert("cliente aggiornato");
        },
        (errore) => {
          console.error('Errore aggiornamento: ', errore);
        }
      );
    }
  }
}
