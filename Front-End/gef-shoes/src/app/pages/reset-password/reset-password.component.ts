import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserServiceService } from '../../services/user-service/user-service.service';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { MatIconModule } from '@angular/material/icon';
import { emailPattern } from '../login/login.component';
import { ResetPasswordResponse } from '../../services/interfaces/interface-request/interface-request';
import { EmailServiceService } from '../../services/email-service/email-service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-reset-password',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    HttpClientModule,
    MatIconModule,
  ],
  providers: [UserServiceService],
  templateUrl: './reset-password.component.html',
  styleUrl: './reset-password.component.scss',
})
export class ResetPasswordComponent {
  public hide: boolean = true;
  protected redefinirSenhaForm!: FormGroup;
  public email!: string;

  public constructor(
    private formGroup: FormBuilder,
    private userService: UserServiceService,
    private emailService: EmailServiceService,
    public router: Router
  ) {}

  public ngOnInit(): void {
    this.emailService.currentEmail.subscribe((email) => {
      console.log('E-mail recebido:', email);
      this.email = email;
      this.initializeForm();
    });
  }

  private initializeForm(): void {
    this.redefinirSenhaForm = this.formGroup.group({
      emailInput: [
        { value: this.email, disabled: true },
        [Validators.required, Validators.pattern(emailPattern)],
      ],
      email: [this.email, [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  /**
   * Redefine a senha do usuário
   * @returns Promise que resolve para um objeto `ResetPasswordResponse`
   */
  public async redefinirSenha(): Promise<ResetPasswordResponse | void> {
    if (this.redefinirSenhaForm.valid) {
      try {
        const resetResponse = await this.userService.resetPassword(
          this.redefinirSenhaForm.value
        );
        this.router.navigate(['/confirmar-redefinicao']);
        return resetResponse;
      } catch (error) {
        console.error('error', error);
      }
    }
  }
}
