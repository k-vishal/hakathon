import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  message;
  email = '';
  password = '';
  constructor(private router:Router,private service: AuthService) { }

  ngOnInit() {
  
  }
  
  SignIn(loginForm)
  {
    let loginCredentials = loginForm.form.value;
    console.log(loginCredentials);

  }
}


  /*SignIn(loginForm)
  {
    let loginCredentials = loginForm.form.value;
    console.log(loginCredentials);

    let isUserValid= this.service.CheckCredentialsWithDB(loginCredentials);
    if(isUserValid)
    {
      console.log("User Is Valid");
      
      this.router.navigate(['/home']); 
    }
    else{
      this.message = "User Name / Password is Invalid!";
    }
  }
}
*/




