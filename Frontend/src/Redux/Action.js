import { callapi } from "../callapi/callapi";








export const fetchCategories=()=>async(dispatch)=>{
    try{ 
        const {data}=await callapi.get(`/public/category/fetch`)
        console.log(data);
        dispatch({
            type:"FETCH_CATEGORIES",
            payload:data,

        })
    }catch(error){
        
    }
}


export const fetchExpenses=()=>async(dispatch,getState)=>{
    try{
        const {data}=await callapi.get(`/public/expense/get`)
         console.log(data);
        dispatch({
            type:"FETCH_EXPENSES",
            payload:data,
        })
    }catch(error){

    }
}

export const addExpenses=(data)=>async(dispatch)=>{
    try{
        await callapi.post(`/public/expense/add/${1}`,data)
        dispatch(fetchExpenses());
    }catch(error){

    }
}

export const deleteExpense=(data)=>
    async(dispatch)=>{
        
        try{
            await callapi.delete(`/public/expense/remove/${data.id}`);
            dispatch(fetchExpenses());
        }catch(error){

        }
        
}


export const authenticateSignInUser=(sendData,toast,reset, navigate, setLoader)=>async(dispatch)=>{
    try{
        setLoader(true);
        const{data}=await callapi.post("/auth/SignIn",sendData);
         dispatch({ type: "LOGIN_USER", payload: data });
        localStorage.setItem("auth", JSON.stringify(data));
        reset();
            toast.success("Login Success");
            navigate("/");
        } catch (error) {
            console.log(error);
            toast.error(error?.response?.data?.message || "Internal Server Error");
        } finally {
            setLoader(false);
        }
}

export const SignUpUser=(sendData,toast,reset,navigate,setLoader)=>async(dispatch)=>{
    try{
        setLoader(true);
        const{data}=await callapi.post("/auth/SignUp",sendData);
        reset();
        toast.success("User Registered Successfully");
        navigate("/login");
    }catch(error){
        console.log(error);
        toast.error(error?.response?.data?.message || "Internal Servor Error");
    }finally{
        setLoader(false);
    }
}
export const Logoutuser=(navigate)=>(dispatch)=>{
        dispatch({
            type:"LOGOUT_USER"
        })
        localStorage.removeItem("auth")
        navigate("/login");
        toast.success("You have successfully loggedOut");
   
}


