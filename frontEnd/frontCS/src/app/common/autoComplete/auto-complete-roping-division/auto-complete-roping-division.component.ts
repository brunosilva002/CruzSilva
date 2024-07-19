import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { MessageService } from 'primeng/api';
import { AutoCompleteCompleteEvent } from 'primeng/autocomplete';
import { RopingDTO, AxiosRopingResourceClient, AxiosRopingDivisionResourceClient } from 'src/app/shared/java-objects';
import { UtilsService } from 'src/app/shared/utils.service';

@Component({
  selector: 'app-auto-complete-roping-division',
  templateUrl: './auto-complete-roping-division.component.html',
  styleUrls: ['./auto-complete-roping-division.component.scss']
})
export class AutoCompleteRopingDivisionComponent implements OnInit{


  @Input()
  input: RopingDTO={}

  @Output() 
  inputChange: EventEmitter<RopingDTO> = new EventEmitter<RopingDTO>();


  filtred: RopingDTO[]=[];

  constructor(
    private messageService      : MessageService,
    private translate           : TranslateService,
    private utilService         : UtilsService,
    private api                 : AxiosRopingDivisionResourceClient,
  ){
  }

  async ngOnInit(): Promise<void> {
    this.utilService.ngOnInit();
    try {
      await Promise.all([
        this.translate.get('Name').toPromise(),
      ]);
    } catch (error) {
      console.error("Error initializing component:", error);
    } finally {
    }
  }

  select($event: AutoCompleteCompleteEvent) {
    let query = $event.query;
    const filtered: any[] = [];
    
    this.api.paginationFull({
      name: {
        value: query,
        matchMode: 'contains'
      }
    }).then((response)=>{
      this.filtred = response.data.data!.content!
    }).finally(()=>{
      
    })
  }
  
  onChange() {
    this.inputChange.emit(this.input);
  }

}
