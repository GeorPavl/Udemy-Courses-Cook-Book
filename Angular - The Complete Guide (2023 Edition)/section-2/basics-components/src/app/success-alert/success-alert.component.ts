import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-success-alert',
  templateUrl: './success-alert.component.html',
  styleUrls: ['./success-alert.component.css']
})
export class SuccessAlertComponent implements OnInit {

  serverId = 10156;
  serverStatus = 'offline'

  constructor() { }

  ngOnInit(): void {
  }

  getServerStatus() {
    return this.serverStatus;
  }

}
