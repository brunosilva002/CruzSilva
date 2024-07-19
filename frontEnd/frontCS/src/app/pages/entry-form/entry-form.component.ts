import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { MessageService } from 'primeng/api';
import { DynamicDialogRef, DialogService } from 'primeng/dynamicdialog';
import { TableRowSelectEvent } from 'primeng/table';
import { EntryFormDTO, AxiosEntryFormResourceClient, PaymentDTO } from 'src/app/shared/java-objects';
import { MenuOptionsService, RewardKind } from 'src/app/shared/menu-options.service';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';
import { UtilsService, CurrentScreenSize } from 'src/app/shared/utils.service';
import { ModalEditPaymentComponent } from './modal-edit-payment/modal-edit-payment.component';

@Component({
  selector: 'app-entry-form',
  templateUrl: './entry-form.component.html',
  styleUrls: ['./entry-form.component.scss']
})
export class EntryFormComponent implements OnInit{

  tabRef: string = 'entryForm';
  cdnTabRef: string = 'cdnEntryForm';
  activeRegister: EntryFormDTO ={};
  cdnParam: any
  
  isDisabledValuePrice: boolean = false;
  isDisabledValueRate: boolean = false;
  
  selectedEntryFormRank: EntryFormDTO={};

  ChampionshipStage:EntryFormDTO={};

  paymentPopup: DynamicDialogRef | undefined;
  selectedPayment: PaymentDTO={};
  
  constructor(
    private activatedRoute              : ActivatedRoute,
    private EntryFormApi                : AxiosEntryFormResourceClient,
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
    this.EntryFormApi.obtain({
      cdnEntryForm:this.cdnParam
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
    this.EntryFormApi.save(this.activeRegister)
    .then(resp=>{
      this.utilService.showToast(resp.data.messagens!,'success')
      this.activeRegister = resp.data.data!
      this.router.navigate(['/roping-division'], { queryParams: { cdnEntryForm: this.activeRegister.cdnEntryForm } });
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
  
  editLine($event: TableRowSelectEvent) {
    this.addLine($event.data, $event.data.numPayment)
  }

  addLine(line?: PaymentDTO, lineNum?: any) {
    if (!line){
      line = new PaymentDTO({
        numPayment : this.activeRegister.payments ? this.activeRegister?.payments!.length+1  : 1
      }); // Crie uma nova instância de SalesQuoteProductDTO  
    }

    this.paymentPopup = this.dialogService.open(ModalEditPaymentComponent, {
      header: this.translate.instant("Payment.singular"),
      width:  this.utilService.currentScreenSize===CurrentScreenSize.XSmall ? '70%'   : '30%',
      height: this.utilService.currentScreenSize===CurrentScreenSize.XSmall ? '500px' : '300px',
      contentStyle: { overflow: 'auto' },
      baseZIndex: 10000,
      maximizable: true,
      resizable:true,
      keepInViewport: true,
      draggable: true,
      data:{
        activeRegister: line,
      }
  });

  this.paymentPopup.onClose.subscribe((modal: any) => {
    if (modal.action=='save') {
        if (lineNum!<0){
          if(!this.activeRegister.payments){
            this.activeRegister.payments = this.activeRegister.payments || [];
          }
          this.activeRegister.payments?.push(modal.item)
        }
    }else if(modal.action=='delete'){
      const index = this.activeRegister.payments?.findIndex(item => item.numPayment === modal.item.numPayment);

      // Se o índice for encontrado, remova o item
      if (index !== -1) {
          this.activeRegister.payments?.splice(index ||0, 1);
        }
      }
    });
  }

}
