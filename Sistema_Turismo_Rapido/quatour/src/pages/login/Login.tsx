import React, {useEffect, useContext, useState} from 'react'
//import axios, { AxiosError } from 'axios'
import axios from 'axios'
import { Navbar, Footer } from '../../components'
import { useTranslation } from 'react-i18next'
import { useAPI } from '../../data/API'
import {AuthContext} from '../../store/authContext';
import {Navigate, useNavigate} from 'react-router-dom';
import Alertify from '../../components/alertify/Alertify'
import { setUserLocalStorage, getUserLocalStorage } from '../../store/util'
import { ReactComponent as Loader } from '../../assets/img/loader.svg'
import LogoQuatour from '../../assets/img/logo-icon.svg'

type LoginData = {
  email: string;
  password: string;
}


function Login(){
	const auth = useContext(AuthContext);
	const navigate = useNavigate();
	const { t } = useTranslation()
	const [state, setState] = useState<LoginData>({ email: '', password: '' })
	const api = useAPI()
	const [isActive, setIsActive] = useState(false);
	const [inputType, setInputType] = useState<string>("password")
	const [loading, setloading] = useState(false);

	const onUpdate = (e: React.ChangeEvent<any>, name: 'email' | 'password') => {
		setState((state) => ({ ...state, [name]: e.target.value }))
	}

	useEffect(() => {
		document.body.classList.remove('bg-internas-dashboard');
		document.body.classList.add('bg-internas-login');
	}, []);
	
	const basicAuth = 'Basic ' + btoa(state.email +':'+state.password)
	const token = btoa(state.email +':'+state.password)
	
	function handleSubmit(e: any){
		e.preventDefault()
		
		setloading(true)
		
        const headers = {
            headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json',
				'Authorization': basicAuth,
            }
        }

		if(state.email != '' && state.password != ''){
			axios.get('http://localhost:3000/quatour/user', headers).then(response => { 
				console.log(response)
				setloading(false)
				
				const session = { user_id: response.data.idClient, name: response.data.name, username: state.email, mail: response.data.mail, phone: response.data.tel_number, birthdate: response.data.data_nascimento,  token: token, role: response.data.roles[0].authority }
				auth.updateUser ? auth.updateUser({...session}) : null;
				setUserLocalStorage(session)
				navigate('/me/profile');				
			})
			.catch(error => {
				console.log(error.response)
				Alertify.alert('Erro', 'Usuário ou senha inválidos!');
				setloading(false)
			});
		}else{
			Alertify.alert('Erro', 'Digite seus dados de acesso!');
			setloading(false)
		}

	}

	const showPassword = () => {
		setIsActive(current => !current);
		
		if(!isActive){
			setInputType("text")
		}else{
			setInputType("password")
		}
	}
  
    return(
		<div>
		  <div className="text-center pt-5">
			<div className="login-form m-auto">
			  <form className="row rounded-3" onSubmit={handleSubmit}>
				<p className="text-center mb-5">
				  <a href="/">
					<img src={LogoQuatour} alt="Logo Quatour" />
				  </a>
				</p>

				<div className="col-md-12 mb-2">
				  <input
						type="text"
						id="email"
						name="email"
						className="form-control"
						placeholder="Seu usuário"
						value={state.email}
						onChange={(e) => onUpdate(e, 'email')}
						
				  />
				</div>

				<div className="col-md-12 mb-4">
				  <div className="input-group">
					<input
						type={inputType}
						name="password"
						className="form-control"
						id="password"
						aria-describedby="password"
						placeholder="Sua senha"
						value={state.password}
						onChange={(e) => onUpdate(e, 'password')}
					/>
					<span className="input-group-text" onClick={() => showPassword()}>
					  <i className={isActive ? 'bi bi-eye' : 'bi bi-eye-slash'}></i>
					</span>
				  </div>
				</div>

				<div className="col-md-12">
				  <a href="#" className="float-start text-muted mb-2 forgot">
					Esqueceu sua senha?
				  </a>

				  <button className="btn btn-warning rounded-5 float-end" type="submit">
					{loading ? <Loader className="spinner" /> : 'Acessar'} 
				  </button>
				</div>
			  </form>

			  <p className="mt-4 text-muted signup-link">
				Não possui uma conta?{" "}
				<a href="/cadastre-se">
				  <strong>Cadastre-se.</strong>
				</a>
			  </p>
			</div>
		  </div>
		</div>	
	)

}

export default Login