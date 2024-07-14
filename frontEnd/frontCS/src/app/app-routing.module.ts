import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './common/login/login.component';
import { MainPageComponent } from './common/main-page/main-page.component';
import { AnimalComponent } from './pages/animal/animal.component';
import { CompetitorComponent } from './pages/competitor/competitor.component';
import { JudgeComponent } from './pages/judge/judge.component';
import { RopingComponent } from './pages/roping/roping.component';
import { RopingDivisionComponent } from './pages/roping-division/roping-division.component';
import { RopingProductComponent } from './pages/roping-product/roping-product.component';
import { AnimalListComponent } from './pages/animal/animal-list/animal-list.component';
import { CompetitorListComponent } from './pages/competitor/competitor-list/competitor-list.component';
import { JudgeListComponent } from './pages/judge/judge-list/judge-list.component';
import { RopingDivisionListComponent } from './pages/roping-division/roping-division-list/roping-division-list.component';
import { RopingProductListComponent } from './pages/roping-product/roping-product-list/roping-product-list.component';
import { RopingListComponent } from './pages/roping/roping-list/roping-list.component';
import { EntryFormComponent } from './pages/entry-form/entry-form.component';
import { ChampionshipComponent } from './pages/championship/championship.component';
import { TrackComponent } from './pages/track/track.component';
import { EntryFormListComponent } from './pages/entry-form/entry-form-list/entry-form-list.component';
import { ChampionshipListComponent } from './pages/championship/championship-list/championship-list.component';
import { TrackListComponent } from './pages/track/track-list/track-list.component';

const routes: Routes = [
  {path: 'login'                , component:LoginComponent},
  {path: 'mainPage'             , component:MainPageComponent},

  {path: 'animal'               , component:AnimalComponent},
  {path: 'competitor'           , component:CompetitorComponent},
  {path: 'judge'                , component:JudgeComponent},
  {path: 'roping'               , component:RopingComponent},
  {path: 'roping-division'      , component:RopingDivisionComponent},
  {path: 'roping-product'       , component:RopingProductComponent},
  {path: 'entry-form'           , component:EntryFormComponent},
  {path: 'championship'         , component:ChampionshipComponent},
  {path: 'track'                , component:TrackComponent},

  {path: 'animal-list'          , component:AnimalListComponent},
  {path: 'competitor-list'      , component:CompetitorListComponent},
  {path: 'judge-list'           , component:JudgeListComponent},
  {path: 'roping-list'          , component:RopingListComponent},
  {path: 'roping-division-list' , component:RopingDivisionListComponent},
  {path: 'roping-product-list'  , component:RopingProductListComponent},
  {path: 'entry-form-list'      , component:EntryFormListComponent},
  {path: 'championship-list'    , component:ChampionshipListComponent},
  {path: 'track-list'           , component:TrackListComponent},



  {path: '**'                 , redirectTo:"/login"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
