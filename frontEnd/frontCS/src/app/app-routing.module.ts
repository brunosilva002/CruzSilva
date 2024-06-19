import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './common/login/login.component';
import { MainPageComponent } from './common/main-page/main-page.component';

const routes: Routes = [
  {path: 'login'              , component:LoginComponent},
  {path: 'mainPage'           , component:MainPageComponent},

  {path: '**'                 , redirectTo:"/login"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
