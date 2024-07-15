import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { MessageService } from 'primeng/api';
import { AutoCompleteCompleteEvent } from 'primeng/autocomplete';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { TableRowSelectEvent } from 'primeng/table';
import { RopingDivisionDTO, GenderDTO, AxiosRopingDivisionResourceClient, AxiosGenderResourceClient, AddressDTO, RopingDTO, AxiosRopingResourceClient, AxiosDivisionResourceClient, DivisionDTO, RewardKindDTO, AxiosRewardKindResourceClient, BarrelTypeDTO, AxiosBarrelTypeResourceClient, TypeClassificationDTO, TypeClassificationTimeDTO, AxiosTypeClassificationResourceClient, AxiosTypeClassificationTimeResourceClient, RopingDivisionRankDTO } from 'src/app/shared/java-objects';
import { MenuOptionsService, RewardKind } from 'src/app/shared/menu-options.service';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';
import { CurrentScreenSize, UtilsService } from 'src/app/shared/utils.service';
import { ModalEditRopingDivisionRankComponent } from './modal-edit-roping-division-rank/modal-edit-roping-division-rank.component';

@Component({
  selector: 'app-roping-division',
  templateUrl: './roping-division.component.html',
  styleUrls: ['./roping-division.component.scss']
})
export class RopingDivisionComponent  implements OnInit{
  tabRef: string = 'RopingDivision';
  cdnTabRef: string = 'cdnRopingDivision';
  activeRegister: RopingDivisionDTO ={};
  cdnParam: any
  
  isDisabledValuePrice: boolean = false;
  isDisabledValueRate: boolean = false;
  
  selectedRopingDivisionRank: RopingDivisionRankDTO={};

  ChampionshipStage:RopingDivisionRankDTO={};

  ropingDivisionRankPopup: DynamicDialogRef | undefined;
  
  constructor(
    private activatedRoute              : ActivatedRoute,
    private RopingDivisionApi           : AxiosRopingDivisionResourceClient,
    public dialogService                : DialogService,
    private messageService              : MessageService,
    private translate                   : TranslateService,
    private spinner                     : SpinnerDefaultService,
    private utilService                 : UtilsService,
    private router                      : Router,
    public menusOptions                 : MenuOptionsService,
  ){
    
  }
  
  async ngOnInit(): Promise<void> {
    this.spinner.show();
    this.utilService.ngOnInit();
    try {
      await Promise.all([
        this.translate.get('Name').toPromise(),
        this.menusOptions.ngOnInit() // Supondo que o MenuOptionsService tenha um método initialize que retorne uma Promise
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
    this.RopingDivisionApi.obtain({
      cdnRopingDivision:this.cdnParam
    })
    .then(resp=>{
      this.activeRegister = resp.data.data!
    })
    .catch(err=>{
      this.utilService.showToast(err.response.data.messagens, "error")
    })
    .finally(()=>{
      this.checkDisableFields();
      this.spinner.hide()
    })
  }
  
  onSave(): void{
    this.spinner.show()
    this.RopingDivisionApi.save(this.activeRegister)
    .then(resp=>{
      this.utilService.showToast(resp.data.messagens!,'success')
      this.activeRegister = resp.data.data!
      this.router.navigate(['/roping-division'], { queryParams: { cdnRopingDivision: this.activeRegister.cdnRopingDivision } });
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
    this.router.navigate(['/roping-division-list'], {
      
    });
  }
    
  onChangeRewardKind() {
    this.checkDisableFields()
  }

  editRopingDivisionRank(ropingDivisionRank: TableRowSelectEvent) {
    this.addAwardLine(ropingDivisionRank.data, ropingDivisionRank.data.lineNumber)
  }

  addAwardLine(award?: RopingDivisionRankDTO, line?: any) {
    if (!award){
      award = new RopingDivisionRankDTO({
        rankNumber : this.activeRegister.ropingDivisionRanks ? this.activeRegister?.ropingDivisionRanks!.length+1  : 1
      }); // Crie uma nova instância de SalesQuoteProductDTO  
    }

    this.ropingDivisionRankPopup = this.dialogService.open(ModalEditRopingDivisionRankComponent, {
      header: this.translate.instant("Award.singular"),
      width:  this.utilService.currentScreenSize===CurrentScreenSize.XSmall ? '70%'   : '30%',
      height: this.utilService.currentScreenSize===CurrentScreenSize.XSmall ? '500px' : '300px',
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      resizable:true,
      keepInViewport: true,
      draggable: true,
      data:{
        activeRegister: award,
        isDisabledValueRate: this.isDisabledValueRate,
        isDisabledValuePrice: this.isDisabledValuePrice
      }
  });

  this.ropingDivisionRankPopup.onClose.subscribe((awardModal: any) => {
    if (awardModal.action=='save') {
        if (line!<0){
          if(!this.activeRegister.ropingDivisionRanks){
            this.activeRegister.ropingDivisionRanks = this.activeRegister.ropingDivisionRanks || [];
          }
          this.activeRegister.ropingDivisionRanks?.push(awardModal.item)
        }
    }else if(awardModal.action=='delete'){
      const index = this.activeRegister.ropingDivisionRanks?.findIndex(item => item.rankNumber === awardModal.item.rankNumber);

      // Se o índice for encontrado, remova o item
      if (index !== -1) {
          this.activeRegister.ropingDivisionRanks?.splice(index ||0, 1);
        }
      }
    });
  }

  checkDisableFields(){
    console.log("checkDisableFields",this.activeRegister.rewardKind)
    if (this.activeRegister.rewardKind?.cdnRewardKind===RewardKind.SUBSCRIPTION){
      this.isDisabledValuePrice=true
      this.isDisabledValueRate=false
      this.activeRegister.valuePrice=0
    }else if (this.activeRegister.rewardKind?.cdnRewardKind===RewardKind.FIXED_VALUE){
      this.isDisabledValuePrice=false
      this.isDisabledValueRate=true
      this.activeRegister.valueRate=0
    }
  }

}
