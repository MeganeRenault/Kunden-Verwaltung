import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {CustomersComponent} from './customers/customers.component';
import {LoadCustomersComponent} from './load-customers/load-customers.component';
import {ProfileComponent} from './profile/profile.component';
import {LoginComponent} from './login/login.component';
import {AdminTemplateComponent} from './admin-template/admin-template.component';
import {AuthGuard} from './guards/auth.guard';
import {AuthorizationGuard} from './guards/authorization.guard';

const routes: Routes = [
  {path : "", component : LoginComponent},
  {path : "login", component : LoginComponent},
  {path : "admin", component : AdminTemplateComponent,
    canActivate : [AuthGuard],
    children: [
      {path : "home", component : HomeComponent},
      {path : "customers", component : CustomersComponent},
      {
        path : "loadCustomers", component : LoadCustomersComponent,
        canActivate : [AuthorizationGuard], data : {roles : ['ADMIN']}
      },
      {path : "profile", component : ProfileComponent},
    ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
