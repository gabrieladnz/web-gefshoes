import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { RegisterComponent } from './pages/register/register.component';
import { LoginComponent } from './pages/login/login.component';
import { FeminineComponent } from './pages/feminine/feminine.component';
import { MasculineComponent } from './pages/masculine/masculine.component';
import { ChildrenComponent } from './pages/children/children.component';
import { SportsComponent } from './pages/sports/sports.component';
import { GefworldComponent } from './pages/gefworld/gefworld.component';
import { FavoritesComponent } from './pages/favorites/favorites.component';
import { CartComponent } from './pages/cart/cart.component';
import { ResetPasswordComponent } from './pages/reset-password/reset-password.component';
import { ValidatorTokenComponent } from './components/validator-token/validator-token.component';
import { ResultRegisterComponent } from './pages/result-register/result-register.component';
import { ResultResetPasswordComponent } from './pages/result-reset-password/result-reset-password.component';
import { PageResultComponent } from './pages/page-result/page-result.component';
import { ProductScreenComponent } from './pages/product-screen/product-screen.component';

export const routes: Routes = [
  /** Rotas da página GEFShoes */
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'cadastro',
    component: RegisterComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'feminino',
    component: FeminineComponent,
  },
  {
    path: 'masculino',
    component: MasculineComponent,
  },
  {
    path: 'infantil',
    component: ChildrenComponent,
  },
  {
    path: 'esportes',
    component: SportsComponent,
  },
  {
    path: 'mundogef',
    component: GefworldComponent,
  },
  {
    path: 'favorites',
    component: FavoritesComponent,
  },
  {
    path: 'carrinho',
    component: CartComponent,
  },
  {
    path: 'redefinir-senha',
    component: ResetPasswordComponent,
  },
  {
    path: 'validar-token',
    component: ValidatorTokenComponent,
  },
  {
    path: 'confirmar-cadastro',
    component: ResultRegisterComponent,
  },
  {
    path: 'confirmar-redefinicao',
    component: ResultResetPasswordComponent,
  },
  {
    path: 'tela-produto',
    component: ProductScreenComponent
  },
  /** Inclusão da rota curinga, no caso do usuário inserir um endereço errado na URL. */
  {
    path: '**',
    redirectTo: '/home',
  },
];
