/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 2.32.889 on 2024-06-09 20:53:49.

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

export class BaseResource {

    constructor(data: BaseResource) {
    }
}

export interface Serializable {
}

export interface Page<T> extends Slice<T> {
    totalElements?: number;
    totalPages?: number;
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
    unsorted?: boolean;
    sorted?: boolean;

    constructor(data: Sort) {
        this.empty = data.empty;
        this.unsorted = data.unsorted;
        this.sorted = data.sorted;
    }
}

export interface Slice<T> extends Streamable<T> {
    first?: boolean;
    numberOfElements?: number;
    last?: boolean;
    pageable?: Pageable;
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

export class AxiosCustomerResourceClient extends CustomerResourceClient<Axios.AxiosRequestConfig> {

    constructor(baseURL: string, axiosInstance: Axios.AxiosInstance = axios.create()) {
        axiosInstance.defaults.baseURL = baseURL;
        super(new AxiosHttpClient(axiosInstance));
    }
}
