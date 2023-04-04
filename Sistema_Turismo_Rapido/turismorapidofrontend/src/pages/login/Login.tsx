import React, {useEffect, useContext, useState} from 'react'
import axios, { AxiosError } from 'axios'
import { Navbar, Footer } from '../../components'
import { useTranslation } from 'react-i18next'
import { useAPI } from '../../data/API'
import {AuthContext} from "../../store/authContext";
import {useNavigate} from "react-router-dom";

import LogoQuatour from "../../assets/img/logo-icon.svg";

type LoginData = {
  username: string
  password: string
}

function Login(){
	const auth = useContext(AuthContext);
	const navigate = useNavigate();
	const { t } = useTranslation()
	const [state, setState] = useState<LoginData>({ username: '', password: '' })
	const api = useAPI()

	const onUpdate = (e: React.ChangeEvent<any>, name: 'username' | 'password') => {
		setState((state) => ({ ...state, [name]: e.target.value }))
	}

	useEffect(() => {
	   document.body.classList.add('bg-internas-login');
	}, []);

	function handleSubmit(e: any){
		e.preventDefault()		
		console.log('Requisição GET');

		if (state.username && state.password){			
			//passando parâmetro na segunda posição -> {name: 'Rafael'}
			api.get('/clients', {}, {}).then((res) => {
				console.log(res)
			})

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
						id="username"
						name="username"
						className="form-control"
						placeholder="Seu usuário"
						value={state.username}
						onChange={(e) => onUpdate(e, 'username')}					
				  />
				</div>

				<div className="col-md-12 mb-4">
				  <div className="input-group">
					<input
						type="password"
						name="password"
						className="form-control"
						id="password"
						aria-describedby="password"
						placeholder="Sua senha"
						value={state.password}
						onChange={(e) => onUpdate(e, 'password')}
					/>
					<span className="input-group-text">
					  <i className="bi bi-eye-slash"></i>
					</span>
				  </div>
				</div>

				<div className="col-md-12">
				  <a href="#" className="float-start text-muted mb-2 forgot">
					Esqueceu sua senha?
				  </a>

				  <button className="btn btn-primary rounded-5 float-end" type="submit">
					{t('auth.login.enter')}
				  </button>
				</div>
			  </form>

			  <p className="mt-4 text-muted signup-link">
				Não possui uma conta?{" "}
				<a href="cadastre-se">
				  <strong>Cadastre-se.</strong>
				</a>
			  </p>
			</div>
		  </div>
		</div>	
	)

}

export default Login