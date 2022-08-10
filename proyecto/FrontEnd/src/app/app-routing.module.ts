import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import {NewExperienciaComponent} from "./components/experiencia/new-experiencia.component";
import {EditarExperienciaComponent} from "./components/experiencia/editar-experiencia.component";
import {EducacionComponent} from "./components/educacion/educacion.component";
import {NeweducacionComponent} from "./components/educacion/neweducacion.component";
import {EditeducacionComponent} from "./components/educacion/editeducacion.component";


const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaexp', component: NewExperienciaComponent},
  {path:'editarexp/:id', component: EditarExperienciaComponent},
  {path:'educacion', component: NeweducacionComponent},
  {path:'editareducacion/:id', component: EditeducacionComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
