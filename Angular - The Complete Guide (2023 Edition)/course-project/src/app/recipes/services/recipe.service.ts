import { Recipe } from "../recipe.module";

export class RecipeService {

  private recipes: Recipe[] = [
    new Recipe('A Test Recipe', 'This is a siple test', 'https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chorizo-mozarella-gnocchi-bake-cropped-9ab73a3.jpg'),
    new Recipe('Something', 'Be Quite!', 'https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/101ad363237205.5aa9feaddf1f7.gif')
  ];

  getRecipes() {
    // with .slice() you get a copy of the array
    return this.recipes.slice();
  }

}
