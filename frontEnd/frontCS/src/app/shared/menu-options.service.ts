import { Injectable, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Injectable({
  providedIn: 'root'
})
export class MenuOptionsService implements OnInit {

  isOfficialDivisionOptions:any;
  isForUnionOptions: any;
  isShowEntriesOptions:any;
  isSendNotificationOptions:any;
  isGeneratePaceNextClassificationOptions:any;
  isRodeoOptions:any;
  isAllowChangeAnimalFinalOptions:any;
  isFinalRodeoDrawOptions:any;
  showInscriptionOptions:any;

  constructor(
    private translate           : TranslateService,
  ) { 

  }
  
  async ngOnInit(): Promise<void> {
    await this.translate.get('Name').toPromise().then()
    this.isOfficialDivisionOptions = [
      { name: this.translate.instant('NotOficial.singular')   , value: false },
      { name: this.translate.instant('Oficial.singular')      , value: true }
    ];
    
    this.isForUnionOptions = [
      { name: this.translate.instant('NotForUnion.plural')   , value: false},
      { name: this.translate.instant('ForUnion.singular') , value: true }
    ];

    this.isShowEntriesOptions = [
      { name: this.translate.instant('NotShowEntries.singular')   , value: false},
      { name: this.translate.instant('ShowEntries.singular') , value: true }
    ];
    this.isSendNotificationOptions = [
      { name: this.translate.instant('NotSendNotification.singular')   , value: false},
      { name: this.translate.instant('SendNotification.singular') , value: true }
    ];
    this.isGeneratePaceNextClassificationOptions = [
      { name: this.translate.instant('NotGeneratePaceNextClassification.singular')   , value: false},
      { name: this.translate.instant('GeneratePaceNextClassification.singular') , value: true }
    ];
    this.isRodeoOptions = [
      { name: this.translate.instant('NotRodeo.singular')   , value: false},
      { name: this.translate.instant('Rodeo.plural') , value: true }
    ];
    this.isAllowChangeAnimalFinalOptions = [
      { name: this.translate.instant('NotAllowChangeAnimalFinal.singular')   , value: false},
      { name: this.translate.instant('AllowChangeAnimalFinal.plural') , value: true }
    ];
    this.isFinalRodeoDrawOptions = [
      { name: this.translate.instant('NotFinalRodeoDraw.singular')   , value: false},
      { name: this.translate.instant('FinalRodeoDraw.singular') , value: true }
    ];

    this.showInscriptionOptions = [
      { name: this.translate.instant('NotShowInscriptionOptions.singular')   , value: false},
      { name: this.translate.instant('ShowInscriptionOptions.singular') , value: true }
    ];
  }

  getName(valueRef:any, menuOptions:any){
    return menuOptions.find((option: { value: any; }) =>option.value==valueRef).name
  }
}



export interface Option {
  name: string;
  value: any;
}

export enum OfficialDivision {
  NOT_OFFICIAL = 0,
  OFFICIAL = 1
}

export enum YesNo {
  NO = 0,
  YES = 1
}

export enum  RewardKind  {
  FIXED_VALUE = 1,
  SUBSCRIPTION = 2
}
