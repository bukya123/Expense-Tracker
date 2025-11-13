
import { useDispatch, useSelector } from "react-redux";
import Filter from "./Filter";
import { useEffect } from "react";
import { fetchExpenses } from "./Redux/Action";
import ExpenseFilter from "./ExpenseFilter";
import ExpenseCard from "./ExpenseCard";
import AddExpense from "./AddExpense";

function Expense(){
   
    const {expenses}=useSelector(
        (state)=>state.expenses
    )
    const {user}=useSelector(
        (state)=>state.auth
    )
    const dispatch=useDispatch();
    ExpenseFilter();

    let sum=0;
     expenses && expenses.map((item)=>{
        sum+=(item.amount)
    })

    function handleAddChange(){
        
    }
    return(
        <div> 
            <Filter/>
            <AddExpense />
            <div>
                {   
                    (expenses && expenses.map((item)=>{
                    
                    return <ExpenseCard item={item}/>
                }) )

                }
            </div>
            <div className="flex gap-2">
                <div>
                    Total expenses
                </div>
                <div>
                    {sum}
                </div> 
            </div>
        </div>
        
    )
}
export default Expense;