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

  public addImage(imageFile: File, ownerId: string): Observable<void> {
    // Create a form data element
    const fd = new FormData();
    fd.append('imageFile', imageFile);
    fd.append('ownerId', ownerId);
    return this.http.post<null>(`${this.apiServerUrl}/upload/local`, fd);
  }

  public getImagesOwner() {
    const fd = new FormData();
    fd.append('ownerId', "14");
    return this.http.post(`${this.apiServerUrl}/get/local/owner`, fd)
  }

  public updateImage(image: Image): Observable<Image> {
    return this.http.put<Image>(`${this.apiServerUrl}/Image/update`, Image);
  }

  public deleteImage(imageId: string, ownerId: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/delete/local?imageId=${imageId}&ownerId=${ownerId}`);
  }
}