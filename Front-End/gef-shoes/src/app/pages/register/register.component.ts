import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { UserServiceService } from '../../services/user-service/user-service.service';
import { RegisterResponse } from '../../services/interfaces/interface-request/interface-request';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    HttpClientModule,
  ],
  providers: [UserServiceService],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss',
})
export class RegisterComponent {
  protected registerForm!: FormGroup;
  public emailPattern = /^[A-Za-z0-9.%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
  public hide: boolean = true;
  public samePassword: boolean = true;
  public errorOccurred: boolean = false;

  public constructor(
    private formGroup: FormBuilder,
    private userService: UserServiceService,
    public router: Router
  ) {}

  public ngOnInit() {
    /**
     * FormGroup contendo os campos do formulário de cadastro
     */
    this.registerForm = this.formGroup.group({
      email: ['', [Validators.required, Validators.pattern(this.emailPattern)]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      // confirmPassword: ['', [Validators.required]],
    });
  }

  /**
   * Função responsável por submeter o formulário
   * @returns
   */
  public submit(): void {
    if (!this.registerForm.valid) {
      return;
    }
  }

  /**
   * Acessar o campo de e-mail do formulário
   */
  public get email(): FormControl {
    return this.registerForm.get('email') as FormControl;
  }

  /**
   * Compara duas strings de senha para verificar se são iguais
   * @param password senha inserida pelo usuário
   * @param confirmPassword senha de confirmação inserida pelo usuário
   * @returns valor booleano indicando se as senhas são iguais
   */
  public comparePassword(password: string, confirmPassword: string): boolean {
    return (this.samePassword = password === confirmPassword);
  }

  /**
   * Função responsável por realizar o cadastro do usuário
   * @returns uma request ou um erro em caso de erro
   */
  public async createAccount(): Promise<RegisterResponse | void> {
    if (this.registerForm.valid) {
      try {
        const valueRegister = await this.userService.signUp(
          this.registerForm.value
        );
        this.router.navigate(['/confirmar-cadastro']);
        return valueRegister;
      } catch (error) {
        this.errorOccurred = true;
        console.error('error: ', error);
      }
    }
  }
}
