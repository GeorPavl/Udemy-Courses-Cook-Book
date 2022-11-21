import { EventEmitter } from "@angular/core";
import { Ingredient } from "src/app/_shared/ingredient.model";

export class ShoppingListService {

  ingredientsChanged = new EventEmitter<Ingredient[]>();

  private ingredients: Ingredient[] = [
    new Ingredient('apples', 5),
    new Ingredient('tomatoes', 10)
  ];

  getIngredients() {
    return this.ingredients.slice();
  }

  addIngredient(ingredient: Ingredient) {
    this.ingredients.push(ingredient);
    this.ingredientsChanged.emit(this.ingredients.slice())
  }

}
