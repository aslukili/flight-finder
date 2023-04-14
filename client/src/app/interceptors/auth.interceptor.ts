import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { AuthService } from '../service/auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  private readonly apiUrl = environment.apiUrl;

  constructor(private authService: AuthService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (request.url.includes(`${this.apiUrl}/auth/login`)){ return next.handle(request); }
    if (request.url.includes(`${this.apiUrl}/auth/register`)){ return next.handle(request); }

    this.authService.loadToken();
    const token = this.authService.getToken();
    const goRequest = request.clone({ setHeaders: {Authorization: `Bearer ${token}`}})
    return next.handle(goRequest)
  }
}
