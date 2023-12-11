import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Prodotto } from '../../models/Prodotto';
import { ProdottoService } from '../../services/prodotto.service';
import { Observable } from 'rxjs';
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
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-prodotto',
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
  templateUrl: './prodotto.component.html',
  styleUrl: './prodotto.component.scss',
})
export class ProdottoComponent implements OnInit {
  prodotti?: Observable<Array<Prodotto>>;
  prodotto?: Observable<Prodotto>;
  mostraLista: boolean = false;

  constructor(private service: ProdottoService, private router: Router) {}
  navigateToHome(): void {
    this.router.navigate(['/']);
  }

  ngOnInit(): void {
    this.getAllProdotti();
  }

  getAllProdotti() {
    this.prodotti = this.service.getProdotti();
    this.prodotti.subscribe();
  }

  deleteProdottoById(id: number | undefined) {
    if (id !== undefined) {
      this.service.deleteProdottoById(id).subscribe(
        () => {
          this.getAllProdotti();
        },
        (error) => {
          console.error('Errore eliminazione:', error);
        }
      );
    }
  }


  toggleLista(): void {
    this.mostraLista = !this.mostraLista;
    if (this.mostraLista) {
      this.getAllProdotti;
    }
  }

  prodottoForm = new FormGroup({
    nome: new FormControl('', [Validators.required]),
    marca: new FormControl('', [Validators.required]),
    prezzo: new FormControl('', [Validators.required]),
  });

  submitFormProdotto() {
    if (this.prodottoForm.valid) {
      const formValues = this.prodottoForm.value;
      //Pulizia valori per evitare 'null' o 'undefined' + parsing del prezzo
      const nome = formValues.nome ?? '';
      const marca = formValues.marca ?? '';
      const prezzo = parseFloat(formValues.prezzo ?? '');

      // creo nuova istanza di prodotto e faccio il cast degli elementi (causa errore)
      const prodottoNuovo: Prodotto = {
        nome: nome as string,
        marca: marca as string,
        prezzo: prezzo,
      };

      this.service.createProdotto(prodottoNuovo).subscribe(
        (response) => {
          console.log(response);
          this.getAllProdotti();
          alert("prodotto creato");
          this.prodottoForm.reset();
        },
        (errore) => {
          console.error('Errore inserimento: ', errore);
        }
      );
    }
  }

  // UPDATE FORM
  updateFormProdotto = new FormGroup({
    id_prodotto: new FormControl('', [Validators.required]),
    nome: new FormControl(''),
    marca: new FormControl(''),
    prezzo: new FormControl(''),
  });

  updateByFormProdotto() {
    if (this.updateFormProdotto.valid) {
      const formValues = this.updateFormProdotto.value;
      const id_prodotto = formValues.id_prodotto ?? '';
      const nome = formValues.nome ?? '';
      const marca = formValues.marca ?? '';
      const prezzo = parseFloat(formValues.prezzo ?? '');

      const prodotto: Prodotto = {
        id_prodotto: id_prodotto as unknown as number,
        nome: nome as string,
        marca: marca as string,
        prezzo: prezzo,
      };

      this.service.updateProdotto(prodotto).subscribe(
        (response) => {
          console.log('prodotto aggiornato:', response);
          this.getAllProdotti();
          alert("prodotto modificato");
          this.updateFormProdotto.reset();
        },
        (errore) => {
          console.error('Errore aggiornamento: ', errore);
        }
      );
    }
  }
}
