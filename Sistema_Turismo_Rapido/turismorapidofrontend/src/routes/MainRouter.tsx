import React, { useContext } from 'react'
import { Navigate, Outlet, Route, Routes } from 'react-router-dom'
import {
	NotFound,
	Home,  
	About,
	Contact,
	Login,
	Signup,
	//Itinerary,
	Dashboard,
	ItinerarySearch,
	Result,
	Profile,
	Booking,
} from '../pages'
import { AuthContext } from '../store/authContext'

const RequireAuth = ({ children }: { children: any }) => {
  const auth = useContext(AuthContext)

  if (!auth.user) {
    return <Navigate to='/login' />
  }

  return children
}

const MainRouter = () => {
  return (
    <Routes>
      <Route element={<Outlet />} errorElement={<NotFound />}>
        <Route path='/' element={<Home />} />
		<Route path='/quem-somos' element={<About />} />
		<Route path='/fale-conosco' element={<Contact />} />
        <Route path='/login' element={<Login />} />
		<Route path='/cadastre-se' element={<Signup />} />
		<Route path='/me/profile' element={<Profile />} />
		<Route path='/me/booking' element={<Booking />} />
		<Route path='/pesquisar-roteiro' element={<ItinerarySearch />} />
        <Route
          path=''
          errorElement={<NotFound />}
          element={
            <RequireAuth>
            </RequireAuth>
          }
        >
		 <Route path={'dashboard'} element={<Dashboard />} />
		  {/*<Route path={'pesquisar-roteiro'} element={<ItinerarySearch />} />*/}
		  <Route path={'roteiro'} element={<Result />} />
        </Route>
      </Route>
    </Routes>
  )
}

export default MainRouter
