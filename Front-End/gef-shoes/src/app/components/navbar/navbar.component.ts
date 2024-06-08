import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    CommonModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    RouterModule,
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss',
})
export class NavbarComponent {
  public rotaAtual: string = '';

  public constructor(public router: Router) {
    this.rotaAtual = this.router.url;
  }

  /**
   * Função responsável por redirecionar o usuário para a rota de login
   */
  public login(): void {
    this.router.navigate(['/login']);
  }

  /**
   * Função responsável por redirecionar o usuário para a rota de favoritos
   */
  public favorites(): void {
    this.router.navigate(['/favorites']);
  }

  /**
   * Função responsável por redirecionar o usuário para o carrinho
   */
  public shoppingCart(): void {
    this.router.navigate(['/carrinho']);
  }
}
