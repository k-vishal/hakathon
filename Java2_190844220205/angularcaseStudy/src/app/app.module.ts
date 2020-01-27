import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { RouterModule } from '@angular/router';
import {NgModel, FormsModule, NgForm} from '@angular/forms';
import { AuthService } from './auth.service';
import { HttpClientModule } from '@angular/common/http';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { CheckbookavailabilityComponent } from './checkbookavailability/checkbookavailability.component';
import { AddnewbookComponent } from './addnewbook/addnewbook.component';
import { ReturnbookComponent } from './returnbook/returnbook.component';
import { AddnewcopyComponent } from './addnewcopy/addnewcopy.component';
import { IssuebookComponent } from './issuebook/issuebook.component';
import { ListofissuedbookComponent } from './listofissuedbook/listofissuedbook.component';
import { AddnewmemberComponent } from './addnewmember/addnewmember.component';
import { TakepaymentComponent } from './takepayment/takepayment.component';
import { PaymenthistoryComponent } from './paymenthistory/paymenthistory.component';
import { ListofallusersComponent } from './listofallusers/listofallusers.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    EditprofileComponent,
    ChangepasswordComponent,
    CheckbookavailabilityComponent,
    AddnewbookComponent,
    ReturnbookComponent,
    AddnewcopyComponent,
    IssuebookComponent,
    ListofissuedbookComponent,
    AddnewmemberComponent,
    TakepaymentComponent,
    PaymenthistoryComponent,
    ListofallusersComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot([
          { path:"", component: LoginComponent},
      {path:"login",component: LoginComponent},
      {path:"home",component: HomeComponent},
      {path:"signup",component: SignupComponent},
      {path:"editprofile",component: EditprofileComponent},
      {path:"changepassword",component: ChangepasswordComponent},
      {path:"checkbookavailability",component: CheckbookavailabilityComponent},
      {path:"addnewbook",component: AddnewbookComponent},
      {path:"addnewcopy",component: AddnewcopyComponent},
      {path:"returnbook",component: ReturnbookComponent},
      {path:"issuebook",component: IssuebookComponent},
      {path:"listofissuedbook",component: ListofissuedbookComponent},
      {path:"addnewmember",component: AddnewmemberComponent},
      {path:"takepayment",component: TakepaymentComponent},
      {path:"paymenthistory",component: PaymenthistoryComponent},
      {path:"listofallusers",component: ListofallusersComponent}

    ])
  ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule { }
