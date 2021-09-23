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
  public editImage: Image;
  public deleteImage: Image;
  public uploadedFile: File;

  constructor(private imageService: ImageService){ 
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

  public onDeleteImage(imageId: string = ""): void {
    this.imageService.deleteImage(imageId).subscribe(
      (response: void) => {
        console.log(response);
        this.getImages();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public uploadImage(): void {
    // TODO: get the owner ID
    console.log("UploadImage");
    this.imageService.addImage(this.uploadedFile, "14")
  }

  public onFileSelected(event): void {
    this.uploadedFile = event.target.files[0];
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

