import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class RequestService {
  protected BASE_URL: string = environment.baseUrl;

  constructor() { }
}
