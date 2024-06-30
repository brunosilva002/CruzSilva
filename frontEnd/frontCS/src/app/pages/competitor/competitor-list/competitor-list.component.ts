import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { TableRowSelectEvent, TableLazyLoadEvent } from 'primeng/table';
import { EnvironmentService } from 'src/app/shared/environment.service';
import { CompetitorDTO, AxiosCompetitorResourceClient } from 'src/app/shared/java-objects';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';
import { UtilsService } from 'src/app/shared/utils.service';

@Component({
  selector: 'app-competitor-list',
  templateUrl: './competitor-list.component.html',
  styleUrls: ['./competitor-list.component.scss']
})
export class CompetitorListComponent implements OnInit {

  competitorList: CompetitorDTO[] | any
  selectCompetitor: CompetitorDTO | any
  paginationTotal: number = 0
  paginationRows:   number = 10
  teste: number=0;

  constructor (
    private competitorApi: AxiosCompetitorResourceClient,
    private utilService: UtilsService,
    private spinner: SpinnerDefaultService,
    private translate: TranslateService,
    private router: Router,
    public environment: EnvironmentService,
    ){
  } 

  onRowSelect(event:TableRowSelectEvent){
    this.router.navigate(['/competitor'], {
      queryParams: { cdnCompetitor: event.data.cdnCompetitor },
    });
  }

  onLazyLoad(event: TableLazyLoadEvent){
    this.spinner.show();
    const paginaAtual = event.first!/event.rows!
    this.competitorApi.paginationFull(event.filters!, { 
      page: paginaAtual,
      pageSize: event.rows!,
      sortBy: event.sortField! as string,
      direction: event.sortOrder!==1 ? 'asc' : 'desc',
    })
    .then(resp=>{
      this.competitorList=resp.data.data?.content!
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
    this.router.navigate(['/competitor'], {
      
    });
  }

}
