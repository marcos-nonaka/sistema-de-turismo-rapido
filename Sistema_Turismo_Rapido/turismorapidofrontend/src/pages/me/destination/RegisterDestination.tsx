import React, {useEffect, useContext, useState} from 'react'
import axios, { AxiosError } from 'axios'
import { Meheader, Menav, Menavgist, Footer } from '../../../components'
import Alertify from "../../../components/alertify/Alertify";
import { useNavigate } from 'react-router-dom'
import { getUserLocalStorage } from '../../../store/util'
import { ReactComponent as Loader } from '../../../assets/img/loader.svg'

type UserData = {
  city: string
  attraction: string
  food: string
  hotel: string
  price: string
  days: string
  name: string
}

function RegisterDestination(){
	const [loading, setloading] = useState(false)
	const userData = getUserLocalStorage()
	const token = getUserLocalStorage().token
	const [state, setState] = useState<UserData>({
		city: '',
		attraction: '',
		food: '',
		hotel: '',
		price: '',
		days: '',
		name: '',
	})

	const navigate = useNavigate()
	const updateState = (e: any, field: string) => {
		setState((state) => ({ ...state, [field]: e.target.value }))
	}
	
	useEffect(() => {
		document.body.classList.remove('bg-internas-login');
		document.body.classList.add('bg-internas-dashboard');
		//console.log(token)
	}, []);

  const handleClick = (e: any) => {
    console.log(e.target.value)
	const target = e.target.value
  }
  
  function handleSubmit(e: any){
    e.preventDefault()
	
	setloading(true)
	
	const data = JSON.stringify({
		"city": state.city,
		"attraction": state.attraction,
		"food": state.food,
		"hotel": state.hotel,
		"price": state.price,
		"days": state.days,	
		"name": state.name,	  
	});	
	

    const headers = {
      headers: {
        'Authorization': 'Basic ' + token,
		'Content-Type': 'application/json'
      }
    }
	console.log(headers)
	console.log(data)

	axios.post('http://localhost:3000/roteiros', data, headers).then((response) => {
		if(response.status == 200){
			setloading(false)
			Alertify.alert("", "Cadastro realizado com sucesso!")
		}else{
			console.log('Erro ao tentar realizar cadastro!')
			Alertify.alert('Erro ao tentar realizar cadastro!');	
		}
	})

  }


    return(
		<>
		<Meheader />
		<div id="main">
			<div className="container">				
				<div className="row">
					<div className="col-md-3 col-sm-12">
						{ userData.role == 'ROLE_TURISTA' ? <Menav /> : <Menavgist /> }
					</div>
					<div className="col-md-9 col-sm-12">
						<h2 className="h2 fw-bold mb-2">Cadastrar roteiro</h2>
						<p className="mb-4">Administre sua experiência na Quatour</p>
				
						<div className="dashboard-content rounded-4 bg-white p-5 mb-5">
						
							<div className="card rounded-4 mb-4">
								<div className="card-header bg-white">
									Detalhes do roteiro
								</div>
								<div className="card-body">
									<form className="row g-3 mt-2" onSubmit={handleSubmit}>
										<div className="col-md-12">
											<label htmlFor="city" className="form-label">Cidade</label>
											<input type="text" className="form-control" id="city" value={state.city} onChange={(e) => updateState(e, 'city')} />
										</div>
										<div className="col-md-12">
											<label htmlFor="attraction" className="form-label">Atrações</label>
											<input type="text" className="form-control" id="attraction" value={state.attraction} onChange={(e) => updateState(e, 'attraction')} />
										</div>	
				
										<div className="col-md-12">
											<label htmlFor="food" className="form-label">Alimentação</label>
											<input type="text" className="form-control" id="food" value={state.food} onChange={(e) => updateState(e, 'food')} />
										</div>
										<div className="col-md-12">
											<label htmlFor="hotel" className="form-label">Hotéis</label>
											<input type="text" className="form-control" id="hotel" value={state.hotel} onChange={(e) => updateState(e, 'hotel')} />
										</div>
										<div className="col-md-6">
											<label htmlFor="price" className="form-label">Valor</label>
											<input type="text" className="form-control" id="price" value={state.price} onChange={(e) => updateState(e, 'price')} />
										</div>
										<div className="col-md-6">
											<label htmlFor="days" className="form-label">Quantidade de dias</label>
											<input type="text" className="form-control" id="days" value={state.days} onChange={(e) => updateState(e, 'days')} />
										</div>
										<div className="col-md-12">
											{/*<label htmlFor="name" className="form-label">Nome</label>*/}
											<input type="hidden" className="form-control" id="name" value={userData.name} onChange={(e) => updateState(e, 'name')} />
										</div>										
										<div className="col-12">
											<button type="submit" className="btn btn-warning rounded-5 ps-3 pe-3 float-end">{loading ? <Loader className="spinner" /> : 'Salvar roteiro'}</button>
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

export default RegisterDestination;