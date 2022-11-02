import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { API_URL } from '../app.constants';

export const TOKEN = 'authenticatedToken';
export const AUTHENTICATED_USER =  'authenticatedUser';

@Injectable({
  providedIn: 'root'
})
export class BaseicAuthenticationService {

  constructor(
    private http: HttpClient
  ) { }

  executeJWTAuthenticationService(username: string, password: string): Observable<any> {
    return this.http.post<any>(`${API_URL}/authenticate`, {
              username,
              password
            })
              .pipe(
                map(
                  data => {
                    sessionStorage.setItem(AUTHENTICATED_USER, username);
                    sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
                    sessionStorage.setItem('testToken', data.token);
                    return data;
                  }
                )
              );
  }

  executeAuthenticationService(username: string, password: string): Observable<any> {
    let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader(username, password);

    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    });

    return this.http.get<AuthenticationBean>(`${API_URL}/basic-auth`, {headers})
              .pipe(
                map(
                  data => {
                    sessionStorage.setItem(AUTHENTICATED_USER, username);
                    sessionStorage.setItem(TOKEN, basicAuthHeaderString);
                    return data;
                  }
                )
                );
  }

  createBasicAuthenticationHttpHeader(username: string, password: string) {
    let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);
    return basicAuthHeaderString;
  }

  getAuthenticatedUser() {
    return sessionStorage.getItem(AUTHENTICATED_USER);
  }

  getAuthenticatedToken() {
    if(this.getAuthenticatedUser()) {
      return sessionStorage.getItem(TOKEN);
    }
    return null;
  }

  logout() {
    console.log('inside logout ')
    sessionStorage.removeItem(AUTHENTICATED_USER);
    sessionStorage.removeItem(TOKEN);
  }

}

export class AuthenticationBean {

  constructor(public message: string) {}

}
