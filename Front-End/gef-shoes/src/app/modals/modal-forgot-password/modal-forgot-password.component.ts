import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { emailPattern } from '../../pages/login/login.component';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { ForgotPasswordResponse } from '../../services/interfaces/interface-request/interface-request';
import { UserServiceService } from '../../services/user-service/user-service.service';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';
import { EmailServiceService } from '../../services/email-service/email-service.service';

@Component({
  selector: 'app-modal-forgot-password',
  templateUrl: './modal-forgot-password.component.html',
  styleUrls: ['./modal-forgot-password.component.scss'],
  imports: [
    MatIconModule,
    MatFormFieldModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    HttpClientModule,
    RouterModule,
  ],
  providers: [UserServiceService],
  standalone: true,
})
export class ModalForgotPasswordComponent {
  protected forgotPasswordForm!: FormGroup;
  public email: string = '';
  public isLoading = false;

  public constructor(
    private formBuilder: FormBuilder,
    private userService: UserServiceService,
    public dialogRef: MatDialogRef<ModalForgotPasswordComponent>,
    public router: Router,
    private emailService: EmailServiceService
  ) {
    this.forgotPasswordForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.pattern(emailPattern)]],
    });
  }

  /**
   * Função responsável por fechar o modal quando o botão "cancel" for acionado.
   */
  public closeModal(): void {
    this.dialogRef.close();
  }

  /**
   * Função responsável por enviar a solicitação de recuperação de senha.
   */
  public async forgotPassword(): Promise<ForgotPasswordResponse | void> {
    this.isLoading = true;

    console.log('gabi', this.forgotPasswordForm.valid);
    if (this.forgotPasswordForm.valid) {
      try {
        const response = await this.userService.forgotPassword(
          this.forgotPasswordForm.value
        );
        this.router.navigate(['/validar-token']);
        this.dialogRef.close();
        this.emailService.changeEmail(this.forgotPasswordForm.value.email);
        return response;
      } catch (error) {
        console.error('error', error);
      }
      this.isLoading = false;
    }
  }
}
