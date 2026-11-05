import { Component } from '@angular/core';
import { MessageService } from '../../core/message.service';

@Component({
  selector: 'app-alert',
  imports: [],
  templateUrl: './alert.component.html',
  styleUrl: './alert.component.css'
})
export class AlertComponent {

  constructor(public messageService: MessageService) { }

}
