import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgxSpinnerModule } from 'ngx-spinner';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import  { BrowserAnimationsModule } from '@angular/platform-browser/animations';

//NGPrime
// Import PrimeNG modules
import { AccordionModule } from 'primeng/accordion';
import { AutoCompleteModule } from 'primeng/autocomplete';
import { AvatarModule } from 'primeng/avatar';
import { AvatarGroupModule } from 'primeng/avatargroup';
import { BadgeModule } from 'primeng/badge';
import { BreadcrumbModule } from 'primeng/breadcrumb';
import { ButtonModule } from 'primeng/button';
import { CalendarModule } from 'primeng/calendar';
import { CarouselModule } from 'primeng/carousel';
import { CascadeSelectModule } from 'primeng/cascadeselect';
import { ChartModule } from 'primeng/chart';
import { CheckboxModule } from 'primeng/checkbox';
import { ChipModule } from 'primeng/chip';
import { ChipsModule } from 'primeng/chips';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmPopupModule } from 'primeng/confirmpopup';
import { ColorPickerModule } from 'primeng/colorpicker';
import { ContextMenuModule } from 'primeng/contextmenu';
import { DataViewModule } from 'primeng/dataview';
import { VirtualScrollerModule } from 'primeng/virtualscroller';
import { DialogModule } from 'primeng/dialog';
import { DividerModule } from 'primeng/divider';
import { DockModule } from 'primeng/dock';
import { DragDropModule } from 'primeng/dragdrop';
import { DropdownModule } from 'primeng/dropdown';
import { DialogService, DynamicDialogConfig, DynamicDialogModule, DynamicDialogRef } from 'primeng/dynamicdialog';
import { EditorModule } from 'primeng/editor';
import { FieldsetModule } from 'primeng/fieldset';
import { FileUploadModule } from 'primeng/fileupload';
import { GalleriaModule } from 'primeng/galleria';
import { InplaceModule } from 'primeng/inplace';
import { InputMaskModule } from 'primeng/inputmask';
import { InputSwitchModule } from 'primeng/inputswitch';
import { InputTextModule } from 'primeng/inputtext';
import { InputNumberModule } from 'primeng/inputnumber';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { ImageModule } from 'primeng/image';
import { KnobModule } from 'primeng/knob';
import { ListboxModule } from 'primeng/listbox';
import { MegaMenuModule } from 'primeng/megamenu';
import { MenuModule } from 'primeng/menu';
import { MenubarModule } from 'primeng/menubar';
import { MessageModule } from 'primeng/message';
import { MessagesModule } from 'primeng/messages';
import { MultiSelectModule } from 'primeng/multiselect';
import { OrderListModule } from 'primeng/orderlist';
import { OrganizationChartModule } from 'primeng/organizationchart';
import { OverlayPanelModule } from 'primeng/overlaypanel';
import { PaginatorModule } from 'primeng/paginator';
import { PanelModule } from 'primeng/panel';
import { PanelMenuModule } from 'primeng/panelmenu';
import { PasswordModule } from 'primeng/password';
import { PickListModule } from 'primeng/picklist';
import { ProgressBarModule } from 'primeng/progressbar';
import { RadioButtonModule } from 'primeng/radiobutton';
import { RatingModule } from 'primeng/rating';
import { ScrollerModule } from 'primeng/scroller';
import { ScrollPanelModule } from 'primeng/scrollpanel';
import { ScrollTopModule } from 'primeng/scrolltop';
import { SelectButtonModule } from 'primeng/selectbutton';
import { SidebarModule } from 'primeng/sidebar';
import { SkeletonModule } from 'primeng/skeleton';
import { SlideMenuModule } from 'primeng/slidemenu';
import { SliderModule } from 'primeng/slider';
import { SpeedDialModule } from 'primeng/speeddial';
import { SpinnerModule } from 'primeng/spinner';
import { SplitButtonModule } from 'primeng/splitbutton';
import { SplitterModule } from 'primeng/splitter';
import { StepsModule } from 'primeng/steps';
import { TabMenuModule } from 'primeng/tabmenu';
import { TableModule } from 'primeng/table';
import { TabViewModule } from 'primeng/tabview';
import { TagModule } from 'primeng/tag';
import { TerminalModule } from 'primeng/terminal';
import { TieredMenuModule } from 'primeng/tieredmenu';
import { TimelineModule } from 'primeng/timeline';
import { ToastModule } from 'primeng/toast';
import { ToggleButtonModule } from 'primeng/togglebutton';
import { ToolbarModule } from 'primeng/toolbar';
import { TooltipModule } from 'primeng/tooltip';
import { TriStateCheckboxModule } from 'primeng/tristatecheckbox';
import { TreeModule } from 'primeng/tree';
import { TreeSelectModule } from 'primeng/treeselect';
import { TreeTableModule } from 'primeng/treetable';
import { AnimateModule } from 'primeng/animate';
import { CardModule } from 'primeng/card';
import { BlockUIModule } from 'primeng/blockui';
import { ProgressSpinnerModule } from 'primeng/progressspinner';

