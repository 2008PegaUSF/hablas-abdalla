import { Component, OnInit } from '@angular/core';
import { Planet } from './planet';

@Component({
  selector: 'app-planet-list',
  templateUrl: './planet-list.component.html',
  styleUrls: ['./planet-list.component.css']
})
export class PlanetListComponent {

  /**
   * this are the instance variabes of the class
   */
  planets: Planet[];
  filteredPlanets: Planet[];
  //used to demo 2-way binding and creating a filter 
  private actualInputField: any; // any data type
  currentUser = 'User';

  /**
   * this is a constructor for the class to initialize the planets array and coppy it to filtereredplanets array
   */
  constructor() {

    this.planets = [
      {
        name: 'Earth',
        image: 'https://images.unsplash.com/photo-1564053489984-317bbd824340?ixlib=rb-1.2.1&auto=format&fit=crop&w=2014&q=80',
        livibility: 5
      },
      {
        name: 'Mars',
        image: 'https://scitechdaily.com/images/Mars-Red-Planet-Highlights-scaled.jpg',
        livibility: 3
      },
      {
        name: 'Venus',
        image: 'https://www.sciencenewsforstudents.org/wp-content/uploads/2019/11/020618_LG_venus-fobette_feat-800x428.jpg',
        livibility: 4
      },
      {
        name: 'Jupiter',
        image: 'https://upload.wikimedia.org/wikipedia/commons/4/4e/Jupiter%27s_swirling_colourful_clouds.jpg',
        livibility: 1
      },
      {
        name: 'Mercury',
        image: 'http://dreamicus.com/data/mercury/mercury-06.jpg',
        livibility: 2
      }

    ]

    this.filteredPlanets = this.planets;

  }

  //used to demo *ngIf
  showTable: boolean = true;

  // dealing with the images
  imageWidth = 100;
  imageMargin = 2;
  showImage = false;
  showName = false;
  showLivibility = false;

  toggleImage() {
    this.showImage = !this.showImage;
  }
  toggleName() {
    this.showName = !this.showName;
  }
  toggleLiviblility() {
    this.showLivibility = !this.showLivibility;
  }

  /**
   * getters and setters for the actualInputField instance variable
   */
  get inputField() {
    return this.actualInputField;
  }

  set inputField(temp) {
    this.actualInputField = temp;
    if (!isNaN(this.actualInputField)) {
      // filter by livibility
      this.filteredPlanets = this.actualInputField ?
        this.filterByLivibility(this.inputField) : this.planets;
    }
    else {
      // if there is input from user, it filter the table. otherwise, display everything
      this.filteredPlanets = this.actualInputField ?
        this.performFilterByname(this.inputField) : this.planets;
    }
  }

  performFilterByname(filterValue: string): Planet[] {
    filterValue = filterValue.toLocaleLowerCase();
    return this.planets.filter(
      (planet: Planet) => {
        return planet.name.toLocaleLowerCase().indexOf(filterValue) != -1;
      }
    );
  }

  filterByLivibility(filterValue: number): Planet[] {
    return this.planets.filter(
      (planet: Planet) => {
        return planet.livibility >= filterValue;
      }
    );
  }

}
