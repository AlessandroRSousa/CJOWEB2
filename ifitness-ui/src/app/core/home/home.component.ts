import { Component, OnInit } from '@angular/core';

import { User } from '../model';
import { AuthService } from '../../security/auth.service';
import { UserService } from '../../users/user.service';
import { ErrorHandlerService } from '../error-handler.service';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  user?: User;

  constructor(
    public auth: AuthService,
    private userService: UserService,
    private errorHandler: ErrorHandlerService
  ) { }

  // executado quando a página é aberta
  ngOnInit(): void {
    this.userService.findById(this.auth.jwtPayload.user_id)
      .then(user => this.user = user)
      .catch(response => this.errorHandler.handle(response));
  }

}
