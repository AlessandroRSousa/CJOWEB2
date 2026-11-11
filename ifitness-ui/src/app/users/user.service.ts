import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';

import { User } from '../core/model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  usersUrl = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) { }

  async add(user: User): Promise<User> {
    const body = User.toJson(user);
    return await firstValueFrom(this.http.post<User>(this.usersUrl, body));
  }

  async findById(id: number): Promise<User> {
    return await firstValueFrom(this.http.get<User>(`${this.usersUrl}/${id}`));
  }

}