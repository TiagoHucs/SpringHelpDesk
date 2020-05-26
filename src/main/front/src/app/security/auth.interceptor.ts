import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpEvent, HttpRequest, HttpResponse, HttpErrorResponse } from "@angular/common/http";
import { Observable } from "rxjs";
import { map, tap } from "rxjs/operators";
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {


    constructor(
        private cookieService: CookieService,
        private router: Router) { 
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>  {
        //console.log('interceptado: ('+ JSON.stringify(req.url) +')');
        let authRequest : any;
        let token = this.cookieService.get('token');
        if(token){
            authRequest = req.clone({
                setHeaders: {
                    'Authorization' : token
                }
            });

            return next.handle(authRequest)
                .pipe(tap(
                    (response: HttpEvent<any>) => {
                        //resposta sem erro                     
                    },
                    (error: HttpErrorResponse) => {
                        if(error.status == 401){
                            // se for erro de autenticação envia para o login
                            this.router.navigate(['login']);
                        }
                    },
                    () => {
                    //console.log("completed successfully"); // this runs when you don't get error
                                                            // same as "complete?" parameter of .subscribe
                    }
                ));

        } else {
            return next.handle(req);
        }
        
    }

}