import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Image } from './Image';
import { ImageService } from './image.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // title = 'picrecon';
  public images: Image[] = [];

  constructor(private imageService: ImageService){ }

  public getImages(): void {
    this.imageService.getImages().subscribe(
      (response: Image[]) => {
        this.images = response;
      }
    )
  }
}
