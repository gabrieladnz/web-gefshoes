import { Component, ElementRef, ChangeDetectorRef} from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { FooterComponent } from '../../components/footer/footer.component';


@Component({
  selector: 'app-product-screen',
  standalone: true,
  imports: [CommonModule,
    NavbarComponent,
    FooterComponent,
  ],
  templateUrl: './product-screen.component.html',
  styleUrl: './product-screen.component.scss'
})
export class ProductScreenComponent{
  mostrarPrimeiraImagem = true;
  segundaImagemUrl = '../../../assets/shoes/tenis-tela-produto-2.png';

  mostrarImagemCoracao = true;
  segundaImagemCoracao = '../../../assets/icons/black-heart.png';
  
  trocarimagem() {
   this.mostrarPrimeiraImagem = !this.mostrarPrimeiraImagem;
  }

  trocarCoracao() {
    this.mostrarImagemCoracao = !this.mostrarImagemCoracao;
    
  }

}