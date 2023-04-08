import React, { useEffect, useState, useContext } from "react";
import { useNavigate } from 'react-router-dom'
import { Navbar, Footer } from '../../components'
//import '../../assets/css/signup-login.css';
import { useAPI } from '../../data/API'
import {AuthContext} from "../../store/authContext";

import LogoQuatour from "../../assets/img/logo-color.svg";

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

//"rolename":"ROLE_TURISTA"

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
	const [block, setBlock] = useState(false)
	const [checked, setChecked] = useState(false)
	
	useEffect(() => {
	   document.body.classList.add('bg-internas-signup')	
	}, [])

  const handleClick = (e: any) => {
    console.log(e.target.value)
	const target = e.target.value

	
	if(target == 'ROLE_TURISTA'){
		setBlock(false)
	}else{
		setBlock(true)
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
	
	console.log('Requisição POST');
    const htmlConfig = {
      headers: {
        'Content-Type': 'multipart/form-data;',
        'Access-Control-Allow-Origin': '*',
        Authorization: auth.user?.basicAuth,
      },
    }

    const formData = new FormData()
    formData.append('name', state.name)
    formData.append('cpf', state.cpf)
    formData.append('tel_number', state.tel_number)
    formData.append('data_nascimento', state.data_nascimento)
    formData.append('mail', state.mail)
    formData.append('username', state.username)
    formData.append('password', state.password)
    formData.append('rolename', state.rolename)		

    api.post('/clients', formData, {}).then(() => {
      navigate('/')
    })
  }	
	

/*
const axios = require('axios');
let data = JSON.stringify({
  "name": "Gilmar Santana",
  "cpf": "999999999999",
  "data_nascimento": "2022-02-02",
  "tel_number": "11999999999",
  "mail": "gilmar@teste.com.br",
  "username": "gilmar",
  "password": "1234",
  "rolename": "ROLE_TURISTA"
});

let config = {
  method: 'post',
  maxBodyLength: Infinity,
  url: 'http://localhost:8080/clients',
  headers: { 
    'Authorization': 'Basic ZG91ZzoxMjM=', 
    'Content-Type': 'application/json'
  },
  data : data
};

axios.request(config)
.then((response) => {
  console.log(JSON.stringify(response.data));
})
.catch((error) => {
  console.log(error);
});
*/



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
									<label htmlFor="birthdate" className="form-label">
									  Data nasc.
									</label>
									<input
									  type="text"
									  className="form-control"
									  id="data_nascimento" value={state.data_nascimento} onChange={(e) => updateState(e, 'data_nascimento')}
									/>
								  </div>
								  <div className="col-md-3">
									<label htmlFor="phone" className="form-label">
									  Telefone
									</label>
									<input
									  type="text"
									  className="form-control"
									  id="tel_number" value={state.tel_number} onChange={(e) => updateState(e, 'tel_number')}
									/>
								  </div>
								  <div className="col-md-6">
									<label htmlFor="email" className="form-label">
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
									  className={checked ? 'btn btn-primary rounded-5 ps-3 pe-3 float-end' : 'disabled btn btn-primary rounded-5 ps-3 pe-3 float-end'}>
									  Cadastrar
									</button>
								  </div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	)

}

export default Signup