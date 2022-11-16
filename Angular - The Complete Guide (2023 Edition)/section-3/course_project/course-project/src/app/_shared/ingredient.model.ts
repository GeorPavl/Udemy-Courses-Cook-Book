export class Ingredient {

  // Alternative way to declare a ts class (with 'public' is like we have normal fields)
  constructor(public name: string, public amount: number) {
    this.name = name;
    this.amount = amount;
  }
}
