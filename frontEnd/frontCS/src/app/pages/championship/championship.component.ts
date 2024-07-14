import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { MessageService } from 'primeng/api';
import { AutoCompleteCompleteEvent } from 'primeng/autocomplete';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { TableRowSelectEvent } from 'primeng/table';
import { ChampionshipDTO, GenderDTO, RopingDTO, AxiosChampionshipResourceClient, AxiosRopingResourceClient, AxiosGenderResourceClient, ChampionshipStageDTO } from 'src/app/shared/java-objects';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';
import { CurrentScreenSize, UtilsService } from 'src/app/shared/utils.service';
import { ModalEditChampionshipStagesComponent } from './modal-edit-championship-stages/modal-edit-championship-stages.component';

@Component({
  selector: 'app-championship',
  templateUrl: './championship.component.html',
  styleUrls: ['./championship.component.scss']
})
export class ChampionshipComponent implements OnInit{
editChampionshipStages($event: TableRowSelectEvent) {
throw new Error('Method not implemented.');
}

  tabRef: string = 'championship';
  cdnTabRef: string = 'cdnChampionship';
  activeRegister: ChampionshipDTO ={};
  cdnParam: any
  
  genderFiltred: GenderDTO[] = [];
  ropingFiltred: RopingDTO[] = [];

  selectedChampionshipStages: ChampionshipStageDTO={};

  championshipStage: ChampionshipStageDTO={};

  champinonshipStagePopup: DynamicDialogRef | undefined;

  constructor(
    private activatedRoute            : ActivatedRoute,
    private championshipApi           : AxiosChampionshipResourceClient,
    public dialogService              : DialogService,
    private messageService            : MessageService,
    private ropingApi                 : AxiosRopingResourceClient,
    private translate                 : TranslateService,
    private spinner                   : SpinnerDefaultService,
    private utilService               : UtilsService,
    private router                    : Router,
    private genderApi                 : AxiosGenderResourceClient,
  ){
  }

 async ngOnInit(): Promise<void> {
    this.spinner.show();
    this.utilService.ngOnInit();
    try {
      await Promise.all([
        this.translate.get('Name').toPromise(),
      ]);
      
      this.activatedRoute.queryParamMap.subscribe((params) => {
        this.cdnParam = params.get(this.cdnTabRef);
        if (this.cdnParam) {
          this.loadData();
          
        }
      });
      //this.activeRegister.isForUnion=0
    } catch (error) {
      console.error("Error initializing component:", error);
    } finally {
      this.spinner.hide();
    }
  }

  loadData(){
    this.spinner.show()
    this.championshipApi.obtain({
      cdnChampionship:this.cdnParam
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
    this.championshipApi.save(this.activeRegister)
    .then(resp=>{
      this.utilService.showToast(resp.data.messagens!,'success')
      this.activeRegister = resp.data.data!
      this.router.navigate(['/championship'], { queryParams: { cdnChampionship: this.activeRegister.cdnChampionship } });
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
    this.router.navigate(['/championship-list'], {
      
    });
  }

  editChampionshipStage(ropingDivisionRank: TableRowSelectEvent) {
    this.addStageLine(ropingDivisionRank.data, ropingDivisionRank.data.lineNumber)
  }

  addStageLine(stage?: ChampionshipStageDTO, line?: any) {
    if (!stage){
      stage = new ChampionshipStageDTO({
        numberStage : this.activeRegister.championshipStages ? this.activeRegister?.championshipStages!.length+1  : 1
      }); // Crie uma nova instância de SalesQuoteProductDTO  
    }

    this.champinonshipStagePopup = this.dialogService.open(ModalEditChampionshipStagesComponent, {
      header: this.translate.instant("Stage.singular"),
      width:  this.utilService.currentScreenSize===CurrentScreenSize.XSmall ? '70%'   : '30%',
      height: this.utilService.currentScreenSize===CurrentScreenSize.XSmall ? '500px' : '300px',
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      resizable:true,
      keepInViewport: true,
      draggable: true,
      data:{
        activeRegister: stage,
      }
  });

  this.champinonshipStagePopup.onClose.subscribe((stageModal: any) => {
    if (stageModal.action=='save') {
        if (line!<0){
          if(!this.activeRegister.championshipStages){
            this.activeRegister.championshipStages = this.activeRegister.championshipStages || [];
          }
          this.activeRegister.championshipStages?.push(stageModal.item)
        }
    }else if(stageModal.action=='delete'){
      const index = this.activeRegister.championshipStages?.findIndex(item => item.numberStage === stageModal.item.numberStage);

      // Se o índice for encontrado, remova o item
      if (index !== -1) {
          this.activeRegister.championshipStages?.splice(index ||0, 1);
        }
      }
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

  selectRoping($event: AutoCompleteCompleteEvent) {
    let query = $event.query;
    const filtered: any[] = [];
    
    this.ropingApi.paginationFull({
      name: {
        value: query,
        matchMode: 'contains'
      }
    }).then((response)=>{
      this.ropingFiltred = response.data.data!.content!
    }).finally(()=>{
      
    })
  }
}
