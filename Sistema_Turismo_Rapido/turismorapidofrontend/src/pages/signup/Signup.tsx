import React, { useEffect, useState, useContext } from "react";
import axios, { AxiosError } from 'axios'
import Alertify from "../../components/alertify/Alertify";
import { useNavigate } from 'react-router-dom'
import { Navbar, Footer } from '../../components'
//import '../../assets/css/signup-login.css';
import { useAPI } from '../../data/API'
import {AuthContext} from "../../store/authContext";

import LogoQuatour from "../../assets/img/logo-color.svg";
//import spinner from "../../assets/img/loader.svg";
import { ReactComponent as Loader } from '../../assets/img/loader.svg'

type UserData = {
  name: string
  cpf: string
  tel_number: string
  data_nascimento: string
  mail: string
  username: string
  password: string
  rolename: string
}


function Signup() {
	const auth = useContext(AuthContext)
	const [state, setState] = useState<UserData>({
		name: '',
		cpf: '',
		tel_number: '',
		data_nascimento: '',
		mail: '',
		username: '',
		password: '',
		rolename: '',
	})
	const api = useAPI()
	const navigate = useNavigate()
	const updateState = (e: any, field: string) => {
		setState((state) => ({ ...state, [field]: e.target.value }))
	}
	const [loading, setloading] = useState(false);
	const [block, setBlock] = useState(false)
	const [checked, setChecked] = useState(false)
	const [role, setRole] = useState("ROLE_TURISTA")

	const basicAuth = 'Basic ' + btoa('doug:123')
	//Authorization: auth.user?.basicAuth,
	
	useEffect(() => {
	   document.body.classList.add('bg-internas-signup')	
	}, [])

  const handleClick = (e: any) => {
    console.log(e.target.value)
	const target = e.target.value

	
	if(target == 'ROLE_TURISTA'){
		setBlock(false)
		setRole("ROLE_TURISTA")
	}else{
		setBlock(true)
		setRole("ROLE_TURISMOLOGO")
	}
  }
 
  const handleTermsClick = (e: any) => {
        if (e.target.checked) {
            console.log('checked')
			setChecked(true)
        }else{
			console.log('unchecked')
			setChecked(false)
		}
		
  }
  
  function handleSubmit(e: any) {
    e.preventDefault()
	
	setloading(true)
	
	const data = JSON.stringify({
	  "name": state.name,
	  "cpf": state.cpf,
	  "data_nascimento": state.data_nascimento,
	  "tel_number": state.tel_number,
	  "mail": state.mail,
	  "username": state.username,
	  "password": state.password,
	  "rolename": role
	});	
	

    const headers = {
      headers: {
        //'Authorization': basicAuth,
		'Content-Type': 'application/json'
      }
    }

	axios.post('/clients', data, headers).then((response) => {
		if(response.status == 200){
			setloading(false)
			//console.log("Cadastro efetuado com sucesso!")
			Alertify.alert("", "Cadastro realizado com sucesso!")
		}else{
			console.log('Erro ao tentar realizar cadastro!')
			//Alertify.alert('Erro ao tentar realizar cadastro!');
				
		}
	})	

  }

    return(
		<div>
			<div id="main">
				<div className="w-100 pt-3 pb-3 border-bottom">
					<p className="text-center m-0">
						<a href="/">
							<img src={LogoQuatour} width="170" alt="Logo Quatour" />
						</a>
					</p>
				</div>
				
				<div className="container">
					<div className="row">
						<div className="col-md-12 col-sm-12 pt-5">
							<div className="p-5 bg-white m-auto rounded-4" id="signup">
								<h3 className="h3 fw-bold mb-5">Crie uma conta</h3>
								<p className="mb-4">
									<strong>Turista</strong>, inscreva-se grátis e tenha acesso
									aos melhores roteiros pré-definidos para você aproveitar o seu
									tempo livre. <strong>Turismólogo</strong>, você também pode
									fazer seu cadastro e planejar roteiros.
								</p>
								
								<form className="row g-3" onSubmit={handleSubmit}>
								  <div className="col-md-12 mb-3">
									<div className="form-check form-check-inline">
									  <input className="form-check-input" type="radio" name="signupType" id="signUpBtn1" value="ROLE_TURISTA" onClick={handleClick} />
									  <label className="form-check-label" htmlFor="signUpBtn1">Conta turista</label>
									</div>
									<div className="form-check form-check-inline">
									  <input className="form-check-input" type="radio" name="signupType" id="signUpBtn2" value="ROLE_TURISMOLOGO" onClick={handleClick} />
									  <label className="form-check-label" htmlFor="signUpBtn2">Conta turismólogo</label>
									</div>
								  </div>								
								  <div className="col-md-6">
									<label htmlFor="username" className="form-label">
									  Usuário
									</label>
									<input
									  type="text"
									  className="form-control"
									  id="username" value={state.username} onChange={(e) => updateState(e, 'username')}
									/>
								  </div>
								  <div className="col-md-6">
									<label htmlFor="password" className="form-label">
									  Senha
									</label>
									<input
									  type="password"
									  className="form-control"
									  id="password" value={state.password} onChange={(e) => updateState(e, 'password')}
									/>
								  </div>
								  <div className="col-md-8">
									<label htmlFor="name" className="form-label">
									  Nome
									</label>
									<input type="text" className="form-control" id="name" value={state.name} onChange={(e) => updateState(e, 'name')} />
								  </div>
								  <div className="col-md-4">
									<label htmlFor="cpf" className="form-label">
									  CPF
									</label>
									<input type="text" className="form-control" id="cpf" value={state.cpf} onChange={(e) => updateState(e, 'cpf')} />
								  </div>
								  <div className={block ? 'd-block col-md-12' : 'd-none col-md-12'} id="cpa">
									<label htmlFor="tourismologistID" className="form-label">CPA</label>
									<input type="text" className="form-control" id="tourismologistID" />
								  </div>
								  <div className="col-md-3">
									<label htmlFor="data_nascimento" className="form-label">
									  Data nasc.
									</label>
									<input
									  type="text"
									  className="form-control"
									  id="data_nascimento" value={state.data_nascimento} onChange={(e) => updateState(e, 'data_nascimento')}
									/>
								  </div>
								  <div className="col-md-3">
									<label htmlFor="tel_number" className="form-label">
									  Telefone
									</label>
									<input
									  type="text"
									  className="form-control"
									  id="tel_number" value={state.tel_number} onChange={(e) => updateState(e, 'tel_number')}
									/>
								  </div>
								  <div className="col-md-6">
									<label htmlFor="mail" className="form-label">
									  E-mail
									</label>
									<input
									  type="email"
									  className="form-control"
									  id="mail" value={state.mail} onChange={(e) => updateState(e, 'mail')}
									/>
								  </div>
								  <div className="col-12">
									<div className="form-check">
									  <input
										className="form-check-input"
										type="checkbox"
										id="terms"
										onClick={handleTermsClick}
									  />
									  <label className="form-check-label term" htmlFor="terms">
										Ao criar uma conta, eu aceito os Termos e condições
										e a Declaração de privacidade da Quatour, e os
										Termos e condições da Quatour.
									  </label>
									</div>
								  </div>
								  <div className="col-12">
									<button
									  type="submit"
									  className={checked ? 'btn btn-warning rounded-5 ps-3 pe-3 float-end' : 'disabled btn btn-warning rounded-5 ps-3 pe-3 float-end'}>
									  {loading ? <Loader className="spinner" /> : 'Cadastrar'}
									</button>
									
								  </div>
								</form>
							</div>
							
							<p className="mt-4 text-muted signup-link text-center">Já tem uma conta? <a href="/login"><strong>Fazer login.</strong></a></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	)

}

export default Signup