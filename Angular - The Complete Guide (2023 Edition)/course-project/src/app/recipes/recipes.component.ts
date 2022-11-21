import { Component, Input, OnInit } from '@angular/core';
import { Recipe } from './recipe.module';
import { RecipeService } from './services/recipe.service';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css'],
  providers: [RecipeService]
})
export class RecipesComponent implements OnInit {

  @Input() selectedRecipe: Recipe

  constructor() { }

  ngOnInit(): void {
  }

}
