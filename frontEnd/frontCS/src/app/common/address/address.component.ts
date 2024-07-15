import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { AutoCompleteCompleteEvent } from 'primeng/autocomplete';
import { CountryDTO, EstateDTO, CityDTO, CountryResourceClient, AddressDTO, EstateResourceClient, CityResourceClient, AxiosCountryResourceClient, AxiosCityResourceClient, AxiosEstateResourceClient } from 'src/app/shared/java-objects';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';
import { UtilsService } from 'src/app/shared/utils.service';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.scss']
})
export class AddressComponent implements OnInit{


  @Input()
  address: AddressDTO={}

  countryListFiltred  :  CountryDTO[]=[]
  estateListFiltred   :  EstateDTO[]=[] 
  cityListFiltred     :  CityDTO[]=[] 


  constructor (
    private countryApi  : AxiosCountryResourceClient,
    private estateApi   : AxiosEstateResourceClient,
    private cityApi     : AxiosCityResourceClient,
  ){

  }
  ngOnInit(): void {
    if (!this.address){
      this.address          = new AddressDTO({});
    }
  }

  selectCountry($event: AutoCompleteCompleteEvent) {
    let query = $event.query;
    const filtered: any[] = [];

    this.address.estate =undefined
    this.address.city   =undefined

    this.countryApi.paginationFull({
      name: {
        value: query,
        matchMode: 'contains'
      }
    }).then((response)=>{
      this.countryListFiltred = response.data.data!.content!
    }).finally(()=>{

    })
  }

  selectEstate($event: AutoCompleteCompleteEvent) {
    let query = $event.query;
    const filtered: any[] = [];

    this.address.city   =undefined

    this.estateApi.paginationFull({
      name: {
        value: query,
        matchMode: 'contains'
      },
      'country.cdnCountry' : {
        value: this.address.country?.cdnCountry,
        matchMode: 'equals'
      }
    }, { 
      sortBy: 'name' as string,
      direction: 'asc'
    }
  ).then((response)=>{
      this.estateListFiltred = response.data.data!.content!
    }).finally(()=>{

    })
  }

  selectCity($event: AutoCompleteCompleteEvent) {
    let query = $event.query;
    const filtered: any[] = [];

    this.cityApi.paginationFull({
      name: {
        value: query,
        matchMode: 'contains'
      },
      'estate.cdnEstate':{
        value: this.address.estate?.cdnEstate,
        matchMode: 'equals'
      }
    }, { 
      sortBy: 'name' as string,
      direction: 'asc'
    }).then((response)=>{
      this.cityListFiltred = response.data.data!.content!
    }).finally(()=>{

    })
  }




}
