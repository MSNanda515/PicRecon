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
  public editImage: Image | null;

  constructor(private imageService: ImageService){ 
    this.editImage = null;
  }

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

  public onOpenModal(image: Image | null, mode: string): void {
    // Create a modal button element
    const container = document.getElementById('home-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addImageModal');
    }
    if (mode === 'edit') {
      this.editImage = image;
      button.setAttribute('data-target', '#updateImageModal');
    }
    if (mode === 'delete') {
      // this.deleteImage = image;
      button.setAttribute('data-target', '#deleteImageModal');
    }
    if (container != null) {
      container.appendChild(button);
    }
    button.click();
  }

}

