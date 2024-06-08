import { Injectable } from '@angular/core';
import { RequestService } from '../request/request.service';
import {
  ErrorResponse,
  ForgotPasswordRequest,
  ForgotPasswordResponse,
  LoginRequest,
  LoginResponse,
  RegisterRequest,
  RegisterResponse,
  ResetPasswordRequest,
  ResetPasswordResponse,
  TokenPasswordRequest,
} from '../interfaces/interface-request/interface-request';
import { lastValueFrom } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserServiceService extends RequestService {
  public constructor(public httpClient: HttpClient) {
    super();
  }

  /**
   * Realiza o login do usuário
   * @param data dados do usuário para login (e-mail e senha usuário)
   * @returns uma Promise no caso de sucesso ou uma mensagem de erro
   */
  public async login(data: LoginRequest): Promise<LoginResponse> {
    try {
      return await lastValueFrom(
        this.httpClient.post<LoginResponse>(
          `${this.BASE_URL}/gef-shoes/accounts/login`,
          data
        )
      );
    } catch (error) {
      const errorMessage: ErrorResponse = {
        success: false,
        message: 'Erro ao realizar o login.',
      };
      throw errorMessage;
    }
  }

  /**
   * Realiza o cadastro de um novo usuário
   * @param data dados do usuário para cadastro (e-mail, senha e confrimação de senha)
   * @returns uma Promise no caso de sucesso ou uma mensagem de erro
   */
  public async signUp(data: RegisterRequest): Promise<RegisterResponse> {
    try {
      return await lastValueFrom(
        this.httpClient.post<RegisterResponse>(
          this.BASE_URL + '/gef-shoes/accounts/register',
          data
        )
      );
    } catch (error) {
      const errorMessage: ErrorResponse = {
        success: false,
        message:
          'Ocorreu um erro ao efetuar cadastro. Por favor, tente novamente mais tarde.',
      };
      throw errorMessage;
    }
  }

  /**
   * Função responsável por enviar uma solicitação de redefinição de senha para o e-mail fornecido
   * @param data endereço de e-mail para o qual enviar a solicitação de redefinição de senha
   * @returns Promise contendo os dados de retorno da solicitação de redefinição de senha
   */
  public async forgotPassword(
    data: ForgotPasswordRequest
  ): Promise<ForgotPasswordResponse> {
    try {
      return await lastValueFrom(
        this.httpClient.post<ForgotPasswordResponse>(
          this.BASE_URL + '/gef-shoes/recovery-codes/send',
          data
        )
      );
    } catch (error) {
      const errorMessage: ErrorResponse = {
        success: false,
        message: 'Ocorreu um erro. Por favor, tente novamente mais tarde.',
      };
      throw errorMessage;
    }
  }

  /**
   * Valida um token de recuperação para redefinição de senha.
   * @param data objeto contendo o token e dados associados para validação.
   * @returns booleano indicando se o token é válido ou não.
   */
  public async validatorToken(data: TokenPasswordRequest): Promise<boolean> {
    try {
      await lastValueFrom(this.httpClient.post(this.BASE_URL + '/gef-shoes/recovery-codes/verify', data));
      return true;
    } catch (error) {
      const errorMessage: ErrorResponse = {
        success: false,
        message: 'Error in validatorToken'
      }
      throw errorMessage;
    }
  }

  /**
   * Redefine a senha de uma conta de usuário.
   * @param data objeto contendo as informações necessárias para redefinição de senha.
   * @returns promise que resolve a resposta da operação de redefinição de senha ou uma mensagem de erro.
   */
  public async resetPassword(data: ResetPasswordRequest): Promise<ResetPasswordResponse> {
    try {
      return await lastValueFrom(this.httpClient.put<ResetPasswordResponse>(this.BASE_URL + '/gef-shoes/accounts/update', data));
    } catch (error) {
      const errorMessage: ErrorResponse = {
        success: false,
        message: 'Ocorreu um erro durante a redefinição de senha. Por favor, tente novamente mais tarde.'
      }
      throw errorMessage;
    }
  }
}