import { SpinnerDefaultService } from './shared/spinner-default/spinner-default.service';
import { SpinnerDefaultComponent } from './shared/spinner-default/spinner-default.component';
import { UtilsService } from './shared/utils.service';
import { AxiosAddressResourceClient, AxiosAnimalResourceClient, AxiosAuthenticationResourceClient, AxiosBarrelTypeResourceClient, AxiosChampionshipResourceClient, AxiosChampionshipStageResourceClient, AxiosCityResourceClient, AxiosCompetitorResourceClient, AxiosCountryResourceClient, AxiosDivisionResourceClient, AxiosEntryFormResourceClient, AxiosEstateResourceClient, AxiosGenderAnimalResourceClient, AxiosGenderResourceClient, AxiosJudgeResourceClient, AxiosPaymentResourceClient, AxiosPaymentTypeResourceClient, AxiosRewardKindResourceClient, AxiosRopingDivisionRankResourceClient, AxiosRopingDivisionResourceClient, AxiosRopingModalityResourceClient, AxiosRopingModalityTypeResourceClient, AxiosRopingPaymentTypeResourceClient, AxiosRopingProductResourceClient, AxiosRopingResourceClient, AxiosRopingStatusResourceClient, AxiosRopingTypeResourceClient, AxiosTrackResourceClient, AxiosTrackStatusResourceClient, AxiosTypeClassificationResourceClient, AxiosTypeClassificationTimeResourceClient } from './shared/java-objects';
import { ListEndPoints } from './shared/list-endpoints';
import { ConfirmationService, MessageService } from 'primeng/api';
import { LoginComponent } from './common/login/login.component';
import { EditHeaderDivComponent } from './shared/edit-header-div/edit-header-div.component';
import { MainMenuComponent } from './common/main-menu/main-menu.component';
import { MainPageComponent } from './common/main-page/main-page.component';
import { JudgeComponent } from './pages/judge/judge.component';
import { AnimalComponent } from './pages/animal/animal.component';
import { CompetitorComponent } from './pages/competitor/competitor.component';
import { RopingDivisionComponent } from './pages/roping-division/roping-division.component';
import { RopingComponent } from './pages/roping/roping.component';
import { RopingProductComponent } from './pages/roping-product/roping-product.component';
import { CalendarCustomComponent } from './common/calendar-custom/calendar-custom.component';
import { JudgeListComponent } from './pages/judge/judge-list/judge-list.component';
import { AnimalListComponent } from './pages/animal/animal-list/animal-list.component';
import { CompetitorListComponent } from './pages/competitor/competitor-list/competitor-list.component';
import { RopingDivisionListComponent } from './pages/roping-division/roping-division-list/roping-division-list.component';
import { RopingListComponent } from './pages/roping/roping-list/roping-list.component';
import { RopingProductListComponent } from './pages/roping-product/roping-product-list/roping-product-list.component';
import { AddressComponent } from './common/address/address.component';
import { DateFormatPipe } from './common/pipess/date-format.pipe';
import { ModalEditRopingDivisionRankComponent } from './pages/roping-division/modal-edit-roping-division-rank/modal-edit-roping-division-rank.component';
import { FormataNumeroInteiroPipe } from './common/pipess/formata-numero-inteiro.pipe';
import { FormataNumeroDecimalPipe } from './common/pipess/formata-numero-decimal.pipe';
import { FormataNumeroMoedaPipe } from './common/pipess/formata-numero-moeda.pipe';
import { EntryFormComponent } from './pages/entry-form/entry-form.component';
import { EntryFormListComponent } from './pages/entry-form/entry-form-list/entry-form-list.component';
import { ChampionshipComponent } from './pages/championship/championship.component';
import { ChampionshipListComponent } from './pages/championship/championship-list/championship-list.component';
import { TrackComponent } from './pages/track/track.component';
import { TrackListComponent } from './pages/track/track-list/track-list.component';
import { ModalEditChampionshipStagesComponent } from './pages/championship/modal-edit-championship-stages/modal-edit-championship-stages.component';
import { AutoCompleteRopingStatusComponent } from './common/autoComplete/auto-complete-roping-status/auto-complete-roping-status.component';
import { AutoCompleteGenderComponent } from './common/autoComplete/auto-complete-gender/auto-complete-gender.component';
import { AutoCompleteDivisionComponent } from './common/autoComplete/auto-complete-division/auto-complete-division.component';
import { AutoCompleteRopingComponent } from './common/autoComplete/auto-complete-roping/auto-complete-roping.component';
import { AutoCompleteRewardKindComponent } from './common/autoComplete/auto-complete-reward-kind/auto-complete-reward-kind.component';
import { AutoCompleteBarrelTypeComponent } from './common/autoComplete/auto-complete-barrel-type/auto-complete-barrel-type.component';
import { AutoCompleteTypeClassificationComponent } from './common/autoComplete/auto-complete-type-classification/auto-complete-type-classification.component';
import { AutoCompleteTypeClassificationTimeComponent } from './common/autoComplete/auto-complete-type-classification-time/auto-complete-type-classification-time.component';
import { AutoCompleteGenderAnimalComponent } from './common/autoComplete/auto-complete-gender-animal/auto-complete-gender-animal.component';
import { AutoCompleteRopingDivisionComponent } from './common/autoComplete/auto-complete-roping-division/auto-complete-roping-division.component';
import { AutoCompleteRopingTypeComponent } from './common/autoComplete/auto-complete-roping-type/auto-complete-roping-type.component';
import { AutoCompleteAnimalComponent } from './common/autoComplete/auto-complete-animal/auto-complete-animal.component';
import { ModalEditPaymentComponent } from './pages/entry-form/modal-edit-payment/modal-edit-payment.component';
import { EventComponent } from './pages/event/event.component';
import { EventListComponent } from './pages/event/event-list/event-list.component';


