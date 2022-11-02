import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { BaseicAuthenticationService } from './basic-authentication.service';
import { HardcodedAuthenticationService } from './hardcoded-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate{

  constructor(
    private router: Router, 
    private hardcodedAuthenticationService : HardcodedAuthenticationService,
    private basicAuthenticationService : BaseicAuthenticationService
    ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    // if (this.hardcodedAuthenticationService.isUserLoggedIn()===true) {
    //   return true;
    // }
    
    if (this.basicAuthenticationService.getAuthenticatedUser()) {
      return true;
    }

    this.router.navigate(['login']);
    return false;
  }
}
