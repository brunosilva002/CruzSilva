import { Component, OnInit } from '@angular/core';
import { SpinnerDefaultService } from './spinner-default.service';

@Component({
  selector: 'app-spinner-default',
  templateUrl: './spinner-default.component.html',
  styleUrls: ['./spinner-default.component.scss']
})
export class SpinnerDefaultComponent implements OnInit {

  constructor(private spinnerService: SpinnerDefaultService) { 

  }

  ngOnInit(): void {
  }
}