export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}



@NgModule({
  declarations: [
    AppComponent,
    SpinnerDefaultComponent,
    LoginComponent,
    EditHeaderDivComponent,
    MainMenuComponent,
    MainPageComponent,
    JudgeComponent,
    AnimalComponent,
    CompetitorComponent,
    RopingDivisionComponent,
    RopingComponent,
    RopingProductComponent,
    CalendarCustomComponent,
    JudgeListComponent,
    AnimalListComponent,
    CompetitorListComponent,
    RopingDivisionListComponent,
    RopingListComponent,
    RopingProductListComponent,
    AddressComponent,
    DateFormatPipe,
    ModalEditRopingDivisionRankComponent,
    FormataNumeroInteiroPipe,
    FormataNumeroDecimalPipe,
    FormataNumeroMoedaPipe,
    EntryFormComponent,
    EntryFormListComponent,
    ChampionshipComponent,
    ChampionshipListComponent,
    TrackComponent,
    TrackListComponent,
    ModalEditChampionshipStagesComponent,
    AutoCompleteRopingStatusComponent,
    AutoCompleteGenderComponent,
    AutoCompleteDivisionComponent,
    AutoCompleteRopingComponent,
    AutoCompleteRewardKindComponent,
    AutoCompleteBarrelTypeComponent,
    AutoCompleteTypeClassificationComponent,
    AutoCompleteTypeClassificationTimeComponent,
    AutoCompleteGenderAnimalComponent,
    AutoCompleteRopingDivisionComponent,
    AutoCompleteRopingTypeComponent,
    AutoCompleteAnimalComponent,
    ModalEditPaymentComponent,
    EventComponent,
    EventListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxSpinnerModule,
    
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    SidebarModule,
    ButtonModule,
    MenuModule,
    MessageModule,
    MessagesModule,
    MegaMenuModule,
    PanelMenuModule,
    TableModule,
    ToastModule,
    SplitterModule,
    ScrollPanelModule,
    CardModule,
    TabMenuModule,
    SpinnerModule,
    InputTextModule,
    AvatarModule,
    AvatarGroupModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    AccordionModule,
    AutoCompleteModule,
    BadgeModule,
    BreadcrumbModule,
    BlockUIModule,
    ButtonModule,
    CalendarModule,
    CarouselModule,
    CascadeSelectModule,
    ChartModule,
    CheckboxModule,
    ChipsModule,
    ChipModule,
    ColorPickerModule,
    ConfirmDialogModule,
    ConfirmPopupModule,
    ContextMenuModule,
    VirtualScrollerModule,
    DataViewModule,
    DialogModule,
    DividerModule,
    DockModule,
    DragDropModule,
    DropdownModule,
    DynamicDialogModule,
    EditorModule,
    FieldsetModule,
    FileUploadModule,
    GalleriaModule,
    InplaceModule,
    InputMaskModule,
    InputSwitchModule,
    InputTextModule,
    InputTextareaModule,
    InputNumberModule,
    ImageModule,
    KnobModule,
    ListboxModule,
    MegaMenuModule,
    MenuModule,
    MenubarModule,
    MessageModule,
    MessagesModule,
    MultiSelectModule,
    OrganizationChartModule,
    OrderListModule,
    OverlayPanelModule,
    PaginatorModule,
    PanelModule,
    PanelMenuModule,
    PasswordModule,
    PickListModule,
    ProgressSpinnerModule,
    ProgressBarModule,
    RadioButtonModule,
    RatingModule,
    SelectButtonModule,
    SidebarModule,
    ScrollerModule,
    ScrollPanelModule,
    ScrollTopModule,
    SkeletonModule,
    SlideMenuModule,
    SliderModule,
    SpeedDialModule,
    SplitterModule,
    SplitButtonModule,
    StepsModule,
    TableModule,
    TabMenuModule,
    TabViewModule,
    TagModule,
    TerminalModule,
    TieredMenuModule,
    TimelineModule,
    ToastModule,
    ToggleButtonModule,
    ToolbarModule,
    TooltipModule,
    TriStateCheckboxModule,
    TreeModule,
    TreeSelectModule,
    TreeTableModule,
    AnimateModule,
    CardModule,
    

    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    })
  ],
  providers: [
    
    {provide: AxiosAddressResourceClient                , useValue: ListEndPoints.addressResourceClient()},
    {provide: AxiosAnimalResourceClient                 , useValue: ListEndPoints.animalResourceClient()},
    {provide: AxiosAuthenticationResourceClient         , useValue: ListEndPoints.authenticResourceClient()},
    {provide: AxiosBarrelTypeResourceClient             , useValue: ListEndPoints.barrelTypeResourceClient()},
    {provide: AxiosCityResourceClient                   , useValue: ListEndPoints.cityResourceClient()},
    {provide: AxiosCompetitorResourceClient             , useValue: ListEndPoints.competitorResourceClient()},
    {provide: AxiosCountryResourceClient                , useValue: ListEndPoints.countryResourceClient()},
    {provide: AxiosDivisionResourceClient               , useValue: ListEndPoints.divisionResourceClient()},
    {provide: AxiosEstateResourceClient                 , useValue: ListEndPoints.estateResourceClient()},
    {provide: AxiosGenderAnimalResourceClient           , useValue: ListEndPoints.genderAnimalResourceClient()},
    {provide: AxiosGenderResourceClient                 , useValue: ListEndPoints.genderResourceClient()},
    {provide: AxiosJudgeResourceClient                  , useValue: ListEndPoints.judgeResourceClient()},
    {provide: AxiosRewardKindResourceClient             , useValue: ListEndPoints.rewardKindResourceClient()},
    {provide: AxiosRopingDivisionRankResourceClient     , useValue: ListEndPoints.ropingDivisionResourceClient()},
    {provide: AxiosRopingDivisionResourceClient         , useValue: ListEndPoints.ropingDivisionResourceClient()},
    {provide: AxiosRopingProductResourceClient          , useValue: ListEndPoints.ropingProductResourceClient()},
    {provide: AxiosRopingResourceClient                 , useValue: ListEndPoints.ropingResourceClient()},
    {provide: AxiosTypeClassificationResourceClient     , useValue: ListEndPoints.typeClassificationResourceClient()},
    {provide: AxiosTypeClassificationTimeResourceClient , useValue: ListEndPoints.typeClassificationTimeResourceClient()},
    {provide: AxiosChampionshipResourceClient           , useValue: ListEndPoints.championshipResourceClient()},
    {provide: AxiosChampionshipStageResourceClient      , useValue: ListEndPoints.championshipStageResourceClient()},
    {provide: AxiosEntryFormResourceClient              , useValue: ListEndPoints.entryFormResourceClient()},
    {provide: AxiosPaymentResourceClient                , useValue: ListEndPoints.paymentResourceClient()},
    {provide: AxiosPaymentTypeResourceClient            , useValue: ListEndPoints.paymentTypeResourceClient()},
    {provide: AxiosRopingModalityResourceClient         , useValue: ListEndPoints.ropingModalityResourceClient()},
    {provide: AxiosRopingModalityTypeResourceClient     , useValue: ListEndPoints.ropingModalityTypeResourceClient()},
    {provide: AxiosRopingPaymentTypeResourceClient      , useValue: ListEndPoints.ropingPaymentTypeResourceClient()},
    {provide: AxiosRopingStatusResourceClient           , useValue: ListEndPoints.ropingStatusResourceClient()},
    {provide: AxiosRopingTypeResourceClient             , useValue: ListEndPoints.ropingTypeResourceClient()},
    {provide: AxiosTrackResourceClient                  , useValue: ListEndPoints.trackResourceClient()},
    {provide: AxiosTrackStatusResourceClient            , useValue: ListEndPoints.tackStatusResourceClient()},


    ConfirmationService,

    SpinnerDefaultService,
    UtilsService,
    MessageService,
    DialogService,
    DynamicDialogConfig,
    DynamicDialogRef,

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

export function httTranslateLoader (http: HttpClient){
  return new TranslateHttpLoader (http);
}