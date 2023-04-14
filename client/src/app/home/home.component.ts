import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = 'travelplanner';

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }
  ngOnInit(): void {
    if(this.authService.isUserLoggedIn()){
      this.router.navigateByUrl('/home'); 
    }else{
        this.router.navigateByUrl('/login');
    }
  }

}