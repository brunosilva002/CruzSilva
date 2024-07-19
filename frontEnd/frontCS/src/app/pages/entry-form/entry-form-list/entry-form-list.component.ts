import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { TableRowSelectEvent, TableLazyLoadEvent } from 'primeng/table';
import { EnvironmentService } from 'src/app/shared/environment.service';
import { EntryFormDTO, AxiosEntryFormResourceClient } from 'src/app/shared/java-objects';
import { MenuOptionsService } from 'src/app/shared/menu-options.service';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';
import { UtilsService } from 'src/app/shared/utils.service';

@Component({
  selector: 'app-entry-form-list',
  templateUrl: './entry-form-list.component.html',
  styleUrls: ['./entry-form-list.component.scss']
})
export class EntryFormListComponent implements OnInit {

  entryFormList: EntryFormDTO[] | any
  selectEntryForm: EntryFormDTO | any
  paginationTotal: number = 0
  paginationRows:   number = 10
  teste: number=0;

  constructor (
    private ropingDivisonApi: AxiosEntryFormResourceClient,
    private utilService     : UtilsService,
    private spinner         : SpinnerDefaultService,
    private translate       : TranslateService,
    private router          : Router,
    public environment      : EnvironmentService,
    public menusOptions     : MenuOptionsService
    ){
  } 

  onRowSelect(event:TableRowSelectEvent){
    this.router.navigate(['/entry-form'], {
      queryParams: { cdnEntryForm: event.data.cdnEntryForm },
    });
  }

  onLazyLoad(event: TableLazyLoadEvent){
    this.spinner.show();
    const paginaAtual = event.first!/event.rows!
    this.ropingDivisonApi.paginationFull(event.filters!, { 
      page: paginaAtual,
      pageSize: event.rows!,
      sortBy: event.sortField! as string,
      direction: event.sortOrder!==1 ? 'asc' : 'desc',
    })
    .then(resp=>{
      this.entryFormList=resp.data.data?.content!
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

  async ngOnInit(): Promise<void> {
    try {
      await Promise.all([
        this.translate.get('Name').toPromise(),
        this.menusOptions.ngOnInit() // Supondo que o MenuOptionsService tenha um método initialize que retorne uma Promise
      ]);
            //this.activeRegister.isForUnion=0
    } catch (error) {
      console.error("Error initializing component:", error);
    } finally {
      this.spinner.hide();
    }
  }

  onNewRegister(){
    this.router.navigate(['/entry-form'], {
      
    });
  }


}
