/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 2.32.889 on 2024-07-22 22:06:45.

export class AddressDTO implements Serializable {
    cdnAddress?: number;
    street?: string;
    number?: string;
    postalCode?: string;
    phone?: string;
    estate?: EstateDTO;
    city?: CityDTO;
    country?: CountryDTO;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: AddressDTO) {
        this.cdnAddress = data.cdnAddress;
        this.street = data.street;
        this.number = data.number;
        this.postalCode = data.postalCode;
        this.phone = data.phone;
        this.estate = data.estate;
        this.city = data.city;
        this.country = data.country;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class AnimalDTO implements Serializable {
    cdnAnimal?: number;
    name?: string;
    register?: string;
    birthday?: Date;
    genderAnimal?: GenderAnimalDTO;
    animalBreed?: string;
    owner?: string;
    ownerCpf?: string;
    address?: AddressDTO;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: AnimalDTO) {
        this.cdnAnimal = data.cdnAnimal;
        this.name = data.name;
        this.register = data.register;
        this.birthday = data.birthday;
        this.genderAnimal = data.genderAnimal;
        this.animalBreed = data.animalBreed;
        this.owner = data.owner;
        this.ownerCpf = data.ownerCpf;
        this.address = data.address;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class AuthenticationRequestDTO {
    email?: string;
    password?: string;

    constructor(data: AuthenticationRequestDTO) {
        this.email = data.email;
        this.password = data.password;
    }
}

export class AuthenticationRequestDTOBuilder {

    constructor(data: AuthenticationRequestDTOBuilder) {
    }
}

export class AuthenticatoinResponseDTO {
    token?: string;
    timeOut?: Date;
    timeAt?: Date;
    cdnUser?: number;

    constructor(data: AuthenticatoinResponseDTO) {
        this.token = data.token;
        this.timeOut = data.timeOut;
        this.timeAt = data.timeAt;
        this.cdnUser = data.cdnUser;
    }
}

export class AuthenticatoinResponseDTOBuilder {

    constructor(data: AuthenticatoinResponseDTOBuilder) {
    }
}

export class BarrelTypeDTO implements Serializable {
    cdnBarrelType?: number;
    name?: string;

    constructor(data: BarrelTypeDTO) {
        this.cdnBarrelType = data.cdnBarrelType;
        this.name = data.name;
    }
}

export class ChampionshipDTO implements Serializable {
    cdnChampionship?: number;
    name?: string;
    championshipStages?: ChampionshipStageDTO[];

    constructor(data: ChampionshipDTO) {
        this.cdnChampionship = data.cdnChampionship;
        this.name = data.name;
        this.championshipStages = data.championshipStages;
    }
}

export class ChampionshipStageDTO implements Serializable {
    cdnChampionshipStage?: number;
    name?: string;
    numberStage?: number;
    startDate?: Date;
    endDate?: Date;
    championship?: ChampionshipDTO;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: ChampionshipStageDTO) {
        this.cdnChampionshipStage = data.cdnChampionshipStage;
        this.name = data.name;
        this.numberStage = data.numberStage;
        this.startDate = data.startDate;
        this.endDate = data.endDate;
        this.championship = data.championship;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class CityDTO implements Serializable {
    cdnCity?: number;
    name?: string;
    code?: string;
    estate?: EstateDTO;
    dateCreated?: Date;
    dateUpdated?: Date;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: CityDTO) {
        this.cdnCity = data.cdnCity;
        this.name = data.name;
        this.code = data.code;
        this.estate = data.estate;
        this.dateCreated = data.dateCreated;
        this.dateUpdated = data.dateUpdated;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class CompetitorDTO implements Serializable {
    cdnCompetitor?: number;
    name?: string;
    nickName?: string;
    gender?: GenderDTO;
    cpf?: string;
    handcapHeader?: string;
    handcapHeeler?: string;
    email?: string;
    address?: AddressDTO;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: CompetitorDTO) {
        this.cdnCompetitor = data.cdnCompetitor;
        this.name = data.name;
        this.nickName = data.nickName;
        this.gender = data.gender;
        this.cpf = data.cpf;
        this.handcapHeader = data.handcapHeader;
        this.handcapHeeler = data.handcapHeeler;
        this.email = data.email;
        this.address = data.address;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class CountryDTO implements Serializable {
    cdnCountry?: number;
    code?: string;
    codIso3?: string;
    numIso?: string;
    bacenCod?: string;
    name?: string;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: CountryDTO) {
        this.cdnCountry = data.cdnCountry;
        this.code = data.code;
        this.codIso3 = data.codIso3;
        this.numIso = data.numIso;
        this.bacenCod = data.bacenCod;
        this.name = data.name;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class CustomerDTO implements Serializable {
    cdnCustomer?: number;
    cdnX3Customer?: string;
    status?: boolean;
    razaoSocial?: string;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: CustomerDTO) {
        this.cdnCustomer = data.cdnCustomer;
        this.cdnX3Customer = data.cdnX3Customer;
        this.status = data.status;
        this.razaoSocial = data.razaoSocial;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class DivisionDTO implements Serializable {
    cdnDivision?: number;
    name?: string;
    gender?: string;
    proAmCabeca?: boolean;
    proAmPe?: boolean;
    incentive?: boolean;
    testHorse?: boolean;
    considerRanking?: boolean;

    constructor(data: DivisionDTO) {
        this.cdnDivision = data.cdnDivision;
        this.name = data.name;
        this.gender = data.gender;
        this.proAmCabeca = data.proAmCabeca;
        this.proAmPe = data.proAmPe;
        this.incentive = data.incentive;
        this.testHorse = data.testHorse;
        this.considerRanking = data.considerRanking;
    }
}

export class EntryFormDTO implements Serializable {
    cdnEntryForm?: number;
    note?: string;
    roping?: Roping;
    ropingDivision?: RopingDivisionDTO;
    ropingType?: RopingTypeDTO;
    competitor?: CompetitorDTO;
    animal?: AnimalDTO;
    payments?: PaymentDTO[];
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: EntryFormDTO) {
        this.cdnEntryForm = data.cdnEntryForm;
        this.note = data.note;
        this.roping = data.roping;
        this.ropingDivision = data.ropingDivision;
        this.ropingType = data.ropingType;
        this.competitor = data.competitor;
        this.animal = data.animal;
        this.payments = data.payments;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class EstateDTO implements Serializable {
    cdnEstate?: number;
    code?: string;
    name?: string;
    country?: CountryDTO;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: EstateDTO) {
        this.cdnEstate = data.cdnEstate;
        this.code = data.code;
        this.name = data.name;
        this.country = data.country;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class EventDTO implements Serializable {
    cdnEvent?: number;
    nome?: string;
    eventTests?: EventTestDTO[];
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: EventDTO) {
        this.cdnEvent = data.cdnEvent;
        this.nome = data.nome;
        this.eventTests = data.eventTests;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class EventTestDTO implements Serializable {
    cdnEventTest?: number;
    cdnTestNumber?: number;
    nome?: string;
    event?: EventDTO;

    constructor(data: EventTestDTO) {
        this.cdnEventTest = data.cdnEventTest;
        this.cdnTestNumber = data.cdnTestNumber;
        this.nome = data.nome;
        this.event = data.event;
    }
}

export class GenderAnimalDTO implements Serializable {
    cdnGenderAnimal?: number;
    name?: string;

    constructor(data: GenderAnimalDTO) {
        this.cdnGenderAnimal = data.cdnGenderAnimal;
        this.name = data.name;
    }
}

export class GenderDTO implements Serializable {
    cdnGender?: number;
    name?: string;

    constructor(data: GenderDTO) {
        this.cdnGender = data.cdnGender;
        this.name = data.name;
    }
}

export class JudgeDTO implements Serializable {
    cdnJudge?: number;
    name?: string;
    nickName?: string;
    cpf?: string;
    gender?: GenderDTO;
    address?: Address;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: JudgeDTO) {
        this.cdnJudge = data.cdnJudge;
        this.name = data.name;
        this.nickName = data.nickName;
        this.cpf = data.cpf;
        this.gender = data.gender;
        this.address = data.address;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class PaymentDTO implements Serializable {
    cdnPayment?: number;
    paymentDate?: Date;
    paymentValue?: number;
    numPayment?: number;
    paymentType?: PaymentTypeDTO;
    entryForm?: EntryFormDTO;

    constructor(data: PaymentDTO) {
        this.cdnPayment = data.cdnPayment;
        this.paymentDate = data.paymentDate;
        this.paymentValue = data.paymentValue;
        this.numPayment = data.numPayment;
        this.paymentType = data.paymentType;
        this.entryForm = data.entryForm;
    }
}

export class PaymentTypeDTO implements Serializable {
    cdnPaymentType?: number;
    name?: string;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: PaymentTypeDTO) {
        this.cdnPaymentType = data.cdnPaymentType;
        this.name = data.name;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class PessoaDTO implements Serializable {
    cdnPessoa?: number;
    name?: string;
    code?: string;
    estate?: EstateDTO;
    dateCreated?: Date;
    dateUpdated?: Date;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: PessoaDTO) {
        this.cdnPessoa = data.cdnPessoa;
        this.name = data.name;
        this.code = data.code;
        this.estate = data.estate;
        this.dateCreated = data.dateCreated;
        this.dateUpdated = data.dateUpdated;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class RegisterRequestDTO {
    firstName?: string;
    lastName?: string;
    email?: string;
    password?: string;
    dateCreated?: Date;
    dateUpdated?: Date;
    userCreate?: UserDTO;
    userUpdate?: UserDTO;

    constructor(data: RegisterRequestDTO) {
        this.firstName = data.firstName;
        this.lastName = data.lastName;
        this.email = data.email;
        this.password = data.password;
        this.dateCreated = data.dateCreated;
        this.dateUpdated = data.dateUpdated;
        this.userCreate = data.userCreate;
        this.userUpdate = data.userUpdate;
    }
}

export class RegisterRequestDTOBuilder {

    constructor(data: RegisterRequestDTOBuilder) {
    }
}

export class ResponseDTO<T> {
    code?: number;
    status?: Status;
    messagens?: string[];
    data?: T;

    constructor(data: ResponseDTO<T>) {
        this.code = data.code;
        this.status = data.status;
        this.messagens = data.messagens;
        this.data = data.data;
    }
}

export class RewardKindDTO implements Serializable {
    cdnRewardKind?: number;
    name?: string;

    constructor(data: RewardKindDTO) {
        this.cdnRewardKind = data.cdnRewardKind;
        this.name = data.name;
    }
}

export class RopingDTO implements Serializable {
    cdnRoping?: number;
    name?: string;
    startDate?: Date;
    endDate?: Date;
    showInscription?: boolean;
    url?: string;
    address?: AddressDTO;
    ropingStatus?: RopingStatusDTO;
    ropingModality?: RopingModalityDTO;
    track?: TrackDTO;
    ropingPaymentTypes?: RopingPaymentTypeDTO[];
    championshipStage?: ChampionshipStageDTO;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: RopingDTO) {
        this.cdnRoping = data.cdnRoping;
        this.name = data.name;
        this.startDate = data.startDate;
        this.endDate = data.endDate;
        this.showInscription = data.showInscription;
        this.url = data.url;
        this.address = data.address;
        this.ropingStatus = data.ropingStatus;
        this.ropingModality = data.ropingModality;
        this.track = data.track;
        this.ropingPaymentTypes = data.ropingPaymentTypes;
        this.championshipStage = data.championshipStage;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class RopingDivisionDTO implements Serializable {
    cdnRopingDivision?: number;
    division?: DivisionDTO;
    rewardKind?: RewardKindDTO;
    valueRate?: number;
    valuePrice?: number;
    displayOrder?: number;
    isOfficialDivision?: boolean;
    isForUnion?: boolean;
    isShowEntries?: boolean;
    isSendNotification?: boolean;
    maxDateWeb?: Date;
    maxDateApp?: Date;
    paceValue1?: number;
    paceValue2?: number;
    paceValue3?: number;
    paceValue4?: number;
    barrelType?: BarrelTypeDTO;
    typeClassification?: TypeClassificationDTO;
    typeClassificationTime?: TypeClassificationTimeDTO;
    minAge?: number;
    maxAge?: number;
    isGeneratePaceNextClassification?: boolean;
    isRodeo?: boolean;
    isAllowChangeAnimalFinal?: boolean;
    isFinalRodeoDraw?: boolean;
    roping?: RopingDTO;
    ropingDivisionRanks?: RopingDivisionRankDTO[];
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: RopingDivisionDTO) {
        this.cdnRopingDivision = data.cdnRopingDivision;
        this.division = data.division;
        this.rewardKind = data.rewardKind;
        this.valueRate = data.valueRate;
        this.valuePrice = data.valuePrice;
        this.displayOrder = data.displayOrder;
        this.isOfficialDivision = data.isOfficialDivision;
        this.isForUnion = data.isForUnion;
        this.isShowEntries = data.isShowEntries;
        this.isSendNotification = data.isSendNotification;
        this.maxDateWeb = data.maxDateWeb;
        this.maxDateApp = data.maxDateApp;
        this.paceValue1 = data.paceValue1;
        this.paceValue2 = data.paceValue2;
        this.paceValue3 = data.paceValue3;
        this.paceValue4 = data.paceValue4;
        this.barrelType = data.barrelType;
        this.typeClassification = data.typeClassification;
        this.typeClassificationTime = data.typeClassificationTime;
        this.minAge = data.minAge;
        this.maxAge = data.maxAge;
        this.isGeneratePaceNextClassification = data.isGeneratePaceNextClassification;
        this.isRodeo = data.isRodeo;
        this.isAllowChangeAnimalFinal = data.isAllowChangeAnimalFinal;
        this.isFinalRodeoDraw = data.isFinalRodeoDraw;
        this.roping = data.roping;
        this.ropingDivisionRanks = data.ropingDivisionRanks;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class RopingDivisionRankDTO implements Serializable {
    cdnRopingDivisionRank?: number;
    rankNumber?: number;
    valueRatePrice?: number;
    valueRewardPrice?: number;
    point?: number;
    name?: string;
    ropingDivision?: RopingDivisionDTO;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: RopingDivisionRankDTO) {
        this.cdnRopingDivisionRank = data.cdnRopingDivisionRank;
        this.rankNumber = data.rankNumber;
        this.valueRatePrice = data.valueRatePrice;
        this.valueRewardPrice = data.valueRewardPrice;
        this.point = data.point;
        this.name = data.name;
        this.ropingDivision = data.ropingDivision;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class RopingModalityDTO implements Serializable {
    cdnRopingModality?: number;
    name?: string;
    ropingModalityType?: RopingModalityTypeDTO;

    constructor(data: RopingModalityDTO) {
        this.cdnRopingModality = data.cdnRopingModality;
        this.name = data.name;
        this.ropingModalityType = data.ropingModalityType;
    }
}

export class RopingModalityTypeDTO implements Serializable {
    cdnRopingModalityType?: number;
    name?: string;

    constructor(data: RopingModalityTypeDTO) {
        this.cdnRopingModalityType = data.cdnRopingModalityType;
        this.name = data.name;
    }
}

export class RopingPaymentTypeDTO implements Serializable {
    cdnRopingPaymentType?: number;
    roping?: RopingDTO;
    paymentType?: PaymentTypeDTO;

    constructor(data: RopingPaymentTypeDTO) {
        this.cdnRopingPaymentType = data.cdnRopingPaymentType;
        this.roping = data.roping;
        this.paymentType = data.paymentType;
    }
}

export class RopingProductDTO implements Serializable {
    cdnRopingDivisionProduct?: number;
    name?: string;
    stockQty?: number;
    stockQtyAvailable?: number;
    stockCost?: number;
    salesReleasedUntil?: Date;
    roping?: RopingDTO;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: RopingProductDTO) {
        this.cdnRopingDivisionProduct = data.cdnRopingDivisionProduct;
        this.name = data.name;
        this.stockQty = data.stockQty;
        this.stockQtyAvailable = data.stockQtyAvailable;
        this.stockCost = data.stockCost;
        this.salesReleasedUntil = data.salesReleasedUntil;
        this.roping = data.roping;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class RopingStatusDTO implements Serializable {
    cdnRopingStatus?: number;
    name?: string;

    constructor(data: RopingStatusDTO) {
        this.cdnRopingStatus = data.cdnRopingStatus;
        this.name = data.name;
    }
}

export class RopingTypeDTO implements Serializable {
    cdnRopingType?: number;
    name?: string;

    constructor(data: RopingTypeDTO) {
        this.cdnRopingType = data.cdnRopingType;
        this.name = data.name;
    }
}

export class TrackDTO implements Serializable {
    cdnRoping?: number;
    name?: string;
    startDate?: Date;
    endDate?: Date;
    address?: AddressDTO;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;
    showInscription?: boolean;
    url?: string;
    ropingStatus?: RopingStatusDTO;
    ropingModality?: RopingModalityDTO;
    paymentTypes?: PaymentTypeDTO[];

    constructor(data: TrackDTO) {
        this.cdnRoping = data.cdnRoping;
        this.name = data.name;
        this.startDate = data.startDate;
        this.endDate = data.endDate;
        this.address = data.address;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
        this.showInscription = data.showInscription;
        this.url = data.url;
        this.ropingStatus = data.ropingStatus;
        this.ropingModality = data.ropingModality;
        this.paymentTypes = data.paymentTypes;
    }
}

export class TrackStatusDTO implements Serializable {
    cdnTrackStatus?: number;
    name?: string;

    constructor(data: TrackStatusDTO) {
        this.cdnTrackStatus = data.cdnTrackStatus;
        this.name = data.name;
    }
}

export class TypeClassificationDTO implements Serializable {
    cdnTypeClassification?: number;
    name?: string;

    constructor(data: TypeClassificationDTO) {
        this.cdnTypeClassification = data.cdnTypeClassification;
        this.name = data.name;
    }
}

export class TypeClassificationTimeDTO implements Serializable {
    cdnTypeClassificationTime?: number;
    name?: string;

    constructor(data: TypeClassificationTimeDTO) {
        this.cdnTypeClassificationTime = data.cdnTypeClassificationTime;
        this.name = data.name;
    }
}

export class UserDTO implements Serializable {
    cdnUser?: number;
    email?: string;
    password?: string;
    name?: string;
    lastName?: string;
    creationUser?: string;
    updateUser?: string;

    constructor(data: UserDTO) {
        this.cdnUser = data.cdnUser;
        this.email = data.email;
        this.password = data.password;
        this.name = data.name;
        this.lastName = data.lastName;
        this.creationUser = data.creationUser;
        this.updateUser = data.updateUser;
    }
}

export class BaseResource {

    constructor(data: BaseResource) {
    }
}

export interface Serializable {
}

export class Roping implements Serializable {
    cdnRoping?: number;
    name?: string;
    startDate?: Date;
    endDate?: Date;
    showInscription?: boolean;
    url?: string;
    address?: Address;
    ropingStatus?: RopingStatus;
    ropingModality?: RopingModality;
    track?: Track;
    championshipStage?: ChampionshipStage;
    ropingPaymentTypes?: RopingPaymentType[];
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: Roping) {
        this.cdnRoping = data.cdnRoping;
        this.name = data.name;
        this.startDate = data.startDate;
        this.endDate = data.endDate;
        this.showInscription = data.showInscription;
        this.url = data.url;
        this.address = data.address;
        this.ropingStatus = data.ropingStatus;
        this.ropingModality = data.ropingModality;
        this.track = data.track;
        this.championshipStage = data.championshipStage;
        this.ropingPaymentTypes = data.ropingPaymentTypes;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class Address implements Serializable {
    cdnAddress?: number;
    street?: string;
    number?: string;
    postalCode?: string;
    phone?: string;
    estate?: Estate;
    city?: City;
    country?: Country;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: Address) {
        this.cdnAddress = data.cdnAddress;
        this.street = data.street;
        this.number = data.number;
        this.postalCode = data.postalCode;
        this.phone = data.phone;
        this.estate = data.estate;
        this.city = data.city;
        this.country = data.country;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class RopingStatus implements Serializable {
    cdnRopingStatus?: number;
    name?: string;

    constructor(data: RopingStatus) {
        this.cdnRopingStatus = data.cdnRopingStatus;
        this.name = data.name;
    }
}

export class RopingModality implements Serializable {
    cdnRopingModality?: number;
    name?: string;
    ropingModalityType?: RopingModalityType;

    constructor(data: RopingModality) {
        this.cdnRopingModality = data.cdnRopingModality;
        this.name = data.name;
        this.ropingModalityType = data.ropingModalityType;
    }
}

export class Track implements Serializable {
    cdnTrack?: number;
    name?: string;
    address?: Address;
    trackStatus?: TrackStatus;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: Track) {
        this.cdnTrack = data.cdnTrack;
        this.name = data.name;
        this.address = data.address;
        this.trackStatus = data.trackStatus;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class ChampionshipStage implements Serializable {
    cdnChampionshipStage?: number;
    name?: string;
    numberStage?: number;
    startDate?: Date;
    endDate?: Date;
    championship?: Championship;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: ChampionshipStage) {
        this.cdnChampionshipStage = data.cdnChampionshipStage;
        this.name = data.name;
        this.numberStage = data.numberStage;
        this.startDate = data.startDate;
        this.endDate = data.endDate;
        this.championship = data.championship;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class RopingPaymentType implements Serializable {
    cdnRopingPaymentType?: number;
    roping?: Roping;
    paymentType?: PaymentType;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: RopingPaymentType) {
        this.cdnRopingPaymentType = data.cdnRopingPaymentType;
        this.roping = data.roping;
        this.paymentType = data.paymentType;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class Estate implements Serializable {
    cdnEstate?: number;
    code?: string;
    name?: string;
    country?: Country;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: Estate) {
        this.cdnEstate = data.cdnEstate;
        this.code = data.code;
        this.name = data.name;
        this.country = data.country;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class City implements Serializable {
    cdnCity?: number;
    name?: string;
    code?: string;
    estate?: Estate;
    dateCreated?: Date;
    dateUpdated?: Date;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: City) {
        this.cdnCity = data.cdnCity;
        this.name = data.name;
        this.code = data.code;
        this.estate = data.estate;
        this.dateCreated = data.dateCreated;
        this.dateUpdated = data.dateUpdated;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class Country implements Serializable {
    cdnCountry?: number;
    code?: string;
    codIso3?: string;
    numIso?: string;
    bacenCod?: string;
    name?: string;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: Country) {
        this.cdnCountry = data.cdnCountry;
        this.code = data.code;
        this.codIso3 = data.codIso3;
        this.numIso = data.numIso;
        this.bacenCod = data.bacenCod;
        this.name = data.name;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export interface Page<T> extends Slice<T> {
    totalElements?: number;
    totalPages?: number;
}

export class RopingModalityType implements Serializable {
    cdnRopingModalityType?: number;
    name?: string;

    constructor(data: RopingModalityType) {
        this.cdnRopingModalityType = data.cdnRopingModalityType;
        this.name = data.name;
    }
}

export class TrackStatus implements Serializable {
    cdnTrackStatus?: number;
    name?: string;

    constructor(data: TrackStatus) {
        this.cdnTrackStatus = data.cdnTrackStatus;
        this.name = data.name;
    }
}

export class Championship implements Serializable {
    cdnChampionship?: number;
    name?: string;
    championshipStages?: ChampionshipStage[];
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: Championship) {
        this.cdnChampionship = data.cdnChampionship;
        this.name = data.name;
        this.championshipStages = data.championshipStages;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class PaymentType implements Serializable {
    cdnPaymentType?: number;
    name?: string;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: PaymentType) {
        this.cdnPaymentType = data.cdnPaymentType;
        this.name = data.name;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export interface Pageable {
    paged?: boolean;
    pageNumber?: number;
    unpaged?: boolean;
    pageSize?: number;
    offset?: number;
    sort?: Sort;
}

export class Sort implements Streamable<Order>, Serializable {
    empty?: boolean;
    sorted?: boolean;
    unsorted?: boolean;

    constructor(data: Sort) {
        this.empty = data.empty;
        this.sorted = data.sorted;
        this.unsorted = data.unsorted;
    }
}

export interface Slice<T> extends Streamable<T> {
    first?: boolean;
    last?: boolean;
    pageable?: Pageable;
    numberOfElements?: number;
    size?: number;
    content?: T[];
    number?: number;
    sort?: Sort;
}

export interface Streamable<T> extends Iterable<T>, Supplier<Stream<T>> {
    empty?: boolean;
}

export class Order implements Serializable {
    direction?: Direction;
    property?: string;
    ignoreCase?: boolean;
    nullHandling?: NullHandling;
    ascending?: boolean;
    descending?: boolean;

    constructor(data: Order) {
        this.direction = data.direction;
        this.property = data.property;
        this.ignoreCase = data.ignoreCase;
        this.nullHandling = data.nullHandling;
        this.ascending = data.ascending;
        this.descending = data.descending;
    }
}

export interface Iterable<T> {
}

export interface Supplier<T> {
}

export interface Stream<T> extends BaseStream<T, Stream<T>> {
}

export interface BaseStream<T, S> extends AutoCloseable {
    parallel?: boolean;
}

export interface AutoCloseable {
}

export interface HttpClient<O> {

    request<R>(requestConfig: { method: string; url: string; queryParams?: any; data?: any; copyFn?: (data: R) => R; options?: O; }): RestResponse<R>;
}

export class ChampionshipResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/championship/delete
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipResource.delete
     */
    delete(queryParams: { cdnChampionship: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/championship/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/championship/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<ChampionshipDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/championship/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/championship/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipResource.listExample
     */
    listExample(championshipDTO: ChampionshipDTO, options?: O): RestResponse<ResponseDTO<ChampionshipDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/championship/listExample`, data: championshipDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/championship/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipResource.obtain
     */
    obtain(queryParams: { cdnChampionship: number; }, options?: O): RestResponse<ResponseDTO<ChampionshipDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/championship/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/championship/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<ChampionshipDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/championship/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/championship/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<ChampionshipDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/championship/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/championship/save
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipResource.save
     */
    save(championshipDTO: ChampionshipDTO, options?: O): RestResponse<ResponseDTO<ChampionshipDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/championship/save`, data: championshipDTO, options: options });
    }
}

export class AddressResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/address/delete
     * Java method: br.cruzsilva.CruzSilva.rest.AddressResource.delete
     */
    delete(queryParams: { cdnAddress: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/address/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/address/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.AddressResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<AddressDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/address/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/address/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.AddressResource.listExample
     */
    listExample(addressDTO: AddressDTO, options?: O): RestResponse<ResponseDTO<AddressDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/address/listExample`, data: addressDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/address/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.AddressResource.obtain
     */
    obtain(queryParams: { cdnAddress: number; }, options?: O): RestResponse<ResponseDTO<AddressDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/address/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/address/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.AddressResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<AddressDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/address/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/address/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.AddressResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<AddressDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/address/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/address/save
     * Java method: br.cruzsilva.CruzSilva.rest.AddressResource.save
     */
    save(addressDTO: AddressDTO, options?: O): RestResponse<ResponseDTO<AddressDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/address/save`, data: addressDTO, options: options });
    }
}

export class RewardKindResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/rewardkind/delete
     * Java method: br.cruzsilva.CruzSilva.rest.RewardKindResource.delete
     */
    delete(queryParams: { cdnRewardKind: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/rewardkind/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/rewardkind/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.RewardKindResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<RewardKindDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/rewardkind/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/rewardkind/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.RewardKindResource.listExample
     */
    listExample(rewardkindDTO: RewardKindDTO, options?: O): RestResponse<ResponseDTO<RewardKindDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/rewardkind/listExample`, data: rewardkindDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/rewardkind/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.RewardKindResource.obtain
     */
    obtain(queryParams: { cdnRewardKind: number; }, options?: O): RestResponse<ResponseDTO<RewardKindDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/rewardkind/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/rewardkind/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.RewardKindResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<RewardKindDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/rewardkind/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/rewardkind/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.RewardKindResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<RewardKindDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/rewardkind/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/rewardkind/save
     * Java method: br.cruzsilva.CruzSilva.rest.RewardKindResource.save
     */
    save(rewardkindDTO: RewardKindDTO, options?: O): RestResponse<ResponseDTO<RewardKindDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/rewardkind/save`, data: rewardkindDTO, options: options });
    }
}

export class RopingDivisionRankResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/ropingdivisionrank/delete
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionRankResource.delete
     */
    delete(queryParams: { cdnRopingDivisionRank: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/ropingdivisionrank/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingdivisionrank/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionRankResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<RopingDivisionRankDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingdivisionrank/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingdivisionrank/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionRankResource.listExample
     */
    listExample(ropingdivisionrankDTO: RopingDivisionRankDTO, options?: O): RestResponse<ResponseDTO<RopingDivisionRankDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingdivisionrank/listExample`, data: ropingdivisionrankDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingdivisionrank/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionRankResource.obtain
     */
    obtain(queryParams: { cdnRopingDivisionRank: number; }, options?: O): RestResponse<ResponseDTO<RopingDivisionRankDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingdivisionrank/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingdivisionrank/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionRankResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<RopingDivisionRankDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingdivisionrank/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingdivisionrank/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionRankResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<RopingDivisionRankDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingdivisionrank/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingdivisionrank/save
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionRankResource.save
     */
    save(ropingdivisionrankDTO: RopingDivisionRankDTO, options?: O): RestResponse<ResponseDTO<RopingDivisionRankDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingdivisionrank/save`, data: ropingdivisionrankDTO, options: options });
    }
}

export class PaymentTypeResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/paymenttype/delete
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentTypeResource.delete
     */
    delete(queryParams: { cdnPaymentType: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/paymenttype/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/paymenttype/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentTypeResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<PaymentTypeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/paymenttype/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/paymenttype/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentTypeResource.listExample
     */
    listExample(paymenttypeDTO: PaymentTypeDTO, options?: O): RestResponse<ResponseDTO<PaymentTypeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/paymenttype/listExample`, data: paymenttypeDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/paymenttype/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentTypeResource.obtain
     */
    obtain(queryParams: { cdnPaymentType: number; }, options?: O): RestResponse<ResponseDTO<PaymentTypeDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/paymenttype/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/paymenttype/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentTypeResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<PaymentTypeDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/paymenttype/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/paymenttype/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentTypeResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<PaymentTypeDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/paymenttype/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/paymenttype/save
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentTypeResource.save
     */
    save(paymenttypeDTO: PaymentTypeDTO, options?: O): RestResponse<ResponseDTO<PaymentTypeDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/paymenttype/save`, data: paymenttypeDTO, options: options });
    }
}

export class TypeClassificationResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/typeclassification/delete
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationResource.delete
     */
    delete(queryParams: { cdnTypeClassification: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/typeclassification/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/typeclassification/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<TypeClassificationDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/typeclassification/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/typeclassification/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationResource.listExample
     */
    listExample(typeclassificationDTO: TypeClassificationDTO, options?: O): RestResponse<ResponseDTO<TypeClassificationDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/typeclassification/listExample`, data: typeclassificationDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/typeclassification/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationResource.obtain
     */
    obtain(queryParams: { cdnTypeClassification: number; }, options?: O): RestResponse<ResponseDTO<TypeClassificationDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/typeclassification/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/typeclassification/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<TypeClassificationDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/typeclassification/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/typeclassification/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<TypeClassificationDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/typeclassification/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/typeclassification/save
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationResource.save
     */
    save(typeclassificationDTO: TypeClassificationDTO, options?: O): RestResponse<ResponseDTO<TypeClassificationDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/typeclassification/save`, data: typeclassificationDTO, options: options });
    }
}

export class AuthenticationResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP POST /api/v1/auth/authenticate
     * Java method: br.cruzsilva.CruzSilva.rest.AuthenticationResource.authenticate
     */
    authenticate(request: AuthenticationRequestDTO, options?: O): RestResponse<ResponseDTO<AuthenticatoinResponseDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/auth/authenticate`, data: request, options: options });
    }

    /**
     * HTTP POST /api/v1/auth/reNewToken
     * Java method: br.cruzsilva.CruzSilva.rest.AuthenticationResource.reNewToken
     */
    reNewToken(queryParams: { email: string; }, options?: O): RestResponse<ResponseDTO<UserDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/auth/reNewToken`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/auth/register
     * Java method: br.cruzsilva.CruzSilva.rest.AuthenticationResource.register
     */
    register(register: RegisterRequestDTO, options?: O): RestResponse<ResponseDTO<UserDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/auth/register`, data: register, options: options });
    }
}

export class EntryFormResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/entryform/delete
     * Java method: br.cruzsilva.CruzSilva.rest.EntryFormResource.delete
     */
    delete(queryParams: { cdnEntryForm: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/entryform/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/entryform/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.EntryFormResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<EntryFormDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/entryform/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/entryform/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.EntryFormResource.listExample
     */
    listExample(entryformDTO: EntryFormDTO, options?: O): RestResponse<ResponseDTO<EntryFormDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/entryform/listExample`, data: entryformDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/entryform/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.EntryFormResource.obtain
     */
    obtain(queryParams: { cdnEntryForm: number; }, options?: O): RestResponse<ResponseDTO<EntryFormDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/entryform/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/entryform/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.EntryFormResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<EntryFormDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/entryform/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/entryform/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.EntryFormResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<EntryFormDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/entryform/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/entryform/save
     * Java method: br.cruzsilva.CruzSilva.rest.EntryFormResource.save
     */
    save(entryformDTO: EntryFormDTO, options?: O): RestResponse<ResponseDTO<EntryFormDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/entryform/save`, data: entryformDTO, options: options });
    }
}

export class GenderAnimalResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/genderanimal/delete
     * Java method: br.cruzsilva.CruzSilva.rest.GenderAnimalResource.delete
     */
    delete(queryParams: { cdnGenderAnimal: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/genderanimal/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/genderanimal/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.GenderAnimalResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<GenderAnimalDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/genderanimal/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/genderanimal/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.GenderAnimalResource.listExample
     */
    listExample(genderanimalDTO: GenderAnimalDTO, options?: O): RestResponse<ResponseDTO<GenderAnimalDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/genderanimal/listExample`, data: genderanimalDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/genderanimal/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.GenderAnimalResource.obtain
     */
    obtain(queryParams: { cdnGenderAnimal: number; }, options?: O): RestResponse<ResponseDTO<GenderAnimalDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/genderanimal/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/genderanimal/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.GenderAnimalResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<GenderAnimalDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/genderanimal/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/genderanimal/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.GenderAnimalResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<GenderAnimalDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/genderanimal/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/genderanimal/save
     * Java method: br.cruzsilva.CruzSilva.rest.GenderAnimalResource.save
     */
    save(genderanimalDTO: GenderAnimalDTO, options?: O): RestResponse<ResponseDTO<GenderAnimalDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/genderanimal/save`, data: genderanimalDTO, options: options });
    }
}

export class ChampionshipStageResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/championshipstage/delete
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipStageResource.delete
     */
    delete(queryParams: { cdnChampionshipStage: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/championshipstage/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/championshipstage/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipStageResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<ChampionshipStageDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/championshipstage/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/championshipstage/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipStageResource.listExample
     */
    listExample(championshipstageDTO: ChampionshipStageDTO, options?: O): RestResponse<ResponseDTO<ChampionshipStageDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/championshipstage/listExample`, data: championshipstageDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/championshipstage/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipStageResource.obtain
     */
    obtain(queryParams: { cdnChampionshipStage: number; }, options?: O): RestResponse<ResponseDTO<ChampionshipStageDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/championshipstage/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/championshipstage/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipStageResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<ChampionshipStageDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/championshipstage/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/championshipstage/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipStageResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<ChampionshipStageDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/championshipstage/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/championshipstage/save
     * Java method: br.cruzsilva.CruzSilva.rest.ChampionshipStageResource.save
     */
    save(championshipstageDTO: ChampionshipStageDTO, options?: O): RestResponse<ResponseDTO<ChampionshipStageDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/championshipstage/save`, data: championshipstageDTO, options: options });
    }
}

export class TrackStatusResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/trackstatus/delete
     * Java method: br.cruzsilva.CruzSilva.rest.TrackStatusResource.delete
     */
    delete(queryParams: { cdnTrackStatus: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/trackstatus/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/trackstatus/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.TrackStatusResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<TrackStatusDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/trackstatus/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/trackstatus/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.TrackStatusResource.listExample
     */
    listExample(trackstatusDTO: TrackStatusDTO, options?: O): RestResponse<ResponseDTO<TrackStatusDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/trackstatus/listExample`, data: trackstatusDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/trackstatus/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.TrackStatusResource.obtain
     */
    obtain(queryParams: { cdnTrackStatus: number; }, options?: O): RestResponse<ResponseDTO<TrackStatusDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/trackstatus/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/trackstatus/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.TrackStatusResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<TrackStatusDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/trackstatus/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/trackstatus/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.TrackStatusResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<TrackStatusDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/trackstatus/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/trackstatus/save
     * Java method: br.cruzsilva.CruzSilva.rest.TrackStatusResource.save
     */
    save(trackstatusDTO: TrackStatusDTO, options?: O): RestResponse<ResponseDTO<TrackStatusDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/trackstatus/save`, data: trackstatusDTO, options: options });
    }
}

export class RopingPaymentTypeResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/ropingpaymenttype/delete
     * Java method: br.cruzsilva.CruzSilva.rest.RopingPaymentTypeResource.delete
     */
    delete(queryParams: { cdnRopingPaymentType: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/ropingpaymenttype/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingpaymenttype/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.RopingPaymentTypeResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<RopingPaymentTypeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingpaymenttype/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingpaymenttype/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.RopingPaymentTypeResource.listExample
     */
    listExample(ropingpaymenttypeDTO: RopingPaymentTypeDTO, options?: O): RestResponse<ResponseDTO<RopingPaymentTypeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingpaymenttype/listExample`, data: ropingpaymenttypeDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingpaymenttype/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.RopingPaymentTypeResource.obtain
     */
    obtain(queryParams: { cdnRopingPaymentType: number; }, options?: O): RestResponse<ResponseDTO<RopingPaymentTypeDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingpaymenttype/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingpaymenttype/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.RopingPaymentTypeResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<RopingPaymentTypeDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingpaymenttype/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingpaymenttype/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.RopingPaymentTypeResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<RopingPaymentTypeDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingpaymenttype/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingpaymenttype/save
     * Java method: br.cruzsilva.CruzSilva.rest.RopingPaymentTypeResource.save
     */
    save(ropingpaymenttypeDTO: RopingPaymentTypeDTO, options?: O): RestResponse<ResponseDTO<RopingPaymentTypeDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingpaymenttype/save`, data: ropingpaymenttypeDTO, options: options });
    }
}

export class RopingDivisionResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/ropingdivision/delete
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionResource.delete
     */
    delete(queryParams: { cdnRopingDivision: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/ropingdivision/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingdivision/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<RopingDivisionDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingdivision/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingdivision/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionResource.listExample
     */
    listExample(ropingdivisionDTO: RopingDivisionDTO, options?: O): RestResponse<ResponseDTO<RopingDivisionDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingdivision/listExample`, data: ropingdivisionDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingdivision/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionResource.obtain
     */
    obtain(queryParams: { cdnRopingDivision: number; }, options?: O): RestResponse<ResponseDTO<RopingDivisionDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingdivision/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingdivision/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<RopingDivisionDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingdivision/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingdivision/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<RopingDivisionDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingdivision/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingdivision/save
     * Java method: br.cruzsilva.CruzSilva.rest.RopingDivisionResource.save
     */
    save(ropingdivisionDTO: RopingDivisionDTO, options?: O): RestResponse<ResponseDTO<RopingDivisionDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingdivision/save`, data: ropingdivisionDTO, options: options });
    }
}

export class PessoaResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/pessoa/delete
     * Java method: br.cruzsilva.CruzSilva.rest.PessoaResource.delete
     */
    delete(queryParams: { cdnPessoa: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/pessoa/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/pessoa/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.PessoaResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<PessoaDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/pessoa/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/pessoa/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.PessoaResource.listExample
     */
    listExample(pessoaDTO: PessoaDTO, options?: O): RestResponse<ResponseDTO<PessoaDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/pessoa/listExample`, data: pessoaDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/pessoa/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.PessoaResource.obtain
     */
    obtain(queryParams: { cdnPessoa: number; }, options?: O): RestResponse<ResponseDTO<PessoaDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/pessoa/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/pessoa/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.PessoaResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<PessoaDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/pessoa/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/pessoa/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.PessoaResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<PessoaDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/pessoa/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/pessoa/save
     * Java method: br.cruzsilva.CruzSilva.rest.PessoaResource.save
     */
    save(pessoaDTO: PessoaDTO, options?: O): RestResponse<ResponseDTO<PessoaDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/pessoa/save`, data: pessoaDTO, options: options });
    }
}

export class CountryResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/country/delete
     * Java method: br.cruzsilva.CruzSilva.rest.CountryResource.delete
     */
    delete(queryParams: { cdnCountry: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/country/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/country/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.CountryResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<CountryDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/country/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/country/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.CountryResource.listExample
     */
    listExample(countryDTO: CountryDTO, options?: O): RestResponse<ResponseDTO<CountryDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/country/listExample`, data: countryDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/country/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.CountryResource.obtain
     */
    obtain(queryParams: { cdnCountry: number; }, options?: O): RestResponse<ResponseDTO<CountryDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/country/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/country/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.CountryResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<CountryDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/country/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/country/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.CountryResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<CountryDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/country/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/country/save
     * Java method: br.cruzsilva.CruzSilva.rest.CountryResource.save
     */
    save(countryDTO: CountryDTO, options?: O): RestResponse<ResponseDTO<CountryDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/country/save`, data: countryDTO, options: options });
    }
}

export class RopingProductResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/ropingproduct/delete
     * Java method: br.cruzsilva.CruzSilva.rest.RopingProductResource.delete
     */
    delete(queryParams: { cdnRopingDivisionProduct: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/ropingproduct/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingproduct/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.RopingProductResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<RopingProductDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingproduct/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingproduct/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.RopingProductResource.listExample
     */
    listExample(ropingproductDTO: RopingProductDTO, options?: O): RestResponse<ResponseDTO<RopingProductDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingproduct/listExample`, data: ropingproductDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingproduct/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.RopingProductResource.obtain
     */
    obtain(queryParams: { cdnRopingDivisionProduct: number; }, options?: O): RestResponse<ResponseDTO<RopingProductDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingproduct/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingproduct/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.RopingProductResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<RopingProductDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingproduct/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingproduct/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.RopingProductResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<RopingProductDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingproduct/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingproduct/save
     * Java method: br.cruzsilva.CruzSilva.rest.RopingProductResource.save
     */
    save(ropingproductDTO: RopingProductDTO, options?: O): RestResponse<ResponseDTO<RopingProductDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingproduct/save`, data: ropingproductDTO, options: options });
    }
}

export class AnimalResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/animal/delete
     * Java method: br.cruzsilva.CruzSilva.rest.AnimalResource.delete
     */
    delete(queryParams: { cdnAnimal: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/animal/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/animal/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.AnimalResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<AnimalDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/animal/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/animal/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.AnimalResource.listExample
     */
    listExample(animalDTO: AnimalDTO, options?: O): RestResponse<ResponseDTO<AnimalDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/animal/listExample`, data: animalDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/animal/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.AnimalResource.obtain
     */
    obtain(queryParams: { cdnAnimal: number; }, options?: O): RestResponse<ResponseDTO<AnimalDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/animal/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/animal/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.AnimalResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<AnimalDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/animal/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/animal/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.AnimalResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<AnimalDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/animal/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/animal/save
     * Java method: br.cruzsilva.CruzSilva.rest.AnimalResource.save
     */
    save(animalDTO: AnimalDTO, options?: O): RestResponse<ResponseDTO<AnimalDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/animal/save`, data: animalDTO, options: options });
    }
}

export class RopingStatusResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/ropingstatus/delete
     * Java method: br.cruzsilva.CruzSilva.rest.RopingStatusResource.delete
     */
    delete(queryParams: { cdnRopingStatus: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/ropingstatus/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingstatus/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.RopingStatusResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<RopingStatusDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingstatus/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingstatus/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.RopingStatusResource.listExample
     */
    listExample(ropingstatusDTO: RopingStatusDTO, options?: O): RestResponse<ResponseDTO<RopingStatusDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingstatus/listExample`, data: ropingstatusDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingstatus/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.RopingStatusResource.obtain
     */
    obtain(queryParams: { cdnRopingStatus: number; }, options?: O): RestResponse<ResponseDTO<RopingStatusDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingstatus/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingstatus/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.RopingStatusResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<RopingStatusDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingstatus/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingstatus/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.RopingStatusResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<RopingStatusDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingstatus/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingstatus/save
     * Java method: br.cruzsilva.CruzSilva.rest.RopingStatusResource.save
     */
    save(ropingstatusDTO: RopingStatusDTO, options?: O): RestResponse<ResponseDTO<RopingStatusDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingstatus/save`, data: ropingstatusDTO, options: options });
    }
}

export class GenderResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/gender/delete
     * Java method: br.cruzsilva.CruzSilva.rest.GenderResource.delete
     */
    delete(queryParams: { cdnGender: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/gender/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/gender/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.GenderResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<GenderDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/gender/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/gender/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.GenderResource.listExample
     */
    listExample(genderDTO: GenderDTO, options?: O): RestResponse<ResponseDTO<GenderDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/gender/listExample`, data: genderDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/gender/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.GenderResource.obtain
     */
    obtain(queryParams: { cdnGender: number; }, options?: O): RestResponse<ResponseDTO<GenderDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/gender/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/gender/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.GenderResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<GenderDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/gender/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/gender/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.GenderResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<GenderDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/gender/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/gender/save
     * Java method: br.cruzsilva.CruzSilva.rest.GenderResource.save
     */
    save(genderDTO: GenderDTO, options?: O): RestResponse<ResponseDTO<GenderDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/gender/save`, data: genderDTO, options: options });
    }
}

export class EventResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/event/delete
     * Java method: br.cruzsilva.CruzSilva.rest.EventResource.delete
     */
    delete(queryParams: { cdnEvent: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/event/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/event/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.EventResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<EventDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/event/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/event/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.EventResource.listExample
     */
    listExample(eventDTO: EventDTO, options?: O): RestResponse<ResponseDTO<EventDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/event/listExample`, data: eventDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/event/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.EventResource.obtain
     */
    obtain(queryParams: { cdnEvent: number; }, options?: O): RestResponse<ResponseDTO<EventDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/event/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/event/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.EventResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<EventDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/event/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/event/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.EventResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<EventDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/event/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/event/save
     * Java method: br.cruzsilva.CruzSilva.rest.EventResource.save
     */
    save(eventDTO: EventDTO, options?: O): RestResponse<ResponseDTO<EventDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/event/save`, data: eventDTO, options: options });
    }
}

export class RopingResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/roping/delete
     * Java method: br.cruzsilva.CruzSilva.rest.RopingResource.delete
     */
    delete(queryParams: { cdnRoping: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/roping/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/roping/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.RopingResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<RopingDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/roping/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/roping/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.RopingResource.listExample
     */
    listExample(ropingDTO: RopingDTO, options?: O): RestResponse<ResponseDTO<RopingDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/roping/listExample`, data: ropingDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/roping/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.RopingResource.obtain
     */
    obtain(queryParams: { cdnRoping: number; }, options?: O): RestResponse<ResponseDTO<RopingDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/roping/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/roping/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.RopingResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<RopingDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/roping/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/roping/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.RopingResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<RopingDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/roping/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/roping/save
     * Java method: br.cruzsilva.CruzSilva.rest.RopingResource.save
     */
    save(ropingDTO: RopingDTO, options?: O): RestResponse<ResponseDTO<RopingDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/roping/save`, data: ropingDTO, options: options });
    }
}

export class BarrelTypeResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/barreltype/delete
     * Java method: br.cruzsilva.CruzSilva.rest.BarrelTypeResource.delete
     */
    delete(queryParams: { cdnBarrelType: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/barreltype/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/barreltype/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.BarrelTypeResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<BarrelTypeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/barreltype/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/barreltype/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.BarrelTypeResource.listExample
     */
    listExample(barreltypeDTO: BarrelTypeDTO, options?: O): RestResponse<ResponseDTO<BarrelTypeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/barreltype/listExample`, data: barreltypeDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/barreltype/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.BarrelTypeResource.obtain
     */
    obtain(queryParams: { cdnBarrelType: number; }, options?: O): RestResponse<ResponseDTO<BarrelTypeDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/barreltype/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/barreltype/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.BarrelTypeResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<BarrelTypeDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/barreltype/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/barreltype/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.BarrelTypeResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<BarrelTypeDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/barreltype/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/barreltype/save
     * Java method: br.cruzsilva.CruzSilva.rest.BarrelTypeResource.save
     */
    save(barreltypeDTO: BarrelTypeDTO, options?: O): RestResponse<ResponseDTO<BarrelTypeDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/barreltype/save`, data: barreltypeDTO, options: options });
    }
}

export class CompetitorResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/competitor/delete
     * Java method: br.cruzsilva.CruzSilva.rest.CompetitorResource.delete
     */
    delete(queryParams: { cdnCompetitor: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/competitor/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/competitor/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.CompetitorResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<CompetitorDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/competitor/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/competitor/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.CompetitorResource.listExample
     */
    listExample(competitorDTO: CompetitorDTO, options?: O): RestResponse<ResponseDTO<CompetitorDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/competitor/listExample`, data: competitorDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/competitor/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.CompetitorResource.obtain
     */
    obtain(queryParams: { cdnCompetitor: number; }, options?: O): RestResponse<ResponseDTO<CompetitorDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/competitor/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/competitor/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.CompetitorResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<CompetitorDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/competitor/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/competitor/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.CompetitorResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<CompetitorDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/competitor/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/competitor/save
     * Java method: br.cruzsilva.CruzSilva.rest.CompetitorResource.save
     */
    save(competitorDTO: CompetitorDTO, options?: O): RestResponse<ResponseDTO<CompetitorDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/competitor/save`, data: competitorDTO, options: options });
    }
}

export class RopingTypeResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/ropingtype/delete
     * Java method: br.cruzsilva.CruzSilva.rest.RopingTypeResource.delete
     */
    delete(queryParams: { cdnRopingType: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/ropingtype/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingtype/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.RopingTypeResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<RopingTypeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingtype/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingtype/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.RopingTypeResource.listExample
     */
    listExample(ropingtypeDTO: RopingTypeDTO, options?: O): RestResponse<ResponseDTO<RopingTypeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingtype/listExample`, data: ropingtypeDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingtype/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.RopingTypeResource.obtain
     */
    obtain(queryParams: { cdnRopingType: number; }, options?: O): RestResponse<ResponseDTO<RopingTypeDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingtype/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingtype/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.RopingTypeResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<RopingTypeDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingtype/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingtype/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.RopingTypeResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<RopingTypeDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingtype/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingtype/save
     * Java method: br.cruzsilva.CruzSilva.rest.RopingTypeResource.save
     */
    save(ropingtypeDTO: RopingTypeDTO, options?: O): RestResponse<ResponseDTO<RopingTypeDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingtype/save`, data: ropingtypeDTO, options: options });
    }
}

export class TypeClassificationTimeResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/typeclassificationtime/delete
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationTimeResource.delete
     */
    delete(queryParams: { cdnTypeClassificationTime: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/typeclassificationtime/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/typeclassificationtime/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationTimeResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<TypeClassificationTimeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/typeclassificationtime/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/typeclassificationtime/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationTimeResource.listExample
     */
    listExample(typeclassificationtimeDTO: TypeClassificationTimeDTO, options?: O): RestResponse<ResponseDTO<TypeClassificationTimeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/typeclassificationtime/listExample`, data: typeclassificationtimeDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/typeclassificationtime/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationTimeResource.obtain
     */
    obtain(queryParams: { cdnTypeClassificationTime: number; }, options?: O): RestResponse<ResponseDTO<TypeClassificationTimeDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/typeclassificationtime/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/typeclassificationtime/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationTimeResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<TypeClassificationTimeDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/typeclassificationtime/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/typeclassificationtime/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationTimeResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<TypeClassificationTimeDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/typeclassificationtime/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/typeclassificationtime/save
     * Java method: br.cruzsilva.CruzSilva.rest.TypeClassificationTimeResource.save
     */
    save(typeclassificationtimeDTO: TypeClassificationTimeDTO, options?: O): RestResponse<ResponseDTO<TypeClassificationTimeDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/typeclassificationtime/save`, data: typeclassificationtimeDTO, options: options });
    }
}

export class TrackResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/track/delete
     * Java method: br.cruzsilva.CruzSilva.rest.TrackResource.delete
     */
    delete(queryParams: { cdnTrack: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/track/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/track/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.TrackResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<TrackDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/track/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/track/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.TrackResource.listExample
     */
    listExample(trackDTO: TrackDTO, options?: O): RestResponse<ResponseDTO<TrackDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/track/listExample`, data: trackDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/track/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.TrackResource.obtain
     */
    obtain(queryParams: { cdnTrack: number; }, options?: O): RestResponse<ResponseDTO<TrackDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/track/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/track/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.TrackResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<TrackDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/track/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/track/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.TrackResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<TrackDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/track/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/track/save
     * Java method: br.cruzsilva.CruzSilva.rest.TrackResource.save
     */
    save(trackDTO: TrackDTO, options?: O): RestResponse<ResponseDTO<TrackDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/track/save`, data: trackDTO, options: options });
    }
}

export class CityResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/city/delete
     * Java method: br.cruzsilva.CruzSilva.rest.CityResource.delete
     */
    delete(queryParams: { cdnCity: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/city/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/city/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.CityResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<CityDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/city/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/city/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.CityResource.listExample
     */
    listExample(cityDTO: CityDTO, options?: O): RestResponse<ResponseDTO<CityDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/city/listExample`, data: cityDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/city/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.CityResource.obtain
     */
    obtain(queryParams: { cdnCity: number; }, options?: O): RestResponse<ResponseDTO<CityDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/city/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/city/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.CityResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<CityDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/city/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/city/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.CityResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<CityDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/city/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/city/save
     * Java method: br.cruzsilva.CruzSilva.rest.CityResource.save
     */
    save(cityDTO: CityDTO, options?: O): RestResponse<ResponseDTO<CityDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/city/save`, data: cityDTO, options: options });
    }
}

export class RopingModalityResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/ropingmodality/delete
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityResource.delete
     */
    delete(queryParams: { cdnRopingModality: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/ropingmodality/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingmodality/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<RopingModalityDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingmodality/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingmodality/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityResource.listExample
     */
    listExample(ropingmodalityDTO: RopingModalityDTO, options?: O): RestResponse<ResponseDTO<RopingModalityDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingmodality/listExample`, data: ropingmodalityDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingmodality/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityResource.obtain
     */
    obtain(queryParams: { cdnRopingModality: number; }, options?: O): RestResponse<ResponseDTO<RopingModalityDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingmodality/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingmodality/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<RopingModalityDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingmodality/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingmodality/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<RopingModalityDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingmodality/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingmodality/save
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityResource.save
     */
    save(ropingmodalityDTO: RopingModalityDTO, options?: O): RestResponse<ResponseDTO<RopingModalityDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingmodality/save`, data: ropingmodalityDTO, options: options });
    }
}

export class JudgeResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/judge/delete
     * Java method: br.cruzsilva.CruzSilva.rest.JudgeResource.delete
     */
    delete(queryParams: { cdnJudge: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/judge/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/judge/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.JudgeResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<JudgeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/judge/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/judge/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.JudgeResource.listExample
     */
    listExample(judgeDTO: JudgeDTO, options?: O): RestResponse<ResponseDTO<JudgeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/judge/listExample`, data: judgeDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/judge/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.JudgeResource.obtain
     */
    obtain(queryParams: { cdnJudge: number; }, options?: O): RestResponse<ResponseDTO<JudgeDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/judge/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/judge/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.JudgeResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<JudgeDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/judge/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/judge/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.JudgeResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<JudgeDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/judge/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/judge/save
     * Java method: br.cruzsilva.CruzSilva.rest.JudgeResource.save
     */
    save(judgeDTO: JudgeDTO, options?: O): RestResponse<ResponseDTO<JudgeDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/judge/save`, data: judgeDTO, options: options });
    }
}

export class DivisionResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/division/delete
     * Java method: br.cruzsilva.CruzSilva.rest.DivisionResource.delete
     */
    delete(queryParams: { cdnDivision: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/division/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/division/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.DivisionResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<DivisionDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/division/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/division/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.DivisionResource.listExample
     */
    listExample(divisionDTO: DivisionDTO, options?: O): RestResponse<ResponseDTO<DivisionDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/division/listExample`, data: divisionDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/division/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.DivisionResource.obtain
     */
    obtain(queryParams: { cdnDivision: number; }, options?: O): RestResponse<ResponseDTO<DivisionDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/division/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/division/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.DivisionResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<DivisionDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/division/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/division/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.DivisionResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<DivisionDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/division/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/division/save
     * Java method: br.cruzsilva.CruzSilva.rest.DivisionResource.save
     */
    save(divisionDTO: DivisionDTO, options?: O): RestResponse<ResponseDTO<DivisionDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/division/save`, data: divisionDTO, options: options });
    }

    /**
     * HTTP POST /api/v1/division/saveList
     * Java method: br.cruzsilva.CruzSilva.rest.DivisionResource.saveList
     */
    saveList(divisionDTO: DivisionDTO[], options?: O): RestResponse<ResponseDTO<DivisionDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/division/saveList`, data: divisionDTO, options: options });
    }
}

export class RopingModalityTypeResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/ropingmodalitytype/delete
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityTypeResource.delete
     */
    delete(queryParams: { cdnRopingModalityType: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/ropingmodalitytype/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingmodalitytype/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityTypeResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<RopingModalityTypeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingmodalitytype/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingmodalitytype/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityTypeResource.listExample
     */
    listExample(ropingmodalitytypeDTO: RopingModalityTypeDTO, options?: O): RestResponse<ResponseDTO<RopingModalityTypeDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingmodalitytype/listExample`, data: ropingmodalitytypeDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingmodalitytype/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityTypeResource.obtain
     */
    obtain(queryParams: { cdnRopingModalityType: number; }, options?: O): RestResponse<ResponseDTO<RopingModalityTypeDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingmodalitytype/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/ropingmodalitytype/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityTypeResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<RopingModalityTypeDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/ropingmodalitytype/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingmodalitytype/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityTypeResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<RopingModalityTypeDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingmodalitytype/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/ropingmodalitytype/save
     * Java method: br.cruzsilva.CruzSilva.rest.RopingModalityTypeResource.save
     */
    save(ropingmodalitytypeDTO: RopingModalityTypeDTO, options?: O): RestResponse<ResponseDTO<RopingModalityTypeDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/ropingmodalitytype/save`, data: ropingmodalitytypeDTO, options: options });
    }
}

export class EventTestResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/eventtest/delete
     * Java method: br.cruzsilva.CruzSilva.rest.EventTestResource.delete
     */
    delete(queryParams: { cdnEventTest: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/eventtest/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/eventtest/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.EventTestResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<EventTestDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/eventtest/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/eventtest/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.EventTestResource.listExample
     */
    listExample(eventtestDTO: EventTestDTO, options?: O): RestResponse<ResponseDTO<EventTestDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/eventtest/listExample`, data: eventtestDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/eventtest/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.EventTestResource.obtain
     */
    obtain(queryParams: { cdnEventTest: number; }, options?: O): RestResponse<ResponseDTO<EventTestDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/eventtest/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/eventtest/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.EventTestResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<EventTestDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/eventtest/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/eventtest/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.EventTestResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<EventTestDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/eventtest/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/eventtest/save
     * Java method: br.cruzsilva.CruzSilva.rest.EventTestResource.save
     */
    save(eventtestDTO: EventTestDTO, options?: O): RestResponse<ResponseDTO<EventTestDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/eventtest/save`, data: eventtestDTO, options: options });
    }
}

export class CustomerResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/customer/delete
     * Java method: br.cruzsilva.CruzSilva.rest.CustomerResource.delete
     */
    delete(queryParams: { cdnCustomer: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/customer/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/customer/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.CustomerResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<CustomerDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/customer/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/customer/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.CustomerResource.listExample
     */
    listExample(CustomerDTO: CustomerDTO, options?: O): RestResponse<ResponseDTO<CustomerDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/customer/listExample`, data: CustomerDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/customer/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.CustomerResource.obtain
     */
    obtain(queryParams: { cdnCustomer: number; }, options?: O): RestResponse<ResponseDTO<CustomerDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/customer/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/customer/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.CustomerResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<CustomerDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/customer/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/customer/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.CustomerResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<CustomerDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/customer/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/customer/save
     * Java method: br.cruzsilva.CruzSilva.rest.CustomerResource.save
     */
    save(CustomerDTO: CustomerDTO, options?: O): RestResponse<ResponseDTO<CustomerDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/customer/save`, data: CustomerDTO, options: options });
    }
}

export class PaymentResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/payment/delete
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentResource.delete
     */
    delete(queryParams: { cdnPayment: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/payment/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/payment/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<PaymentDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/payment/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/payment/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentResource.listExample
     */
    listExample(paymentDTO: PaymentDTO, options?: O): RestResponse<ResponseDTO<PaymentDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/payment/listExample`, data: paymentDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/payment/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentResource.obtain
     */
    obtain(queryParams: { cdnPayment: number; }, options?: O): RestResponse<ResponseDTO<PaymentDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/payment/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/payment/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<PaymentDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/payment/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/payment/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<PaymentDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/payment/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/payment/save
     * Java method: br.cruzsilva.CruzSilva.rest.PaymentResource.save
     */
    save(paymentDTO: PaymentDTO, options?: O): RestResponse<ResponseDTO<PaymentDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/payment/save`, data: paymentDTO, options: options });
    }
}

export class EstateResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/estate/delete
     * Java method: br.cruzsilva.CruzSilva.rest.EstateResource.delete
     */
    delete(queryParams: { cdnEstate: number; }, options?: O): RestResponse<ResponseDTO<any>> {
        return this.httpClient.request({ method: "DELETE", url: uriEncoding`api/v1/estate/delete`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/estate/listAll
     * Java method: br.cruzsilva.CruzSilva.rest.EstateResource.listAll
     */
    listAll(options?: O): RestResponse<ResponseDTO<EstateDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/estate/listAll`, options: options });
    }

    /**
     * HTTP POST /api/v1/estate/listExample
     * Java method: br.cruzsilva.CruzSilva.rest.EstateResource.listExample
     */
    listExample(estateDTO: EstateDTO, options?: O): RestResponse<ResponseDTO<EstateDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/estate/listExample`, data: estateDTO, options: options });
    }

    /**
     * HTTP GET /api/v1/estate/obtain
     * Java method: br.cruzsilva.CruzSilva.rest.EstateResource.obtain
     */
    obtain(queryParams: { cdnEstate: number; }, options?: O): RestResponse<ResponseDTO<EstateDTO>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/estate/obtain`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP GET /api/v1/estate/pagination
     * Java method: br.cruzsilva.CruzSilva.rest.EstateResource.pagination
     */
    pagination(queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; filter?: number; }, options?: O): RestResponse<ResponseDTO<Page<EstateDTO>>> {
        return this.httpClient.request({ method: "GET", url: uriEncoding`api/v1/estate/pagination`, queryParams: queryParams, options: options });
    }

    /**
     * HTTP POST /api/v1/estate/paginationFull
     * Java method: br.cruzsilva.CruzSilva.rest.EstateResource.paginationFull
     */
    paginationFull(filterMap: { [index: string]: any }, queryParams?: { page?: number; pageSize?: number; sortBy?: string; direction?: string; }, options?: O): RestResponse<ResponseDTO<Page<EstateDTO>>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/estate/paginationFull`, queryParams: queryParams, data: filterMap, options: options });
    }

    /**
     * HTTP POST /api/v1/estate/save
     * Java method: br.cruzsilva.CruzSilva.rest.EstateResource.save
     */
    save(estateDTO: EstateDTO, options?: O): RestResponse<ResponseDTO<EstateDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/estate/save`, data: estateDTO, options: options });
    }
}

export type RestResponse<R> = Promise<Axios.GenericAxiosResponse<R>>;

export enum Code {
    ERROR_GENERIC = "ERROR_GENERIC",
    SUCCESS = "SUCCESS",
    ERROR_BUSINESS_RULE = "ERROR_BUSINESS_RULE",
}

export enum Status {
    SUCCESS = "SUCCESS",
    ERROR = "ERROR",
    WARN = "WARN",
}

export enum Direction {
    ASC = "ASC",
    DESC = "DESC",
}

export enum NullHandling {
    NATIVE = "NATIVE",
    NULLS_FIRST = "NULLS_FIRST",
    NULLS_LAST = "NULLS_LAST",
}

function uriEncoding(template: TemplateStringsArray, ...substitutions: any[]): string {
    let result = "";
    for (let i = 0; i < substitutions.length; i++) {
        result += template[i];
        result += encodeURIComponent(substitutions[i]);
    }
    result += template[template.length - 1];
    return result;
}


// Added by 'AxiosClientExtension' extension

import axios from "axios";
import * as Axios from "axios";

declare module "axios" {
    export interface GenericAxiosResponse<R> extends Axios.AxiosResponse {
        data: R;
    }
}

class AxiosHttpClient implements HttpClient<Axios.AxiosRequestConfig> {

    constructor(private axios: Axios.AxiosInstance) {
    }

    request<R>(requestConfig: { method: string; url: string; queryParams?: any; data?: any; copyFn?: (data: R) => R; options?: Axios.AxiosRequestConfig; }): RestResponse<R> {
        function assign(target: any, source?: any) {
            if (source != undefined) {
                for (const key in source) {
                    if (source.hasOwnProperty(key)) {
                        target[key] = source[key];
                    }
                }
            }
            return target;
        }

        const config: Axios.AxiosRequestConfig = {};
        config.method = requestConfig.method as typeof config.method;  // `string` in axios 0.16.0, `Method` in axios 0.19.0
        config.url = requestConfig.url;
        config.params = requestConfig.queryParams;
        config.data = requestConfig.data;
        assign(config, requestConfig.options);
        const copyFn = requestConfig.copyFn;

        const axiosResponse = this.axios.request(config);
        return axiosResponse.then(axiosResponse => {
            if (copyFn && axiosResponse.data) {
                (axiosResponse as any).originalData = axiosResponse.data;
                axiosResponse.data = copyFn(axiosResponse.data);
            }
            return axiosResponse;
        });
    }
}

export class AxiosChampionshipResourceClient extends ChampionshipResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosAddressResourceClient extends AddressResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosRewardKindResourceClient extends RewardKindResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosRopingDivisionRankResourceClient extends RopingDivisionRankResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosPaymentTypeResourceClient extends PaymentTypeResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosTypeClassificationResourceClient extends TypeClassificationResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosAuthenticationResourceClient extends AuthenticationResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosEntryFormResourceClient extends EntryFormResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosGenderAnimalResourceClient extends GenderAnimalResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosChampionshipStageResourceClient extends ChampionshipStageResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosTrackStatusResourceClient extends TrackStatusResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosRopingPaymentTypeResourceClient extends RopingPaymentTypeResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosRopingDivisionResourceClient extends RopingDivisionResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosPessoaResourceClient extends PessoaResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosCountryResourceClient extends CountryResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosRopingProductResourceClient extends RopingProductResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosAnimalResourceClient extends AnimalResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosRopingStatusResourceClient extends RopingStatusResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosGenderResourceClient extends GenderResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosEventResourceClient extends EventResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosRopingResourceClient extends RopingResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosBarrelTypeResourceClient extends BarrelTypeResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosCompetitorResourceClient extends CompetitorResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosRopingTypeResourceClient extends RopingTypeResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosTypeClassificationTimeResourceClient extends TypeClassificationTimeResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosTrackResourceClient extends TrackResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosCityResourceClient extends CityResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosRopingModalityResourceClient extends RopingModalityResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosJudgeResourceClient extends JudgeResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosDivisionResourceClient extends DivisionResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosRopingModalityTypeResourceClient extends RopingModalityTypeResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosEventTestResourceClient extends EventTestResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosCustomerResourceClient extends CustomerResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosPaymentResourceClient extends PaymentResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}

export class AxiosEstateResourceClient extends EstateResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}
