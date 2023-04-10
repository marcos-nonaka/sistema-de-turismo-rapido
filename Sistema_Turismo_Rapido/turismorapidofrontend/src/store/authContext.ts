import { createContext } from 'react'
import { getUserLocalStorage } from './util'

export type User = {
  //name: string
  username: string
  //user_id: number
  token: string
  //roles: { authority: string }[]
}

export type AuthType = {
  user?: User
  updateUser?(username: User | undefined): void
}

const initialValue: AuthType = {}

export const AuthContext = createContext(initialValue)