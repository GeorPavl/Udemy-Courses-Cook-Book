import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BaseicAuthenticationService } from '../service/basic-authentication.service';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = ''
  password: string = ''
  errorMessage: String = 'Invalid Credentials'
  invalidCredentials: Boolean = false

  constructor(
    private router: Router, 
    private hardCodedAuthenticationService: HardcodedAuthenticationService,
    private basicAuthenticationService: BaseicAuthenticationService
  ) { }

  ngOnInit(): void {
    console.log("ngOnInit() is running!")
  }

  handleLogin(): void {
    if(this.hardCodedAuthenticationService.authenticate(this.username, this.password)===true) {
      this.router.navigate(['welcome', this.username]);
      this.invalidCredentials = false;
    } else {
      this.invalidCredentials = true;
    }
  }

  handleBasicLogin(): void {

    this.basicAuthenticationService.executeAuthenticationService(this.username, this.password)
        .subscribe(
          {
            next: (v) => this.router.navigate(['welcome', this.username]),
            error: (e) => {
              this.invalidCredentials = true;
              console.error(e)
            },
            complete: () => {
              this.invalidCredentials = false;
              this.router.navigate(['welcome', this.username]);
            }
          }
        )
        
  }

  handleJWTLogin(): void {

    this.basicAuthenticationService.executeJWTAuthenticationService(this.username, this.password)
        .subscribe(
          {
            next: (v) => this.router.navigate(['welcome', this.username]),
            error: (e) => {
              this.invalidCredentials = true;
              console.error(e)
            },
            complete: () => {
              this.invalidCredentials = false;
              this.router.navigate(['welcome', this.username]);
            }
          }
        )
        
  }
  
}
