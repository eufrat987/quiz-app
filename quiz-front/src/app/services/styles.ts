import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class Styles {
    
    get buttonStyleClasses() : string {
        return `bg-amber-500 hover:bg-amber-400 active:bg-amber-300  dark:text-amber-500 text-amber-900
                dark:bg-amber-900  dark:hover:bg-amber-800  active:dark:bg-amber-700 
                p-3 rounded-2xl w-sm m-auto disabled:cursor-not-allowed
                dark:disabled:bg-gray-500 dark:disabled:hover:bg-gray-500 dark:disabled:active:bg-gray-500
                disabled:bg-gray-200 disabled:hover:bg-gray-200 disabled:active:bg-gray-200`;
    }
    
    get formStyleClasses() : string {
        return "shadow m-auto my-3 p-3 text-center bg-inherit rounded max-w-7xl" ;  
    }

    get formGroupStyleClasses() : string {
        return "text-center  m-3 max-w-3xl rounded py-3 shadow text-amber-900 dark:text-amber-300"
    }

    get secondaryColorStyleClasses() : string {
        return "bg-blue-100 dark:bg-blue-800"
    }

    get primaryTextColorStyleClasses() : string {
        return "dark:text-amber-500 text-amber-900"
    }
    
}
