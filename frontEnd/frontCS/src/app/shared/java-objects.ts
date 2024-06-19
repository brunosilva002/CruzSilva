/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 2.32.889 on 2024-06-19 20:49:58.

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

    constructor(data: DivisionDTO) {
        this.cdnDivision = data.cdnDivision;
        this.name = data.name;
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
    address?: AddressDTO;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: RopingDTO) {
        this.cdnRoping = data.cdnRoping;
        this.name = data.name;
        this.startDate = data.startDate;
        this.endDate = data.endDate;
        this.address = data.address;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
    }
}

export class RopingDivisionDTO implements Serializable {
    cdnRopingDivision?: number;
    divison?: DivisionDTO;
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
        this.divison = data.divison;
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
    valueRate?: number;
    valueReward?: number;
    point?: number;
    ropingDivision?: RopingDivisionDTO;
    creationDate?: Date;
    creationUser?: string;
    updateDate?: Date;
    updateUser?: string;

    constructor(data: RopingDivisionRankDTO) {
        this.cdnRopingDivisionRank = data.cdnRopingDivisionRank;
        this.rankNumber = data.rankNumber;
        this.valueRate = data.valueRate;
        this.valueReward = data.valueReward;
        this.point = data.point;
        this.ropingDivision = data.ropingDivision;
        this.creationDate = data.creationDate;
        this.creationUser = data.creationUser;
        this.updateDate = data.updateDate;
        this.updateUser = data.updateUser;
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

export interface Pageable {
    offset?: number;
    sort?: Sort;
    pageSize?: number;
    paged?: boolean;
    pageNumber?: number;
    unpaged?: boolean;
}

export interface Slice<T> extends Streamable<T> {
    size?: number;
    content?: T[];
    number?: number;
    sort?: Sort;
    pageable?: Pageable;
    last?: boolean;
    first?: boolean;
    numberOfElements?: number;
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
    listExample(customerDTO: CustomerDTO, options?: O): RestResponse<ResponseDTO<CustomerDTO[]>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/customer/listExample`, data: customerDTO, options: options });
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
    save(customerDTO: CustomerDTO, options?: O): RestResponse<ResponseDTO<CustomerDTO>> {
        return this.httpClient.request({ method: "POST", url: uriEncoding`api/v1/customer/save`, data: customerDTO, options: options });
    }
}

export class RopingProductResourceClient<O> {

    constructor(protected httpClient: HttpClient<O>) {
    }

    /**
     * HTTP DELETE /api/v1/ropingproduct/delete
     * Java method: br.cruzsilva.CruzSilva.rest.RopingProductResource.delete
     */
    delete(queryParams: { cdnRopingProduct: number; }, options?: O): RestResponse<ResponseDTO<any>> {
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
    obtain(queryParams: { cdnRopingProduct: number; }, options?: O): RestResponse<ResponseDTO<RopingProductDTO>> {
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

export class AxiosCountryResourceClient extends CountryResourceClient<Axios.AxiosRequestConfig> {

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

export class AxiosRopingProductResourceClient extends RopingProductResourceClient<Axios.AxiosRequestConfig> {

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

export class AxiosAuthenticationResourceClient extends AuthenticationResourceClient<Axios.AxiosRequestConfig> {

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

export class AxiosRopingDivisionRankResourceClient extends RopingDivisionRankResourceClient<Axios.AxiosRequestConfig> {

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

export class AxiosAnimalResourceClient extends AnimalResourceClient<Axios.AxiosRequestConfig> {

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

export class AxiosRopingDivisionResourceClient extends RopingDivisionResourceClient<Axios.AxiosRequestConfig> {

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

export class AxiosCompetitorResourceClient extends CompetitorResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}
