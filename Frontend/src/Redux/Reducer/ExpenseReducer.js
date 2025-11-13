const initialState={
    expenses:null,
}

function ExpenseReducer(state=initialState,action){
    switch (action.type) {
        case "FETCH_EXPENSES":
            return{
                ...state,
                expenses:action.payload
            }
         
        default:
            return state;
    }
}
export default ExpenseReducer;