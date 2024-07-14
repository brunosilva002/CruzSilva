import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { TableRowSelectEvent, TableLazyLoadEvent } from 'primeng/table';
import { EnvironmentService } from 'src/app/shared/environment.service';
import { ChampionshipDTO, AxiosChampionshipResourceClient } from 'src/app/shared/java-objects';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';
import { UtilsService } from 'src/app/shared/utils.service';

@Component({
  selector: 'app-championship-list',
  templateUrl: './championship-list.component.html',
  styleUrls: ['./championship-list.component.scss']
})
export class ChampionshipListComponent implements OnInit {

  championshipList: ChampionshipDTO[] | any
  selectChampionship: ChampionshipDTO | any
  paginationTotal: number = 0
  paginationRows:   number = 10
  teste: number=0;

  constructor (
    private championshipApi: AxiosChampionshipResourceClient,
    private utilService: UtilsService,
    private spinner: SpinnerDefaultService,
    private translate: TranslateService,
    private router: Router,
    public environment: EnvironmentService,
    ){
  } 

  onRowSelect(event:TableRowSelectEvent){
    this.router.navigate(['/championship'], {
      queryParams: { cdnChampionship: event.data.cdnChampionship },
    });
  }

  onLazyLoad(event: TableLazyLoadEvent){
    this.spinner.show();
    const paginaAtual = event.first!/event.rows!
    this.championshipApi.paginationFull(event.filters!, { 
      page: paginaAtual,
      pageSize: event.rows!,
      sortBy: event.sortField! as string,
      direction: event.sortOrder!==1 ? 'asc' : 'desc',
    })
    .then(resp=>{
      this.championshipList=resp.data.data?.content!
      this.paginationTotal = resp.data.data?.totalElements!
    })
    .catch(err=>{
      console.log(err)
      this.utilService.showToast(err.response.data.messagens, "error")
    })
    .finally(()=>{
      this.spinner.hide()
    })

  }

  ngOnInit(): void {
  }

  onNewRegister(){
    this.router.navigate(['/championship'], {
      
    });
  }

}
