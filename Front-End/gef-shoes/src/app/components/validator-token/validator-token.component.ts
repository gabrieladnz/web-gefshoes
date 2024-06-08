import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { HttpClientModule } from '@angular/common/http';
import { UserServiceService } from '../../services/user-service/user-service.service';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { Router } from '@angular/router';
import { EmailServiceService } from '../../services/email-service/email-service.service';

@Component({
  selector: 'app-validator-token',
  standalone: true,
  imports: [
    CommonModule,
    NavbarComponent,
    FooterComponent,
    MatButtonModule,
    MatInputModule,
    HttpClientModule,
    FormsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
  ],
  providers: [UserServiceService],
  templateUrl: './validator-token.component.html',
  styleUrl: './validator-token.component.scss',
})
export class ValidatorTokenComponent {
  public tokenForm!: FormGroup;
  public email!: string;

  public constructor(
    private formGroup: FormBuilder,
    private userService: UserServiceService,
    public router: Router,
    private emailService: EmailServiceService
  ) {}

  public ngOnInit(): void {
    this.emailService.currentEmail.subscribe((email) => {
      console.log('E-mail recebido:', email);
      this.email = email;
      this.initializeForm();
    });
  }

  /**
   * Agrupa o token inserido pelo usuário e o e-mail de redefinição para enviar para a validação.
   */
  private initializeForm(): void {
    this.tokenForm = this.formGroup.group({
      token: ['', [Validators.required]],
      email: [this.email, [Validators.required, Validators.email]],
    });
  }

  /**
   * Valida um token fornecido pelo usuário utilizando o serviço de usuário
   * @returns Promise que resolve para um booleano indicando o sucesso da validação do token
   */
  public async validatorToken(): Promise<boolean | void> {
    console.log('gabi 2', this.tokenForm.value);
    if (this.tokenForm.valid) {
      try {
        const tokenResponse = await this.userService.validatorToken(
          this.tokenForm.value
        );
        this.router.navigate(['/redefinir-senha']);
        return tokenResponse;
      } catch (error) {
        console.error('error', error);
      }
    }
  }
}
