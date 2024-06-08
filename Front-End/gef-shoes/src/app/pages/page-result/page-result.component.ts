import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-page-result',
  standalone: true,
  imports: [CommonModule, RouterModule, MatButtonModule],
  templateUrl: './page-result.component.html',
  styleUrl: './page-result.component.scss',
})
export class PageResultComponent {
  public imageUrl = 'sucesso.png';
  public titlePage!: string;
  public textPage!: string;
  public labelButton!: string;

  public constructor(public router: Router) {}

  public redirectTo(): void {
    this.router.navigate(['/home']);
  }
}
