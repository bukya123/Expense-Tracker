import { useState } from "react";
import AddExpenseForm from "./AddExpenseForm";



function AddExpense(){
    const[open,setOpen]=useState(false);

    function handleopen(){
        setOpen(true);
    }
    return(
        <div>
            {

            !open ?(
               <button onClick={handleopen}
                className="bg-blue-500 px-2 py-2 rounded"
               > Add Expense</button>
            ):(
                <AddExpenseForm setOpen={setOpen}/>
            )
        }
        
        </div>
        
    )
}
export default AddExpense;