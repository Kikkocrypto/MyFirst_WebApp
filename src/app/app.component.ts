import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ClienteComponent } from './components/cliente/cliente.component';
import { ClienteService } from './services/cliente.service';
import { ProdottoService } from './services/prodotto.service';
import { ProdottoComponent } from './components/prodotto/prodotto.component';
import { OrdineService } from './services/ordine.service';
import { OrdineComponent } from './components/ordine/ordine.component';
import { HomePageComponent } from './home-page/home-page.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    HttpClientModule,
    ClienteComponent,
    ProdottoComponent,
    OrdineComponent,
    RouterLinkActive,
    RouterLink,
    HomePageComponent
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [ClienteService, ProdottoService, OrdineService],
})
export class AppComponent {
  title = 'Spring Boot + angular --> @GET Method';

  clicca(): void {
    console.log('click');
  }
}
