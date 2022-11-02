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

    let token2 = sessionStorage.getItem('testToken');
    console.log(basicAuthHeaderString);
    console.log('t2 ' + token2);

    if (token2===null) {console.log('test')}
    else {
      const expiry = (JSON.parse(atob(token2.split('.')[1]))).exp;
      console.log(expiry);
      // console.log(expiry/86400000);
      
      console.log((Math.floor((new Date).getTime() / 1000)) >= expiry);
      console.log('kalo = ' + ((expiry - (Math.floor((new Date).getTime()))) <= 60000))

      if((Math.floor((new Date).getTime() / 1000)) >= expiry) {
        console.log('inside if');
        // this.basicAuthenticationService.logout();
        // this.router.navigate(['todos']);

        // this.http.get<any>(`${API_URL}/refresh`, {

        // })
        //   .pipe(
        //     map(
        //       data => {
        //         // sessionStorage.setItem(AUTHENTICATED_USER, username);
        //         console.log('inside map');
        //         console.log('T2 = ' + token2);
        //         sessionStorage.setItem('authenticatedToken', `Bearer ${data.token}`);
        //         sessionStorage.setItem('testToken', data.token);
        //         console.log(sessionStorage.getItem('authenticatedToken'));
        //         return data;
        //       }
        //     )
        //   );

          console.log(sessionStorage.getItem('authenticatedToken'));
      }
    }

    return next.handle(req);
  }

}
