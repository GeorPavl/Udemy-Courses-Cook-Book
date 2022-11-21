import { EventEmitter, Injectable } from "@angular/core";
import { ShoppingListService } from "src/app/shoping-list/services/shopping-list.service";
import { Ingredient } from "src/app/_shared/ingredient.model";
import { Recipe } from "../recipe.model";

@Injectable()
export class RecipeService {

  recipeSelected = new EventEmitter<Recipe>();

  private recipes: Recipe[] = [
    new Recipe(
      'Schnitzel',
      'This is a siple test',
      'https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chorizo-mozarella-gnocchi-bake-cropped-9ab73a3.jpg',
      [
        new Ingredient('Meat', 1),
        new Ingredient('French Fried', 20)
      ]
    ),
    new Recipe(
      'Burger',
      'Be Quite!',
      'https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/101ad363237205.5aa9feaddf1f7.gif',
      [
        new Ingredient('Buns', 2),
        new Ingredient('Meat', 1)
      ]
    )
  ];

  constructor(private shoppingListService: ShoppingListService) {}

  getRecipes() {
    // with .slice() you get a copy of the array
    return this.recipes.slice();
  }

  addIngredientsToShoppingList(ingredients: Ingredient[]) {
    this.shoppingListService.addIngredients(ingredients);
  }

}
