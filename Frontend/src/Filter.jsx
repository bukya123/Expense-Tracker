import { Button, FormControl, InputLabel, MenuItem, Select, Tooltip } from "@mui/material";
import { FiRefreshCw } from "react-icons/fi";
import { useDispatch, useSelector } from "react-redux";
import { useLocation, useNavigate, useSearchParams } from "react-router-dom";
import { fetchCategories } from "./Redux/Action";
import { useEffect, useState } from "react";
import { FaSearch } from "react-icons/fa";



function Filter(){
   
    const {categories}=useSelector(
        (state)=>state.categories
    )
    const dispatch=useDispatch();

     useEffect(()=>{
        dispatch(fetchCategories())
    },[dispatch])

    console.log(categories);
   

    const[searchParams,setSearchParams]=useSearchParams();
    const params=new URLSearchParams(searchParams); //with this we can easily get,set the query parameters.
    const path =useLocation().pathname;
    const navigate=useNavigate();
    

     const[category,setCategory]=useState("All");
    const [searchTerm, setSearchTerm] = useState("");


    

    useEffect(()=>{
        const currentCategory = searchParams.get("category") || "all";
        const currentSearchTerm = searchParams.get("keyword") || "";

        setCategory(currentCategory);
        setSearchTerm(currentSearchTerm);
    },[searchParams])
    
     useEffect(() => { 
        const handler = setTimeout(() => {
            if (searchTerm) {
                searchParams.set("keyword", searchTerm);
            } else {
                searchParams.delete("keyword");
            }
            navigate(`${path}?${searchParams.toString()}`);
        }, 700);

        return () => {
            clearTimeout(handler);
        };
    }, [searchParams, searchTerm, navigate, path]);

    
    function handleCategoryChange(e){
        const selectedCategory=e.target.value;
        if(selectedCategory==="all"){
            params.delete("category")
        }else{
            params.set("category",e.target.value);
        }
        navigate(`${path}?${params}`);
    }

    

    function handleClearFilterChange(){
        setSearchParams({});
       
    }
    return (
        <div className="flex lg:flex-row flex-col-reverse lg:justify-between justify-center items-center gap-4 m-10">
            <div className="flex relative items-center 2xl:w-[450px] sm:w-[420px] w-full">
                
                <input type="text" placeholder="Search Expenses with categories" 
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                className="border border-gray-400 text-slate-800 rounded-md pl-8 py-2 w-2xs focus:outline-hidden focus:ring-2 focus:ring-[#1976d2]"/>
                <FaSearch className="absolute left-3 text-slate-800 size={20}"/>
            </div>
            <div className="flex sm:flex-row flex-col gap-4 items-center">
                 <div className="m-2">
                <FormControl>
                    <InputLabel id="demo-simple-select-label">Category</InputLabel>
                    <Select
                        labelId="demo-simple-select-label"
                        value={category}
                        label="Category"
                        onChange={handleCategoryChange}
                    >
                        <MenuItem value="all">All</MenuItem>
                        {  
                         
                           (categories &&
                            categories.map((item)=>{
                                return (<MenuItem value={item.categoryName}>{item.categoryName}</MenuItem>)
                            }))
                        }
                    </Select>
                </FormControl>
               </div>


                <div>
                    <Button variant="contained" color="error"onClick={handleClearFilterChange}>
                        <FiRefreshCw/>
                        Clear Filters</Button>
                </div>
            </div>
        
        </div>
           
        
    )

}
export default Filter;