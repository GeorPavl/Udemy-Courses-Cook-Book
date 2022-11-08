import { HttpClient, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { BaseicAuthenticationService } from '../basic-authentication.service';
import { API_URL } from '../../app.constants';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterBasicAuthServiceService implements HttpInterceptor{

  constructor(
    private http: HttpClient,
    private router: Router,
    private basicAuthenticationService: BaseicAuthenticationService
  ) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let basicAuthHeaderString = this.basicAuthenticationService.getAuthenticatedToken();
    let username = this.basicAuthenticationService.getAuthenticatedUser();

    if (basicAuthHeaderString && username) {
      req = req.clone({
        setHeaders: {
          Authorization : basicAuthHeaderString
        }
      });
    }

    let token = sessionStorage.getItem('testToken');

    if (token===null) {
      console.log('No Token stored!');
    }
    else {
      const expiry = (JSON.parse(atob(token.split('.')[1]))).exp;

      if((Math.floor((new Date).getTime() / 1000)) >= expiry) {
        this.basicAuthenticationService.logout();
        this.router.navigate(['todos']);
      }
    }

    return next.handle(req);
  }

}
