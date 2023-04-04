import axios, { AxiosError } from 'axios'
import Alertify from "../components/alertify/Alertify";
import {useContext} from "react";
import { AuthContext } from '../store/authContext'

export const useAPI = () => {
    const auth = useContext(AuthContext);
	const BASE_URL = 'http://localhost:3000';

	const user = 'doug'
	const pass = '123'
	const basicAuth = 'Basic ' + btoa(user + ':' + pass)

    const authenticate = (): any => {
        const htmlConfig = {
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',
                Authorization: basicAuth,
            },
			auth: {
				username: 'doug',
				password: '123',
			}
        }

        return htmlConfig;
    }

    const handleHttpError = (error: AxiosError, action: {func: any, args: any}) => {
        Alertify.alert(error.message);
        throw error
    }
	
	//GET
	const get = async(url: string, params: any, headers?: any): Promise<any> => {
		try{
			const response = await axios.get(BASE_URL + url, { ...(headers ? headers : authenticate()), params });
			return response.data;
		}catch(e: any){
			return handleHttpError(e, {func: get, args: [url, params, headers]});
		}
	}
	
    return { get }
	//get, post, put, delete: _delete
}