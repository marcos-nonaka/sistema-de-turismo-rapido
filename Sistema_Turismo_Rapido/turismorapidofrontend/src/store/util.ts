//import axios from 'axios'
//import { Api } from '../services/api'
//import { IUser } from './types'

export interface user{
	email?: string;
	token?: string;
}

export function setUserLocalStorage(user: user | null){
	localStorage.setItem('u', JSON.stringify(user))
	
}
export function getUserLocalStorage(){
	const json = localStorage.getItem('u')
	
	if(!json){
		return null
	}
	
	const user = JSON.parse(json)
	
	return user ?? null
}
/*
export async function LoginRequest(email: string, password: string){
		
	const data = JSON.stringify({
	  //"email": "eve.holt@reqres.in",
	  //"password": "cityslicka"
	  "email": email,
	  "password": password
	});

	try{
		const request = await axios.post('https://reqres.in/api/login', data, {
		  headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		  }
		});

		return request.data
		//console.log(request)

		//const request = await Api.post('login', {email, password})
		//return request.data
	}catch(error){
		return null
	}
}*/