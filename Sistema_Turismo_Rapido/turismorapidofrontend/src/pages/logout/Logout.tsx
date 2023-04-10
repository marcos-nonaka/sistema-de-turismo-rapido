import React, {useEffect, useContext, useState} from 'react'
import { setUserLocalStorage, getUserLocalStorage } from '../../store/util'
import { Navigate } from 'react-router-dom'

function Logout(){
	setUserLocalStorage(null)
	
	return <Navigate to='/login' />

}

export default Logout