import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageResultComponent } from '../page-result/page-result.component';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-result-reset-password',
  standalone: true,
  imports: [CommonModule, MatButtonModule],
  templateUrl: '../page-result/page-result.component.html',
  styleUrl: '../page-result/page-result.component.scss',
})
export class ResultResetPasswordComponent extends PageResultComponent {
  public override titlePage = 'Senha redefinida com sucesso';
  public override textPage =
    'Sua senha foi redefinida com sucesso. Acesse sua conta usando a nova senha.';
  public override labelButton = 'ACESSAR CONTA';

  public override redirectTo(): void {
    this.router.navigate(['/login']);
  }
}
