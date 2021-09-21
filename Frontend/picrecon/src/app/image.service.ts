import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Image } from "./Image";
import { environment } from "src/environments/environment";

// TODO: Fix the api endpoints
@Injectable({providedIn: 'root'})
export class ImageService {
  private apiServerUrl = environment.apiBaseUrl;
  
  constructor(private http: HttpClient) { }

  public getImages(): Observable<Image[]> {
    return this.http.get<Image[]>(`${this.apiServerUrl}/get/local/all`)
  }

  public addImage(image: Image): Observable<Image> {
    return this.http.post<Image>(`${this.apiServerUrl}/Image/add`, Image);
  }

  public updateImage(image: Image): Observable<Image> {
    return this.http.put<Image>(`${this.apiServerUrl}/Image/update`, Image);
  }

  public deleteImage(imageId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/Image/delete/${imageId}`);
  }
}