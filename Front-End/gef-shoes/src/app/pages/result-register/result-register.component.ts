import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageResultComponent } from '../page-result/page-result.component';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-result-register',
  standalone: true,
  imports: [CommonModule, MatButtonModule],
  templateUrl: '../page-result/page-result.component.html',
  styleUrl: '../page-result/page-result.component.scss'
})
export class ResultRegisterComponent extends PageResultComponent {
  public override titlePage = "Cadastro efetuado com sucesso"
  public override textPage = "Faça login para explorar o mundo de novidades da GEFShoes!"
  public override labelButton = "EXPLORAR NOVIDADES";

  public override redirectTo(): void {
      this.router.navigate(['/login']);
  }
}
