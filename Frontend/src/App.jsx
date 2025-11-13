import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { BrowserRouter as Router,Routes,Route, BrowserRouter } from 'react-router-dom'
import Navbar from './Navbar'
import { Toaster } from 'react-hot-toast'
import Expense from './Expense'
import Login from './Auth/Login'
import SignUp from './Auth/SignUp'
import PieCharts from './PieCharts'
import AboutPage from './AboutPage'
import ContactPage from './ContactPage'
function App() {

  return (
    <>
      <Router>
    <Navbar/>
    <Routes>
      <Route path='/Expense' element={<Expense/>}/>
      <Route path="/login" element={<Login/>}/>
      <Route path="/SignUp" element={<SignUp/>}/>
      <Route path='/' element={<PieCharts/>}/>
      <Route path='/about' element={<AboutPage/>}/>
      <Route path="/contact" element={<ContactPage/>}/>
    </Routes>
  </Router>
  <Toaster position='bottom-center'/>
    </>
  )
}

export default App
