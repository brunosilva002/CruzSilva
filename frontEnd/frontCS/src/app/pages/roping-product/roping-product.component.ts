import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { MessageService } from 'primeng/api';
import { AutoCompleteCompleteEvent } from 'primeng/autocomplete';
import { DialogService } from 'primeng/dynamicdialog';
import { GenderDTO, AxiosGenderResourceClient, AddressDTO, RopingProductDTO, AxiosRopingProductResourceClient, RopingDTO, AxiosDivisionResourceClient, AxiosRopingResourceClient } from 'src/app/shared/java-objects';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';
import { UtilsService } from 'src/app/shared/utils.service';

@Component({
  selector: 'app-roping-product',
  templateUrl: './roping-product.component.html',
  styleUrls: ['./roping-product.component.scss']
})
export class RopingProductComponent implements OnInit{

  tabRef: string = 'ropingDivisionProduct';
  cdnTabRef: string = 'cdnRopingDivisionProduct';
  activeRegister: RopingProductDTO ={};
  cdnParam: any
  
  genderFiltred: GenderDTO[] = [];
  ropingFiltred: RopingDTO[] = [];


  constructor(
    private activatedRoute            : ActivatedRoute,
    private ropingDivisionProductApi  : AxiosRopingProductResourceClient,
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
    this.ropingDivisionProductApi.obtain({
      cdnRopingDivisionProduct:this.cdnParam
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
    this.ropingDivisionProductApi.save(this.activeRegister)
    .then(resp=>{
      this.utilService.showToast(resp.data.messagens!,'success')
      this.activeRegister = resp.data.data!
      this.router.navigate(['/roping-product'], { queryParams: { cdnRopingDivisionProduct: this.activeRegister.cdnRopingDivisionProduct } });
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
    this.router.navigate(['/roping-product-list'], {
      
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
