import React, { useContext } from 'react'
//import { Navigate, Outlet, Route, Routes } from 'react-router-dom'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import {
	NotFound,
	Home,
	About,
	Contact,
	Itinerary,
	Result,
	Login,
	Signup,
} from '../pages'



const MainRouter = () => {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<Home />} />
		<Route path='/quem-somos' element={<About />} />
		<Route path='/pesquisar-roteiro' element={<Itinerary />} />
		<Route path='/fale-conosco' element={<Contact />} />
		<Route path='/roteiro' element={<Result />} />
		<Route path='/login' element={<Login />} />
		<Route path='/cadastre-se' element={<Signup />} />
      </Routes>
    </Router>
  )
}

export default MainRouter