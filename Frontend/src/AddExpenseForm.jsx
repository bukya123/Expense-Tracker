import { useState } from "react";
import { useForm } from "react-hook-form"
import { useDispatch } from "react-redux";
import Spinners from "./Spinners";
import { FaAddressBook } from "react-icons/fa";
import InputField from "./InputField";
import { addExpenses } from "./Redux/Action";


function AddExpenseForm({setOpen}){
    const [loader,setLoader]=useState(false);
    const dispatch=useDispatch();
     const {
            register,
            handleSubmit,
            reset,
            setValue,
            formState: {errors},
        } = useForm({
            mode: "onTouched",
        }); 

    const saveAddress = async (data) => {
       dispatch(addExpenses(data))
       setOpen(false)
    };
    // useEffect(() => {
    //         if (selectedAddress?.addressId) {
    //             setValue("buildingName", selectedAddress?.buildingName);
    //             setValue("city", selectedAddress?.city);
    //             setValue("street", selectedAddress?.street);
    //             setValue("state", selectedAddress?.state);
    //             setValue("pincode", selectedAddress?.pincode);
    //             setValue("country", selectedAddress?.country);
    //         }
    //     }, [selectedAddress]);

    return (
        <div className="m-30">
            <form
                onSubmit={handleSubmit(saveAddress)}
                className="">
                    <div className="flex flex-col items-center justify-center space-y-4">
                        <FaAddressBook className="text-slate-800 text-3xl"/>
                       
                        
                    </div>
            <hr className="mt-2 mb-5 text-black" />
            <div className="flex flex-col gap-3">
                <InputField
                    label="Amount"
                    required
                    id="amount"
                    type="number"
                    message="*amount is required"
                    placeholder="Enter amount"
                    register={register}
                    errors={errors}
                    />

                <InputField
                    label="CategoryName"
                    required
                    id="categoryName"
                    type="text"
                    message="*category is required"
                    placeholder="category"
                    register={register}
                    errors={errors}
                    />
                {/* <InputField
                    label="City"
                    required
                    id="city"
                    //id is picked as key value in requestbody
                    type="text"
                    message="*City is required"
                    placeholder="Enter your city"
                    register={register}
                    errors={errors}
                    /> */}
                
            </div>

            <button
                disabled={loader}
                className="bg-blue-500 flex gap-2 items-center justify-center font-semibold text-white w-full py-2 hover:text-slate-400 transition-colors duration-100 rounded-xs my-3"
                type="submit">
                {loader ? (
                    <>
                    <Spinners /> Loading...
                    </>
                ) : (
                    <>Save</>
                )}
            </button>

            </form>
        </div>
    )
    
}
export default AddExpenseForm;