import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Experiencia} from "../model/experiencia";

@Injectable({
  providedIn: 'root'
})
export class ExperienciaService {
  expURL = 'http://localhost:8080/explab'
  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Experiencia[]>{
    return this.httpClient.get<Experiencia []>(`${this.expURL}/lista`);
  }

  public  detail(id: number): Observable<Experiencia>{
    return this.httpClient.get<Experiencia>(this.expURL + `/detail/${id}`);
  }

  public save(Experiencia: Experiencia): Observable<any>{
    return this.httpClient.post<any>(this.expURL + '/create', Experiencia);
  }

  public update(id: number, Experiencia: Experiencia): Observable<any>{
    return this.httpClient.put<any>(this.expURL + `/update/${id}`, Experiencia);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.expURL + `/delete/${id}`);
  }
}
