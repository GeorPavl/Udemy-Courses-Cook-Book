import { HttpBackend, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  message: String = 'Some Welcome Message';
  name: String = '';
  welcomeMessageFromService: string = '';

  constructor(
    private route: ActivatedRoute,
    private service: WelcomeDataService
  ) { }

  ngOnInit(): void {
    this.name = this.route.snapshot.params['name'];
  }

  getWelcomeMessage() {
    this.service.executeHelloWorldBeanService().subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }

  getWelcomeMessageWithParameter() {
    this.service.executeHelloWorldBeanServiceWithPathVariable(this.name).subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }

  handleSuccessfulResponse(response: any) {
    this.welcomeMessageFromService = response.message;
  }

  handleErrorResponse(error: HttpErrorResponse) {
    this.welcomeMessageFromService = error.error.message;
  }
}
