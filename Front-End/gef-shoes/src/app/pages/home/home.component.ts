import { Component, ElementRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { FooterComponent } from '../../components/footer/footer.component';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    NavbarComponent,
    FooterComponent,
    MatButtonModule,
    MatIconModule,
    RouterModule,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  public rotaAtual: string = '';
  public constructor(public elementHome: ElementRef, public router: Router) {
    this.rotaAtual = this.router.url;
  
  }


  /**
   * Função responsável por manipular o elemento HTML, causando um efeito de rolagem suave ao clicar no botão e descer até o elemento com o id colocado
   */
  public scrollToChoose(): void {
    const chooseSection =
      this.elementHome.nativeElement.querySelector('#choose');

    if (chooseSection) {
      chooseSection.scrollIntoView({ behavior: 'smooth' });
    }
  }

  public produto(): void {
    this.router.navigate(['/tela-produto']);
  }

}