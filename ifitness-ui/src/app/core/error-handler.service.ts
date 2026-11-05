import { Injectable } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlerService {

  constructor(private messageService: MessageService) { }

  handle(errorResponse: any): void {
    let messages: string[];

    if (typeof errorResponse === 'string') {
      messages = [errorResponse];
    } else if (errorResponse instanceof HttpErrorResponse
      && errorResponse.status >= 400 && errorResponse.status <= 499) {
      messages = this.getApiMessages(errorResponse);
    } else {
      messages = ['Erro ao processar serviço remoto. Tente novamente.'];
    }

    console.error('Ocorreu um erro', errorResponse);
    this.messageService.error(messages);
  }

  private getApiMessages(errorResponse: HttpErrorResponse): string[] {
    // erros de validação e de regras de negócio: a API devolve uma lista
    if (Array.isArray(errorResponse.error)) {
      return errorResponse.error.map((error: any) => error.userMessage);
    }
    // mensagem inválida: a API devolve um único objeto
    if (errorResponse.error?.userMessage) {
      return [errorResponse.error.userMessage];
    }
    return ['Ocorreu um erro ao processar a sua solicitação'];
  }

}
