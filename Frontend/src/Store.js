import { configureStore } from "@reduxjs/toolkit";
import CategoryReducer from "./Redux/Reducer/CategoryReducer";
import ExpenseReducer from "./Redux/Reducer/ExpenseReducer";
import AuthReducer from "./Redux/Reducer/AuthReducer";


const user = localStorage.getItem("auth")
    ? JSON.parse(localStorage.getItem("auth"))
    : null;


const initialCart={
     auth: { user: user},
}

const Store=configureStore({
    reducer:{
        categories:CategoryReducer,
        expenses:ExpenseReducer,
        auth:AuthReducer
    },
    preloadedState:initialCart,
})

export default Store;