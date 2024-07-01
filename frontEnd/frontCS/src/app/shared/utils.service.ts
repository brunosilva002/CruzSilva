import { BreakpointObserver, BreakpointState, Breakpoints } from '@angular/cdk/layout';
import { Injectable, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { AutoCompleteCompleteEvent } from 'primeng/autocomplete';

@Injectable({
  providedIn: 'root'
})
export class UtilsService implements OnInit{

  currentScreenSize: string = '';

  displayNameMap = new Map([
    [Breakpoints.XSmall, 'XSmall'],
    [Breakpoints.Small, 'Small'],
    [Breakpoints.Medium, 'Medium'],
    [Breakpoints.Large, 'Large'],
    [Breakpoints.XLarge, 'XLarge'],
  ]);


  constructor(
    private messageService      : MessageService,
    public breakpointObserver   : BreakpointObserver
  ) {}


  async ngOnInit(): Promise<void> {
    console.log("entrou")
    this.breakpointObserver.observe([
      Breakpoints.XSmall,
      Breakpoints.Small,
      Breakpoints.Medium,
      Breakpoints.Large,
      Breakpoints.XLarge
    ]).subscribe((state: BreakpointState) => {
      for (const query of Object.keys(state.breakpoints)) {
        if (state.breakpoints[query]) {
          this.currentScreenSize = this.displayNameMap.get(query) ?? 'Unknown';
          console.log(this.currentScreenSize)
        }
      }
    });
  }

  showToast(messages: string[], severityMsg: string) {
    messages.forEach(message => {
      this.messageService.add({ severity: severityMsg , summary: severityMsg.toUpperCase(), detail: message });
    });
  }


  updateFormValues(referenceObject: any, form: FormGroup): void {
    for (const key in form.controls) {
      if (form.controls.hasOwnProperty(key) && referenceObject.hasOwnProperty(key)) {
        referenceObject[key]= form.get(key)?.value;
      }
    }
  }

  completeMethodStd($event: AutoCompleteCompleteEvent,objectName: String, searchField: String ) {
    let query = $event.query;

    const listName = `${objectName}List` as keyof this;
    const filteredListName = `${objectName}Filtred` as keyof this;

    const list = (this[listName] as any[]) || [];
    const filtered: any[] = [];

    for (let i = 0; i < list.length; i++) {
      let item = list[i];
      const propertyName  = `${searchField}` as keyof typeof item;
      const conditonField        = item[propertyName] as String;
      if (conditonField && conditonField.toLowerCase().indexOf(query.toLowerCase()) !== -1) {
            filtered.push(item);
          }
      }
      this[filteredListName] = filtered as this[keyof this];
      console.log(this[filteredListName])
    }

    async completeMethodStdContains($event: AutoCompleteCompleteEvent,objectName: any[],searchField: string, api: any): Promise<void> {
      let query = $event.query;
      const filtered: any[] = [];
    
      await api.paginationFull({
        [searchField]: {
          value: query.toLowerCase(),
          matchMode: 'contains'
        }
      }).then((response: { data: { data: any; }; })=>{
        objectName.length = 0; // Limpar a lista existente
        objectName.push(...response.data.data!.content!);
        console.log(objectName)
      }).finally(()=>{
   
      })


    }
}

export enum CurrentScreenSize {
  XSmall = "XSmall",
  Small = "Small",
  Medium = "Medium",
  Large = "Large",
  XLarge = "XLarge",
}