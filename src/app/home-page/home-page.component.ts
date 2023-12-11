import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OrdineComponent } from '../components/ordine/ordine.component';
import { ProdottoComponent } from '../components/prodotto/prodotto.component';
import { ClienteComponent } from '../components/cliente/cliente.component';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [CommonModule, OrdineComponent, ProdottoComponent, ClienteComponent, RouterOutlet, RouterLinkActive, RouterLink],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.scss'
})
export class HomePageComponent {

}
