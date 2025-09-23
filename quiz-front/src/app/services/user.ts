import { computed, inject, Injectable, Signal, signal } from "@angular/core";
import { Router } from "@angular/router";

@Injectable({
    providedIn: "root"
})
export class User {
    router = inject(Router)
    username = signal(localStorage.getItem("username"))
    validUsername = computed(() => (this.username()?.trim().length ?? 0) > 0)
    
    redirectIfNeeded() {
        if (this.validUsername()) {
            localStorage.setItem("username", this.username()!)
            this.router.navigate(["random"])
        }
    }
}