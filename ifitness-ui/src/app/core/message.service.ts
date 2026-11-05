import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  type = 'success';
  messages: string[] = [];

  success(message: string): void {
    this.type = 'success';
    this.messages = [message];
  }

  error(messages: string[]): void {
    this.type = 'danger';
    this.messages = messages;
  }

  clear(): void {
    this.messages = [];
  }

}
