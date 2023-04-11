import React, {useEffect, useContext, useState} from 'react'
import { Meheader, Menav, Footer } from '../../../components'
import { getUserLocalStorage } from '../../../store/util'

function Profile(){
	const userData = getUserLocalStorage()
	
	useEffect(() => {
		document.body.classList.remove('bg-internas-login');
		document.body.classList.add('bg-internas-dashboard');

	}, []);
	
    return(
		<>
		<Meheader />
		<div id="main">
			<div className="container">				
				<div className="row">
					<div className="col-md-3 col-sm-12">
						<Menav />
					</div>
					<div className="col-md-9 col-sm-12">
						<h2 className="h2 fw-bold mb-2">Configurações da conta</h2>
						<p className="mb-4">Administre sua experiência na Quatour</p>
				
						<div className="dashboard-content rounded-4 bg-white p-5 mb-5">
							<h2 className="h2 fw-bold mb-4">Bem-vindo</h2>
	
							<p className="m-0"><small>E-mail da conta</small></p>
							<p className="fw-bold mb-5">{userData.mail}</p>
						
							<div className="card rounded-4 mb-4">
								<div className="card-header bg-white">
									Informações pessoais
								</div>
								<div className="card-body">
									<form className="row g-3 mt-2">
										<div className="col-md-8">
											<label htmlFor="name" className="form-label">Nome</label>
											<input type="text" className="form-control" id="name" value={userData.name} />
										</div>
										<div className="col-md-4">
											<label htmlFor="cpf" className="form-label">CPF</label>
											<input type="text" className="form-control" id="cpf" value="999.999.999-99" />
										</div>	
				
										<div className="col-md-3">
											<label htmlFor="birthdate" className="form-label">Data nasc.</label>
											<input type="text" className="form-control" id="birthdate" value={userData.birthdate} />
										</div>
										<div className="col-md-3">
											<label htmlFor="phone" className="form-label">Telefone</label>
											<input type="text" className="form-control" id="phone" value={userData.phone} />
										</div>
										<div className="col-md-6">
											<label htmlFor="email" className="form-label">E-mail</label>
											<input type="email" className="form-control" id="email" value={userData.mail} />
										</div>
			
										<div className="col-12">
											<button type="submit" className="btn btn-warning rounded-5 ps-3 pe-3 float-end">Salvar alterações</button>
										</div>
									</form>
								</div>
							</div>
							
							
							<div className="card rounded-4">
								<div className="card-header bg-white">
									Atualizar senha
								</div>
								<div className="card-body">
									<form className="row g-3 mt-2">
										<div className="col-md-12">
											<label htmlFor="newPassword" className="form-label">Nova senha</label>
											<input type="text" className="form-control" id="newPassword" placeholder="Nova senha" />
										</div>
										<div className="col-md-12">
											<label htmlFor="confirmNewPassword" className="form-label">Confimar nova senha</label>
											<input type="text" className="form-control" id="confirmNewPassword" placeholder="Confimar nova senha" />
										</div>	
				
										<div className="col-12">
											<button type="submit" className="btn btn-warning rounded-5 ps-3 pe-3 float-end">Alterar senha</button>
										</div>
									</form>
								</div>
							</div>						
						</div>
					</div>
				</div>

			</div>
		</div>
		
		<Footer />
		</>
	)

}

export default Profile;