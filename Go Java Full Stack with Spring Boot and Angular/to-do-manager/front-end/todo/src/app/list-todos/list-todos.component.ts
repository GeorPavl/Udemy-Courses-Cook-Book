import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TodoDataService } from '../service/data/todo-data.service';

export class Todo {

  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date
  ) {

  }
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  // todos = [
  //   new Todo(1, 'Learn to Dance', false, new Date()),
  //   new Todo(2, 'Become an Expert at Angular', false, new Date()),
  //   new Todo(3, 'Visit India', true, new Date())

  //   // {id: 1, description: 'Learn to Dance'},
  //   // {id: 2, description: 'Become an Expert at Angular'},
  //   // {id: 3, description: 'Visit India'}
  // ]

  // todo = {
  //   id: 1,
  //   description: 'Learn to Dance'
  // }

  todos: Todo[];

  message: string;

  constructor(
    private service: TodoDataService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.refreshTodos();
  }

  deleteTodo(id: number) {
    this.service.deleteTodo('geor', id).subscribe(
      response => {
        this.message = `Delete of Todo ${id} Successfull!`;
        this.refreshTodos();
      }
    )
  }

  refreshTodos() {
    this.service.retrieveAllTodos('geor').subscribe(
      response => {
        this.todos = response;
      }
    );
  }

  updateTodo(id: number) {
    this.router.navigate(['todos', id]);
  }

  addTodo() {
    this.router.navigate(['todos', -1]);
  }

}
