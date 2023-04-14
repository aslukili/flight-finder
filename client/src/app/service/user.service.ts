import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) { }


  getLoggedInUser(): Observable<User> {
    return this.http.get<User>(this.apiUrl+'/users/profile');
  }
}