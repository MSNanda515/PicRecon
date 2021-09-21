import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Image } from './Image';
import { ImageService } from './image.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  // title = 'picrecon';
  public images: Image[] = [];

  constructor(private imageService: ImageService){ }

  ngOnInit() {
    // Automatically called, sets up the images
    this.getImages();
  }

  public getImages(): void {
    this.imageService.getImages().subscribe(
      (response: Image[]) => {
        this.images = response;
        console.log(this.images)
      },
      (error: HttpErrorResponse) => {
        alert(error.message); 
      }
    )
  }
}

