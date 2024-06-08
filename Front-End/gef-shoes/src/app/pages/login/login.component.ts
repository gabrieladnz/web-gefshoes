import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { RouterModule } from '@angular/router';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { ModalForgotPasswordComponent } from '../../modals/modal-forgot-password/modal-forgot-password.component';
import { MatDialog } from '@angular/material/dialog';
import { UserServiceService } from '../../services/user-service/user-service.service';
import { LoginResponse } from '../../services/interfaces/interface-request/interface-request';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

/** exportando variável de validação do e-mail */
export const emailPattern = /^[A-Za-z0-9.%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    RouterModule,
    MatCheckboxModule,
    HttpClientModule
  ],
  providers: [UserServiceService],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  public hide: boolean = true;
  protected loginForm!: FormGroup;
  public errorOccurred: boolean = false;

  public constructor(
    private formGroup: FormBuilder,
    public dialog: MatDialog,
    private userService: UserServiceService,
    public router: Router
  ) {}

  public ngOnInit(): void {
    this.loginForm = this.formGroup.group({
      email: ['', [Validators.required, Validators.pattern(emailPattern)]],
      password: ['', [Validators.required]],
    });
  }

  /**
   * Função responsável por realizar o login do usuário, passando os dados preenchidos e validados no
   * @returns Uma promise ou uma mensagem de erro.
   */
  public async login(): Promise<LoginResponse | void> {

    if (this.loginForm.valid) {
      try {
        const loginResponse = await this.userService.login(
          this.loginForm.value
        );
        this.router.navigate(['/home']);
        return loginResponse;
      } catch (error) {
        this.errorOccurred = true;
        console.error('error', error);
      }
    }
  }

  /**
   * Função responsável por abrir o modal de solicitação para recuperação de senha. Atribuindo estilizações e animações ao componente chamado.
   */
  public openModalForgot(): void {
    const dialogRef = this.dialog.open(ModalForgotPasswordComponent, {
      width: '500px',
      height: '100%',
      panelClass: 'custom__modal',
      disableClose: false,
      position: {
        right: '0',
      },
      exitAnimationDuration: 6000,
      enterAnimationDuration: -6000,
    });

    dialogRef.beforeClosed().subscribe(() => {
      dialogRef.addPanelClass('modal__closed');
    });
  }
}
