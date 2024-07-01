import { Component, Input, OnInit } from '@angular/core';
import { AutoCompleteCompleteEvent } from 'primeng/autocomplete';
import { DynamicDialogRef, DynamicDialogConfig } from 'primeng/dynamicdialog';
import { RopingDivisionRankDTO } from 'src/app/shared/java-objects';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';

@Component({
  selector: 'app-modal-edit-roping-division-rank',
  templateUrl: './modal-edit-roping-division-rank.component.html',
  styleUrls: ['./modal-edit-roping-division-rank.component.scss']
})
export class ModalEditRopingDivisionRankComponent implements OnInit {


  activeRegister : RopingDivisionRankDTO = {}
  isDisabledValueRate: boolean=false;
  isDisabledValuePrice: boolean=false;

  constructor(
    private spinner         : SpinnerDefaultService,
    private dialogRef       : DynamicDialogRef,
    private dialogConfig    : DynamicDialogConfig,
  ){
  }

  ngOnInit(): void {
    this.spinner.show()
  
    this.activeRegister       = this.dialogConfig?.data?.activeRegister || {} as RopingDivisionRankDTO
    this.isDisabledValueRate  = this.dialogConfig?.data?.isDisabledValueRate
    this.isDisabledValuePrice = this.dialogConfig?.data?.isDisabledValuePrice
    this.spinner.hide()
  }

  onClose() {
    this.dialogRef.close({ action: 'save', item: this.activeRegister })
  }
    
  onDelete() {
    this.dialogRef.close({ action: 'delete', item: this.activeRegister })
  }
}
