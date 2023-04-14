import { Component } from '@angular/core';
import { User } from '../model/User';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  user: User | undefined;

  constructor(private userService: UserService){}


  ngOnInit(): void {
    this.userService.getLoggedInUser().subscribe({
      next: (user) => {
        console.log("sucess!");
        console.log(user);
        this.user = user;
      }, 
      error: (error) => {
        console.log("error");
        console.error(error);
      }
    });
  }
}
