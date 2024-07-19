import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-main-menu',
  templateUrl: './main-menu.component.html',
  styleUrls: ['./main-menu.component.scss']
})
export class MainMenuComponent implements OnInit{


  sidebarVisible1: boolean = false;
  items: MenuItem[] | undefined;

  constructor(private translate: TranslateService) {
   
  }


  async ngOnInit(): Promise<void> {
    await this.translate.get('Name').toPromise().then()
      this.items = [
        {
          label:this.translate.instant("Initial.singular",{count:2}) ,
          icon: 'pi pi-fw pi-file',
          routerLink:"/mainPage",
          command: this.onClickMenu.bind(this) 
        },
        {
          label: this.translate.instant('MasterData.plural'),
          icon: 'pi pi-fw pi-file',
          items: [
              {
                  label: this.translate.instant('Championship.plural'),
                  icon: 'pi pi-building',
                  routerLink:"/championship-list",
                  command: this.onClickMenu.bind(this) 
              },
              {
                label: this.translate.instant('Track.plural'),
                icon: 'pi pi-building',
                routerLink:"/track-list",
                command: this.onClickMenu.bind(this)
              },
          ]
        },
        {
          label: this.translate.instant('CommonData.plural'),
          icon: 'pi pi-fw pi-file',
          items: [
              {
                  label: this.translate.instant('Judge.plural'),
                  icon: 'pi pi-building',
                  routerLink:"/judge-list",
                  command: this.onClickMenu.bind(this) 
              },
              {
                label: this.translate.instant('Animal.plural'),
                icon: 'pi pi-building',
                routerLink:"/animal-list",
                command: this.onClickMenu.bind(this)
              },
              {
                label: this.translate.instant('Competitor.plural'),
                icon: 'pi pi-building',
                routerLink:"/competitor-list",
                command: this.onClickMenu.bind(this)
              },
          ]
        },
        {
          label: this.translate.instant('Roping.plural'),
          icon: 'pi pi-fw pi-file',
          items: [
                {
                  label: this.translate.instant('Roping.plural'),
                  icon: 'pi pi-building',
                  routerLink:"/roping-list",
                  command:this.onClickMenu.bind(this),
              },
              {
                  label: this.translate.instant('Division.plural'),
                  icon: 'pi pi-building',
                  routerLink:"/roping-division-list",
                  command:this.onClickMenu.bind(this),
              },
              {
                label: this.translate.instant('Product.plural'),
                icon: 'pi pi-building',
                routerLink:"/roping-product-list",
                command:this.onClickMenu.bind(this),
            },
            {
              label: this.translate.instant('RegistrationForm.plural'),
              icon: 'pi pi-building',
              routerLink:"/entry-form-list",
              command:this.onClickMenu.bind(this),
            },
            {
              label: this.translate.instant('Registration.plural'),
              icon: 'pi pi-building',
              routerLink:"/salesQuoteList",
              command:this.onClickMenu.bind(this),
          },
          {
            label:this.translate.instant('Panel.singular'),
            icon: 'pi pi-fw pi-sign-out',
            routerLink:"/login",
            command: this.onClickMenu.bind(this) 
          },
          {
            label:this.translate.instant('Confirmation.singular'),
            icon: 'pi pi-fw pi-sign-out',
            routerLink:"/login",
            command: this.onClickMenu.bind(this) 
          },
          ]
        }, 
        {
          label:this.translate.instant('Run.singular'),
          icon: 'pi pi-fw pi-sign-out',
          routerLink:"/testeLayout",
          command: this.onClickMenu.bind(this) 
        }, 
        {
          label:this.translate.instant('Report.singular'),
          icon: 'pi pi-fw pi-sign-out',
          routerLink:"/testeLayout",
          command: this.onClickMenu.bind(this) 
        }, 
        {
          label:'teste Layout',
          icon: 'pi pi-fw pi-sign-out',
          routerLink:"/testeLayout",
          command: this.onClickMenu.bind(this) 
        }, 
    ];

  }

  onClickMenu(event:any): void | undefined{
    this.sidebarVisible1=false
    return event
  }

  translationMsg(key: string) {
    this.translate.get(key).subscribe((data) => {
      return data;
    });
  }

}
