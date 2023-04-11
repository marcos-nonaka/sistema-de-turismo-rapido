//import React, {useState} from 'react'
import React, { useState, useContext } from 'react'
import { AuthContext, User } from './store/authContext'
import { Navigate, BrowserRouter, Route, Routes } from 'react-router-dom'
import { setUserLocalStorage, getUserLocalStorage } from './store/util'
import {
	Home,  
	About,
	Contact,
	Login,
	Signup,
	Logout,
	//Itinerary,
	Dashboard,
	ItinerarySearch,
	Result,
	Profile,
	Booking,
} from './pages'

const RequireAuth = ({ children }: { children: any }) => {
	const session = getUserLocalStorage()
	const auth = useContext(AuthContext)
	console.log('Session: ')
	console.log(session)
	if(!session){
	//if(!auth.user) {
		return <Navigate to='/login' />
	}

	return children
}

function App() {
  const [user, setUser] = useState<User>();

  return (
	<AuthContext.Provider value={{user, updateUser: setUser}}>
		<BrowserRouter>
			<Routes>
				<Route path='/' element={<Home />} />
				<Route path='/quem-somos' element={<About />} />
				<Route path='/fale-conosco' element={<Contact />} />
				<Route path='/login' element={<Login />} />
				<Route path='/logout' element={<Logout />} />
				<Route path='/cadastre-se' element={<Signup />} />				
				<Route path='/dashboard' element={<RequireAuth><Dashboard /></RequireAuth>}></Route>
				<Route path={'pesquisar-roteiro'} element={<RequireAuth><ItinerarySearch /></RequireAuth>}></Route>
				<Route path={'detalhes'} element={<RequireAuth><Result /></RequireAuth>}></Route>
				<Route path='/me/profile' element={<RequireAuth><Profile /></RequireAuth>}></Route>
				<Route path='/me/booking' element={<RequireAuth><Booking /></RequireAuth>}></Route>
			</Routes>
		</BrowserRouter>
	</AuthContext.Provider>

  )
}

export default App
