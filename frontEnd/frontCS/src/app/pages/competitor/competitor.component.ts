import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { MessageService } from 'primeng/api';
import { AutoCompleteCompleteEvent } from 'primeng/autocomplete';
import { DialogService } from 'primeng/dynamicdialog';
import { AddressDTO, AxiosCompetitorResourceClient, AxiosGenderResourceClient, CompetitorDTO, GenderDTO } from 'src/app/shared/java-objects';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';
import { UtilsService } from 'src/app/shared/utils.service';

@Component({
  selector: 'app-competitor',
  templateUrl: './competitor.component.html',
  styleUrls: ['./competitor.component.scss']
})
export class CompetitorComponent  implements OnInit{

  tabRef: string = 'competitor';
  cdnTabRef: string = 'cdnCompetitor';
  activeRegister: CompetitorDTO ={};
  cdnParam: any
  genderFiltred: GenderDTO[] = [];

  constructor(
    private activatedRoute      : ActivatedRoute,
    private competitorApi       : AxiosCompetitorResourceClient,
    public dialogService        : DialogService,
    private messageService      : MessageService,
    private translate           : TranslateService,
    private spinner             : SpinnerDefaultService,
    private utilService         : UtilsService,
    private router              : Router,
    private genderApi           : AxiosGenderResourceClient,
  ){
  }

  ngOnInit(): void {
    this.activeRegister.address =  new AddressDTO({})
    this.activatedRoute.queryParamMap.subscribe((params) => {
      this.cdnParam = params.get(this.cdnTabRef);
      if (this.cdnParam) {
          this.loadData();
      }
    });
  }
  loadData(){
    this.spinner.show()
    this.competitorApi.obtain({
      cdnCompetitor:this.cdnParam
    })
    .then(resp=>{
      this.activeRegister = resp.data.data!
    })
    .catch(err=>{
      this.utilService.showToast(err.response.data.messagens, "error")
    })
    .finally(()=>{
      this.spinner.hide()
    })
  }

  onSave(): void{
    this.spinner.show()
    this.competitorApi.save(this.activeRegister)
    .then(resp=>{
      this.utilService.showToast(resp.data.messagens!,'success')
      this.activeRegister = resp.data.data!
      this.router.navigate(['/competitor'], { queryParams: { cdnCompetitor: this.activeRegister.cdnCompetitor } });
      this.loadData()
    })
    .catch( err=>{
      this.utilService.showToast(err.response.data.messagens, "error")
    })
    .finally(()=>{
      this.spinner.hide()
    })
  }

  onDelete() {
    throw new Error('Method not implemented.');
  }

  onBack() {
    this.router.navigate(['/competitor-list'], {
      
    });
  }


  selectGender($event: AutoCompleteCompleteEvent) {
    let query = $event.query;
    const filtered: any[] = [];

    this.genderApi.paginationFull({
      name: {
        value: query,
        matchMode: 'contains'
      }
    }).then((response)=>{
      this.genderFiltred = response.data.data!.content!
    }).finally(()=>{

    })
  }
}
