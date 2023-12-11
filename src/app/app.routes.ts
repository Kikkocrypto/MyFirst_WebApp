import { Routes } from '@angular/router';
import { ClienteComponent } from './components/cliente/cliente.component';
import { OrdineComponent } from './components/ordine/ordine.component';
import { ProdottoComponent } from './components/prodotto/prodotto.component';

export const routes: Routes = [
    {path: 'clienti', component: ClienteComponent},
    {path: 'ordini', component: OrdineComponent},
    {path: 'prodotti', component: ProdottoComponent},


];
