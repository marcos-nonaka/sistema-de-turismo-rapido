import { createContext } from 'react'
import { getUserLocalStorage } from './util'

export type User = {
	user_id: string
	name: string
	username: string
	mail: string
	phone: string
	birthdate: string
	token: string
	role: string
}

export type AuthType = {
  user?: User
  updateUser?(username: User | undefined): void
}

const initialValue: AuthType = {}

export const AuthContext = createContext(initialValue)