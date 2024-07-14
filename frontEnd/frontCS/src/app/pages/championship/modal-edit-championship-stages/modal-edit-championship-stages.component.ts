import { Component, OnInit } from '@angular/core';
import { DynamicDialogRef, DynamicDialogConfig } from 'primeng/dynamicdialog';
import { ChampionshipStageDTO } from 'src/app/shared/java-objects';
import { SpinnerDefaultService } from 'src/app/shared/spinner-default/spinner-default.service';

@Component({
  selector: 'app-modal-edit-championship-stages',
  templateUrl: './modal-edit-championship-stages.component.html',
  styleUrls: ['./modal-edit-championship-stages.component.scss']
})
export class ModalEditChampionshipStagesComponent implements OnInit {


  activeRegister : ChampionshipStageDTO = {}

  constructor(
    private spinner         : SpinnerDefaultService,
    private dialogRef       : DynamicDialogRef,
    private dialogConfig    : DynamicDialogConfig,
  ){
  }

  ngOnInit(): void {
    this.spinner.show()
  
    this.activeRegister       = this.dialogConfig?.data?.activeRegister || {} as ChampionshipStageDTO
    this.spinner.hide()
  }

  onClose() {
    this.dialogRef.close({ action: 'save', item: this.activeRegister })
  }
    
  onDelete() {
    this.dialogRef.close({ action: 'delete', item: this.activeRegister })
  }
}
