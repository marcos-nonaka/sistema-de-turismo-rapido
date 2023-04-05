import React, { useEffect, useState } from "react";
import { Navbar, Footer } from '../../components'
//import '../../assets/css/signup-login.css';

import LogoQuatour from "../../assets/img/logo-color.svg";

function Signup() {
	const [block, setBlock] = useState(false)
	const [checked, setChecked] = useState(false)
	
	useEffect(() => {
	   document.body.classList.add('bg-internas-signup')	
	}, [])

  const handleClick = (e: any) => {
    console.log(e.target.value)
	const target = e.target.value

	
	if(target == 'tourist'){
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
								<p className="mb-5">
									<strong>Turista</strong>, inscreva-se grátis e tenha acesso
									aos melhores roteiros pré-definidos para você aproveitar o seu
									tempo livre. <strong>Turismólogo</strong>, você também pode
									fazer seu cadastro e planejar roteiros.
								</p>
								
								<form className="row g-3 mt-2">
								  <div className="col-md-6">
									<label htmlFor="username" className="form-label">
									  Usuário
									</label>
									<input
									  type="text"
									  className="form-control"
									  id="username"
									/>
								  </div>
								  <div className="col-md-6">
									<label htmlFor="password" className="form-label">
									  Senha
									</label>
									<input
									  type="password"
									  className="form-control"
									  id="password"
									/>
								  </div>
								  <div className="col-md-12">
									<div className="form-check">
									  <input className="form-check-input" type="radio" name="signupType" id="signUpBtn1" value="tourist" onClick={handleClick} />
									  <label className="form-check-label" htmlFor="signUpBtn1">
										Conta turista
									  </label>
									</div>
									<div className="form-check">
									  <input className="form-check-input" type="radio" name="signupType" id="signUpBtn2" value="tourismologist" onClick={handleClick} />
									  <label className="form-check-label" htmlFor="signUpBtn2">
										Conta turismólogo
									  </label>
									</div>					  
								  </div>
								  <div className={block ? 'd-block col-md-12' : 'd-none col-md-12'} id="cpa">
									<label htmlFor="exampleFormControlInput1" className="form-label">CPA</label>
									<input type="text" className="form-control" id="exampleFormControlInput1" />
								  </div>
								  <div className="col-md-8">
									<label htmlFor="name" className="form-label">
									  Nome
									</label>
									<input type="text" className="form-control" id="name" />
								  </div>
								  <div className="col-md-4">
									<label htmlFor="cpf" className="form-label">
									  CPF
									</label>
									<input type="text" className="form-control" id="cpf" />
								  </div>

								  <div className="col-md-3">
									<label htmlFor="birthdate" className="form-label">
									  Data nasc.
									</label>
									<input
									  type="text"
									  className="form-control"
									  id="birthdate"
									/>
								  </div>
								  <div className="col-md-3">
									<label htmlFor="phone" className="form-label">
									  Telefone
									</label>
									<input
									  type="text"
									  className="form-control"
									  id="phone"
									/>
								  </div>
								  <div className="col-md-6">
									<label htmlFor="email" className="form-label">
									  E-mail
									</label>
									<input
									  type="email"
									  className="form-control"
									  id="email"
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