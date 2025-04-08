import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OtpService {

  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  sendOtp(email: string): Observable<any> {
    const params = new HttpParams().set('email', email);
    return this.http.post<any>(`${this.apiUrl}/send`, {}, { params });
  }
  
  verifyOtp(email: string, code: string): Observable<any> {
    const params = new HttpParams().set('email', email).set('code', code);
    return this.http.post<any>(`${this.apiUrl}/verify`, {}, { params });
  }
}
