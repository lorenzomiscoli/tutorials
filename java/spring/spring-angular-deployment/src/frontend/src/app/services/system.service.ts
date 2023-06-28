import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class SystemService {

  constructor(private httpClient: HttpClient) { }

  public getVersion(): Observable<{ version: string }> {
    return this.httpClient.get<{ version: string }>("/api/system/version");
  }

}
