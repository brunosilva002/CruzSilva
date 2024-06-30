import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { MessageService } from 'primeng/api';
import { DialogService } from 'primeng/dynamicdialog';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';
import { AddressDTO, AnimalDTO, AxiosAnimalResourceClient, AxiosGenderAnimalResourceClient, GenderAnimalDTO } from 'src/app/shared/java-objects';
import { UtilsService } from 'src/app/shared/utils.service';
import { AutoCompleteCompleteEvent } from 'primeng/autocomplete';

@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.scss']
})
export class AnimalComponent implements OnInit{


  tabRef: string = 'animal';
  cdnTabRef: string = 'cdnAnimal';
  activeRegister: AnimalDTO ={};
  cdnParam: any
  genderAnimalFiltred: GenderAnimalDTO[] = [];

  constructor(
    private activatedRoute      : ActivatedRoute,
    private animalApi           : AxiosAnimalResourceClient,
    public dialogService        : DialogService,
    private messageService      : MessageService,
    private translate           : TranslateService,
    private spinner             : SpinnerDefaultService,
    private utilService         : UtilsService,
    private router              : Router,
    private genderAnimalApi     : AxiosGenderAnimalResourceClient,
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
    this.animalApi.obtain({
      cdnAnimal:this.cdnParam
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
    this.animalApi.save(this.activeRegister)
    .then(resp=>{
      this.utilService.showToast(resp.data.messagens!,'success')
      this.activeRegister = resp.data.data!
      this.router.navigate(['/animal'], { queryParams: { cdnAnimal: this.activeRegister.cdnAnimal } });
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
    this.router.navigate(['/animal-list'], {
      
    });
  }


  selectGenderAnimal($event: AutoCompleteCompleteEvent) {
    let query = $event.query;
    const filtered: any[] = [];

    this.genderAnimalApi.paginationFull({
      name: {
        value: query,
        matchMode: 'contains'
      }
    }).then((response)=>{
      this.genderAnimalFiltred = response.data.data!.content!
    }).finally(()=>{

    })
  }


}
