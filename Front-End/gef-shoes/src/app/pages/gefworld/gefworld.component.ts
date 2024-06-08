import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { FooterComponent } from '../../components/footer/footer.component';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';


@Component({
  selector: 'app-gefworld',
  standalone: true,
  imports: [CommonModule, NavbarComponent, FooterComponent, RouterModule],
  templateUrl: './gefworld.component.html',
  styleUrl: './gefworld.component.scss'
})
export class GefworldComponent {
  public rotaAtual: string = '';
  public constructor(public router: Router) {
    this.rotaAtual = this.router.url;
  
  }

  public produto(): void {
    this.router.navigate(['/tela-produto']);
  }
}
