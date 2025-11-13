import { useSearchParams } from "react-router-dom";
import { useEffect } from "react";
import { useDispatch } from "react-redux";
import { fetchExpenses } from "./Redux/Action";


function ExpenseFilter(user){
    const[searchParams]=useSearchParams();
    const dispatch=useDispatch();
    useEffect(()=>{

        const params=new URLSearchParams();
        const keyword = searchParams.get("keyword") || null;
        if (keyword) {
            params.set("keyword", keyword);
        }
        
        const queryString=params.toString();
         console.log("QUERY STRING", queryString);
        dispatch(fetchExpenses(queryString));
    },[searchParams])
    
}
export default ExpenseFilter;