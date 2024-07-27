import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { MessageService } from 'primeng/api';
import { DynamicDialogRef, DialogService } from 'primeng/dynamicdialog';
import { TableRowSelectEvent } from 'primeng/table';
import { EventDTO, PaymentDTO, AxiosEventResourceClient, EventTestDTO } from 'src/app/shared/java-objects';
import { MenuOptionsService } from 'src/app/shared/menu-options.service';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';
import { UtilsService, CurrentScreenSize } from 'src/app/shared/utils.service';
import { ModalEditPaymentComponent } from '../entry-form/modal-edit-payment/modal-edit-payment.component';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.scss']
})
export class EventComponent implements OnInit{

  tabRef: string = 'event';
  cdnTabRef: string = 'cdnEvent';
  activeRegister: EventDTO ={};
  cdnParam: any
  
  isDisabledValuePrice: boolean = false;
  isDisabledValueRate: boolean = false;
  
  selectedEventRank: EventDTO={};

  ChampionshipStage:EventDTO={};

  paymentPopup: DynamicDialogRef | undefined;
  selectedTest: EventTestDTO={};
  
  constructor(
    private activatedRoute              : ActivatedRoute,
    private EventApi                    : AxiosEventResourceClient,
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
    this.EventApi.obtain({
      cdnEvent:this.cdnParam
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
    this.EventApi.save(this.activeRegister)
    .then(resp=>{
      this.utilService.showToast(resp.data.messagens!,'success')
      this.activeRegister = resp.data.data!
      this.router.navigate(['/roping-division'], { queryParams: { cdnEvent: this.activeRegister.cdnEvent } });
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
        numPayment : this.activeRegister.eventTests ? this.activeRegister?.eventTests!.length+1  : 1
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
          if(!this.activeRegister.eventTests){
            this.activeRegister.eventTests = this.activeRegister.eventTests || [];
          }
          this.activeRegister.eventTests?.push(modal.item)
        }
    }else if(modal.action=='delete'){
      const index = this.activeRegister.eventTests?.findIndex(item => item.cdnTestNumber === modal.item.cdnTestNumber);

      // Se o índice for encontrado, remova o item
      if (index !== -1) {
          this.activeRegister.eventTests?.splice(index ||0, 1);
        }
      }
    });
  }

}
