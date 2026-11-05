import { Component, Input } from '@angular/core';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-message',
  imports: [],
  templateUrl: './message.component.html',
  styleUrl: './message.component.css'
})
export class MessageComponent {

  @Input() control!: NgModel;
  @Input() error!: string;
  @Input() text!: string;

  hasError(): boolean {
    return this.control.hasError(this.error) && !!this.control.touched;
  }

}
