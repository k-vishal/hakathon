import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';  
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate {

   url = 'http://localhost:8080/hackathon_lab/librarian';

  constructor(private router: Router,  email = '', password = '')
     { }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    // check if user has logged in
    if (sessionStorage['login_status'] == '1') {
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }
  login(email: string, password: string) {
    const body = {
      email: email,
      password: password
    };

    const headers = new Headers({'Content-Type': 'application/json'});
    const requestOptions = new requestOptions({headers: headers});

    return this.http.post(this.url + '/librarian/login', body, requestOptions);

  } 

}
