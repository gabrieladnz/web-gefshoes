/* Interface padrão das request e response principais */

/* Padrão de envio */
export interface LoginRequest {
  email: string;
  password: string;
}

export interface RegisterRequest {
  email: string;
  senha: string;
}

export interface ForgotPasswordRequest {
  email: string;
}

export interface ResetPasswordRequest {
  email: string;
  password: string;
}

export interface TokenPasswordRequest {
  token: string;
}

/* Padrão de retorno */

export interface LoginResponse {
  id: number;
}

export interface RegisterResponse {
  message: string;
}

export interface ForgotPasswordResponse {
  message: string;
}

export interface ResetPasswordResponse {
  message: string;
}

export interface TokenPasswordResponse {}

/* Padrão de sucesso/erro na requisição */
export interface SuccessResponse {
  success?: boolean;
  message: string;
}

export interface ErrorResponse {
  success?: boolean;
  message: string;
}
