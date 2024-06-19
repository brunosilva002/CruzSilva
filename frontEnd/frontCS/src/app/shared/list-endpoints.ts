import { environment } from 'src/environments/environment'
import axios, { AxiosError } from 'axios'
import { config } from 'rxjs';
import { AxiosAnimalResourceClient, AxiosAuthenticationResourceClient, AxiosCompetitorResourceClient, AxiosCustomerResourceClient, AxiosJudgeResourceClient, AxiosRopingDivisionResourceClient, AxiosRopingProductResourceClient, AxiosRopingResourceClient} from './java-objects';

// Função para obter um novo token a partir do AxiosAuthenticationResourceClient
async function getNewToken() {
    // try {
    //   const authClient = new AxiosAuthenticationResourceClient(environment.apiBaseUrl, axios);
    //   const response = await authClient.reNewToken({
    //     email:localStorage.getItem('email')!
    //   })
    //   .then(resp=>{
    //     localStorage.setItem("token", resp.data.data?.token!)
    //     localStorage.setItem("timeOut", resp.data?.data?.timeOut!.toString()!)
    //     localStorage.setItem("timeAt", resp.data.data?.timeAt!.toString()!)
    //   });
    //   return 1;
    // } catch (error) {
    //   console.error('Erro ao obter um novo token:', error);
    //   return null;
    // }
  }
  
  // Interceptor de solicitação
  axios.interceptors.request.use( config=> {

    if (localStorage.getItem('token') && !config.url?.includes("auth")){
   
        const currentTimestamp = Math.floor(Date.now() / 1000);
        const tokenExpiration = Number(localStorage.getItem('timeOut'));
      
        if (currentTimestamp + 1000 >=tokenExpiration){
          getNewToken().then(() => {
            // Atualize o cabeçalho Authorization com o novo token ou o token existente
            config.headers.Authorization = `Bearer ${localStorage.getItem('token')}`;
          });
        }else{
          config.headers.Authorization = `Bearer ${localStorage.getItem('token')}`;
        }
        return config;
      }
      return config
    }, err => Promise.reject(err)
  );
  
  // Interceptor de resposta
  axios.interceptors.response.use(
    (response) => {
      // Faça operações na resposta
      console.log('Intercepted Response:', response);
      return response;
    },
    (error: AxiosError) => {
      // Faça algo com erros de resposta
      return Promise.reject(error);
    }
  );

export class ListEndPoints {

    static createAxiosInstance(){
        return axios;
    }

    static authenticResourceClient(){
      return new AxiosAuthenticationResourceClient(environment.apiBaseUrl,ListEndPoints.createAxiosInstance());
    }    

    static judgeResourceClient(){
      return new AxiosJudgeResourceClient(environment.apiBaseUrl,ListEndPoints.createAxiosInstance());
    }  
    
    static animalResourceClient(){
      return new AxiosAnimalResourceClient(environment.apiBaseUrl,ListEndPoints.createAxiosInstance());
    }  

    static competitorResourceClient(){
      return new AxiosCompetitorResourceClient(environment.apiBaseUrl,ListEndPoints.createAxiosInstance());
    }
    
    static ropingDivisionResourceClient(){
      return new AxiosRopingDivisionResourceClient(environment.apiBaseUrl,ListEndPoints.createAxiosInstance());
    }

    static ropingResourceClient(){
      return new AxiosRopingResourceClient(environment.apiBaseUrl,ListEndPoints.createAxiosInstance());
    }

    static ropingProductResourceClient(){
      return new AxiosRopingProductResourceClient(environment.apiBaseUrl,ListEndPoints.createAxiosInstance());
    }


}