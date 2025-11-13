import { HiOutlineTrash } from "react-icons/hi";
import { useDispatch } from "react-redux";
import { deleteExpense } from "./Redux/Action";


function ExpenseCard({item}){
    const dispatch=useDispatch();

    function handleRemoveChange(){
        dispatch(deleteExpense(item))
    }
    return (
        <div className="grid md:grid-cols-5 grid-cols-4 gap-4 my-5 py-2 px-10 font-semibold  border-2 border-gray-300 mx-5">
            <div className="w-30 col-span-2">
                <div className="pb-2">
                    {item.categoryName}
                </div>
            </div>

            
            <div className="justify-center place-self-center">
                {item.amount}
            </div>

            <div className="place-self-center">
                 <button onClick={handleRemoveChange}
                        className="flex items-center font-semibold space-x-2 px-4 py-1 text-xs border border-rose-600 text-rose-600 rounded-md hover:bg-red-50 transition-colors duration-200">
                        <HiOutlineTrash size={16} className="text-rose-600"/>
                        Remove
                    </button>
            </div>
            
        </div>
    )
}
export default ExpenseCard;