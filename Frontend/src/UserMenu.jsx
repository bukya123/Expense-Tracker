import { Backdrop, Menu, MenuItem } from "@mui/material";
import { useState } from "react";
import { FaRegUser, FaUser } from "react-icons/fa";
import { IoLogOut } from "react-icons/io5";
import { useDispatch, useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import { Logoutuser } from "./Redux/Action";


function UserMenu(){
    const [anchorEl, setAnchorEl] = useState(null);
    const open = Boolean(anchorEl);
    const {user}=useSelector((state)=>state.auth);
    const dispatch=useDispatch();
    const navigate=useNavigate();
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };

  const handleLogoutUser=()=>{
    dispatch(Logoutuser(navigate))
  }

  return (
    <div>
      
      <FaUser aria-controls={open ? 'basic-menu' : undefined} aria-haspopup="true"  aria-expanded={open ? 'true' : undefined} onClick={handleClick} size={25}/>
      <Menu
        id="basic-menu"
        anchorEl={anchorEl}
        open={open}
        onClose={handleClose}
        slotProps={{
          list: {
            'aria-labelledby': 'basic-button',
          },
        }}
      >
        <Link to="/profile">
            <MenuItem onClick={handleClose} className='flex gap-2 items-center'>
                <FaRegUser size={15}/>
                <span>{user.username}</span> 
            </MenuItem>
        </Link>


        
        <MenuItem onClick={handleLogoutUser} className='flex gap-2 items-center'>
        <IoLogOut size={20}/>
        <span>Logout</span>
        </MenuItem>
        
      </Menu>
        {open && <Backdrop data={open}/>}
    </div>

  );
}
export default UserMenu;