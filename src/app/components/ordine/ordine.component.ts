import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { Prodotto } from '../../models/Prodotto';
import { OrdineService } from '../../services/ordine.service';
import { Ordine } from '../../models/Ordine';
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
import { Cliente } from '../../models/Cliente';
import { Router } from '@angular/router';
import { ProdottoService } from '../../services/prodotto.service';
import { ClienteService } from '../../services/cliente.service';

@Component({
  selector: 'app-ordine',
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
  templateUrl: './ordine.component.html',
  styleUrl: './ordine.component.scss',
  providers:[ProdottoService, ClienteService]
})
export class OrdineComponent {
  clienti?: Observable<Array<Cliente>>;
  ordini?: Observable<Array<Ordine>>;
  prodotti?: Observable<Array<Prodotto>>;


  constructor(private service: OrdineService, private router: Router, private prdottoService: ProdottoService, private clienteService: ClienteService) {}
  navigateToHome(): void {
    this.router.navigate(['/']);
  }

  ngOnInit(): void {
    this.getAllOrdini();
    this.clienti = this.clienteService.getClienti();
    this.prodotti = this.prdottoService.getProdotti();
    // this.ordini.subscribe();
  }

  getAllOrdini() {
    this.ordini = this.service.getOrdini();
    this.ordini.subscribe((data) => console.log(data));
  }

  deleteOrdineById(id: number | undefined) {
    if (id !== undefined) {
      this.service.deleteOrdineById(id).subscribe(
        () => {
          this.getAllOrdini();
        },
        (error) => {
          console.error('Errore eliminazione:', error);
        }
      );
    }
  }

  //ADD ORDINE
  // clienteAggiunto:Cliente = new Cliente();
  ordineForm = new FormGroup({
    data: new FormControl('', [Validators.required]),
    prodotto: new FormControl('', [Validators.required]),
    cliente: new FormControl('', [Validators.required]),
  });

  submitFormOrdine() {
    if (this.ordineForm.valid) {
      const formValues = this.ordineForm.value;
      //Pulizia valori per evitare 'null' o 'undefined'
      const data = formValues.data ?? '';
      const id_prodotto = formValues.prodotto ?? '';
      const id_cliente = formValues.cliente ?? '';

      // creo nuova istanza di ordine e faccio il cast degli elementi (causa errore)
      const nuovoOrdine: Ordine = {
        data: data,
        cliente: {
          id_cliente: Number(id_cliente),
          nome: '',
          cognome: '',
          cartaDiCredito: '',
        },
        prodotto: {
          id_prodotto: Number(id_prodotto),
          nome: '',
          marca: '',
          prezzo: 0,
        },
      };

      this.service.createOrdine(nuovoOrdine).subscribe(
        (response) => {
          console.log(response);
          this.getAllOrdini();
          this.ordineForm.reset();
        },
        (errore) => {
          console.error('Errore inserimento: ', errore);
        }
      );
    }
  }

  // UPDATE FORM
  updateFormOrdine = new FormGroup({
    id_ordine: new FormControl<number>(0),
    data: new FormControl<string>(''),
    marca: new FormControl<string>(''),
    id_prodotto: new FormControl<number>(0),
    id_cliente: new FormControl<number>(0),
  });

  updateByFormOrdine() {
    console.log('Form value:', this.updateFormOrdine.status);
    if (this.updateFormOrdine.valid) {
      console.log('Form valid!');
      const formValues = this.updateFormOrdine.value;
      const id_ordine = Number(formValues.id_ordine) ?? 0;
      const data = formValues.data ?? '';
      const id_prodotto = Number(formValues.id_prodotto) ?? 0;
      const id_cliente = Number(formValues.id_cliente) ?? 0;

      const ordine: Ordine = {
        id_ordine: id_ordine,
        data: data,
        cliente: {
          id_cliente: id_cliente,
          nome: '',
          cognome: '',
          cartaDiCredito: '',
        },
        prodotto: {
          id_prodotto: id_prodotto,
          nome: '',
          marca: '',
          prezzo: 0,
        },
      };
      this.getAllOrdini();

      this.service.updateOrdine(ordine).subscribe(
        (response) => {
          console.log(response);
          this.getAllOrdini();
          this.updateFormOrdine.reset();
        },
        (errore) => {
          console.error('Errore inserimento: ', errore);
        }
      );
    } else {
      console.log('Form non valido');
    }
  }
}

// getAllOrdini(){
  //     this.service.getOrdini().subscribe({
  //       next: (data) => {console.log(data)},
  //       error: () => {}
  //     })
  // }
  
  //   deleteOrdineById(id: number | undefined){
  //     if (id !== undefined) {
  //     this.service.deleteOrdineById(id).subscribe({
  //       next: () => {this.getAllOrdini();},
  //       error: () => {}
  //     })
  //   }
  // }
